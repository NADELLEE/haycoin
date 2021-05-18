package org.hay.core;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hay.crypto.ECKey;
import org.hay.datasource.leveldb.LevelDbDataSource;
import org.hay.protos.core.hayTXOutput;
import org.hay.protos.core.hayTXOutputs;
import org.hay.protos.core.hayTXOutputs.TXOutputs;
import org.hay.utils.ByteArray;

import java.util.*;

import static org.hay.core.Constant.TRANSACTION_DB_NAME;

public class UTXOSet {
    private static final Logger logger = LoggerFactory.getLogger("UTXOSet");

    private Blockchain blockchain;
    private LevelDbDataSource txDB = null;

    public UTXOSet() {
        txDB = new LevelDbDataSource(TRANSACTION_DB_NAME);
        txDB.init();
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    public void reindex() {
        logger.info("reindex");

        txDB.reset();

        HashMap<String, TXOutputs> utxo = blockchain.findUTXO();

        Set<Map.Entry<String, TXOutputs>> entrySet = utxo.entrySet();

        for (Map.Entry<String, TXOutputs> entry : entrySet) {
            String key = entry.getKey();
            TXOutputs value = entry.getValue();

            for (hayTXOutput.TXOutput txOutput : value.getOutputsList()) {
                txDB.put(ByteArray.fromHexString(key), value.toByteArray());
            }
        }
    }

    public SpendableOutputs findSpendableOutputs(byte[] pubKeyHash, long amount) {
        SpendableOutputs spendableOutputs = new SpendableOutputs();
        HashMap<String, long[]> unspentOutputs = new HashMap<>();
        long accumulated = 0L;

        Set<byte[]> keySet = txDB.keys();

        for (byte[] key : keySet) {
            byte[] txOutputsData = txDB.get(key);
            try {
                TXOutputs txOutputs = hayTXOutputs.TXOutputs.parseFrom(txOutputsData);

                int len = txOutputs.getOutputsCount();

                for (int i = 0; i < len; i++) {
                    hayTXOutput.TXOutput txOutput = txOutputs.getOutputs(i);
                    if (ByteArray.toHexString(ECKey.computeAddress(pubKeyHash)).equals(ByteArray.toHexString(txOutput
                            .getPubKeyHash()
                            .toByteArray())) && accumulated < amount) {
                        accumulated += txOutput.getValue();

                        long[] v = unspentOutputs.get(ByteArray.toHexString(key));

                        if (v == null) {
                            v = new long[0];
                        }

                        long[] tmp = Arrays.copyOf(v, v.length + 1);
                        tmp[tmp.length - 1] = i;

                        unspentOutputs.put(ByteArray.toHexString(key), tmp);
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }

        spendableOutputs.setAmount(accumulated);
        spendableOutputs.setUnspentOutputs(unspentOutputs);

        return spendableOutputs;
    }

    public ArrayList<hayTXOutput.TXOutput> findUTXO(byte[] pubKeyHash) {
        ArrayList<hayTXOutput.TXOutput> utxos = new ArrayList<>();

        Set<byte[]> keySet = txDB.keys();
        for (byte[] key : keySet) {
            byte[] txData = txDB.get(key);

            try {
                TXOutputs txOutputs = TXOutputs.parseFrom(txData);
                for (hayTXOutput.TXOutput txOutput : txOutputs.getOutputsList()) {
                    if (ByteArray.toHexString(ECKey.computeAddress(pubKeyHash)).equals(ByteArray.toHexString(txOutput
                            .getPubKeyHash()
                            .toByteArray()))) {
                        utxos.add(txOutput);
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }

        return utxos;
    }
}

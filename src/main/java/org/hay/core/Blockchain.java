package org.hay.core;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hay.crypto.ECKey;
import org.hay.datasource.leveldb.LevelDbDataSource;
import org.hay.example.hay;
import org.hay.overlay.Net;
import org.hay.overlay.message.Message;
import org.hay.overlay.message.Type;
import org.hay.peer.Peer;
import org.hay.protos.core.hayBlock.Block;
import org.hay.protos.core.hayTXInput.TXInput;
import org.hay.protos.core.hayTXOutput.TXOutput;
import org.hay.protos.core.hayTXOutputs.TXOutputs;
import org.hay.protos.core.hayTransaction.Transaction;
import org.hay.utils.ByteArray;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hay.core.Constant.BLOCK_DB_NAME;
import static org.hay.core.Constant.LAST_HASH;
import static org.hay.datasource.leveldb.LevelDbDataSource.databaseName;

public class Blockchain {
    public static final Logger logger = LoggerFactory.getLogger("BlockChain");
    public static final String genesisCoinbaseData = "0x00";
    private LevelDbDataSource blockDB = null;
    private PendingState pendingState = new PendingStateImpl();

    private byte[] lastHash;
    private byte[] currentHash;

    /**
     * create new blockchain
     *
     * @param address wallet address
     */
    public Blockchain(String address) {
        if (dbExists()) {
            logger.info("blockchain already exists.");
            System.exit(0);
        }

        blockDB = new LevelDbDataSource(BLOCK_DB_NAME);
        blockDB.init();

        Transaction coinbase = TransactionUtils.newCoinbaseTransaction
                (address, genesisCoinbaseData);
        Block genesisBlock = BlockUtils.newGenesisBlock(coinbase);

        this.lastHash = genesisBlock.getBlockHeader().getHash().toByteArray();
        this.currentHash = this.lastHash;

        blockDB.put(genesisBlock.getBlockHeader().getHash().toByteArray(),
                genesisBlock.toByteArray());
        byte[] lastHash = genesisBlock.getBlockHeader()
                .getHash()
                .toByteArray();

        blockDB.put(LAST_HASH, lastHash);

        logger.info("new blockchain");
    }

    /**
     * create blockchain by db source
     */
    public Blockchain() {
        if (!dbExists()) {
            logger.info("no existing blockchain found. please create one " +
                    "first");
            System.exit(0);
        }

        blockDB = new LevelDbDataSource(BLOCK_DB_NAME);
        blockDB.init();

        this.lastHash = blockDB.get(LAST_HASH);
        this.currentHash = this.lastHash;

        logger.info("load blockchain");
    }

    /**
     * find transaction by id
     *
     * @param id ByteString id
     * @return {@link Transaction}
     */
    public Transaction findTransaction(ByteString id) {
        Transaction transaction = Transaction.newBuilder().build();

        BlockchainIterator bi = new BlockchainIterator(this);
        while (bi.hasNext()) {
            Block block = (Block) bi.next();

            for (Transaction tx : block.getTransactionsList()) {
                String txID = ByteArray.toHexString(tx.getId().toByteArray());
                String idStr = ByteArray.toHexString(id.toByteArray());
                if (txID.equals(idStr)) {
                    transaction = tx.toBuilder().build();
                    return transaction;
                }
            }

            if (block.getBlockHeader().getParentHash().isEmpty()) {
                break;
            }
        }

        return transaction;
    }

    public HashMap<String, TXOutputs> findUTXO() {
        HashMap<String, TXOutputs> utxo = new HashMap<>();
        HashMap<String, long[]> spenttxos = new HashMap<>();

        BlockchainIterator bi = new BlockchainIterator(this);
        while (bi.hasNext()) {
            Block block = (Block) bi.next();

            for (Transaction transaction : block.getTransactionsList()) {
                String txid = ByteArray.toHexString(transaction.getId()
                        .toByteArray());

                output:
                for (int outIdx = 0; outIdx < transaction.getVoutList().size
                        (); outIdx++) {
                    TXOutput out = transaction.getVout(outIdx);
                    if (!spenttxos.isEmpty() && spenttxos.containsKey(txid)) {
                        for (int i = 0; i < spenttxos.get(txid).length; i++) {
                            if (spenttxos.get(txid)[i] == outIdx) {
                                continue output;
                            }
                        }
                    }


                    TXOutputs outs = utxo.get(txid);

                    if (outs == null) {
                        outs = TXOutputs.newBuilder().build();
                    }

                    outs = outs.toBuilder().addOutputs(out).build();
                    utxo.put(txid, outs);
                }

                if (!TransactionUtils.isCoinbaseTransaction(transaction)) {
                    for (TXInput in : transaction.getVinList()) {
                        String inTxid = ByteArray.toHexString(in.getTxID()
                                .toByteArray());
                        long[] vindexs = spenttxos.get(inTxid);

                        if (vindexs == null) {
                            vindexs = new long[0];
                        }

                        vindexs = Arrays.copyOf(vindexs, vindexs.length + 1);
                        vindexs[vindexs.length - 1] = in.getVout();

                        spenttxos.put(inTxid, vindexs);
                    }
                }
            }

        }

        return utxo;
    }

    /**
     * judge db is exists
     *
     * @return boolean
     */
    public static boolean dbExists() {
        File file = new File(Paths.get(databaseName, BLOCK_DB_NAME).toString());

        return file.exists();
    }

    public void addBlock(Block block) {
        byte[] blockInDB = blockDB.get(block.getBlockHeader().getHash().toByteArray());

        if (blockInDB == null || blockInDB.length == 0) {
            return;
        }

        blockDB.put(block.getBlockHeader().getHash().toByteArray(), block.toByteArray());

        byte[] lastHash = blockDB.get(ByteArray.fromString("lashHash"));
        byte[] lastBlockData = blockDB.get(lastHash);
        try {
            Block lastBlock = Block.parseFrom(lastBlockData);
            if (block.getBlockHeader().getNumber() > lastBlock.getBlockHeader().getNumber()) {
                blockDB.put(ByteArray.fromString("lashHash"), block.getBlockHeader().getHash().toByteArray());
                this.lastHash = block.getBlockHeader().getHash().toByteArray();
                this.currentHash = this.lastHash;
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    public Transaction signTransaction(Transaction transaction, ECKey myKey) {
        HashMap<String, Transaction> prevTXs = new HashMap<>();

        for (TXInput txInput : transaction.getVinList()) {
            ByteString txID = txInput.getTxID();
            Transaction prevTX = this.findTransaction(txID).toBuilder().build();
            String key = ByteArray.toHexString(txID.toByteArray());
            prevTXs.put(key, prevTX);
        }

        transaction = TransactionUtils.sign(transaction, myKey, prevTXs);
        return transaction;
    }

    /**
     * {@see org.hay.overlay.kafka.KafkaTest#testKafka()}
     *
     * @param transactions transactions
     */
    public void addBlock(List<Transaction> transactions, Net net) {
        // get lastHash
        byte[] lastHash = blockDB.get(LAST_HASH);
        ByteString parentHash = ByteString.copyFrom(lastHash);
        // get number
        long number = BlockUtils.getIncreaseNumber(hay.getPeer().getBlockchain());
        // get difficulty
        ByteString difficulty = ByteString.copyFromUtf8(Constant.DIFFICULTY);
        Block block = BlockUtils.newBlock(transactions, parentHash, difficulty,
                number);

        String value = ByteArray.toHexString(block.toByteArray());

        if (hay.getPeer().getType().equals(Peer.PEER_SERVER)) {
            Message message = new Message(value, Type.BLOCK);
            net.broadcast(message);
        }
    }

    public void receiveBlock(Block block, UTXOSet utxoSet) {

        byte[] lastHashKey = LAST_HASH;
        byte[] lastHash = blockDB.get(lastHashKey);

        if (!ByteArray.toHexString(block.getBlockHeader().getParentHash().toByteArray()).equals(ByteArray.toHexString
                (lastHash))) {
            return;
        }

        // save the block into the database
        byte[] blockHashKey = block.getBlockHeader().getHash().toByteArray();
        byte[] blockVal = block.toByteArray();
        blockDB.put(blockHashKey, blockVal);

        byte[] ch = block.getBlockHeader().getHash()
                .toByteArray();

        // update lastHash
        hay.getPeer().getBlockchain().getBlockDB().put(lastHashKey, ch);

        this.lastHash = ch;
        currentHash = ch;

        // update UTXO cache
        utxoSet.reindex();
    }

    public static String getGenesisCoinbaseData() {
        return genesisCoinbaseData;
    }

    public LevelDbDataSource getBlockDB() {
        return blockDB;
    }

    public void setBlockDB(LevelDbDataSource blockDB) {
        this.blockDB = blockDB;
    }

    public PendingState getPendingState() {
        return pendingState;
    }

    public void setPendingState(PendingState pendingState) {
        this.pendingState = pendingState;
    }

    public byte[] getLastHash() {
        return lastHash;
    }

    public void setLastHash(byte[] lastHash) {
        this.lastHash = lastHash;
    }

    public byte[] getCurrentHash() {
        return currentHash;
    }

    public void setCurrentHash(byte[] currentHash) {
        this.currentHash = currentHash;
    }
}

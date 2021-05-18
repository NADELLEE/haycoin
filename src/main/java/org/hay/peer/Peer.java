package org.hay.peer;

import com.google.protobuf.InvalidProtocolBufferException;
import org.hay.config.Configer;
import org.hay.core.*;
import org.hay.crypto.ECKey;
import org.hay.overlay.Net;
import org.hay.overlay.kafka.Kafka;
import org.hay.overlay.listener.ReceiveSource;
import org.hay.overlay.message.Message;
import org.hay.overlay.message.Type;
import org.hay.protos.core.hayBlock;
import org.hay.protos.core.hayTransaction;
import org.hay.utils.ByteArray;

import java.util.Arrays;

import static org.hay.core.Constant.TOPIC_BLOCK;
import static org.hay.core.Constant.TOPIC_TRANSACTION;

public class Peer {
    public final static String PEER_NORMAL = "normal";
    public final static String PEER_SERVER = "server";

    private static Peer INSTANCE = null;

    private String type;

    private Peer() {
        init();
        source.addReceiveListener((Message message) -> {
            if (message.getType() == Type.BLOCK) {
                hayBlock.Block block = null;
                try {
                    block = hayBlock.Block.parseFrom(ByteArray.fromHexString(message.getMessage()));
                    blockchain.receiveBlock(block, utxoSet);
                } catch (InvalidProtocolBufferException e) {
                    e.printStackTrace();
                }
            }
        });
        source.addReceiveListener((Message message) -> {
            if (message.getType() == Type.TRANSACTION) {
                try {
                    hayTransaction.Transaction transaction = hayTransaction.Transaction.parseFrom(ByteArray
                            .fromHexString(message.getMessage()));
                    System.out.println(TransactionUtils.toPrintString(transaction));
                    PendingStateImpl pendingState = (PendingStateImpl) blockchain.getPendingState();
                    pendingState.addPendingTransaction(blockchain, transaction, net);
                } catch (InvalidProtocolBufferException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Peer getInstance(String type) {
        if (INSTANCE == null) {
            INSTANCE = new Peer();
            INSTANCE.type = type;
        }

        return INSTANCE;
    }

    private final ECKey myKey = Configer.getMyKey();

    private Wallet wallet = null;

    private Blockchain blockchain = null;

    private UTXOSet utxoSet = null;

    private ReceiveSource source;

    private Net net;

    private void init() {
        initWallet();

        initBlockchian();

        initUTXOSet();

        initNet();
    }

    private void initWallet() {
        wallet = new Wallet();
        wallet.init(myKey);
    }

    private void initBlockchian() {
        if (Blockchain.dbExists()) {
            blockchain = new Blockchain();
        } else {
            blockchain = new Blockchain(ByteArray.toHexString(wallet.getAddress()));
        }
    }

    private void initUTXOSet() {
        utxoSet = new UTXOSet();
        utxoSet.setBlockchain(blockchain);
        utxoSet.reindex();
    }

    private void initNet() {
        source = new ReceiveSource();

        net = new Kafka(source, Arrays.asList(TOPIC_BLOCK, TOPIC_TRANSACTION));
    }

    public ECKey getMyKey() {
        return myKey;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    public UTXOSet getUTXOSet() {
        return utxoSet;
    }

    public void setUTXOSet(UTXOSet utxoSet) {
        this.utxoSet = utxoSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Net getNet() {
        return net;
    }

    public void setNet(Net net) {
        this.net = net;
    }
}

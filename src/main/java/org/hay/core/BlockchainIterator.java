package org.hay.core;

import com.google.protobuf.InvalidProtocolBufferException;
import org.hay.protos.core.hayBlock;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class BlockchainIterator implements Iterator {
    private Blockchain blockchain;
    private byte[] index;

    public BlockchainIterator(Blockchain blockchain) {
        this.blockchain = blockchain;
        index = new byte[blockchain.getCurrentHash().length];
        index = Arrays.copyOf(blockchain.getCurrentHash(), blockchain
                .getCurrentHash().length);
    }

    @Override
    public boolean hasNext() {
        return (index == null || index.length == 0);
    }

    @Override
    public Object next() {
        hayBlock.Block block = null;
        if (hasNext()) {
            byte[] value = blockchain.getBlockDB().get(index);
            try {
                block = hayBlock.Block.parseFrom(value);
                index = block.getBlockHeader().getParentHash()
                        .toByteArray();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }

        return block;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}

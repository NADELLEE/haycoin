package org.hay.core;


import org.hay.protos.core.hayBlock;

import java.math.BigInteger;
import java.util.Map;

public class BlockSummary {

    private final hayBlock.Block block;
    private final Map<byte[], BigInteger> rewards;
    private BigInteger totalDifficulty = BigInteger.ZERO;

    public BlockSummary(hayBlock.Block block, Map<byte[], BigInteger> rewards) {
        this.block = block;
        this.rewards = rewards;
    }

    public void setTotalDifficulty(BigInteger totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
    }
}

package org.hay.peer;

import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.hay.core.BlockUtils;
import org.hay.protos.core.hayBlock.Block;
import org.hay.utils.FastByteComparisons;
import org.hay.utils.TypeConversion;

import java.math.BigInteger;

import static org.hay.crypto.Hash.sha3;

public class Validation implements ValidationRule {
    private boolean isStop;

    @Override
    public byte[] start(Block block) {
        isStop = false;
        BigInteger max = BigInteger.valueOf(2).pow(255);
        byte[] target = BigIntegers.asUnsignedByteArray(32,
                max.divide(new BigInteger(1, block.getBlockHeader()
                        .getDifficulty()
                        .toByteArray())));

        byte[] testNonce = new byte[32];
        byte[] concat;

        while (TypeConversion.increment(testNonce) && !isStop) {

            if (testNonce[31] == 0 && testNonce[30] == 0) {
                System.out.println("mining: " + new BigInteger(1, testNonce));
            }

            if (testNonce[31] == 0)
                sleep();
            concat = Arrays.concatenate(BlockUtils.prepareData(block),
                    testNonce);
            byte[] result = sha3(concat);
            if (FastByteComparisons.compareTo(result, 0, 32, target, 0, 32) <
                    0) {
                System.out.println("mined success");
                return testNonce;
            }
        }
        return new byte[]{};
    }

    @Override
    public void stop() {
        this.isStop = true;
    }

    @Override
    public boolean validate(Block block) {
        byte[] proof = BlockUtils.getMineValue(block);
        byte[] boundary = BlockUtils.getPowBoundary(block);

        if (FastByteComparisons.compareTo(proof, 0, 32, boundary, 0, 32) > 0) {
            return false;
        }

        return true;
    }

    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

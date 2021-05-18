package org.hay.core;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.hay.peer.Validator;
import org.hay.protos.core.hayBlock;
import org.hay.protos.core.hayBlock.Block;
import org.hay.protos.core.hayBlockHeader.BlockHeader;
import org.hay.protos.core.hayTransaction.Transaction;
import org.hay.utils.ByteArray;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hay.core.Constant.LAST_HASH;
import static org.hay.crypto.Hash.sha3;

public class BlockUtils {

    private static Block.Builder block;
    private byte[] serializEncode;

    /**
     * get a new block
     *
     * @return {@link Block} block
     */
    public static Block newBlock(List<Transaction> transactions, ByteString
            parentHash, ByteString difficulty, long number) {
        Block.Builder block = Block.newBuilder();

        for (int i = 0; transactions != null && i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            block.addTransactions(i, transaction);
        }

        //Chain programming
//        BlockHeader.Builder builder = BlockHeader.newBuilder()
// .setParentHash(parentHash).setDifficulty(difficulty)
//                .setNumber(number).setTimestamp(System.currentTimeMillis());

        BlockHeader.Builder blockHeaderBuilder = BlockHeader.newBuilder();

        blockHeaderBuilder.setParentHash(parentHash);
        blockHeaderBuilder.setDifficulty(difficulty);
        blockHeaderBuilder.setNumber(number);
        blockHeaderBuilder.setTimestamp(System.currentTimeMillis());

        block.setBlockHeader(blockHeaderBuilder.build());

        blockHeaderBuilder.setHash(ByteString.copyFrom(sha3(prepareData(block
                .build()))));

        block.setBlockHeader(blockHeaderBuilder.build());
        return block.build();
    }

    /**
     * new genesis block
     *
     * @return {@link Block} block
     */
    public static Block newGenesisBlock(Transaction coinbase) {


        Block.Builder genesisBlock = Block.newBuilder();
        genesisBlock.addTransactions(coinbase);

        BlockHeader.Builder builder = BlockHeader.newBuilder();
        builder.setDifficulty(ByteString.copyFrom(ByteArray.fromHexString
                ("2001")));

        genesisBlock.setBlockHeader(builder.build());

        builder.setHash(ByteString.copyFrom(sha3(prepareData
                (genesisBlock.build()))));

        genesisBlock.setBlockHeader(builder.build());

        return genesisBlock.build();
    }

    /**
     * get prepare data of the block
     *
     * @param block {@link Block} block
     * @return byte[] data
     */
    public static byte[] prepareData(Block block) {
        Block.Builder tmp = block.toBuilder();

        BlockHeader.Builder blockHeader = tmp.getBlockHeaderBuilder();
        blockHeader.clearHash();
        blockHeader.clearIsPoW();
        blockHeader.clearNonce();

        tmp.setBlockHeader(blockHeader.build());

        return tmp.build().toByteArray();
    }

    /**
     * the proof block
     *
     * @param block {@link Block} block
     * @return boolean is it the proof block
     */
    public static boolean isValidate(Block block) {
        return Validator.validate(block);
    }

    /**
     * get print string of the block
     *
     * @param block {@link Block} block
     * @return String format string of the block
     */
    public static String toPrintString(Block block) {
        if (block == null) {
            return "";
        }

        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        return "\nBlock {\n" +
                "\ttimestamp=" + sdf.format(new Timestamp(block
                .getBlockHeader().getTimestamp
                        ())) +
                ", \n\tparentHash=" + ByteArray.toHexString(block
                .getBlockHeader()
                .getParentHash().toByteArray()) +
                ", \n\thash=" + ByteArray.toHexString(block.getBlockHeader()
                .getHash()
                .toByteArray()) +
                ", \n\tnonce=" + ByteArray.toHexString(block.getBlockHeader()
                .getNonce()
                .toByteArray()) +
                ", \n\tdifficulty=" + ByteArray.toHexString(block
                .getBlockHeader()
                .getDifficulty().toByteArray()) +
                ", \n\tnumber=" + block.getBlockHeader().getNumber() +
                "\n}\n";
    }

    /**
     * get mine value
     *
     * @param block {@link Block} block
     * @return byte[] mine value
     */
    public static byte[] getMineValue(Block block) {
        byte[] concat = Arrays.concatenate(prepareData(block), block
                .getBlockHeader().getNonce
                        ().toByteArray());

        return sha3(concat);
    }

    /**
     * get Verified boundary
     *
     * @param block {@link Block} block
     * @return byte[] boundary
     */
    public static byte[] getPowBoundary(Block block) {
        return BigIntegers.asUnsignedByteArray(32, BigInteger.ONE.shiftLeft
                (256).divide(new BigInteger(1, block.getBlockHeader()
                .getDifficulty()
                .toByteArray())));
    }

    /**
     * get increase number + 1
     *
     * @return long number
     */
    public static long getIncreaseNumber(Blockchain blockchain) {
        byte[] lastHash = blockchain.getBlockDB().get(LAST_HASH);
        if (lastHash == null) {
            return 0;
        }

        byte[] value = blockchain.getBlockDB().get(lastHash);
        if (value == null) {
            return 0;
        }

        long number = 0;
        try {

            Block bpRead = Block.parseFrom(value).toBuilder().build();
            number = bpRead.getBlockHeader().getNumber();
            number += 1;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        return number;
    }

    // Whether the hash of the judge block is equal to the hash of the parent
    // block
    public static boolean isParentOf(hayBlock.Block block1, hayBlock.Block
            block2) {

        return (block1.getBlockHeader().getParentHash() == block2.getBlockHeader
                ().getHash());
    }
}

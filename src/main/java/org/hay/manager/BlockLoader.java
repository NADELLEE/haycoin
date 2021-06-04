package org.tron.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.tron.config.SystemProperties;
import org.tron.core.TransactionUtils;
import org.tron.core.TronBlockChainImpl;
import org.tron.protos.core.TronBlock;
import org.tron.protos.core.TronTransaction;
import org.tron.utils.ExecutorPipeline;
import org.tron.utils.Functional;

import java.io.FileInputStream;
import java.util.Scanner;


public class BlockLoader {

    private static final Logger logger = LoggerFactory.getLogger("blockqueue");

    @Autowired
    private TronBlockChainImpl blockchain;

    @Autowired
    SystemProperties config;

    Scanner scanner = null;

    ExecutorPipeline<TronBlock.Block, TronBlock.Block> exce1;
    ExecutorPipeline<TronBlock.Block, ?> exce2;

    public void loadBlocks() {
        exce1 = new ExecutorPipeline(8, 1000, true, new Functional
                .Function<TronBlock.Block, TronBlock.Block>() {

            public TronBlock.Block apply(TronBlock.Block block) {
                if (block.getBlockHeader().getNumber() >= blockchain
                        .getBlockStore().getBestBlock().getBlockHeader()
                        .getNumber()) {
                    for (TronTransaction.Transaction tx : block
                            .getTransactionsList()) {
                        TransactionUtils.getSender(tx);
                    }
                }
                return block;
            }
        }, new Functional.Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                logger.error("Unhandled exception: ", throwable);
            }
        });

        exce2 = exce1.add(1, 1000, new Functional.Consumer<TronBlock.Block>() {
            public void accept(TronBlock.Block block) {
                try {
                    blockWork(block);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        String fileSrc = config.blocksLoader();

        try {
            final String blocksFormat = config.getConfig().hasPath("blocks" +
                    ".format") ? config.getConfig().getString
                    ("blocks.format") : null;
            System.out.println("Loading blocks: " + fileSrc + ", format: " +
                    blocksFormat);

            FileInputStream inputStream = new FileInputStream(fileSrc);

            scanner = new Scanner(inputStream, "UTF-8");

            while (scanner.hasNext()) {
                byte[] blockBytes = Hex.decode(scanner.nextLine());
                TronBlock.Block block = TronBlock.Block.parseFrom(blockBytes);

                exce1.push(block);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void blockWork(TronBlock.Block block) {
        if (block.getBlockHeader().getNumber() >= blockchain.getBlockStore()
                .getBestBlock().getBlockHeader().getNumber()
                || blockchain.getBlockStore().getBlockByHash(block
                .getBlockHeader().getHash().toByteArray()) == null) {
            if (block.getBlockHeader().getNumber() > 0) {
                throw new RuntimeException();
            }
        }
    }
}

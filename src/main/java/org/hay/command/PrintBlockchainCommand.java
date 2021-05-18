package org.hay.command;

import org.hay.core.BlockUtils;
import org.hay.core.Blockchain;
import org.hay.core.BlockchainIterator;
import org.hay.peer.Peer;
import org.hay.protos.core.hayBlock;

public class PrintBlockchainCommand extends Command {
    public PrintBlockchainCommand() {
    }

    @Override
    public void execute(Peer peer, String[] parameters) {
        Blockchain blockchian = peer.getUTXOSet().getBlockchain();
        BlockchainIterator bi = new BlockchainIterator(blockchian);
        while (bi.hasNext()) {
            hayBlock.Block block = (hayBlock.Block) bi.next();
            System.out.println(BlockUtils.toPrintString(block));
        }
    }

    @Override
    public void usage() {
        System.out.println("");
        System.out.println("USAGE [printblockchain]:");
        System.out.println("Command: printblockchain");
        System.out.println("Description: Print Blockchain.");
        System.out.println("");
    }

    @Override
    public boolean check(String[] parameters) {
        return true;
    }
}

package org.hay.command;

import org.hay.peer.Peer;
import org.hay.protos.core.hayTXOutput;

import java.util.ArrayList;

public class GetBalanceCommand extends Command {
    public GetBalanceCommand() {
    }

    @Override
    public void execute(Peer peer, String[] parameters) {
        byte[] pubKeyHash = peer.getWallet().getEcKey().getPubKey();
        ArrayList<hayTXOutput.TXOutput> utxos = peer.getUTXOSet().findUTXO(pubKeyHash);

        long balance = 0;

        for (hayTXOutput.TXOutput txOutput : utxos) {
            balance += txOutput.getValue();
        }

        System.out.println(balance);
    }

    @Override
    public void usage() {
        System.out.println("");
        System.out.println("USAGE [getbalance]:");
        System.out.println("Command: getbalance");
        System.out.println("Description: Get your balance.");
        System.out.println("");
    }

    @Override
    public boolean check(String[] parameters) {
        return true;
    }
}

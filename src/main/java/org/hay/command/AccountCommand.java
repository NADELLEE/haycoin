package org.hay.command;

import org.hay.peer.Peer;
import org.hay.utils.ByteArray;

public class AccountCommand extends Command {
    public AccountCommand() {
    }

    @Override
    public void execute(Peer peer, String[] parameters) {
        System.out.println(ByteArray.toHexString(peer.getMyKey().getAddress()));
    }

    @Override
    public void usage() {
        System.out.println("");
        System.out.println("USAGE [account]:");
        System.out.println("Command: account");
        System.out.println("Description: Get your account.");
        System.out.println("");
    }

    @Override
    public boolean check(String[] parameters) {
        return true;
    }
}

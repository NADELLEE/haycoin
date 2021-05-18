package org.hay.command;

import org.hay.peer.Peer;

public abstract class Command {
    public abstract void execute(Peer peer, String[] parameters);

    public abstract void usage();

    public abstract boolean check(String[] parameters);
}

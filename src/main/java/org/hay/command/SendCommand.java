package org.hay.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hay.core.TransactionUtils;
import org.hay.overlay.message.Message;
import org.hay.overlay.message.Type;
import org.hay.peer.Peer;
import org.hay.protos.core.hayTransaction;
import org.hay.utils.ByteArray;

public class SendCommand extends Command {
    private static final Logger logger = LoggerFactory.getLogger("command");

    public SendCommand() {
    }

    @Override
    public void execute(Peer peer, String[] parameters) {
        if (check(parameters)) {
            String to = parameters[0];
            long amount = Long.valueOf(parameters[1]);
            hayTransaction.Transaction transaction = TransactionUtils.newTransaction(peer.getWallet(), to, amount,
                    peer.getUTXOSet());

            if (transaction != null) {
                Message message = new Message(ByteArray.toHexString(transaction.toByteArray()), Type.TRANSACTION);
                peer.getNet().broadcast(message);
            }
        }
    }

    @Override
    public void usage() {
        System.out.println("");
        System.out.println("USAGE [send]:");
        System.out.println("Command: send [receiver] [mount]");
        System.out.println("Description: Make a transaction.");
        System.out.println("");
    }

    @Override
    public boolean check(String[] parameters) {
        if (parameters.length < 2) {
            logger.error("missing parameters");
            return false;
        }

        if (parameters[0].length() != 40) {
            logger.error("address invalid");
            return false;
        }


        long amount = 0;
        try {
            amount = Long.valueOf(parameters[1]);
        } catch (NumberFormatException e) {
            logger.error("amount invalid");
            return false;
        }

        if (amount <= 0) {
            logger.error("amount required a positive number");
            return false;
        }

        return true;
    }
}

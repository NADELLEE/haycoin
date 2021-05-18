
package org.hay.core;

import org.hay.protos.core.hayTransaction.Transaction;

import java.util.List;


public interface PendingState {

    List<Transaction> addPendingTransactions(List<Transaction> transactions);

    void addPendingTransaction(Transaction tx);

    List<Transaction> getPendingTransactions();

}

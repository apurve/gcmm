package com.luxoft.gcmm.repository;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;

public interface TransactionRepository {

    void addTransaction(Transaction transaction);

    Transactions getTransactions();

    void printAll();
}

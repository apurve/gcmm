package com.luxoft.gcmm.repository;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;

import java.util.List;

public interface TransactionRepository {

    void addTransaction(Transaction transaction);

    List<Transaction> getTransactions();

    void printAll();
}

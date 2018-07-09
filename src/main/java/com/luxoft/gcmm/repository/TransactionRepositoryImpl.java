package com.luxoft.gcmm.repository;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository, Serializable {

    private static final Transactions transactions = new Transactions();
    private static TransactionRepositoryImpl transactionRepository;

    static {
        transactions.setTransactionList(new ArrayList<>());
    }

    private TransactionRepositoryImpl() {
    }

    public static TransactionRepositoryImpl getInstance() {
        if (transactionRepository == null) {
            transactionRepository = new TransactionRepositoryImpl();
        }
        return transactionRepository;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactions.getTransactionList().add(transaction);
        }
    }

    @Override
    public Transactions getTransactions() {
        return transactions.clone();
    }

    @Override
    public void printAll() {
        transactions.getTransactionList().forEach(transaction -> {
            System.out.println(transaction);
        });
    }

}
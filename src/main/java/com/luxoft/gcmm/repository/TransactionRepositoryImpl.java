package com.luxoft.gcmm.repository;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

    private static final Transactions transactions = new Transactions();

    static {
        transactions.setTransactionList(new ArrayList<>());
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if(transaction!=null) {
            transactions.getTransactionList().add(transaction);
        }
    }

    @Override
    public Transactions getTransactions() {
        return transactions.clone();
    }

    @Override
    public  void  printAll(){
        transactions.getTransactionList().forEach(transaction -> {
            System.out.println(transaction);
        });
    }

}
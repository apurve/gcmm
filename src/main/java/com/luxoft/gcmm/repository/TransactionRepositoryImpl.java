package com.luxoft.gcmm.repository;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

    private static final Transactions transactions = new Transactions();

    static {
        transactions.setTransactions(new ArrayList<>());
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if(transaction!=null) {
            transactions.getTransactions().add(transaction);
        }
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions.clone().getTransactions();
    }

    @Override
    public  void  printAll(){
        transactions.getTransactions().forEach( transaction -> {
            System.out.println(transaction);
        });
    }

}
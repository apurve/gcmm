package com.luxoft.gcmm.model;

import java.util.ArrayList;
import java.util.List;

public class Transactions implements Cloneable {

    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    public Transactions clone() {
        final Transactions transactions = new Transactions();
        final List<Transaction> transactionsList = new ArrayList<>();
        this.transactions.forEach(transaction -> {
            transactionsList.add(transaction.clone());
        });
        transactions.setTransactions(transactionsList);
        return transactions;
    }


}

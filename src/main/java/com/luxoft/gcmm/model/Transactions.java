package com.luxoft.gcmm.model;

import java.util.ArrayList;
import java.util.List;

public class Transactions implements Cloneable {

    private List<Transaction> transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }


    public Transactions clone() {
        final Transactions transactions = new Transactions();
        final List<Transaction> transactionsList = new ArrayList<>();
        this.transactionList.forEach(transaction -> {
            transactionsList.add(transaction.clone());
        });
        transactions.setTransactionList(transactionsList);
        return transactions;
    }


}

package com.luxoft.gcmm.repository;

import com.luxoft.gcmm.model.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class TransactionRepositoryTest {

    TransactionRepository transactionRepository = null;

    @Before
    public void initialize() throws InterruptedException {
        transactionRepository = TransactionRepositoryImpl.getInstance();
    }

    @Test
    public void testTransactionRepositoryIsNotCorrupted(){
        List<Transaction> transactions = transactionRepository.getTransactions().getTransactionList();
        transactions.get(0).setPrice(BigDecimal.valueOf(12345));
        Assert.assertNotEquals(transactions.get(0).getPrice(),
                transactionRepository.getTransactions().getTransactionList().get(0).getPrice());
    }

}
package com.luxoft.gcmm.repository;

import com.luxoft.gcmm.model.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.luxoft.gcmm.TestUtils.TransactionDataHelper.populateValidTransactionDummyTransactions;

public class TransactionRepositoryImplTest {

    TransactionRepositoryImpl transactionRepository = null;

    @Before
    public void initialize() throws InterruptedException {
        transactionRepository = new TransactionRepositoryImpl();
        populateValidTransactionDummyTransactions(transactionRepository);
        //transactionRepository.printAll();
    }

    @Test
    public void testTransactionCountInRepository(){
        Assert.assertEquals(transactionRepository.getTransactions().size(), 5);
    }

    @Test
    public void testTransactionRepositoryIsNotCorrupted(){
        List<Transaction> transactions = transactionRepository.getTransactions();
        transactions.get(0).setPrice(BigDecimal.valueOf(10000));
        Assert.assertNotEquals(transactions.get(0).getPrice(), transactionRepository.getTransactions().get(0).getPrice());
    }

}

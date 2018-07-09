package com.luxoft.gcmm.repository;

import com.luxoft.gcmm.model.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.luxoft.gcmm.TestUtils.TransactionDataHelper.populateFiveDummyTransactions;

public class TransactionRepositoryImplTest {

    TransactionRepository transactionRepository = null;

    @Before
    public void initialize() throws InterruptedException {
        transactionRepository = new TransactionRepositoryImpl();
        populateFiveDummyTransactions(transactionRepository);
        //transactionRepository.printAll();
    }

    @Test
    public void testTransactionCountInRepository(){
        Assert.assertEquals(5, transactionRepository.getTransactions().getTransactionList().size());
    }

    @Test
    public void testTransactionRepositoryIsNotCorrupted(){
        List<Transaction> transactions = transactionRepository.getTransactions().getTransactionList();
        transactions.get(0).setPrice(BigDecimal.valueOf(12345));
        Assert.assertNotEquals(transactions.get(0).getPrice(),
                transactionRepository.getTransactions().getTransactionList().get(0).getPrice());
    }

}

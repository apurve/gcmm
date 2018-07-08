package com.luxoft.gcmm.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void testRepo(){
        //Assert.assertEquals(transactionRepository.g);
    }


}

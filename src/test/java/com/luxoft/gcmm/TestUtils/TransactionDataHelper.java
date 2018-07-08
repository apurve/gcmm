package com.luxoft.gcmm.TestUtils;

import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.types.TransactionIndicator;
import com.luxoft.gcmm.repository.TransactionRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;

public class TransactionDataHelper {

    public static void populateValidTransactionDummyTransactions(TransactionRepositoryImpl transactionRepository) throws  InterruptedException {
        transactionRepository.addTransaction(new Transaction(OilID.ACC, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(10000)));
        Thread.sleep(100);
        transactionRepository.addTransaction( new Transaction(OilID.REW, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.SELL, BigDecimal.valueOf(100)));
        //Thread.sleep(100);
        transactionRepository.addTransaction( new Transaction(OilID.TIM, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.SELL, BigDecimal.valueOf(107770)));
        //Thread.sleep(100);
        transactionRepository.addTransaction( new Transaction(OilID.BWO, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(11070)));
        Thread.sleep(100);
        transactionRepository.addTransaction( new Transaction(OilID.QFC, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(100)));
    }

}

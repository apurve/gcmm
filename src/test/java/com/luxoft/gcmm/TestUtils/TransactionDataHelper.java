package com.luxoft.gcmm.TestUtils;

import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.types.TransactionIndicator;
import com.luxoft.gcmm.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;

public class TransactionDataHelper {

    public static void populateFiveDummyTransactions(TransactionRepository transactionRepository) throws InterruptedException {
        if (transactionRepository.getTransactions() == null
                || transactionRepository.getTransactions().getTransactionList() == null
                || transactionRepository.getTransactions().getTransactionList().size() == 0) {
            transactionRepository.addTransaction(new Transaction(OilID.ACC, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(100)));
            Thread.sleep(100);
            transactionRepository.addTransaction(new Transaction(OilID.REW, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.SELL, BigDecimal.valueOf(10)));
            //Thread.sleep(100);
            transactionRepository.addTransaction(new Transaction(OilID.TIM, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.SELL, BigDecimal.valueOf(70)));
            //Thread.sleep(100);
            transactionRepository.addTransaction(new Transaction(OilID.BWO, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(107)));
            Thread.sleep(100);
            transactionRepository.addTransaction(new Transaction(OilID.QFC, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(50)));
        }
    }

}

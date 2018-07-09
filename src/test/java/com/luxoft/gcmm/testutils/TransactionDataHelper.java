package com.luxoft.gcmm.testutils;

import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.types.TransactionIndicator;
import com.luxoft.gcmm.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionDataHelper {

    public static List<Transaction> getFiveDummyTransactions() {
        List<Transaction> transactionList = new ArrayList<>();

        transactionList.add(new Transaction(OilID.ACC, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(100)));

        transactionList.add(new Transaction(OilID.REW, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.SELL, BigDecimal.valueOf(10)));

        transactionList.add(new Transaction(OilID.TIM, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.SELL, BigDecimal.valueOf(70)));

        transactionList.add(new Transaction(OilID.BWO, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(107)));

        transactionList.add(new Transaction(OilID.QFC, LocalDateTime.now(), Integer.valueOf(10), TransactionIndicator.BUY, BigDecimal.valueOf(50)));

        return transactionList;
    }
}



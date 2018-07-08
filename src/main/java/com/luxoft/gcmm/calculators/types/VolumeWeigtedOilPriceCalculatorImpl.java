package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VolumeWeigtedOilPriceCalculatorImpl implements VolumeWeigtedOilPriceCalculator {

    @Override
    public BigDecimal calculate(Transactions transactions) throws IllegalArgumentException, UnsupportedOperationException {
        final LocalDateTime thirtyMinutesBeforeNow = LocalDateTime.now().minusMinutes(30);
        final BigDecimal divident = BigDecimal.ZERO;
        final BigDecimal divisor = BigDecimal.ZERO;

        transactions.getTransactions().forEach(transaction -> {
            if(transaction.getTransactionDateTime().isAfter(thirtyMinutesBeforeNow)) {
                divident.add(computePriceQuantitySummation(transaction));
                divisor.add(BigDecimal.valueOf(transaction.getQuantity()));
            }
        });

        return divident.divide(divisor);
    }

    private BigDecimal computePriceQuantitySummation(Transaction transaction) {
        return transaction.getPrice().multiply(BigDecimal.valueOf(transaction.getQuantity()));
    }

}

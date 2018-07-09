package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.function.Consumer;

public class VolumeWeightedOilPriceCalculatorImpl implements VolumeWeightedOilPriceCalculator {

    @Override
    public BigDecimal calculate(Transactions transactions) throws IllegalArgumentException, UnsupportedOperationException {
        if(transactions.getTransactionList() == null || transactions.getTransactionList().size() == 0) {
            return BigDecimal.ZERO;
        }
        DividendAndDivisorCalculator dividendAndDivisorCalculator = new DividendAndDivisorCalculator();
        transactions.getTransactionList().forEach(dividendAndDivisorCalculator);
        return dividendAndDivisorCalculator.getDividend().divide(dividendAndDivisorCalculator.getDivisor()).setScale(3, RoundingMode.HALF_UP);
    }

}

class DividendAndDivisorCalculator implements Consumer<Transaction> {

    private BigDecimal dividend;
    private BigDecimal divisor;
    private LocalDateTime thirtyMinutesBeforeNow;

    DividendAndDivisorCalculator() {
        this.dividend = BigDecimal.ZERO;
        this.divisor = BigDecimal.ZERO;
        thirtyMinutesBeforeNow = LocalDateTime.now().minusMinutes(30);
    }
    @Override
    public void accept(Transaction transaction) {
        if(transaction.getTransactionDateTime().isAfter(thirtyMinutesBeforeNow)) {
            dividend = dividend.add(multiplyPriceAndQuantity(transaction));
            divisor = divisor.add(BigDecimal.valueOf(transaction.getQuantity()));
        }
    }

    private BigDecimal multiplyPriceAndQuantity(Transaction transaction) {
        return transaction.getPrice().multiply(BigDecimal.valueOf(transaction.getQuantity()));
    }

    public BigDecimal getDividend() {
        return dividend;
    }

    public BigDecimal getDivisor() {
        return divisor;
    }
}
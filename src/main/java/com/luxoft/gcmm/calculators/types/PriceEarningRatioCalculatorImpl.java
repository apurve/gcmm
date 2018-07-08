package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Oil;
import com.luxoft.gcmm.model.types.OilType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceEarningRatioCalculatorImpl implements PriceEarningRatioCalculator {

    RevenueYieldCalculator revenueYieldCalculator = new RevenueYieldCalculatorImpl();

    @Override
    public BigDecimal calculate(Oil oil, BigDecimal oilPrice) throws IllegalArgumentException, UnsupportedOperationException {
        BigDecimal priceEarningRatio = null;
        if(oil != null ) {
            try {
                priceEarningRatio = computePriceEarningRatio(oilPrice, revenueYieldCalculator.calculate(oil, oilPrice));
            } catch (IllegalArgumentException | UnsupportedOperationException exception) {
                throw exception;
            }
        } else {
            throw new IllegalArgumentException("Oil cannot be null.");
        }
        return priceEarningRatio;
    }

    private BigDecimal computePriceEarningRatio(BigDecimal oilPrice, BigDecimal revenue) {
        if(revenue != null && revenue.compareTo(BigDecimal.ZERO) == 1) {
            return oilPrice.divide(revenue, 3, RoundingMode.HALF_UP);
        } else {
            throw new IllegalArgumentException("Revenue cannot be null or zero.");
        }
    }
}

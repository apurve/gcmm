package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.model.Oil;
import com.luxoft.gcmm.model.OilType;

import java.math.BigDecimal;
import java.util.List;

public class RevenueYieldCalculatorImpl implements RevenueYieldCalculator {

    @Override
    public BigDecimal calculate(Oil oil, BigDecimal oilPrice) throws IllegalArgumentException, UnsupportedOperationException {
        BigDecimal revenueYield = null;
        if(oilPrice != null && oilPrice.compareTo(BigDecimal.ZERO) == 1) {
            if(oil != null ) {
                if(OilType.STANDARD.equals(oil.getType())) {
                    revenueYield = computeRevenueYieldForStandardOil(oilPrice, oil);
                } else if(OilType.PREMIUM.equals(oil.getType())) {
                    if(oil.getVariableRevenue() != null) {
                        revenueYield = computeRevenueYieldForPremiumOil(oilPrice, oil);
                    } else {
                        throw new IllegalArgumentException("Variable revenue cannot be null for premium oils.");
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } else {
                throw new IllegalArgumentException("Oil cannot be null.");
            }
        } else {
            throw new IllegalArgumentException("Price cannot be zero or negative");
        }
        return revenueYield;
    }

    private BigDecimal computeRevenueYieldForPremiumOil(BigDecimal price, Oil oil) {
        return (oil.getFixedRevenue().multiply(oil.getVariableRevenue())).divide(price);
    }

    private BigDecimal computeRevenueYieldForStandardOil(BigDecimal price, Oil oil) {
        return oil.getFixedRevenue().divide(price);
    }

}
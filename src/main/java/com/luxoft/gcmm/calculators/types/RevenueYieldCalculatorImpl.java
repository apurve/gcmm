package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.model.Oil;
import com.luxoft.gcmm.model.OilType;

public class RevenueYieldCalculatorImpl implements RevenueYieldCalculator {

    @Override
    public RevenueYield calculate(Oil oil, Double oilPrice) throws IllegalArgumentException, UnsupportedOperationException {
        RevenueYield revenueYield = null;
        if(oilPrice <= 0) {
            throw new IllegalArgumentException("Price cannot be zero or negative");
        } else {
            if(oil != null ) {
                if(OilType.STANDARD.equals(oil.getType())) {
                    revenueYield = new RevenueYield(computeRevenueYieldForStandardOil(oilPrice, oil));
                } else if(OilType.PREMIUM.equals(oil.getType())) {
                    if(oil.getVariableRevenue() != null) {
                        revenueYield = new RevenueYield(computeRevenueYieldForPremiumOil(oilPrice, oil));
                    } else {
                        throw new IllegalArgumentException("Variable revenue cannot be null for premium oils.");
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } else {
                throw new IllegalArgumentException("Oil cannot be null.");
            }
        }
        return revenueYield;
    }

    private double computeRevenueYieldForPremiumOil(Double price, Oil oil) {
        return (oil.getFixedRevenue()*oil.getVariableRevenue())/price;
    }

    private double computeRevenueYieldForStandardOil(Double price, Oil oil) {
        return oil.getFixedRevenue()/price;
    }

}
package com.luxoft.gcmm.calculators.results;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RevenueYield implements CalculationOutput {

    private final List<BigDecimal> revenueYieldList = new ArrayList<BigDecimal>();

    public List<BigDecimal> getRevenueYieldList() {
        return revenueYieldList;
    }

    public RevenueYield addRevenueYield(BigDecimal revenueYield) {
        revenueYieldList.add(revenueYield);
        return this;
    }

}

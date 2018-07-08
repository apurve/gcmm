package com.luxoft.gcmm.calculators.results;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PriceEarningRatio implements CalculationOutput {

    private final List<BigDecimal> priceEarningRatioList = new ArrayList<BigDecimal>();

    public List<BigDecimal> getPriceEarningRatioList() {
        return priceEarningRatioList;
    }

    public PriceEarningRatio addPriceEarningRatio(BigDecimal revenueYield) {
        priceEarningRatioList.add(revenueYield);
        return this;
    }

}

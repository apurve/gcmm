package com.luxoft.gcmm.calculators.results;

import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceEarningRatio implements CalculationOutput {

    private final Map<OilID,BigDecimal> priceEarningRatios = new HashMap<>();

    public Map<OilID,BigDecimal> getPriceEarningRatios() {
        return priceEarningRatios;
    }

    public PriceEarningRatio addPriceEarningRatio(OilID oilID,BigDecimal revenueYield) {
        priceEarningRatios.put(oilID,revenueYield);
        return this;
    }


    @Override
    public String toString() {
        return "PriceEarningRatio{" +
                "priceEarningRatios=" + priceEarningRatios +
                '}';
    }

}

package com.luxoft.gcmm.calculators.results;

import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceEarningRatio {

    private final Map<OilID,BigDecimal> priceEarningRatioMap = new HashMap<>();

    public Map<OilID,BigDecimal> getPriceEarningRatioMap() {
        return priceEarningRatioMap;
    }

    public PriceEarningRatio addPriceEarningRatio(OilID oilID,BigDecimal revenueYield) {
        priceEarningRatioMap.put(oilID,revenueYield);
        return this;
    }


    @Override
    public String toString() {
        return "PriceEarningRatio{" +
                "priceEarningRatioMap=" + priceEarningRatioMap +
                '}';
    }

}

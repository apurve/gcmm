package com.luxoft.gcmm.calculators.results;

import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class RevenueYield {

    private final Map<OilID, BigDecimal> revenueYieldMap = new TreeMap<OilID, BigDecimal>();

    @Override
    public String toString() {
        return "RevenueYield{" +
                "revenueYield=" + revenueYieldMap +
                '}';
    }

    public  Map<OilID,BigDecimal> getRevenueYieldMap() {
        return revenueYieldMap;
    }



    public RevenueYield addRevenueYield(OilID oilID ,BigDecimal revenueYield) {
        revenueYieldMap.put(oilID,revenueYield);
        return this;
    }

}
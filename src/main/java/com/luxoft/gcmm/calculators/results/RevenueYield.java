package com.luxoft.gcmm.calculators.results;

import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RevenueYield implements CalculationOutput {

    private final Map<OilID,BigDecimal> revenueYieldList = new TreeMap<OilID,BigDecimal>();

    @Override
    public String toString() {
        return "RevenueYield{" +
                "revenueYield=" + revenueYieldList +
                '}';
    }

    public  Map<OilID,BigDecimal> getRevenueYieldList() {
        return revenueYieldList;
    }



    public RevenueYield addRevenueYield(OilID oilID ,BigDecimal revenueYield) {
        revenueYieldList.put(oilID,revenueYield);
        return this;
    }

}
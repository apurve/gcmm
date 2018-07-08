package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.model.Oil;

public interface RevenueYieldCalculator {

    RevenueYield calculate(Double price, Oil oil);

}
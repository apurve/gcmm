package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Oil;

import java.math.BigDecimal;

public interface RevenueYieldCalculator {

    BigDecimal calculate(Oil oil, BigDecimal oilPrice) throws IllegalArgumentException, UnsupportedOperationException;

}
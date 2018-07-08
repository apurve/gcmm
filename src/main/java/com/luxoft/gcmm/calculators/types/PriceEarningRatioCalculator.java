package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Oil;

import java.math.BigDecimal;

//TODO
public interface PriceEarningRatioCalculator {

    BigDecimal calculate(Oil oil, BigDecimal oilPrice) throws IllegalArgumentException, UnsupportedOperationException;

}

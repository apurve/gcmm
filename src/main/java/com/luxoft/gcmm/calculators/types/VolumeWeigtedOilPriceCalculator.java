package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Oil;
import com.luxoft.gcmm.model.Transactions;

import java.math.BigDecimal;

public interface VolumeWeigtedOilPriceCalculator {

    BigDecimal calculate(Transactions transactions) throws IllegalArgumentException, UnsupportedOperationException;

}

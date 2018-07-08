package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Oil;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;

import java.math.BigDecimal;
import java.util.List;

public interface VolumeWeightedOilPriceCalculator {

    BigDecimal calculate(Transactions transactions) throws IllegalArgumentException, UnsupportedOperationException;

}

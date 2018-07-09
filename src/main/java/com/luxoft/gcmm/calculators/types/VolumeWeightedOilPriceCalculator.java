package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Oil;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.Transactions;
import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

public interface VolumeWeightedOilPriceCalculator {

    EnumMap<OilID, BigDecimal> calculate(Transactions transactions) throws IllegalArgumentException, UnsupportedOperationException;

}

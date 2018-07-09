package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Transactions;
import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.EnumMap;

public interface GeometricMeanCalculator {

    EnumMap<OilID, BigDecimal> calculate(Transactions transactions);

}

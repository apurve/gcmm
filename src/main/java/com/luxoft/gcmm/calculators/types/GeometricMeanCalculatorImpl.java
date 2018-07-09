package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.calculators.types.helpers.GeometricMeanHelper;
import com.luxoft.gcmm.model.Transactions;
import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;

public class GeometricMeanCalculatorImpl implements GeometricMeanCalculator {

    @Override
    public EnumMap<OilID, BigDecimal> calculate(Transactions transactions) {
        GeometricMeanHelper geometricMeanHelper = new GeometricMeanHelper();
        transactions.getTransactionList().forEach(geometricMeanHelper);

        EnumMap<OilID, BigDecimal> geometricMeanMap = new EnumMap<OilID, BigDecimal>(OilID.class);

        Arrays.stream(OilID.values()).forEach(oil -> {
            GeometricMeanHelper.GeometricMeanMetaData data = geometricMeanHelper.getMeanHelperMap().get(oil);
            geometricMeanMap.put(oil,
                BigDecimal.valueOf(
                    Math.pow(Double.valueOf(data.getSum().toString()), data.getRoot()
                )).setScale(3, RoundingMode.HALF_UP)
            );
        });
        return geometricMeanMap;
    }

}
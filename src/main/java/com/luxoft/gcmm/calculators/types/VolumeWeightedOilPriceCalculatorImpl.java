package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.calculators.types.helpers.GeometricMeanHelper;
import com.luxoft.gcmm.calculators.types.helpers.VolumeWeightedHelper;
import com.luxoft.gcmm.model.Transactions;
import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;

public class VolumeWeightedOilPriceCalculatorImpl implements VolumeWeightedOilPriceCalculator {

    @Override
    public EnumMap<OilID, BigDecimal> calculate(Transactions transactions) throws IllegalArgumentException, UnsupportedOperationException {

        EnumMap<OilID, BigDecimal> volumeWeightedPriceMap = new EnumMap<OilID, BigDecimal>(OilID.class);
        if(transactions.getTransactionList() == null || transactions.getTransactionList().size() == 0) {
            return volumeWeightedPriceMap;
        }

        VolumeWeightedHelper volumeWeightedHelper = new VolumeWeightedHelper();
        transactions.getTransactionList().forEach(volumeWeightedHelper);
        
        Arrays.stream(OilID.values()).forEach(oil -> {
            VolumeWeightedHelper.VolumeWeightedMetaData data = volumeWeightedHelper.getVolumeWeightedHelperMap().get(oil);
            volumeWeightedPriceMap.put(oil,
                    data.getDividend().divide(data.getDivisor()).setScale(3, RoundingMode.HALF_UP)
            );
        });
        return volumeWeightedPriceMap;

    }

}
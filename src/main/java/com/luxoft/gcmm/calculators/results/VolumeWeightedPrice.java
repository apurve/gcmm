package com.luxoft.gcmm.calculators.results;

import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.EnumMap;

public class VolumeWeightedPrice {

    private EnumMap<OilID, BigDecimal> volumeWeightedPriceMap = new EnumMap<OilID, BigDecimal>(OilID.class);

    public VolumeWeightedPrice(EnumMap<OilID, BigDecimal> volumeWeightedPriceMap) {
        this.volumeWeightedPriceMap.putAll(volumeWeightedPriceMap);
    }

    public EnumMap<OilID, BigDecimal> getVolumeWeightedPriceMap() {
        return volumeWeightedPriceMap;
    }

    @Override
    public String toString() {
        return "VolumeWeightedPrice{" +
                "volumeWeightedPriceMap=" + volumeWeightedPriceMap +
                '}';
    }

}
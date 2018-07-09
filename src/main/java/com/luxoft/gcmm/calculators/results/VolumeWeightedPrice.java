package com.luxoft.gcmm.calculators.results;

import java.math.BigDecimal;

public class VolumeWeightedPrice implements CalculationOutput {

    private BigDecimal volumeWeightedPrice = null;

    public VolumeWeightedPrice(BigDecimal volumeWeightedPrice) {
        this.volumeWeightedPrice = volumeWeightedPrice;
    }

    public BigDecimal getVolumeWeightedPrice() {
        return new BigDecimal(volumeWeightedPrice.toString());
    }

}
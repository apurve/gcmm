package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.types.OilID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceEarningRatioCalculatorTest {

    private PriceEarningRatioCalculator priceEarningRatioCalculator;

    @Before
    public void initialize() {
        priceEarningRatioCalculator = new PriceEarningRatioCalculatorImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPriceEarningRatioForZeroPrice() {
        priceEarningRatioCalculator.calculate(OilID.ACC.get(), BigDecimal.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPriceEarningRatioForNegativePrice() {
        priceEarningRatioCalculator.calculate(OilID.ACC.get(), BigDecimal.valueOf(-10.0));
    }

    @Test
    public void testPriceEarningRatioForPositivePrice() {
        BigDecimal priceEarningRatio = priceEarningRatioCalculator.calculate(OilID.ACC.get(), BigDecimal.valueOf(10.0));
        BigDecimal expectedPriceEarningRatio = new BigDecimal("100.000");
        expectedPriceEarningRatio.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedPriceEarningRatio, priceEarningRatio);
    }

    @Test
    public void testPriceEarningRatioForPremiumOil() {
        BigDecimal priceEarningRatio = priceEarningRatioCalculator.calculate(OilID.TIM.get(), BigDecimal.valueOf(10.0));
        BigDecimal expectedPriceEarningRatio = new BigDecimal("12.870");
        expectedPriceEarningRatio.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedPriceEarningRatio, priceEarningRatio);
    }

}

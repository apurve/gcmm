package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

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
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("100.000"), priceEarningRatio);
    }

    @Test
    public void testPriceEarningRatioForPremiumOil() {
        BigDecimal priceEarningRatio = priceEarningRatioCalculator.calculate(OilID.TIM.get(), BigDecimal.valueOf(10.0));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("12.870"), priceEarningRatio);
    }

}

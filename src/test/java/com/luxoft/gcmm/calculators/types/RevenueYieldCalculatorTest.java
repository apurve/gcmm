package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class RevenueYieldCalculatorTest {

    private RevenueYieldCalculator revenueYieldCalculator = null;

    @Before
    public void initialize() {
        revenueYieldCalculator = new RevenueYieldCalculatorImpl();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRevenueYieldForZeroPrice() {
        revenueYieldCalculator.calculate(OilID.ACC.get(), BigDecimal.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRevenueYieldForNegativePrice() {
        revenueYieldCalculator.calculate(OilID.ACC.get(), BigDecimal.valueOf(-10.0));
    }

    @Test
    public void testRevenueYieldForPositivePrice() {
        BigDecimal revenueYield = revenueYieldCalculator.calculate(OilID.ACC.get(), BigDecimal.valueOf(10.0));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.100"), revenueYield);
    }

    @Test
    public void testRevenueYieldForPremiumOil() {
        BigDecimal revenueYield = revenueYieldCalculator.calculate(OilID.TIM.get(), BigDecimal.valueOf(10.0));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.777"), revenueYield);
    }

}
package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.OilFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class RevenueYieldCalculatorTest {

    RevenueYieldCalculator revenueYieldCalculator = null;

    @Before
    public void initialize() {
        revenueYieldCalculator = new RevenueYieldCalculatorImpl();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRevenueYieldForZeroPrice() {
        revenueYieldCalculator.calculate(OilFactory.ACC.get(), BigDecimal.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRevenueYieldForNegativePrice() {
        revenueYieldCalculator.calculate(OilFactory.ACC.get(), BigDecimal.valueOf(-10.0));
    }

    @Test
    public void testRevenueYieldForPositivePrice() {
        BigDecimal revenueYield = revenueYieldCalculator.calculate(OilFactory.ACC.get(), BigDecimal.valueOf(10.0));
        assert BigDecimal.valueOf(0.1).equals(revenueYield);
    }

    @Test
    public void testRevenueYieldForPremiumOil() {
        BigDecimal revenueYield = revenueYieldCalculator.calculate(OilFactory.TIM.get(), BigDecimal.valueOf(10.0));
        assert BigDecimal.valueOf(3.5).equals(revenueYield);
    }

}
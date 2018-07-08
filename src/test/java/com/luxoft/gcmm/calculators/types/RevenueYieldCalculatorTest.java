package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.model.OilTestFactory;
import org.junit.Before;
import org.junit.Test;

public class RevenueYieldCalculatorTest {

    RevenueYieldCalculator revenueYieldCalculator = null;

    @Before
    public void initialize() {
        revenueYieldCalculator = new RevenueYieldCalculatorImpl();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRevenueYieldForZeroPrice() {
        RevenueYield revenueYield = revenueYieldCalculator.calculate(OilTestFactory.initializeACCOil(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRevenueYieldForNegativePrice() {
        RevenueYield revenueYield = revenueYieldCalculator.calculate(OilTestFactory.initializeACCOil(), -10.0);
    }

    @Test
    public void testRevenueYieldForPositivePrice() {
        RevenueYield revenueYield = revenueYieldCalculator.calculate(OilTestFactory.initializeACCOil(), 10.0);
        assert Double.valueOf(0.1).equals(revenueYield.getResult());
    }

    @Test
    public void testRevenueYieldForPremiumOil() {
        RevenueYield revenueYield = revenueYieldCalculator.calculate(OilTestFactory.initializeTIMOil(), 10.0);
        assert Double.valueOf(3.5).equals(revenueYield.getResult());
    }

}
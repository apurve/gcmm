package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.RevenueYield;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RevenueYieldCalculatorFacadeTest {

    CalculatorFacade calculatorFacade;


    @Before
    public void initialize() {
        calculatorFacade = new CalculatorFacade();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRevenueYieldWhenNull(){
        calculatorFacade.calculate(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRevenueYieldWhenPriceZero(){
        calculatorFacade.calculate(FormulaeTypes.REVENUE_YIELD, BigDecimal.ZERO);
    }

    @Test
    public void testCalculateRevenueYieldWhenPriceIsValid(){
        CalculationOutput calculationOutput =  calculatorFacade.calculate(FormulaeTypes.REVENUE_YIELD, BigDecimal.ONE);
        Assert.assertTrue(calculationOutput instanceof RevenueYield);
        Assert.assertNotNull((((RevenueYield) calculationOutput).getRevenueYieldList()));
        Assert.assertEquals(5,(((RevenueYield) calculationOutput)).getRevenueYieldList().size());

        assertRevenueYieldOfACCOil((RevenueYield) calculationOutput);
        assertRevenueYieldOfREWOil((RevenueYield) calculationOutput);
        assertRevenueYieldOfBWOOil((RevenueYield) calculationOutput);
        assertRevenueYieldOfTIMOil((RevenueYield) calculationOutput);
        assertRevenueYieldOfQFCOil((RevenueYield) calculationOutput);
    }

    private void assertRevenueYieldOfQFCOil(RevenueYield calculationOutput) {
        BigDecimal expectedRevenueYield = new BigDecimal("22.000");
        expectedRevenueYield.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedRevenueYield, calculationOutput.getRevenueYieldList().get(4));
    }

    private void assertRevenueYieldOfTIMOil(RevenueYield calculationOutput) {
        BigDecimal expectedRevenueYield = new BigDecimal("7.770");
        expectedRevenueYield.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedRevenueYield, calculationOutput.getRevenueYieldList().get(3));
    }

    private void assertRevenueYieldOfBWOOil(RevenueYield calculationOutput) {
        BigDecimal expectedRevenueYield = new BigDecimal("17.000");
        expectedRevenueYield.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedRevenueYield, calculationOutput.getRevenueYieldList().get(2));
    }

    private void assertRevenueYieldOfREWOil(RevenueYield calculationOutput) {
        BigDecimal expectedRevenueYield = new BigDecimal("7.000");
        expectedRevenueYield.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedRevenueYield, calculationOutput.getRevenueYieldList().get(1));
    }

    private void assertRevenueYieldOfACCOil(RevenueYield calculationOutput) {
        BigDecimal expectedRevenueYield = new BigDecimal("1.000");
        expectedRevenueYield.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedRevenueYield, calculationOutput.getRevenueYieldList().get(0));
    }

}

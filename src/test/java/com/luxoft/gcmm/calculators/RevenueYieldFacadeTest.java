package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class RevenueYieldFacadeTest extends AbstractFacadeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFacadeWhenPriceZero(){
        gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_REVENUE_YIELD, BigDecimal.ZERO, null);
    }

    @Override
    public void testFacadeWithValidInput(){
        CalculationOutput calculationOutput =  gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_REVENUE_YIELD, BigDecimal.ONE, null);
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
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("22.000"), calculationOutput.getRevenueYieldList().get(4));
    }

    private void assertRevenueYieldOfTIMOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("7.770"), calculationOutput.getRevenueYieldList().get(3));
    }

    private void assertRevenueYieldOfBWOOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("17.000"), calculationOutput.getRevenueYieldList().get(2));
    }

    private void assertRevenueYieldOfREWOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("7.000"), calculationOutput.getRevenueYieldList().get(1));
    }

    private void assertRevenueYieldOfACCOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("1.000"), calculationOutput.getRevenueYieldList().get(0));
    }

}

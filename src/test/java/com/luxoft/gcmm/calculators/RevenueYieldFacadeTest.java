package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class RevenueYieldFacadeTest extends AbstractFacadeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFacadeWhenPriceZero(){
        gcmmOperationsFacade.computeRevenueYield(BigDecimal.ZERO);
    }

    @Override
    public void testFacadeWithValidInput(){
        RevenueYield revenueYield =  gcmmOperationsFacade.computeRevenueYield(BigDecimal.ONE);
        Assert.assertNotNull((revenueYield.getRevenueYieldMap()));
        Assert.assertEquals(5,(revenueYield.getRevenueYieldMap().size()));

        assertRevenueYieldOfACCOil(revenueYield);
        assertRevenueYieldOfREWOil(revenueYield);
        assertRevenueYieldOfBWOOil(revenueYield);
        assertRevenueYieldOfTIMOil(revenueYield);
        assertRevenueYieldOfQFCOil(revenueYield);
    }

    private void assertRevenueYieldOfQFCOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("22.000"), calculationOutput.getRevenueYieldMap().get((OilID.QFC)));
    }

    private void assertRevenueYieldOfTIMOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("7.770"), calculationOutput.getRevenueYieldMap().get((OilID.TIM)));
    }

    private void assertRevenueYieldOfBWOOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("17.000"), calculationOutput.getRevenueYieldMap().get(OilID.BWO));
    }

    private void assertRevenueYieldOfREWOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("7.000"), calculationOutput.getRevenueYieldMap().get((OilID.REW)));
    }

    private void assertRevenueYieldOfACCOil(RevenueYield calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("1.000"), calculationOutput.getRevenueYieldMap().get((OilID.ACC)));
    }

}

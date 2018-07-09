package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.PriceEarningRatio;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PriceEarningRatioFacadeTest extends AbstractFacadeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFacadeWhenPriceZero(){
        gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_PRICE_EARNING_RATIO, BigDecimal.ZERO, null);
    }

    @Override
    public void testFacadeWithValidInput(){
        CalculationOutput calculationOutput =  gcmmOperationsFacade.calculate(
                GCMMOperations.COMPUTE_PRICE_EARNING_RATIO, BigDecimal.ONE, null);
        Assert.assertTrue(calculationOutput instanceof PriceEarningRatio);
        Assert.assertNotNull((((PriceEarningRatio) calculationOutput).getPriceEarningRatioList()));
        Assert.assertEquals(5,(((PriceEarningRatio) calculationOutput)).getPriceEarningRatioList().size());

        assertPriceEarningRatioOfACCOil((PriceEarningRatio) calculationOutput);
        assertPriceEarningRatioOfREWOil((PriceEarningRatio) calculationOutput);
        assertPriceEarningRatioOfBWOOil((PriceEarningRatio) calculationOutput);
        assertPriceEarningRatioOfTIMOil((PriceEarningRatio) calculationOutput);
        assertPriceEarningRatioOfQFCOil((PriceEarningRatio) calculationOutput);
    }

    private void assertPriceEarningRatioOfQFCOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.045"), calculationOutput.getPriceEarningRatioList().get(4));
    }

    private void assertPriceEarningRatioOfTIMOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.129"), calculationOutput.getPriceEarningRatioList().get(3));
    }

    private void assertPriceEarningRatioOfBWOOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.059"), calculationOutput.getPriceEarningRatioList().get(2));
    }

    private void assertPriceEarningRatioOfREWOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.143"), calculationOutput.getPriceEarningRatioList().get(1));
    }

    private void assertPriceEarningRatioOfACCOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("1.000"), calculationOutput.getPriceEarningRatioList().get(0));
    }

}

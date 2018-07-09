package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.PriceEarningRatio;
import com.luxoft.gcmm.model.types.OilID;
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
        Assert.assertNotNull((((PriceEarningRatio) calculationOutput).getPriceEarningRatios()));
        Assert.assertEquals(5,(((PriceEarningRatio) calculationOutput)).getPriceEarningRatios().size());

        assertPriceEarningRatioOfACCOil((PriceEarningRatio) calculationOutput);
        assertPriceEarningRatioOfREWOil((PriceEarningRatio) calculationOutput);
        assertPriceEarningRatioOfBWOOil((PriceEarningRatio) calculationOutput);
        assertPriceEarningRatioOfTIMOil((PriceEarningRatio) calculationOutput);
        assertPriceEarningRatioOfQFCOil((PriceEarningRatio) calculationOutput);
    }

    private void assertPriceEarningRatioOfQFCOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.045"), calculationOutput.getPriceEarningRatios().get((OilID.QFC)));
    }

    private void assertPriceEarningRatioOfTIMOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.129"), calculationOutput.getPriceEarningRatios().get(OilID.TIM));
    }

    private void assertPriceEarningRatioOfBWOOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.059"), calculationOutput.getPriceEarningRatios().get(OilID.BWO));
    }

    private void assertPriceEarningRatioOfREWOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.143"), calculationOutput.getPriceEarningRatios().get(OilID.REW));
    }

    private void assertPriceEarningRatioOfACCOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("1.000"), calculationOutput.getPriceEarningRatios().get(OilID.ACC));
    }

}

package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.PriceEarningRatio;
import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PriceEarningRatioFacadeTest extends AbstractFacadeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFacadeWhenPriceZero(){
        gcmmOperationsFacade.computePriceEarningRatio(BigDecimal.ZERO);
    }

    @Override
    public void testFacadeWithValidInput(){
        PriceEarningRatio priceEarningRatio =  gcmmOperationsFacade.computePriceEarningRatio(BigDecimal.ONE);

        Assert.assertNotNull(priceEarningRatio.getPriceEarningRatioMap());
        Assert.assertEquals(5,priceEarningRatio.getPriceEarningRatioMap().size());

        assertPriceEarningRatioOfACCOil(priceEarningRatio);
        assertPriceEarningRatioOfREWOil(priceEarningRatio);
        assertPriceEarningRatioOfBWOOil(priceEarningRatio);
        assertPriceEarningRatioOfTIMOil(priceEarningRatio);
        assertPriceEarningRatioOfQFCOil(priceEarningRatio);
    }

    private void assertPriceEarningRatioOfQFCOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.045"), calculationOutput.getPriceEarningRatioMap().get((OilID.QFC)));
    }

    private void assertPriceEarningRatioOfTIMOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.129"), calculationOutput.getPriceEarningRatioMap().get(OilID.TIM));
    }

    private void assertPriceEarningRatioOfBWOOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.059"), calculationOutput.getPriceEarningRatioMap().get(OilID.BWO));
    }

    private void assertPriceEarningRatioOfREWOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("0.143"), calculationOutput.getPriceEarningRatioMap().get(OilID.REW));
    }

    private void assertPriceEarningRatioOfACCOil(PriceEarningRatio calculationOutput) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("1.000"), calculationOutput.getPriceEarningRatioMap().get(OilID.ACC));
    }

}

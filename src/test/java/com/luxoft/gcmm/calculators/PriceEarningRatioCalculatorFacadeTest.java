package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.PriceEarningRatio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceEarningRatioCalculatorFacadeTest {

    CalculatorFacade calculatorFacade;

    @Before
    public void initialize() {
        calculatorFacade = new CalculatorFacade();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculatePriceEarningRatioWhenNull(){
        calculatorFacade.calculate(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculatePriceEarningRatioWhenPriceZero(){
        calculatorFacade.calculate(FormulaeTypes.PRICE_EARNING_RATIO, BigDecimal.ZERO);
    }

    @Test
    public void testCalculatePriceEarningRatioWhenPriceIsValid(){
        CalculationOutput calculationOutput =  calculatorFacade.calculate(FormulaeTypes.PRICE_EARNING_RATIO, BigDecimal.ONE);
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
        BigDecimal expectedPriceEarningRatio = new BigDecimal("0.045");
        expectedPriceEarningRatio.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedPriceEarningRatio, calculationOutput.getPriceEarningRatioList().get(4));
    }

    private void assertPriceEarningRatioOfTIMOil(PriceEarningRatio calculationOutput) {
        BigDecimal expectedPriceEarningRatio = new BigDecimal("0.129");
        expectedPriceEarningRatio.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedPriceEarningRatio, calculationOutput.getPriceEarningRatioList().get(3));
    }

    private void assertPriceEarningRatioOfBWOOil(PriceEarningRatio calculationOutput) {
        BigDecimal expectedPriceEarningRatio = new BigDecimal("0.059");
        expectedPriceEarningRatio.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedPriceEarningRatio, calculationOutput.getPriceEarningRatioList().get(2));
    }

    private void assertPriceEarningRatioOfREWOil(PriceEarningRatio calculationOutput) {
        BigDecimal expectedPriceEarningRatio = new BigDecimal("0.143");
        expectedPriceEarningRatio.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedPriceEarningRatio, calculationOutput.getPriceEarningRatioList().get(1));
    }

    private void assertPriceEarningRatioOfACCOil(PriceEarningRatio calculationOutput) {
        BigDecimal expectedPriceEarningRatio = new BigDecimal("1.000");
        expectedPriceEarningRatio.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedPriceEarningRatio, calculationOutput.getPriceEarningRatioList().get(0));
    }

}

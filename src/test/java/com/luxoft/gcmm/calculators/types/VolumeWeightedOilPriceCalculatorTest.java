package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.model.Transactions;
import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.testutils.TransactionDataHelper;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.EnumMap;

public class VolumeWeightedOilPriceCalculatorTest {

    VolumeWeightedOilPriceCalculator volumeWeightedOilPriceCalculator = null;
    private Transactions transactions;

    @Before
    public void initialize() {
        volumeWeightedOilPriceCalculator = new VolumeWeightedOilPriceCalculatorImpl();
        transactions = new Transactions();
        transactions.setTransactionList(TransactionDataHelper.getFiveDummyTransactions());
    }

    @Test
    public void testVolumeWeightedPriceComputation() {
        EnumMap<OilID, BigDecimal> volumeWeightedOilPriceMap = volumeWeightedOilPriceCalculator.calculate(transactions);
        Assert.assertNotNull(volumeWeightedOilPriceMap);
        Assert.assertEquals(5, volumeWeightedOilPriceMap.size());
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("100.000"), volumeWeightedOilPriceMap.get(OilID.ACC));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("10.000"), volumeWeightedOilPriceMap.get(OilID.REW));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("107.000"), volumeWeightedOilPriceMap.get(OilID.BWO));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("70.000"), volumeWeightedOilPriceMap.get(OilID.TIM));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("50.000"), volumeWeightedOilPriceMap.get(OilID.QFC));
    }

}
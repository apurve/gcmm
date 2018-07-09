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

public class GeometricMeanCalculatorTest {

    private GeometricMeanCalculator geometricMeanCalculator;
    private Transactions transactions;

    @Before
    public void initialize() {
        geometricMeanCalculator = new GeometricMeanCalculatorImpl();
        transactions = new Transactions();
        transactions.setTransactionList(TransactionDataHelper.getFiveDummyTransactions());
    }

    @Test
    public void testGeometricMeanComputation() {
        EnumMap<OilID, BigDecimal> geometricMeanMap = geometricMeanCalculator.calculate(transactions);
        Assert.assertNotNull(geometricMeanMap);
        Assert.assertEquals(5, geometricMeanMap.size());
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("100.000"), geometricMeanMap.get(OilID.ACC));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("10.000"), geometricMeanMap.get(OilID.REW));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("107.000"), geometricMeanMap.get(OilID.BWO));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("70.000"), geometricMeanMap.get(OilID.TIM));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("50.000"), geometricMeanMap.get(OilID.QFC));
    }

}

package com.luxoft.gcmm.integration;

import com.luxoft.gcmm.calculators.GCMMOperationsFacade;
import com.luxoft.gcmm.calculators.results.InventoryIndexes;
import com.luxoft.gcmm.calculators.results.PriceEarningRatio;
import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.calculators.results.VolumeWeightedPrice;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.testutils.TransactionDataHelper;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class IntegrationTest {

    private GCMMOperationsFacade gcmmOperationsFacade;

    @Before
    public void initialize() {
        gcmmOperationsFacade = new GCMMOperationsFacade();
    }

    @Test
    public void testUserBehavious() {
        assertRevenueYield(gcmmOperationsFacade.computeRevenueYield(BigDecimal.valueOf(100)));
        assertPriceEarningRatio(gcmmOperationsFacade.computePriceEarningRatio(BigDecimal.valueOf(100)));

        List<Transaction> transactionList = TransactionDataHelper.getFiveDummyTransactions();
        transactionList.forEach(transaction -> {
            gcmmOperationsFacade.transact(transaction);
        });

        assertVolumeWeightedPrice(gcmmOperationsFacade.computeVolumeWeightedPrice());
        assertInventoryIndex(gcmmOperationsFacade.computeInventoryIndex());
    }

    private void assertInventoryIndex(InventoryIndexes inventoryIndexes) {
        assertEqualsExpectedAndComputed("40000.000", inventoryIndexes.getInventoryIndexMap().get(OilID.ACC));
        assertEqualsExpectedAndComputed("400.000", inventoryIndexes.getInventoryIndexMap().get(OilID.REW));
        assertEqualsExpectedAndComputed("45796.000", inventoryIndexes.getInventoryIndexMap().get(OilID.BWO));
        assertEqualsExpectedAndComputed("19600.000", inventoryIndexes.getInventoryIndexMap().get(OilID.TIM));
        assertEqualsExpectedAndComputed("10000.000", inventoryIndexes.getInventoryIndexMap().get(OilID.QFC));
    }

    private void assertVolumeWeightedPrice(VolumeWeightedPrice volumeWeightedPrice) {
        assertEqualsExpectedAndComputed("100.000", volumeWeightedPrice.getVolumeWeightedPriceMap().get(OilID.ACC));
        assertEqualsExpectedAndComputed("10.000", volumeWeightedPrice.getVolumeWeightedPriceMap().get(OilID.REW));
        assertEqualsExpectedAndComputed("107.000", volumeWeightedPrice.getVolumeWeightedPriceMap().get(OilID.BWO));
        assertEqualsExpectedAndComputed("70.000", volumeWeightedPrice.getVolumeWeightedPriceMap().get(OilID.TIM));
        assertEqualsExpectedAndComputed("50.000", volumeWeightedPrice.getVolumeWeightedPriceMap().get(OilID.QFC));
    }

    private void assertPriceEarningRatio(PriceEarningRatio priceEarningRatio) {
        assertEqualsExpectedAndComputed("10000.000", priceEarningRatio.getPriceEarningRatioMap().get(OilID.ACC));
        assertEqualsExpectedAndComputed("1428.571", priceEarningRatio.getPriceEarningRatioMap().get(OilID.REW));
        assertEqualsExpectedAndComputed("588.235", priceEarningRatio.getPriceEarningRatioMap().get(OilID.BWO));
        assertEqualsExpectedAndComputed("1282.051", priceEarningRatio.getPriceEarningRatioMap().get(OilID.TIM));
        assertEqualsExpectedAndComputed("454.545", priceEarningRatio.getPriceEarningRatioMap().get(OilID.QFC));
    }

    private void assertRevenueYield(RevenueYield revenueYield) {
        assertEqualsExpectedAndComputed("0.010", revenueYield.getRevenueYieldMap().get(OilID.ACC));
        assertEqualsExpectedAndComputed("0.070", revenueYield.getRevenueYieldMap().get(OilID.REW));
        assertEqualsExpectedAndComputed("0.170", revenueYield.getRevenueYieldMap().get(OilID.BWO));
        assertEqualsExpectedAndComputed("0.078", revenueYield.getRevenueYieldMap().get(OilID.TIM));
        assertEqualsExpectedAndComputed("0.220", revenueYield.getRevenueYieldMap().get(OilID.QFC));
    }

    private void assertEqualsExpectedAndComputed(String expected, BigDecimal computed) {
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf(expected), computed);
    }

}
package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.VolumeWeightedPrice;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.testutils.TransactionDataHelper;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;

import java.util.List;

public class VolumeWeightedPriceFacadeTest extends AbstractFacadeTest {

    @Override
    public void testFacadeWithValidInput() throws InterruptedException {
        populateTransactionRepository();
        CalculationOutput calculationOutput = gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_VOLUME_WEIGHTED_PRICE, null, null);
        Assert.assertTrue(calculationOutput instanceof VolumeWeightedPrice);
        Assert.assertNotNull((((VolumeWeightedPrice) calculationOutput).getVolumeWeightedPriceMap()));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("100.000"),(((VolumeWeightedPrice) calculationOutput).getVolumeWeightedPriceMap().get(OilID.ACC)));
    }

    private void populateTransactionRepository() throws InterruptedException {
        List<Transaction> transactionList = TransactionDataHelper.getFiveDummyTransactions();
        transactionList.forEach(transaction -> {
            gcmmOperationsFacade.calculate(GCMMOperations.TRANSACT, null, transaction);
        });
    }

}

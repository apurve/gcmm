package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.VolumeWeightedPrice;
import com.luxoft.gcmm.repository.TransactionRepository;
import com.luxoft.gcmm.repository.TransactionRepositoryImpl;
import com.luxoft.gcmm.utils.BigDecimalWithThreeDecimals;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.luxoft.gcmm.TestUtils.TransactionDataHelper.populateFiveDummyTransactions;

public class VolumeWeightedPriceFacadeTest extends AbstractFacadeTest {

    @Override
    public void testFacadeWithValidInput() throws InterruptedException {
        populateTransactionRepository();
        CalculationOutput calculationOutput = gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_VOLUME_WEIGHTED_PRICE, null, null);
        Assert.assertTrue(calculationOutput instanceof VolumeWeightedPrice);
        Assert.assertNotNull((((VolumeWeightedPrice) calculationOutput).getVolumeWeightedPrice()));
        Assert.assertEquals(BigDecimalWithThreeDecimals.valueOf("67.400"),(((VolumeWeightedPrice) calculationOutput).getVolumeWeightedPrice()));
    }

    private void populateTransactionRepository() throws InterruptedException {
        TransactionRepository transactionRepository = new TransactionRepositoryImpl();
        populateFiveDummyTransactions(transactionRepository);
    }

}

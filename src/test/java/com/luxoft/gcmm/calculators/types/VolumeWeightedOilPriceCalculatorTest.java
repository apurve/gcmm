package com.luxoft.gcmm.calculators.types;

import com.luxoft.gcmm.repository.TransactionRepository;
import com.luxoft.gcmm.repository.TransactionRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.luxoft.gcmm.TestUtils.TransactionDataHelper.populateFiveDummyTransactions;

public class VolumeWeightedOilPriceCalculatorTest {

    VolumeWeightedOilPriceCalculator volumeWeightedOilPriceCalculator = null;
    TransactionRepository transactionRepository = null;

    @Before
    public void initialize() throws InterruptedException {
        volumeWeightedOilPriceCalculator = new VolumeWeightedOilPriceCalculatorImpl();
        transactionRepository = new TransactionRepositoryImpl();
        populateFiveDummyTransactions(transactionRepository);
    }

    @Test
    public void testVolumeWeightedPriceComputation() {
        BigDecimal volumeWeightedOilPrice = volumeWeightedOilPriceCalculator.calculate(transactionRepository.getTransactions());
        BigDecimal expectedvolumeWeightedOilPrice = new BigDecimal("67.400");
        expectedvolumeWeightedOilPrice.setScale(3, RoundingMode.HALF_UP);
        Assert.assertEquals(expectedvolumeWeightedOilPrice, volumeWeightedOilPrice);
    }

}
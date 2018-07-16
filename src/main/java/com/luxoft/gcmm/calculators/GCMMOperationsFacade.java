package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.*;
import com.luxoft.gcmm.calculators.types.*;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.repository.TransactionRepository;
import com.luxoft.gcmm.repository.TransactionRepositoryImpl;

import java.math.BigDecimal;
import java.util.Arrays;

public class GCMMOperationsFacade {

    private RevenueYieldCalculator revenueYieldCalculator = new RevenueYieldCalculatorImpl();

    private PriceEarningRatioCalculator priceEarningRatioCalculator = new PriceEarningRatioCalculatorImpl();

    private VolumeWeightedOilPriceCalculator volumeWeightedOilPriceCalculator = new VolumeWeightedOilPriceCalculatorImpl();

    private TransactionRepository transactionRepository = TransactionRepositoryImpl.getInstance();

    private GeometricMeanCalculator geometricMeanCalculator = new GeometricMeanCalculatorImpl();

    public InventoryIndexes computeInventoryIndex() {
        return new InventoryIndexes().addInventoryIndexes(
                geometricMeanCalculator.calculate(transactionRepository.getTransactions()));
    }

    public RevenueYield computeRevenueYield(BigDecimal price) {
        RevenueYield revenueYield = new RevenueYield();
        Arrays.stream(OilID.values()).forEach(oilFactory -> revenueYield.addRevenueYield(oilFactory.getOil().getId() , revenueYieldCalculator.calculate(oilFactory.getOil(), price)));
        return revenueYield;
    }

    public PriceEarningRatio computePriceEarningRatio(BigDecimal price) {
        PriceEarningRatio priceEarningRatio = new PriceEarningRatio();
        Arrays.stream(OilID.values()).forEach(oilID -> priceEarningRatio.addPriceEarningRatio(oilID.getOil().getId(),priceEarningRatioCalculator.calculate(oilID.getOil(), price)));
        return priceEarningRatio;
    }

    public VolumeWeightedPrice computeVolumeWeightedPrice() {
        return new VolumeWeightedPrice(
                volumeWeightedOilPriceCalculator.calculate(transactionRepository.getTransactions()));
    }

    public void transact(Transaction transaction) {
        transactionRepository.addTransaction(transaction);
    }

}
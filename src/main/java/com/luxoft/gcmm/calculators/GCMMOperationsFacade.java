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

    public CalculationOutput calculate(GCMMOperations operation, BigDecimal price, Transaction transaction) {
        CalculationOutput calculationOutput = null;
        if (operation == null) {
            throw new IllegalArgumentException("Formulae cannot be null");
        }
        switch (operation) {
            case COMPUTE_REVENUE_YIELD: {
                calculationOutput = computeRevenueYield(price);
                break;
            }
            case COMPUTE_PRICE_EARNING_RATIO: {
                calculationOutput = computePriceEarningRatio(price);
                break;
            }
            case TRANSACT: {
                transact(transaction);
                break;
            }
            case COMPUTE_VOLUME_WEIGHTED_PRICE: {
                calculationOutput = computeVolumeWeightedPrice();
                break;
            }
            case COMPUTE_INVENTORY_INDEX: {
                calculationOutput = computeInventoryIndex();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid Formulae type");
            }
        }
        return calculationOutput;
    }

    private InventoryIndexes computeInventoryIndex() {
        return new InventoryIndexes().addInventoryIndexes(
                geometricMeanCalculator.calculate(transactionRepository.getTransactions()));
    }

    private RevenueYield computeRevenueYield(BigDecimal price) {
        RevenueYield revenueYield = new RevenueYield();
        Arrays.stream(OilID.values()).forEach(oilFactory -> {
            revenueYield.addRevenueYield(oilFactory.get().getId() , revenueYieldCalculator.calculate(oilFactory.get(), price));
        });
        return revenueYield;
    }

    private PriceEarningRatio computePriceEarningRatio(BigDecimal price) {
        PriceEarningRatio priceEarningRatio = new PriceEarningRatio();
        Arrays.stream(OilID.values()).forEach(oilFactory -> {
            priceEarningRatio.addPriceEarningRatio(oilFactory.get().getId(),priceEarningRatioCalculator.calculate(oilFactory.get(), price));
        });
        return priceEarningRatio;
    }

    private VolumeWeightedPrice computeVolumeWeightedPrice() {
        return new VolumeWeightedPrice().addVolumeWeightedPrice(
                volumeWeightedOilPriceCalculator.calculate(transactionRepository.getTransactions())
        );
    }

    private void transact(Transaction transaction) {
        transactionRepository.addTransaction(transaction);
    }

}
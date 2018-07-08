package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.PriceEarningRatio;
import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.calculators.types.PriceEarningRatioCalculator;
import com.luxoft.gcmm.calculators.types.PriceEarningRatioCalculatorImpl;
import com.luxoft.gcmm.calculators.types.RevenueYieldCalculator;
import com.luxoft.gcmm.calculators.types.RevenueYieldCalculatorImpl;
import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.Arrays;

public class CalculatorFacade {

    private RevenueYieldCalculator revenueYieldCalculator = new RevenueYieldCalculatorImpl();

    private PriceEarningRatioCalculator priceEarningRatioCalculator = new PriceEarningRatioCalculatorImpl();

    public CalculationOutput calculate(FormulaeTypes formulae, BigDecimal price) {
        CalculationOutput calculationOutput = null;
        if(formulae==null){
            throw new IllegalArgumentException("Formulae cannot be null");
        }
        switch (formulae) {
            case REVENUE_YIELD: {
                calculationOutput = computeRevenueYield(price);
                break;
            }
            case PRICE_EARNING_RATIO: {
                calculationOutput = computePriceEarningRatio(price);
                break;
            }
            case GEOMETRIC_MEAN: {
                break;
            }
            case VOLUME_WEIGHTED_OIL_PRICE: {
                break;
            }
             default :{
                 throw new IllegalArgumentException("Invalid Formulae type");
            }
        }
        return calculationOutput;
    }

    private RevenueYield computeRevenueYield(BigDecimal price) {
        RevenueYield revenueYield = new RevenueYield();
        Arrays.stream(OilID.values()).forEach(oilFactory -> {
            revenueYield.addRevenueYield(revenueYieldCalculator.calculate(oilFactory.get(), price));
        });
        return revenueYield;
    }

    private PriceEarningRatio computePriceEarningRatio(BigDecimal price) {
        PriceEarningRatio priceEarningRatio = new PriceEarningRatio();
        Arrays.stream(OilID.values()).forEach(oilFactory -> {
            priceEarningRatio.addPriceEarningRatio(priceEarningRatioCalculator.calculate(oilFactory.get(), price));
        });
        return priceEarningRatio;
    }

}
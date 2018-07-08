package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.results.RevenueYield;
import com.luxoft.gcmm.calculators.types.RevenueYieldCalculator;
import com.luxoft.gcmm.calculators.types.RevenueYieldCalculatorImpl;
import com.luxoft.gcmm.model.Oil;
import com.luxoft.gcmm.model.OilFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

public class CalculatorFacade {

    RevenueYieldCalculator revenueYieldCalculator = new RevenueYieldCalculatorImpl();

    public CalculationOutput calculate(FormulaeTypes formulae, BigDecimal price) {
        CalculationOutput calculationOutput = null;
        switch (formulae) {
            case REVENUE_YIELD: {
                RevenueYield revenueYield = new RevenueYield();
                Arrays.stream(OilFactory.values()).forEach(oilFactory -> {
                    revenueYield.addRevenueYield(revenueYieldCalculator.calculate(oilFactory.get(), price));
                });
                calculationOutput = revenueYield;
                break;
            }
            case PRICE_EARNING_RATIO: {
                break;
            }
            case GEOMETRIC_MEAN: {
                break;
            }
            case VOLUME_WEIGHTED_OIL_PRICE: {
                break;
            }
        }
        return calculationOutput;
    }

}

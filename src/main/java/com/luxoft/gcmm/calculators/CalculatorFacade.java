package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.calculators.results.CalculationOutput;
import com.luxoft.gcmm.calculators.types.RevenueYieldCalculator;
import com.luxoft.gcmm.calculators.types.RevenueYieldCalculatorImpl;
import com.luxoft.gcmm.model.Oil;

public class CalculatorFacade {

    RevenueYieldCalculator revenueYieldCalculator = new RevenueYieldCalculatorImpl();

    public CalculationOutput calculate(Oil oil, FormulaeTypes formulae, Double price) {
        CalculationOutput calculationOutput = null;
        switch (formulae) {
            case REVENUE_YIELD: {
                calculationOutput = revenueYieldCalculator.calculate(price, );
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

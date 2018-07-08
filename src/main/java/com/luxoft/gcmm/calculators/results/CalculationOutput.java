package com.luxoft.gcmm.calculators.results;

public abstract class CalculationOutput {

    private Double result;

    CalculationOutput(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }
    
}

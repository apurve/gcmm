package com.luxoft.gcmm.model;

public class OilTestFactory {

    private static Oil acc = null;
    private static Oil accPremium = null;
    private static Oil rew = null;
    private static Oil tim = null;

    private OilTestFactory(){}

    public static Oil initializeACCOil() {
        if(acc == null) {
            acc = new Oil("AAC", OilType.STANDARD);
            acc.setFixedRevenue(1);
            acc.setBarrelValue(42);
        }
        return acc;
    }

    public static Oil initializePremiumACCOil() {
        if(accPremium == null) {
            accPremium = new Oil("AAC", OilType.PREMIUM);
            accPremium.setFixedRevenue(10);
            accPremium.setBarrelValue(84);
        }
        return accPremium;
    }

    public static Oil initializeREWOil() {
        if(rew == null) {
            rew = new Oil("REW", OilType.STANDARD);
            rew.setFixedRevenue(7);
            rew.setBarrelValue(47);
        }
        return rew;
    }

    public static Oil initializeTIMOil() {
        if(tim == null) {
            tim = new Oil("TIM", OilType.PREMIUM);
            tim.setFixedRevenue(5);
            tim.setBarrelValue(111);
            tim.setVariableRevenue(7);
        }
        return tim;
    }

}

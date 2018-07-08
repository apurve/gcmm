package com.luxoft.gcmm.model;

import java.math.BigDecimal;

public enum OilFactory {

    ACC {
        @Override
        public Oil get() {
            Oil acc = new Oil("AAC", OilType.STANDARD);
            acc.setFixedRevenue(BigDecimal.valueOf(1));
            acc.setBarrelValue(BigDecimal.valueOf(42));
            return acc;
        }
    },
    REW {
        @Override
        public Oil get() {
            Oil rew = new Oil("REW", OilType.STANDARD);
            rew.setFixedRevenue(BigDecimal.valueOf(7));
            rew.setBarrelValue(BigDecimal.valueOf(47));
            return rew;
        }
    },
    BWO{
        @Override
        public Oil get() {
            Oil bwo = new Oil("BWO", OilType.STANDARD);
            bwo.setFixedRevenue(BigDecimal.valueOf(17));
            bwo.setBarrelValue(BigDecimal.valueOf(61));
            return bwo;
        }
    },
    TIM{
        @Override
        public Oil get() {
            Oil tim = new Oil("TIM", OilType.PREMIUM);
            tim.setFixedRevenue(BigDecimal.valueOf(5));
            tim.setBarrelValue(BigDecimal.valueOf(111));
            tim.setVariableRevenue(BigDecimal.valueOf(7));
            return tim;
        }
    },
    QFC{
        @Override
        public Oil get() {
            Oil qfc = new Oil("QFC", OilType.STANDARD);
            qfc.setFixedRevenue(BigDecimal.valueOf(22));
            qfc.setBarrelValue(BigDecimal.valueOf(123));
            return qfc;
        }
    };

    abstract public Oil get();

}

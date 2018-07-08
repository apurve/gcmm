package com.luxoft.gcmm.model.types;

import com.luxoft.gcmm.model.Oil;

import java.math.BigDecimal;
import java.util.Arrays;

public enum OilID implements  Cloneable {

    ACC {
        @Override
        public Oil get() {
            Oil acc = new Oil(OilID.ACC, OilType.STANDARD);
            acc.setFixedRevenue(BigDecimal.valueOf(1));
            acc.setBarrelValue(BigDecimal.valueOf(42));
            return acc;
        }
    },
    REW {
        @Override
        public Oil get() {
            Oil rew = new Oil(OilID.REW, OilType.STANDARD);
            rew.setFixedRevenue(BigDecimal.valueOf(7));
            rew.setBarrelValue(BigDecimal.valueOf(47));
            return rew;
        }
    },
    BWO {
        @Override
        public Oil get() {
            Oil bwo = new Oil(OilID.BWO, OilType.STANDARD);
            bwo.setFixedRevenue(BigDecimal.valueOf(17));
            bwo.setBarrelValue(BigDecimal.valueOf(61));
            return bwo;
        }
    },
    TIM {
        @Override
        public Oil get() {
            Oil tim = new Oil(OilID.TIM, OilType.PREMIUM);
            tim.setFixedRevenue(BigDecimal.valueOf(5));
            tim.setBarrelValue(BigDecimal.valueOf(111));
            tim.setVariableRevenue(BigDecimal.valueOf(7));
            return tim;
        }
    },
    QFC {
        @Override
        public Oil get() {
            Oil qfc = new Oil(OilID.QFC, OilType.STANDARD);
            qfc.setFixedRevenue(BigDecimal.valueOf(22));
            qfc.setBarrelValue(BigDecimal.valueOf(123));
            return qfc;
        }
    };

    abstract public Oil get();

    public OilID toString(String value) {
        return Arrays.stream(OilID.values()).filter(oil -> oil.toString().equals(value)).findFirst().get();
    }

}
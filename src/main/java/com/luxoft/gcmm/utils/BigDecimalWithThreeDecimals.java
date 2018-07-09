package com.luxoft.gcmm.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalWithThreeDecimals {

    private BigDecimalWithThreeDecimals() { }

    public static final BigDecimal valueOf(String bigDecimalString) {
        BigDecimal bigDecimal1 = new BigDecimal(bigDecimalString);
        bigDecimal1.setScale(3, RoundingMode.HALF_UP);
        return bigDecimal1;
    }

}

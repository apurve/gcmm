package com.luxoft.gcmm.calculators.types.helpers;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.Consumer;

public class GeometricMeanHelper implements Consumer<Transaction> {

    private EnumMap<OilID, GeometricMeanMetaData> meanHelperMap;

    public GeometricMeanHelper() {
        meanHelperMap = new EnumMap<OilID, GeometricMeanMetaData>(OilID.class);
        initializeSummationMap();
    }

    private void initializeSummationMap() {
        Arrays.stream(OilID.values()).forEach(oil -> {
            meanHelperMap.put(oil, new GeometricMeanMetaData(
                    BigDecimal.ZERO.setScale(3, RoundingMode.HALF_UP),
                    Double.valueOf(0)
            ));
        });
    }

    @Override
    public void accept(Transaction transaction) {
        meanHelperMap.put(transaction.getOilID(), sumPriceAndIncrementRoot(transaction));
    }

    private GeometricMeanMetaData sumPriceAndIncrementRoot(Transaction transaction) {
        GeometricMeanMetaData data = meanHelperMap.get(transaction.getOilID());
        data.setSum(data.getSum().add(transaction.getPrice()));
        data.setRoot(data.getRoot() + 1);
        return data;
    }

    public EnumMap<OilID, GeometricMeanMetaData> getMeanHelperMap() {
        return meanHelperMap;
    }

    public class GeometricMeanMetaData {

        private BigDecimal sum;

        private Double root;

        GeometricMeanMetaData(BigDecimal sum, Double root) {
            this.sum = sum;
            this.root = root;
        }

        public BigDecimal getSum() {
            return sum;
        }

        public void setSum(BigDecimal sum) {
            this.sum = sum;
        }

        public Double getRoot() {
            return root;
        }

        public void setRoot(Double root) {
            this.root = root;
        }

    }

}
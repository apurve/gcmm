package com.luxoft.gcmm.calculators.types.helpers;

import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.Consumer;

public class VolumeWeightedHelper implements Consumer<Transaction> {

    private EnumMap<OilID, VolumeWeightedMetaData> volumeWeightedHelperMap;
    private LocalDateTime thirtyMinutesBeforeNow;

    public VolumeWeightedHelper() {
        volumeWeightedHelperMap = new EnumMap<OilID, VolumeWeightedMetaData>(OilID.class);
        thirtyMinutesBeforeNow = LocalDateTime.now().minusMinutes(30);
        initializeVolumeWeightedHelperMap();
    }

    private void initializeVolumeWeightedHelperMap() {
        Arrays.stream(OilID.values()).forEach(oil -> {
            volumeWeightedHelperMap.put(oil, new VolumeWeightedMetaData(
                    BigDecimal.ZERO.setScale(3, RoundingMode.HALF_UP),
                    BigDecimal.ZERO.setScale(3, RoundingMode.HALF_UP)
            ));
        });
    }

    @Override
    public void accept(Transaction transaction) {
        if (transaction.getTransactionDateTime().isAfter(thirtyMinutesBeforeNow)) {
            volumeWeightedHelperMap.put(transaction.getOilID(), computeDividendAndDivisor(transaction));
        }
    }

    private VolumeWeightedMetaData computeDividendAndDivisor(Transaction transaction) {
        VolumeWeightedMetaData volumeWeightedMetaData = volumeWeightedHelperMap.get(transaction.getOilID());
        volumeWeightedMetaData.setDividend(volumeWeightedMetaData.getDividend().add(multiplyPriceAndQuantity(transaction)));
        volumeWeightedMetaData.setDivisor(volumeWeightedMetaData.getDivisor().add(BigDecimal.valueOf(transaction.getQuantity())));
        return volumeWeightedMetaData;
    }

    private BigDecimal multiplyPriceAndQuantity(Transaction transaction) {
        return transaction.getPrice().multiply(BigDecimal.valueOf(transaction.getQuantity()));
    }

    public EnumMap<OilID, VolumeWeightedMetaData> getVolumeWeightedHelperMap() {
        return volumeWeightedHelperMap;
    }

    public class VolumeWeightedMetaData {

        private BigDecimal dividend;
        private BigDecimal divisor;

        VolumeWeightedMetaData(BigDecimal dividend, BigDecimal divisor) {
            this.dividend = dividend;
            this.divisor = divisor;
        }

        public BigDecimal getDividend() {
            return dividend;
        }

        public void setDividend(BigDecimal dividend) {
            this.dividend = dividend;
        }

        public BigDecimal getDivisor() {
            return divisor;
        }

        public void setDivisor(BigDecimal divisor) {
            this.divisor = divisor;
        }
    }

}
package com.luxoft.gcmm.model;

import com.luxoft.gcmm.model.types.OilID;
import com.luxoft.gcmm.model.types.TransactionIndicator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Transaction implements  Cloneable {

    public Transaction(){

    }

    public Transaction(OilID oilID, LocalDateTime transactionDateTime, Integer quantity, TransactionIndicator transactionIndicator, BigDecimal price) {
        this.oilID = oilID;
        this.transactionDateTime = transactionDateTime;
        this.quantity = quantity;
        this.transactionIndicator = transactionIndicator;
        this.price = price;
    }

    private OilID oilID;
    private LocalDateTime transactionDateTime;
    private Integer quantity;
    private TransactionIndicator transactionIndicator;
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return oilID == that.oilID &&
                Objects.equals(transactionDateTime, that.transactionDateTime) &&
                Objects.equals(quantity, that.quantity) &&
                transactionIndicator == that.transactionIndicator &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oilID, transactionDateTime, quantity, transactionIndicator, price);
    }

    public OilID getOilID() {
        return oilID;
    }

    public void setOilID(OilID oilID) {
        this.oilID = oilID;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TransactionIndicator getTransactionIndicator() {
        return transactionIndicator;
    }

    public void setTransactionIndicator(TransactionIndicator transactionIndicator) {
        this.transactionIndicator = transactionIndicator;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "oilID=" + oilID +
                ", transactionDateTime=" + transactionDateTime +
                ", quantity=" + quantity +
                ", transactionIndicator=" + transactionIndicator +
                ", price=" + price +
                '}';
    }

    public Transaction clone(){

        final Transaction transaction = new Transaction();
        LocalDateTime copy = LocalDateTime.of(this.transactionDateTime.toLocalDate(), this.transactionDateTime.toLocalTime());
        //TODO: // LIke wise clone can be implemented - Please check assumptions for more informataion.
        return  transaction;
    }


}
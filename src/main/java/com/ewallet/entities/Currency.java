package com.ewallet.entities;

import java.io.Serializable;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/30/13
 */
public class Currency implements Serializable {
    private static final long serialVersionUID = 6421195358114000406L;

    private final int id;
    private String currency;
    private float purchaseRatio;
    private float saleRatio;

    public Currency(){
        this.id = 0;
        this.currency = null;
        this.purchaseRatio = 0;
        this.saleRatio = 0;
    }

    private Currency(Builder builder){
        this.id = builder.id;
        this.currency = builder.currency;
        this.purchaseRatio = builder.purchaseRatio;
        this.saleRatio = builder.saleRatio;
    }

    public int getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public float getPurchaseRatio() {
        return purchaseRatio;
    }

    public float getSaleRatio() {
        return saleRatio;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPurchaseRatio(float purchaseRatio) {
        this.purchaseRatio = purchaseRatio;
    }

    public void setSaleRatio(float saleRatio) {
        this.saleRatio = saleRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency1 = (Currency) o;

        if (id != currency1.id) return false;
        if (Float.compare(currency1.purchaseRatio, purchaseRatio) != 0) return false;
        if (Float.compare(currency1.saleRatio, saleRatio) != 0) return false;
        if (currency != null ? !currency.equals(currency1.currency) : currency1.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (purchaseRatio != +0.0f ? Float.floatToIntBits(purchaseRatio) : 0);
        result = 31 * result + (saleRatio != +0.0f ? Float.floatToIntBits(saleRatio) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", purchaseRatio=" + purchaseRatio +
                ", saleRatio=" + saleRatio +
                '}';
    }

    public static class Builder{
        private int id;
        private String currency;
        private float purchaseRatio;
        private float saleRatio;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder currency(String currency){
            this.currency = currency;
            return this;
        }

        public Builder purchaseRatio(float purchaseRatio){
            this.purchaseRatio = purchaseRatio;
            return this;
        }

        public Builder saleRatio(float saleRatio){
            this.saleRatio = saleRatio;
            return this;
        }

        public Currency build(){
            return new Currency(this);
        }
    }
}
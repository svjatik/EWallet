package com.ewallet.model;

import java.io.Serializable;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class Wallet implements Serializable {
    private static final long serialVersionUID = 3502250924741228225L;

    private final int userId;
    private final float cashAmount;

    public Wallet(){
        this.userId = 0;
        this.cashAmount = 0;
    }

    private Wallet(Builder builder){
        this.userId = builder.userId;
        this.cashAmount = builder.cashAmount;
    }

    public int getUserId() {
        return userId;
    }

    public float getCashAmount() {
        return cashAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (Float.compare(wallet.cashAmount, cashAmount) != 0) return false;
        if (userId != wallet.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (cashAmount != +0.0f ? Float.floatToIntBits(cashAmount) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "userId=" + userId +
                ", cashAmount=" + cashAmount +
                '}';
    }

    public static class Builder{
        private int userId;
        private float cashAmount;

        public Builder userId(int userId){
            this.userId = userId;
            return this;
        }

        public Builder cashAmount(float cashAmount){
            this.cashAmount = cashAmount;
            return this;
        }
    }
}

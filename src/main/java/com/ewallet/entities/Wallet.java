package com.ewallet.entities;

import java.io.Serializable;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class Wallet implements Serializable {
    private static final long serialVersionUID = 3502250924741228225L;

    private final int id;
    private final int userId;
    private final Currency currency;
    private float cashAmount;

    public Wallet(){
        this.id = 0;
        this.userId = 0;
        this.currency = null;
        this.cashAmount = 0;
    }

    private Wallet(Builder builder){
        this.id = builder.id;
        this.userId = builder.userId;
        this.currency = builder.currency;
        this.cashAmount = builder.cashAmount;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public float getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(float cashAmount) {
        this.cashAmount = cashAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (Float.compare(wallet.cashAmount, cashAmount) != 0) return false;
        if (id != wallet.id) return false;
        if (userId != wallet.userId) return false;
        if (currency != null ? !currency.equals(wallet.currency) : wallet.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (cashAmount != +0.0f ? Float.floatToIntBits(cashAmount) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", userId=" + userId +
                ", currency=" + currency +
                ", cashAmount=" + cashAmount +
                '}';
    }

    public static class Builder{
        private int id;
        private int userId;
        private float cashAmount;
        private Currency currency;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder userId(int userId){
            this.userId = userId;
            return this;
        }

        public Builder cashAmount(float cashAmount){
            this.cashAmount = cashAmount;
            return this;
        }

        public Builder currency(Currency currency){
            this.currency = currency;
            return this;
        }

        public Wallet build(){
            return new Wallet(this);
        }
    }
}

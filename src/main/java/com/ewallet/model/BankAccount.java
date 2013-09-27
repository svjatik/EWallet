package com.ewallet.model;

import java.io.Serializable;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class BankAccount implements Serializable {
    private static final long serialVersionUID = 6529977150625795683L;

    private final int id;
    private final int userId;
    private final float cashAmount;

    public BankAccount(){
        this.id = 0;
        this.userId = 0;
        this.cashAmount = 0;
    }

    private BankAccount(Builder builder){
        this.id = builder.id;
        this.userId = builder.userId;
        this.cashAmount = builder.cashAmount;
    }

    public int getId() {
        return id;
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

        BankAccount that = (BankAccount) o;

        if (Float.compare(that.cashAmount, cashAmount) != 0) return false;
        if (id != that.id) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (cashAmount != +0.0f ? Float.floatToIntBits(cashAmount) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", userId=" + userId +
                ", cashAmount=" + cashAmount +
                '}';
    }

    public static class Builder{
        private int id;
        private int userId;
        private float cashAmount;

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
    }
}

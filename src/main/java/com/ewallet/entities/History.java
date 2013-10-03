package com.ewallet.entities;

import java.io.Serializable;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/30/13
 */
public class History implements Serializable {
    private static final long serialVersionUID = 48026734761422681L;

    private final int userId;
    private final int transactionId;

    public History(){
        this.userId = 0;
        this.transactionId = 0;
    }

    private History(Builder builder){
        this.userId = builder.userId;
        this.transactionId = builder.transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        if (transactionId != history.transactionId) return false;
        if (userId != history.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + transactionId;
        return result;
    }

    @Override
    public String toString() {
        return "History{" +
                "userId=" + userId +
                ", transactionId=" + transactionId +
                '}';
    }

    public static class Builder{
        private int userId;
        private int transactionId;

        public Builder userId(int userId){
            this.userId = userId;
            return this;
        }

        public Builder transactionId(int transactionId){
            this.transactionId = transactionId;
            return this;
        }

        public History build(){
            return new History(this);
        }
    }
}

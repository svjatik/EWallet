package com.ewallet.entities;

import java.io.Serializable;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/30/13
 */
public class Transaction implements Serializable {
    private static final long serialVersionUID = -6826928388811288451L;

    private final int id;
    private final int sourceId;
    private String sourceType;
    private final int targetId;
    private String targetType;
    private float moneyAmount;
    private final Currency currency;
    private String description;

    public Transaction() {
        this.id = 0;
        this.sourceId = 0;
        this.sourceType = null;
        this.targetId = 0;
        this.targetType = null;
        this.moneyAmount = 0;
        this.currency = null;
        this.description = null;
    }

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.sourceId = builder.sourceId;
        this.sourceType = builder.sourceType;
        this.targetId = builder.targetId;
        this.targetType = builder.targetType;
        this.moneyAmount = builder.moneyAmount;
        this.currency = builder.currency;
        this.description = builder.description;
    }

    public int getId() {
        return id;
    }

    public int getSourceId() {
        return sourceId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public int getTargetId() {
        return targetId;
    }

    public String getTargetType() {
        return targetType;
    }

    public float getMoneyAmount() {
        return moneyAmount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public void setMoneyAmount(float moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != that.id) return false;
        if (Float.compare(that.moneyAmount, moneyAmount) != 0) return false;
        if (sourceId != that.sourceId) return false;
        if (targetId != that.targetId) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (sourceType != null ? !sourceType.equals(that.sourceType) : that.sourceType != null) return false;
        if (targetType != null ? !targetType.equals(that.targetType) : that.targetType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sourceId;
        result = 31 * result + (sourceType != null ? sourceType.hashCode() : 0);
        result = 31 * result + targetId;
        result = 31 * result + (targetType != null ? targetType.hashCode() : 0);
        result = 31 * result + (moneyAmount != +0.0f ? Float.floatToIntBits(moneyAmount) : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", sourceType='" + sourceType + '\'' +
                ", targetId=" + targetId +
                ", targetType='" + targetType + '\'' +
                ", moneyAmount=" + moneyAmount +
                ", currency=" + currency +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder{
        private int id;
        private int sourceId;
        private String sourceType;
        private int targetId;
        private String targetType;
        private float moneyAmount;
        private Currency currency;
        private String description;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder sourceId(int sourceId){
            this.sourceId = sourceId;
            return this;
        }

        public Builder sourceType(String sourceType){
            this.sourceType = sourceType;
            return this;
        }

        public Builder targetId(int targetId){
            this.targetId = targetId;
            return this;
        }

        public Builder targetType(String targetType){
            this.targetType = targetType;
            return this;
        }

        public Builder moneyAmount(float moneyAmount){
            this.moneyAmount = moneyAmount;
            return this;
        }

        public Builder currency(Currency currency){
            this.currency = currency;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Transaction build(){
            return new Transaction(this);
        }
    }
}

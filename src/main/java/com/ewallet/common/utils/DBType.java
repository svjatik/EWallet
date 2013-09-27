package com.ewallet.common.utils;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public enum DBType {
    MY_SQL("MySQL"),
    MONGO("Mongo");

    private final String dbType;

    private DBType(String dbType){
        this.dbType = dbType;
    }

    @Override
    public String toString(){
        return dbType;
    }
}

package com.ewallet.db;

import com.ewallet.db.dao.BankAccountDAO;
import com.ewallet.db.dao.UserDAO;
import com.ewallet.db.dao.WalletDAO;
import com.ewallet.common.utils.DBType;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/26/13
 */
public abstract class DAOFactory {
    public abstract UserDAO getUserDAO();
    public abstract WalletDAO getWalletDAO();
    public abstract BankAccountDAO getBankAccountDAO();

    public static DAOFactory getDAOFactory(DBType dbType){
        switch (dbType){
            case MY_SQL :
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}
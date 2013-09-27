package com.ewallet.db;

import com.ewallet.db.dao.*;
import com.ewallet.db.dao.mysql.MySQLBankAccountDAO;
import com.ewallet.db.dao.mysql.MySQLUserDAO;
import com.ewallet.db.dao.mysql.MySQLWalletDAO;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class MySQLDAOFactory extends DAOFactory {

    private static final String DB_NAME = "bionic";
    private static final String HOST = "localhost";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";
    private static final String UTF_8 = "UTF-8";

    private Connection connection;

    public MySQLDAOFactory() throws SQLException {
        connection = createConnection();
    }

    private static Connection createConnection() throws SQLException {
        MysqlDataSource d = new MysqlDataSource();
        d.setUser(DB_USER);
        d.setPassword(DB_PASS);
        d.setServerName(HOST);
        d.setDatabaseName(DB_NAME);
        d.setEncoding(UTF_8);

        return d.getConnection();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO(connection);
    }

    @Override
    public WalletDAO getWalletDAO() {
        return new MySQLWalletDAO(connection);
    }

    @Override
    public BankAccountDAO getBankAccountDAO() {
        return new MySQLBankAccountDAO(connection);
    }
}

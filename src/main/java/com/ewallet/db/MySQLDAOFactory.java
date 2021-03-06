package com.ewallet.db;

import com.ewallet.common.utils.MySQLDBConfig;
import com.ewallet.db.dao.BankAccountDAO;
import com.ewallet.db.dao.UserDAO;
import com.ewallet.db.dao.WalletDAO;
import com.ewallet.db.dao.mysql.MySQLBankAccountDAO;
import com.ewallet.db.dao.mysql.MySQLUserDAO;
import com.ewallet.db.dao.mysql.MySQLWalletDAO;
import com.ewallet.entities.Currency;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class MySQLDAOFactory extends DAOFactory implements ICurrencyHandler {

    private static Connection connection;

    public MySQLDAOFactory() throws SQLException {
        connection = createConnection();
    }

    private static Connection createConnection() throws SQLException {
        MySQLDBConfig config = MySQLDBConfig.getInstance();

        MysqlDataSource d = new MysqlDataSource();
        d.setUser(config.getProperty(MySQLDBConfig.DB_USER));
        d.setPassword(config.getProperty(MySQLDBConfig.DB_PASS));
        d.setServerName(config.getProperty(MySQLDBConfig.HOST));
        d.setDatabaseName(config.getProperty(MySQLDBConfig.DB_NAME));
        d.setEncoding(config.getProperty(MySQLDBConfig.UTF_8));

        return d.getConnection();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO(connection);
    }

    @Override
    public WalletDAO getWalletDAO() {
        return new MySQLWalletDAO(connection, this);
    }

    @Override
    public BankAccountDAO getBankAccountDAO() {
        return new MySQLBankAccountDAO(connection, this);
    }

    @Override
    public Currency getCurrency(int id) {
        return null;
    }

    @Override
    public int getCurrencyIdByCode(String code) {
        return 1;
    }
}

package com.ewallet.db.dao.mysql;

import com.ewallet.db.ICurrencyHandler;
import com.ewallet.db.dao.BankAccountDAO;
import com.ewallet.entities.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class MySQLBankAccountDAO implements BankAccountDAO {
    private static final String ID = "id";
    private static final String USER_ID = "userID";
    private static final String CASH_AMOUNT = "cashAmount";
    private static final String CURRENCY_ID = "currencyID";

    private static final String SELECT_ALL = "SELECT * FROM BankAccount";
    private static final String SELECT_ACCOUNT_BY_ID = "SELECT * FROM BankAccount WHERE id = ?";
    private static final String SELECT_ACCOUNT_BY_USER_ID = "SELECT * FROM BankAccount WHERE userID = ?";

    private static final String INSERT_ACCOUNT = "INSERT INTO BankAccount (userID, currencyID, cashAmount) VALUES"
            + "(?,?,?)";

    private PreparedStatement statement;
    private Connection connection;

    private ICurrencyHandler currencyHandler;

    public MySQLBankAccountDAO(Connection connection, ICurrencyHandler currencyHandler){
        this.connection = connection;
        this.currencyHandler = currencyHandler;
    }

    @Override
    public List<BankAccount> findAll() {
        List<BankAccount> accounts = new ArrayList<BankAccount>();
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                accounts.add(new BankAccount.Builder()
                        .id(rs.getInt(ID))
                        .userId(rs.getInt(USER_ID))
                        .cashAmount(rs.getFloat(CASH_AMOUNT))
                        .currency(currencyHandler.getCurrency(rs.getInt(CURRENCY_ID)))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public BankAccount findAccountById(int id) {
        BankAccount bankAccount = null;
        try {
            statement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                bankAccount = new BankAccount.Builder()
                        .id(rs.getInt(ID))
                        .userId(rs.getInt(USER_ID))
                        .cashAmount(rs.getFloat(CASH_AMOUNT))
                        .currency(currencyHandler.getCurrency(rs.getInt(CURRENCY_ID)))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAccountsByUserId(int userId) {
        List<BankAccount> accounts = new ArrayList<BankAccount>();
        try {
            statement = connection.prepareStatement(SELECT_ACCOUNT_BY_USER_ID);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                accounts.add(new BankAccount.Builder()
                        .id(rs.getInt(ID))
                        .userId(rs.getInt(USER_ID))
                        .cashAmount(rs.getFloat(CASH_AMOUNT))
                        .currency(currencyHandler.getCurrency(rs.getInt(CURRENCY_ID)))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public int insertAccount(BankAccount bankAccount) {
        int result = -1;
        try{
            statement = connection.prepareStatement(INSERT_ACCOUNT);
            statement.setInt(1, bankAccount.getUserId());
            statement.setInt(2, currencyHandler.getCurrencyIdByCode(bankAccount.getCurrency().getCurrency()));
            statement.setFloat(3, bankAccount.getCashAmount());
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}

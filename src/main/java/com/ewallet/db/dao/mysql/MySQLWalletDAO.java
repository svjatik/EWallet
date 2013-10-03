package com.ewallet.db.dao.mysql;

import com.ewallet.db.ICurrencyHandler;
import com.ewallet.db.dao.WalletDAO;
import com.ewallet.entities.Wallet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class MySQLWalletDAO implements WalletDAO {
    private static final String ID = "id";
    private static final String USER_ID = "userID";
    private static final String CASH_AMOUNT = "cashAmount";
    private static final String CURRENCY_ID = "currencyID";

    private static final String SELECT_ALL = "SELECT * FROM Wallet";
    private static final String SELECT_WALLET_BY_USER_ID = "SELECT * FROM Wallet WHERE userID = ?";

    private static final String INSERT_WALLET = "INSERT INTO Wallet (userID, currencyID, cashAmount) VALUES"
            + "(?,?,?)";

    private PreparedStatement statement;
    private Connection connection;

    private ICurrencyHandler currencyHandler;

    public MySQLWalletDAO(Connection connection, ICurrencyHandler currencyHandler){
        this.connection = connection;
        this.currencyHandler = currencyHandler;
    }
    @Override
    public List<Wallet> findAll() {
        List<Wallet> wallets = new ArrayList<Wallet>();
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                wallets.add(new Wallet.Builder()
                        .id(rs.getInt(ID))
                        .userId(rs.getInt(USER_ID))
                        .cashAmount(rs.getFloat(CASH_AMOUNT))
                        .currency(currencyHandler.getCurrency(rs.getInt(CURRENCY_ID))).build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallets;
    }

    @Override
    public Wallet findWalletByUserId(int userId) {
        Wallet wallet = null;
        try {
            statement = connection.prepareStatement(SELECT_WALLET_BY_USER_ID);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                wallet = new Wallet.Builder()
                        .id(rs.getInt(ID))
                        .userId(rs.getInt(USER_ID))
                        .cashAmount(rs.getFloat(CASH_AMOUNT))
                        .currency(currencyHandler.getCurrency(rs.getInt(CURRENCY_ID))).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallet;
    }

    @Override
    public int insertWallet(Wallet wallet) {
        int result = -1;
        try{
            statement = connection.prepareStatement(INSERT_WALLET);
            statement.setInt(1, wallet.getUserId());
            statement.setInt(2, currencyHandler.getCurrencyIdByCode(wallet.getCurrency().getCurrency()));
            statement.setFloat(3, wallet.getCashAmount());
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}

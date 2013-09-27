package com.ewallet.db.dao.mysql;

import com.ewallet.db.dao.WalletDAO;
import com.ewallet.model.Wallet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class MySQLWalletDAO implements WalletDAO {
    private static final String USER_ID = "UserID";
    private static final String CASH_AMOUNT = "CashAmount";

    private static final String SELECT_ALL = "SELECT * FROM Wallet";

    private Statement statement;

    public MySQLWalletDAO(Connection connection){
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Wallet> selectAllWallets() {
        List<Wallet> wallets = new ArrayList<Wallet>();
        try {
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()){
                wallets.add(new Wallet.Builder().userId(rs.getInt(USER_ID)).cashAmount(rs.getFloat(CASH_AMOUNT)).build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallets;
    }
}

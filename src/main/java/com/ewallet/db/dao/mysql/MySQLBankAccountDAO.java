package com.ewallet.db.dao.mysql;

import com.ewallet.db.dao.BankAccountDAO;
import com.ewallet.model.BankAccount;

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
public class MySQLBankAccountDAO implements BankAccountDAO {
    private static final String ID = "ID";
    private static final String USER_ID = "UserID";
    private static final String CASH_AMOUNT = "CashAmount";

    private static final String SELECT_ALL = "SELECT * FROM BankAccount";

    private Statement statement;

    public MySQLBankAccountDAO(Connection connection){
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<BankAccount> selectAllBankAccounts() {
        List<BankAccount> accounts = new ArrayList<BankAccount>();
        try {
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()){
                accounts.add(new BankAccount.Builder().id(rs.getInt(ID)).userId(rs.getInt(USER_ID))
                        .cashAmount(rs.getFloat(CASH_AMOUNT)).build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}

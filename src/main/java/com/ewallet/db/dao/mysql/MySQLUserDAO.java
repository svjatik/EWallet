package com.ewallet.db.dao.mysql;

import com.ewallet.db.dao.UserDAO;
import com.ewallet.model.User;

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
public class MySQLUserDAO implements UserDAO {
    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String SURNAME = "Surname";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";

    private static final String SELECT_ALL = "SELECT * FROM User";

    private Statement statement;

    public MySQLUserDAO(Connection connection){
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()){
                users.add(new User.Builder().id(rs.getInt(ID)).name(rs.getString(NAME)).surname(rs.getString(SURNAME))
                        .email(rs.getString(EMAIL)).password(rs.getString(PASSWORD)).build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

package com.ewallet.db.dao.mysql;

import com.ewallet.db.dao.UserDAO;
import com.ewallet.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class MySQLUserDAO implements UserDAO {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String USER_TYPE = "userType";

    private static final String SELECT_ALL = "SELECT * FROM User";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM User WHERE email = ?";

    private static final String INSERT_USER = "INSERT INTO User (name, surname, email, password, userType) VALUES"
            + "(?,?,?,?,?)";

    private PreparedStatement statement;
    private Connection connection;

    public MySQLUserDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                users.add(new User.Builder()
                        .id(rs.getInt(ID))
                        .name(rs.getString(NAME))
                        .surname(rs.getString(SURNAME))
                        .email(rs.getString(EMAIL))
                        .password(rs.getString(PASSWORD))
                        .userType(rs.getString(USER_TYPE))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByEmail(String email) {
         User user =null;
        try {
            statement = connection.prepareStatement(SELECT_USER_BY_EMAIL);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                user = new User.Builder()
                        .id(rs.getInt(ID))
                        .name(rs.getString(NAME))
                        .surname(rs.getString(SURNAME))
                        .email(rs.getString(EMAIL))
                        .password(rs.getString(PASSWORD))
                        .userType(rs.getString(USER_TYPE))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int insertEmailAndPassword(String email, String password) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int insertUserByEmailAndPassword(String email, String password) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

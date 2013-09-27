package com.ewallet.db.dao;

import com.ewallet.model.User;

import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public interface UserDAO {
    public List<User> selectAllUsers();
}

package com.ewallet.db.dao;

import com.ewallet.entities.User;

import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public interface UserDAO {
    public List<User> findAll();
    public User findByEmail(String email);
    public int insertEmailAndPassword(String email, String password);
    public int insertUserByEmailAndPassword(String email, String password);
}

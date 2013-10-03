package com.ewallet.db.dao;

import com.ewallet.entities.BankAccount;

import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public interface BankAccountDAO {
    public List<BankAccount> findAll();
    public BankAccount findAccountById(int id);
    public List<BankAccount> findAccountsByUserId(int userId);
    public int insertAccount(BankAccount bankAccount);
}

package com.ewallet.db.dao;

import com.ewallet.model.BankAccount;

import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public interface BankAccountDAO {
    public List<BankAccount> selectAllBankAccounts();
}

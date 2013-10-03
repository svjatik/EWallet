package com.ewallet.db.dao;

import com.ewallet.entities.Wallet;

import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public interface WalletDAO {
    public List<Wallet> findAll();
    public Wallet findWalletByUserId(int userId);
    public int insertWallet(Wallet wallet);
}

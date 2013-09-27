package com.ewallet.db.dao;

import com.ewallet.model.Wallet;

import java.util.List;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public interface WalletDAO {
    public List<Wallet> selectAllWallets();
}

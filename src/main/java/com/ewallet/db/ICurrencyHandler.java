package com.ewallet.db;

import com.ewallet.entities.Currency;

/**
 * User: Svjatoslav Glushchenko
 * Date: 10/1/13
 */
public interface ICurrencyHandler {
    Currency getCurrency(int id);
    int getCurrencyIdByCode(String code);
}

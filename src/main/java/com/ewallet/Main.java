package com.ewallet;

import com.ewallet.common.utils.DBType;
import com.ewallet.db.DAOFactory;
import com.ewallet.db.dao.BankAccountDAO;
import com.ewallet.db.dao.UserDAO;
import com.ewallet.db.dao.WalletDAO;
import com.ewallet.entities.BankAccount;
import com.ewallet.entities.Currency;
import com.ewallet.entities.User;
import com.ewallet.entities.Wallet;

/**
 * User: Svjatoslav Glushchenko
 * Date: 9/27/13
 */
public class Main {
    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MY_SQL);

        UserDAO userDAO = daoFactory.getUserDAO();
        WalletDAO walletDAO = daoFactory.getWalletDAO();
        BankAccountDAO bankAccountDAO = daoFactory.getBankAccountDAO();

        walletDAO.insertWallet(new Wallet.Builder().userId(1).cashAmount(10000.1F).currency(new Currency.Builder().id(1).build()).build());
        bankAccountDAO.insertAccount(new BankAccount.Builder().userId(1).cashAmount(5555.55F).currency(new Currency.Builder().id(1).build()).build());

        System.out.println("************* Users ***************");
        for (User user : userDAO.findAll()){
            System.out.println(user.toString());
        }

        System.out.println("************ Bank Accounts *************");
        for (BankAccount bankAccount : bankAccountDAO.findAll()){
            System.out.println(bankAccount.toString());
        }

        System.out.println("************ Wallets **************");
        for (Wallet wallet : walletDAO.findAll()){
            System.out.println(wallet.toString());
        }
    }
}

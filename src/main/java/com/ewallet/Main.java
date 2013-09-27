package com.ewallet;

import com.ewallet.common.utils.DBType;
import com.ewallet.db.DAOFactory;
import com.ewallet.db.dao.BankAccountDAO;
import com.ewallet.db.dao.UserDAO;
import com.ewallet.db.dao.WalletDAO;
import com.ewallet.model.BankAccount;
import com.ewallet.model.User;
import com.ewallet.model.Wallet;

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

        System.out.println("************* Users ***************");
        for (User user : userDAO.selectAllUsers()){
            System.out.println(user.toString());
        }

        System.out.println("************ Bank Accounts *************");
        for (BankAccount bankAccount : bankAccountDAO.selectAllBankAccounts()){
            System.out.println(bankAccount.toString());
        }

        System.out.println("************ Wallets **************");
        for (Wallet wallet : walletDAO.selectAllWallets()){
            System.out.println(wallet.toString());
        }
    }
}

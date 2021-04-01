package edu.hebeu.dao;

import edu.hebeu.entity.Account;

public interface IAccountDao {

    void updateAccount(Account account);

    Account selectAccountById(Integer accountId);

    Account selectAccountByName(String accountName);

}

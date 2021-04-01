package edu.hebeu.dao;

import edu.hebeu.entity.Account;

public interface IAccountDao {

    void insertAccount(Account account);

    void deleteAccount(Integer accountId);

    void updateAccount(Account account);

    Account selectAccountById(Integer accountId);

    Account selectAccountByName(String name);
}

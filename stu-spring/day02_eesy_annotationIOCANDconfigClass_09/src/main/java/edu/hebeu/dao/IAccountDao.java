package edu.hebeu.dao;

import edu.hebeu.entity.Account;

import java.util.List;

public interface IAccountDao {

    void insertAccount(Account account);

    void deleteAccount(Integer accountId);

    void updateAccount(Account account);

    List<Account> selectAccount();

    List<Account> selectAccount(Account account);

    Account selectAccount(Integer accountId);
}

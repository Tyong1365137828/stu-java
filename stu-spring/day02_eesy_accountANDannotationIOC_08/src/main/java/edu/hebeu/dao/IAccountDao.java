package edu.hebeu.dao;

import edu.hebeu.entity.Account;

import java.util.List;

public interface IAccountDao {

    void insertAccount(Account account);

    void deleteAccount(Integer accountId);

    void updateAccount(Account account);

    List<Account> selectAccountAll();

    Account selectAccountById(Integer accountId);

    List<Account> selectAccountByCondition(Account account);

}

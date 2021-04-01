package edu.hebeu.service;

import edu.hebeu.entity.Account;

import java.util.List;

public interface IAccountService {

    void addAccount(Account account);

    void cutAccount(Integer accountId);

    void alterAccount(Account account);

    List<Account> findAccount();

    List<Account> findAccount(Account account);

    Account findAccount(Integer accountId);
}

package edu.hebeu.service;

import edu.hebeu.entity.Account;

import java.util.List;

public interface IAccountService {

    void addAccount(Account account);

    void cutAccount(Integer accountId);

    void alterAccount(Account account);

    List<Account> findAccountAll();

    Account findAccountSingle(Integer accountId);

    List<Account> findAccountDim(Account account);

}

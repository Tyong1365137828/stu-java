package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import edu.hebeu.util.TransactionManager;

import java.util.List;

public class AccountServiceImpl2 implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void addAccount(Account account) {
        accountDao.insertAccount(account);
    }

    public void cutAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void alterAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public List<Account> findAccountAll() {
        List<Account> accounts = accountDao.selectAccountAll();
        return accounts;
    }

    public Account findAccountSingle(Integer accountId) {
        Account account = accountDao.selectAccountSingle(accountId);
        return account;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDao.selectAccountByName(sourceName);
        Account targetAccount = accountDao.selectAccountByName(targetName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        accountDao.updateAccount(sourceAccount);
        int i = 1 / 0;
        accountDao.updateAccount(targetAccount);
    }
}

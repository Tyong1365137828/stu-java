package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDao.selectAccountByName(sourceName);
        Account targetAccount = accountDao.selectAccountByName(targetName);

        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);

        accountDao.updateAccount(sourceAccount);

//        int i = 1 / 0;

        accountDao.updateAccount(targetAccount);

    }
}

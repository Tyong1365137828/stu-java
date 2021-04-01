package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public void addAccount(Account account) {

    }

    public void cutAccount(Integer accountId) {

    }

    public void alterAccount(Account account) {

    }

    public List<Account> findAccountAll() {
        return null;
    }

    public Account findAccountSingle(Integer accountId) {
        return null;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("转账开始了...");
        Account sourceAccount = accountDao.selectAccountByName(sourceName);
        Account targetAccount = accountDao.selectAccountByName(targetName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);

        accountDao.updateAccount(sourceAccount);

//        int  i = 1 / 0;

        accountDao.updateAccount(targetAccount);
    }
}

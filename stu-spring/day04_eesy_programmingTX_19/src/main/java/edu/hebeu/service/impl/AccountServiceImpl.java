package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 业务层的转账实现方法
     * @param sourceName 转账人
     * @param targetName 接收者
     * @param money 转账金额
     */
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

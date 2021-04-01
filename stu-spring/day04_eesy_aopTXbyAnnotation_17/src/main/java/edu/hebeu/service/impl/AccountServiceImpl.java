package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) // 该Service层上所有未被@Transactional注解标注覆盖的方法都会按照这种事务
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false) // 不会按照类上标注的，而是按照这里标注的事务
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

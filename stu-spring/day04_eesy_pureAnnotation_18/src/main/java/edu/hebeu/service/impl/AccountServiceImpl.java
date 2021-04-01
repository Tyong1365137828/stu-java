package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) // 将该业务层的所有方法配置为只读的事务
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false) // 将这个业务的事务配置为另外的
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

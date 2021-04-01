package edu.hebeu.service.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import util.factory.BeanFactory;

public class IAccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao = (IAccountDao) BeanFactory.getBeanForBeans("iAccountDao");

    public void addAccount() {
        Account account = (Account) BeanFactory.getBeanForBeans("account");
        iAccountDao.insertAccount(account);

        Account account2 = (Account) BeanFactory.getBeanForBeans("account");
        iAccountDao.insertAccount(account2);

        Account account3 = (Account) BeanFactory.getBeanForBeans("account");
        iAccountDao.insertAccount(account3);

        Account account4 = (Account) BeanFactory.getBeanForBeans("account");
        iAccountDao.insertAccount(account4);
    }

}

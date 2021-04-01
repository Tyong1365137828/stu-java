package edu.hebeu.dao.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;

public class IAccountDaoImpl implements IAccountDao {

    public IAccountDaoImpl() {
        System.out.println("IAccountDaoImpl对象创建！！！");
    }

    /**
     * 插入一条用户
     * @param account
     */
    public void insertAccount(Account account) {
        System.out.println("插入一条账户：" + account);
    }

}

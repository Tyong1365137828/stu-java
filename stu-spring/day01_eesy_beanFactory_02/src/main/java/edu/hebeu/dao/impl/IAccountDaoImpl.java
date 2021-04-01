package edu.hebeu.dao.impl;

import edu.hebeu.dao.IAccountDao;
import edu.hebeu.entity.Account;

public class IAccountDaoImpl implements IAccountDao {

    public void insertAccount(Account account) {
        System.out.println("添加用户成功" + account);
    }
}

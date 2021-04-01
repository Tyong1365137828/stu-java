package edu.hebeu.service;

import edu.hebeu.entity.Account;

import java.util.List;

/**
 * 账户类的业务层
 */
public interface IAccountService {

    /**
     * 添加账户
     * @param account
     */
    void addAccount(Account account);

    /**
     * 查询全部账户
     * @return
     */
    List<Account> findAccount();
}

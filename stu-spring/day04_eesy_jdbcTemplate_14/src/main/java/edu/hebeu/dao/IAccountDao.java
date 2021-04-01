package edu.hebeu.dao;

import edu.hebeu.entity.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    /**
     * 插入账户
     * @param account
     */
    void insertAccount(Account account);

    /**
     * 删除账户
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 通过id查询账户信息
     * @param accountId
     * @return
     */
    Account selectAccountById(Integer accountId);

    /**
     * 通过账户名查询账户
     * @param accountName
     * @return
     */
    Account selectAccountByName(String accountName);

}

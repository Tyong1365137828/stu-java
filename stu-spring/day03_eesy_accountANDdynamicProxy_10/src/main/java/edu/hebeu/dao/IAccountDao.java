package edu.hebeu.dao;

import edu.hebeu.entity.Account;

import java.util.List;

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
     * 查询全部账户
     * @return
     */
    List<Account> selectAccountAll();

    /**
     * 通过id精确查询账户信息
     * @param accountId
     * @return
     */
    Account selectAccountSingle(Integer accountId);

    /**
     * 根据名称查询账户信息
     * @param accountName
     * @return
     */
    Account selectAccountByName(String accountName);
}

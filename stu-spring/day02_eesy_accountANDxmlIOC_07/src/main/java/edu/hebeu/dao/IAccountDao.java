package edu.hebeu.dao;

import edu.hebeu.entity.Account;

import java.util.List;

/**
 * 持久层的 Account接口类
 */
public interface IAccountDao {

    /**
     * 添加账户
     * @param account
     */
    void insertAccount(Account account);

    /**
     * 删除账户
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 修改账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 查询全部账户
     * @return
     */
    List<Account> selectAccountAll();

    /**
     * 通过id精确查询Account
     * @param accountId
     * @return
     */
    Account selectAccountById(Integer accountId);

    /**
     * 通过条件模糊查询Account
     * @param account
     * @return
     */
    List<Account> selectAccountByCondition(Account account);

}

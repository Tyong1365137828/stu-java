package edu.hebeu.dao;

import edu.hebeu.entity.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 插入一条账户 记录
     * @param account
     */
    void insertAccount(Account account);

    /**
     * 删除一条账户记录
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 修改一条账户记录
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 查询所有账户记录
     * @return
     */
    List<Account> selectAccountAll();

    /**
     * 通过id精确查询一条账户记录
     * @param accountId
     * @return
     */
    Account selectAccountById(Integer accountId);

    /**
     * 通过name查询账户
     * @param accountName
     * @return
     */
    Account selectAccountByName(String accountName);
}

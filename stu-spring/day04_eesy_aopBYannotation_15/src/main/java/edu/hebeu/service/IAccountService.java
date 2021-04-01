package edu.hebeu.service;

import edu.hebeu.entity.Account;

import java.util.List;

public interface IAccountService {

    /**
     * 添加账户
     * @param account
     */
    void addAccount(Account account);

    /**
     * 删除你账户
     * @param accountId
     */
    void cutAccount(Integer accountId);

    /**
     * 修改账户
     * @param account
     */
    void alterAccount(Account account);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAccountAll();

    /**
     * 精确查询账户
     * @param accountId
     * @return
     */
    Account findAccountSingle(Integer accountId);

    /**
     * 转账业务
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, Float money);
}

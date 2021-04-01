package edu.hebeu.service;

import edu.hebeu.entity.Account;

import java.util.List;

/**
 * 业务层 Account的接口类
 */
public interface IAccountService {

    /**
     * 添加账户Account
     * @param account
     */
    void addAccount(Account account);

    /**
     * 删除账户Account
     * @param accountId
     */
    void cutAccount(Integer accountId);

    /**
     * 修改账户Account
     * @param account
     */
    void alterAccount(Account account);

    /**
     * 查找所有的Account
     * @return
     */
    List<Account> findAccountAll();

    /**
     * 精确查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountSingle(Integer accountId);

    /**
     * 模糊查询账户信息
     * @param account
     * @return
     */
    List<Account> findAccountDim(Account account);

}

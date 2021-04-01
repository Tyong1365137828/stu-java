package edu.hebeu.service;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    void addAccount();

    /**
     * 模拟删除账户
     * @param i
     * @return
     */
    int deleteAccount();

    /**
     * 模拟更新账户
     */
    void updateAccount();
}

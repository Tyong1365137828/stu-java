package edu.hebeu.service;

public interface IAccountService {

    /**
     * 转账业务
     * @param sourceName 转账用户名
     * @param targetName 接收转账用户名
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);

}

package edu.hebeu.service;

import org.springframework.stereotype.Service;

public interface IAccountService {

    /**
     * 转账业务
     * @param sourceName 转账人
     * @param targetName 接收者
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}

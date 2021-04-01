package edu.hebeu.service.impl;

import edu.hebeu.service.IAccountService;

public class IAccountServiceImpl implements IAccountService {

    public void init() {
        System.out.println("对象初始化了...");
    }

    public void destroy() {
        System.out.println("对象销毁了！");
    }

    public void addAccount() {
        System.out.println("添加Account成功！！！");
    }

}

package edu.hebeu.service.impl;

import edu.hebeu.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void addAccount() {
        System.out.println("执行了添加账户方法！！！");
        int i = 1 / 0;
    }
}

package edu.hebeu.service.impl;

import edu.hebeu.service.IAccountService;

import java.util.Date;

public class IAccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public IAccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void addAccount() {
        System.out.println("添加账户成功！！！name = " + name + "; age = " + age + "; birthday = " + birthday);
    }
}

package edu.hebeu.service.impl;

import edu.hebeu.service.IAccountService;

import java.util.Date;

public class IAccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setUserName(String name) {
        this.name = name;
    }

    public void setUserAge(Integer age) {
        this.age = age;
    }

    public void setUserBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public void addAccount() {
        System.out.println("添加账户成功！！！name = " + name + "; age = " + age + "; birthday = " + birthday);
    }
}

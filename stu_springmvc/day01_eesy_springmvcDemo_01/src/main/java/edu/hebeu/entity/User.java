package edu.hebeu.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String uname;
    private Date registerDate;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", registerDate=" + registerDate +
                ", age=" + age +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

package edu.hebeu.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {

    private String username;
    private String password;
    private Float money;

    private User u; // 引用数据类型User

    private List<User> userList; // List类型的集合类型的数据引用
    private Map<String, User> userMap; // Map类型的集合数据引用

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", u=" + u +
                ", userList=" + userList +
                ", userMap=" + userMap +
                '}';
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}

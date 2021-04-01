package edu.hebeu.entity;

import java.io.Serializable;

/**
 * User类的包装类
 */
public class UserVo implements Serializable {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

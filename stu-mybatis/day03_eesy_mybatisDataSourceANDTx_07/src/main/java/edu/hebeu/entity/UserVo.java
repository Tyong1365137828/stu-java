package edu.hebeu.entity;

import java.util.List;

/**
 * User类的封包装类
 */
public class UserVo {

    private User user;

    private List<Integer> userIds;

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

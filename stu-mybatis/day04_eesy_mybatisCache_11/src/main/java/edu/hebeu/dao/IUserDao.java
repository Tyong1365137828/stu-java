package edu.hebeu.dao;

import edu.hebeu.entity.User;

import java.util.List;

public interface IUserDao {

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 查询全部的用户
     * @return
     */
    List<User> selectUserAll();

    /**
     * 通过用户id查询用户
     * @param userId 查询的用户id
     * @return
     */
    User selectUserById(Integer userId);

}

package edu.hebeu.dao;

import edu.hebeu.entity.User;

import java.util.List;

public interface IUserDao {

    /**
     * 插入一条用户
     * @param user 插入的用户对象
     */
    void insertUser(User user);

    /**
     * 查询所有用户
     * @return 所有用户对象
     */
    List<User> selectUserAll();

    /**
     * 通过用户对象的信息条件模糊查询用户
     * @param user 存储用户信息的对象
     * @return 符合条件的用户对象
     */
    List<User> selectUserDim(User user);

}

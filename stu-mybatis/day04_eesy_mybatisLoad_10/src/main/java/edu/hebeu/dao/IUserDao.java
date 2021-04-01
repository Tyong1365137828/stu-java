package edu.hebeu.dao;

import edu.hebeu.entity.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询全部的用户，并将每个用户 的 所有账户 查询出来(这是一个 一对多关系)
     * @return
     */
    List<User> selectUserAll();

    /**
     * 通过用户的id查询出唯一的用户
     * @param userId 查询的用户id
     * @return 一个用户对象
     */
    User selectUserById(Integer userId);

}

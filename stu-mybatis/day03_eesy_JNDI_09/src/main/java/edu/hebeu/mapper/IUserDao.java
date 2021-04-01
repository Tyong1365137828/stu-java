package edu.hebeu.mapper;

import edu.hebeu.entity.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有的用户
     * @return
     */
    List<User> selectUserAll();

}

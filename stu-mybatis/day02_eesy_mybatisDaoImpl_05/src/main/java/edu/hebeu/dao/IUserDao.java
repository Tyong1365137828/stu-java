package edu.hebeu.dao;

import edu.hebeu.entity.User;
import edu.hebeu.entity.UserVo;

import java.util.List;

public interface IUserDao {

    /**
     * 插入一个用户记录
     * @param user 插入的用户对象
     */
    void insertUser(User user);

    /**
     * 删除用户
     * @param userId 删除的用户的id
     */
    void deleteUser(Integer userId);

    /**
     * 修改用户信息
     * @param user 修改的用户的信息对象
     */
    void updateUser(User user);

    /**
     * 查询所有用户
     * @return 一个泛型为User的List集合
     */
    List<User> selectUserAll();

    /**
     * 通过用户的id精确查询用户信息
     * @param userId 查询的用户的id
     * @return 一个用户对象
     */
    User selectUserById(Integer userId);

    /**
     * 查询用户条数
     * @return 返回条数
     */
    int selectUserTotal();

    /**
     * 通过用户信息模糊查询用户
     * @param userVo User类的包装类对象
     * @return 一个泛型为User的List集合
     */
    List<User> selectUserByVoDim(UserVo userVo);
}

package edu.hebeu.dao;

import edu.hebeu.entity.User;
import edu.hebeu.entity.UserVo;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有的用户
     * @return 所有的用户集合
     */
    List<User> selectUserAll();

    /**
     * 通过用户的id精确查询用户
     * @param userId 用户的id
     * @return 一个用户对象
     */
    User selectUserById(Integer userId);

    /**
     * 通过用户对象的信息模糊查询用户
     * @param user 用户的信息
     * @return 符合条件的List用户集合
     */
    List<User> selectUserDim(User user);

    /**
     * 通过Uaser类的包装类查询用户
     * @param userVo User类的包装类对象
     * @return 符合条件的用户List集合
     */
    List<User> selectUserByVo(UserVo userVo);

}

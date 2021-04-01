package edu.hebeu.dao;

import edu.hebeu.entity.User;
import edu.hebeu.entity.UserVo;

import java.util.List;

public interface IUserDao {

    /**
     * 插入用户
     * @param user 插入的用户对象
     */
    void insertUser(User user);

    /**
     * 通过用户id删除用户
     * @param userId 删除的用户id值
     */
    void deleteUser(Integer userId);

    /**
     * 更新用户
     * @param user 更新的用户信息对象
     */
    void updateUser(User user);

    /**
     * 查询所有的用户
     * @return
     */
    List<User> selectAll();

    /**
     * 通过id精确查询用户
     * @param userId 查询的用户的id值
     * @return 精确查找的用户
     */
    User selectUserById(Integer userId);

    /**
     * 通过用户的多个条件模糊查询用户
     * @param user 查询的用户条件信息
     * @return 模糊查找的符合条件的用户
     */
    List<User> selectUserDim(User user);

    /**
     * 查询总用户数
     * @return 用户总数
     */
    int totalUser();

    /**
     * 根据User的包装类UserVo内的属性查询用户
     * @param userVo User的包装类的对象
     * @return 符合条件的所有用户
     */
    List<User> selectUserByVo(UserVo userVo);

}

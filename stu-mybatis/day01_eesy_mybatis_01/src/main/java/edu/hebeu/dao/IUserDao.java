package edu.hebeu.dao;

import edu.hebeu.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * 使用xml文件配置方式实现省略impl
     * @return
     */
    List<User> findAll();

    /**
     * 查询所有用户
     * 使用注解方式(省略xml文件)实现
     * @return
     */
    @Select("SELECT * FROM `user`")
    List<User> findAllAnnotation();
}

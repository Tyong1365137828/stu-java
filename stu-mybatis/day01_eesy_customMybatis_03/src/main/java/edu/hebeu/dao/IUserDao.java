package edu.hebeu.dao;

import edu.hebeu.custom_mybatis.annotation.Select;
import edu.hebeu.entity.User;

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
     * 通过注解的方式实现省略impl
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> findAllByAnnotation();

}

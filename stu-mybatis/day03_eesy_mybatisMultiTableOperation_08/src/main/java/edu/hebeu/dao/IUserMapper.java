package edu.hebeu.dao;

import edu.hebeu.entity.User;

import java.util.List;

public interface IUserMapper {

    /**
     * 查询全部的用户
     * @return 用户类型的集合
     */
    List<User> selectUserAll();

    /**
     * 查询所有的用户，并且包含该用户的账户信息；
     *  分析：这是一个 一对多 的关系，一个user 对应 多个account或者没有account
     *      主表是user，从表是account，
     *          因此User主类 种应定义一个 泛型为从表Account类型的List集合对象
     * @return
     */
    List<User> selectUserAllOM();

    /**
     * 查询所有用户，并且包含用户的角色信息，
     *  分析：这是一个 多对多 的关系，一个角色可以对应多个用户，一个用户也可以对应多个角色；
     *      因此User类中应该有泛型为 Role类的List集合对象，Role类中应该有泛型为 User类型的List集合对象；
     * @return
     */
    List<User> selectUserAllMM();

}

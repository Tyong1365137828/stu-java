package edu.hebeu.dao;

import edu.hebeu.entity.Role;

import java.util.List;

public interface IRoleMapper {

    /**
     * 查询所有的role
     * @return
     */
    List<Role> selectRoleAll();

    /**
     * 查询所有角色role，同时获取角色所赋予的用户，
     *  分析：这是一个 多对多 的关系，一个角色可以对应多个用户，一个用户也可以对应多个角色；
     *      因此User类中应该有泛型为 Role类的List集合对象，Role类中应该有泛型为 User类型的List集合对象；
     * @return
     */
    List<Role> selectRoleAllMM();

}

package edu.hebeu.dao;

import edu.hebeu.domain.Permission;
import edu.hebeu.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public interface IRoleDao {

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    @Insert("INSERT INTO role(roleName,roleDesc) VALUES(#{roleName},#{roleDesc})")
    void insert(Role role) throws Exception;

    /**
     * 删除角色
     * @param roleId
     * @throws Exception
     */
    @Delete("DELETE FROM role WHERE id = #{ty}")
    void delete(String roleId) throws Exception;

    /**
     * 修改角色
     * @param role
     * @throws Exception
     */
    @Update("UPDATE role SET roleName = #{roleName}, roleDesc = #{roleDesc} WHERE id = #{id}")
    void update(Role role) throws Exception;

    /**
     * 查询全部的角色Role
     * @return
     */
    @Select("SELECT * FROM role ORDER BY roleName")
    List<Role> selectAll() throws Exception;

    /**
     * 通过角色Id精确查询角色Role
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM role WHERE id = #{ty}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = List.class,
                    many = @Many(select = "edu.hebeu.dao.IPermissionDao.selectByRoleId"))
    })
    Role selectById(String roleId) throws Exception;

    /**
     * 通过用户Id获取角色Role
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM role WHERE id IN (SELECT roleId FROM users_role WHERE userId = #{ty}) ORDER BY roleName")
    @Results({
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = List.class,
                    many = @Many(select = "edu.hebeu.dao.IPermissionDao.selectByRoleId"))
    })
    List<Role> selectByUserId(String userId) throws Exception;

    /**
     * 通过权限Id PermissionId查询对应的角色记录
     * @param permissionId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM role WHERE id IN (SELECT roleId FROM role_permission WHERE permissionId = #{ty}) ORDER BY roleName")
    List<Role> selectByPermissionId(String permissionId) throws Exception;

    /**
     * 从users_role表中删除
     * @param roleId
     */
    @Delete("DELETE FROM users_role WHERE roleId = #{ty}")
    void deleteToUsers_Role(String roleId) throws Exception;

    /**
     * 从role_permission表中删除
     * @param roleId
     * @throws Exception
     */
    @Delete("DELETE FROM role_permission WHERE roleId = #{ty}")
    void deleteToRole_Permission(String roleId) throws Exception;

    /**
     * 查询出该角色可添加的权限Permission
     * @param roleId
     * @return
     */
    @Select("SELECT * FROM permission WHERE id NOT IN (SELECT permissionId FROM role_permission WHERE roleId = #{ty}) ORDER BY permissionName")
    List<Permission> canInsertPermissions(String roleId) throws Exception;

    /**
     * 给该角色添加一个权限Permission
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Insert("INSERT INTO role_permission(roleId,permissionId) VALUES(#{roleId},#{permissionId})")
    void insertPermission(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;

    /**
     * 删除该角色对应的权限
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Delete("DELETE FROM role_permission WHERE roleId = #{roleId} AND permissionId = #{permissionId}")
    void deletePermission(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;
}

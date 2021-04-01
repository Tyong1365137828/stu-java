package edu.hebeu.dao;

import edu.hebeu.domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("permissionDao")
public interface IPermissionDao {

    /**
     * 添加一条Permission记录
     * @param permission
     * @throws Exception
     */
    @Insert("INSERT INTO permission(permissionName,url) VALUES(#{permissionName},#{url})")
    void insert(Permission permission) throws Exception;

    /**
     * 删除一条Permission记录
     * @param permissionId
     * @throws Exception
     */
    @Delete("DELETE FROM permission WHERE id = #{ty}")
    void delete(String permissionId) throws Exception;

    /**
     * 修改一条Permission记录
     * @param permission
     * @throws Exception
     */
    @Update("UPDATE permission SET permissionName = #{permissionName}, url = #{url} WHERE id = #{id}")
    void update(Permission permission) throws Exception;

    /**
     * 查询全部的Permission资源权限记录
     * @return
     */
    @Select("SELECT * FROM permission ORDER BY permissionName")
    List<Permission> selectAll() throws Exception;

    /**
     * 通过id精确查询Permission资源权限记录
     * @param permissionId
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM permission WHERE id = #{ty}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "permissionName", property = "permissionName"),
            @Result(column = "url", property = "url"),
            @Result(column = "id", property = "roles", javaType = List.class,
                    many = @Many(select = "edu.hebeu.dao.IRoleDao.selectByPermissionId"))
    })
    Permission selectById(String permissionId) throws Exception;

    /**
     * 通过角色Id即RoleId查询资源权限Permission
     * @param roleId
     * @return
     */
    @Select("SELECT * FROM permission WHERE id IN(SELECT permissionId FROM role_permission WHERE roleId=#{ty}) ORDER BY permissionName")
    List<Permission> selectByRoleId(String roleId);

    /**
     * 从role_permission表中删除这条Permission的相关记录
     * @param permissionId
     * @throws Exception
     */
    @Delete("DELETE FROM role_permission WHERE permissionId = #{ty}")
    void deleteToRole_Permission(String permissionId) throws Exception;

}

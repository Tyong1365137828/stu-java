package edu.hebeu.service;

import edu.hebeu.domain.Permission;
import edu.hebeu.domain.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 添加角色Role
     * @param role
     * @throws Exception
     */
    void saveS(Role role) throws Exception;

    /**
     * 删除角色 通过角色id
     * @param roleId
     * @throws Exception
     */
    void cutS(String roleId) throws Exception;

    /**
     * 修改角色信息
     * @param role
     * @throws Exception
     */
    void alterS(Role role) throws Exception;

    /**
     * 查询全部的角色Role
     * @return
     */
    List<Role> findAllS() throws Exception;

    /**
     * 通过角色Id精确查询角色Role
     * @param roleId
     * @throws Exception
     */
    Role findSingleS(String roleId) throws Exception;

    /**
     * 查询该角色可添加的权限
     * @param roleId
     * @return
     */
    List<Permission> canAddPermissionsS(String roleId) throws Exception;

    /**
     * 给该角色添加权限
     * @param roleId
     * @param permissionIds
     */
    void addPermissionsS(String roleId, String[] permissionIds) throws Exception;

    /**
     * 给该角色删除权限
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    void cutPermissionS(String roleId, String permissionId) throws Exception;
}

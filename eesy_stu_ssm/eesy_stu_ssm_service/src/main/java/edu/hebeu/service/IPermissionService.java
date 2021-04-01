package edu.hebeu.service;

import edu.hebeu.domain.Permission;

import java.util.List;

public interface IPermissionService {

    /**
     * 添加Permission记录
     * @param permission
     * @throws Exception
     */
    void saveS(Permission permission) throws Exception;

    /**
     * 删除一条Permission
     * @param permissionId
     * @throws Exception
     */
    void cutS(String permissionId) throws Exception;

    /**
     * 修改一条Permission
     * @param permission
     * @throws Exception
     */
    void alterS(Permission permission) throws Exception;

    /**
     * 查询全部的Permission资源权限
     * @return
     */
    List<Permission> findAllS(Integer page, Integer pageSize) throws Exception;

    /**
     * 精确查询Permission权限
     * @param permissionId
     * @return
     * @throws Exception
     */
    Permission findSingleS(String permissionId) throws Exception;

}

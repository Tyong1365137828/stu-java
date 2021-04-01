package edu.hebeu.service.impl;

import edu.hebeu.dao.IRoleDao;
import edu.hebeu.domain.Permission;
import edu.hebeu.domain.Role;
import edu.hebeu.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public void saveS(Role role) throws Exception {
        roleDao.insert(role);
    }

    @Override
    public void cutS(String roleId) throws Exception {
        // 从users_role中间表中删除角色
        roleDao.deleteToUsers_Role(roleId);
        // 从role_permission中间表中删除角色
        roleDao.deleteToRole_Permission(roleId);
        // 从role表中删除角色
        roleDao.delete(roleId);
    }

    @Override
    public void alterS(Role role) throws Exception {
        roleDao.update(role);
    }

    @Override
    public List<Role> findAllS() throws Exception {
        return roleDao.selectAll();
    }

    @Override
    public Role findSingleS(String roleId) throws Exception {
        return roleDao.selectById(roleId);
    }

    @Override
    public List<Permission> canAddPermissionsS(String roleId) throws Exception {
        return roleDao.canInsertPermissions(roleId);
    }

    @Override
    public void addPermissionsS(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.insertPermission(roleId, permissionId);
        }
    }

    @Override
    public void cutPermissionS(String roleId, String permissionId) throws Exception {
        roleDao.deletePermission(roleId, permissionId);
    }
}

package edu.hebeu.service.impl;

import com.github.pagehelper.PageHelper;
import edu.hebeu.dao.IPermissionDao;
import edu.hebeu.domain.Permission;
import edu.hebeu.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public void saveS(Permission permission) throws Exception {
        permissionDao.insert(permission);
    }

    @Override
    public void cutS(String permissionId) throws Exception {
        permissionDao.deleteToRole_Permission(permissionId);// 从role_permission表中删除这个Permission的相关记录
        permissionDao.delete(permissionId); // 从permission表中删除这条Permission记录
    }

    @Override
    public void alterS(Permission permission) throws Exception {
        permissionDao.update(permission);
    }

    @Override
    public List<Permission> findAllS(Integer page, Integer pageSize) throws Exception {

        PageHelper.startPage(page, pageSize);
        return permissionDao.selectAll();
    }

    @Override
    public Permission findSingleS(String permissionId) throws Exception {
        return permissionDao.selectById(permissionId);
    }
}

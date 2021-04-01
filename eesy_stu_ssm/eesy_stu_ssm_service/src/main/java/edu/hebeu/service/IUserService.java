package edu.hebeu.service;

import edu.hebeu.domain.Role;
import edu.hebeu.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    /**
     * 添加用户
     * @param userInfo
     */
    void saveS(UserInfo userInfo) throws Exception;

    /**
     * 修改用户
     * @param userInfo
     */
    void alterS(UserInfo userInfo) throws Exception;

    /**
     * 查询全部用户
     * @return
     */
    List<UserInfo> findAllS() throws Exception;

    /**
     * 精确查询一条用户
     * @param userId
     * @return
     */
    UserInfo findSingleS(String userId) throws Exception;

    /**
     * 查询用户可以添加的角色
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> canAddRolesS(String userId) throws Exception;

    /**
     * 给该用户添加角色信息
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    void addRoles(String userId, String[] roleIds) throws Exception;

    /**
     * 移除该用户的角色信息
     * @param userId
     * @throws Exception
     */
    void cutRoleS(String userId, String roleId) throws Exception;
}

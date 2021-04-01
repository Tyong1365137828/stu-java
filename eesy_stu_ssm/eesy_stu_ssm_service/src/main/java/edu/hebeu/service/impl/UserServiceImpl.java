package edu.hebeu.service.impl;


import edu.hebeu.dao.IUserDao;
import edu.hebeu.domain.Role;
import edu.hebeu.domain.UserInfo;
import edu.hebeu.service.IUserService;
import edu.hebeu.utils.BCryptPasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; // 这个类是SpringSecurity提供的，这里用来对UserInfo的密码进行加密使用

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.selectByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("-----------------" + username);
        System.err.println("-----------------" + userInfo);
        //处理自己的用户对象封装成UserDetails
//          User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
//        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    /**
     * 保存一条UserInfo记录
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void saveS(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword())); // 将UserInfo对象的password修改为加密后的password
//        userInfo.setPassword(BCryptPasswordEncoderUtil.toEncode(userInfo.getPassword())); // 将UserInfo对象的password修改为加密后的password
        userDao.insert(userInfo);
    }

    @Override
    public void alterS(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword())); // 将UserInfo对象的password修改为加密后的password
        userDao.update(userInfo);
    }

    /**
     * findAllS()方法的实现类
     * @return
     */
    @Override
    public List<UserInfo> findAllS() throws Exception {
        return userDao.selectAll();
    }

    @Override
    public UserInfo findSingleS(String userId) throws Exception {
        return userDao.selectById(userId);
    }

    @Override
    public List<Role> canAddRolesS(String userId) throws Exception {
        return userDao.canInsertRoles(userId);
    }

    @Override
    public void addRoles(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userDao.insertRole(userId, roleId);
        }
    }

    @Override
    public void cutRoleS(String userId, String roleId) throws Exception {
        userDao.deleteRole(userId, roleId);
    }
}

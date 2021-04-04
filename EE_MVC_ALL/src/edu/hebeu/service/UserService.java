package edu.hebeu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.entity.User;
import edu.hebeu.util.PageBean;

public interface UserService {
	
	/**
	 * 用户登录Service
	 */
	public User login(String num,String password);
	
	/**
	 * 注册用户Service
	 */
	public int register(User user) throws SQLException;
	
	/**
	 * 显示全部用户Service
	 */
	public List<User> findUserAll();
	
	/**
	 * 分页显示全部用户,对上述方法(findUserAll()方法)的重载Service
	 * @param pageBean
	 */
	public void findUserAll(PageBean<User> pageBean);
	
	/**
	 * 分页显示多条件模糊查询的用户Service
	 */
	public void findUserAll(User user,PageBean<User> pageBean);
	
	/**
	 * 精确查询用户Service
	 */
	public User findUserSingle(User user);
	
	/**
	 * 模糊查询用户Service
	 */
	public List<User> findUserMul(User user);
	
	/**
	 * 删除用户Service
	 * @return 
	 */
	public int deleteUser(String num) throws SQLException;
}

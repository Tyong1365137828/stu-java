package edu.hebeu.dao;

import edu.hebeu.po.User;

public interface UserDao {
	/*
	 * 按照用户名和密码查询用户
	 */
	public User findUserByNameAndPassword(String username,String password);

}

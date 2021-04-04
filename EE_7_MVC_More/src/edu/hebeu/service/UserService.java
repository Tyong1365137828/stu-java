package edu.hebeu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.entity.User;
import edu.hebeu.util.PageBean;

public interface UserService {
	
	//由num精确查找用户全部信息
	public User findUserByNum(String num);
	//显示全部用户
	public List<User> findUserAll();
	//分页显示全部用户,对上述方法重载
	public void findUserAll(PageBean pageBean);
	//分页显示多条件查询的用户,对上述方法重载
	public void findUserAll(String name,Integer age,PageBean pageBean);
	//由name模糊查询用户信息
	public List<User> findDimUserByName(String name);
	//由name和age多条件查询用户信息
	public List<User> findUserMulByNameAndAge(String name,Integer age);
	
	//由num删除此用户
	public void deleteUserByNum(String num) throws SQLException;
	//修改用户信息
	public int updateUser(User user) throws SQLException;
}

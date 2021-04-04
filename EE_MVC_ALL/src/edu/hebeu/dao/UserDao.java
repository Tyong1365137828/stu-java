package edu.hebeu.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.entity.User;

public interface UserDao {
	
//	/**
//	 * 由用户id和密码查询其全部信息Dao
//	 */
//	public User FindAllByIdAndPasswd(String id,String passwd);
//	
	/**
	 * 插入一个用户Dao
	 */
	public int save(User user) throws SQLException;
	
	/**
	 * 返回全部信息Dao
	 */
	public List<User> findAll();
	
	/**
	 * 精确查询用户信息Dao
	 */
	public User singleFind(User user);
	
	/**
	 * 查询由n到m条记录的字段信息Dao
	 */
	public List<User> allFindPage(int start,int end);
	
	/**
	 * 查询由n到m条记录且符合多条件的字段信息Dao,重载
	 */
	public List<User> allFindPage(int start,int end,User user);
	
	/**
	 * 模糊查询用户Dao
	 */
	public List<User> mulFind(User user);
	
	/**
	 * 删除用户
	 */
	public int delete(String num) throws SQLException;
}

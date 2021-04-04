package edu.hebeu.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.entity.User;

public interface UserDao {
	//根据num查找全部信息
	public User findSingleByNum(String num);
	//返回全部信息字段
	public List<User> findAll();
	//查询由n到m条记录的字段信息
	public List<User> findAllPage(int start,int end);
	//查询由n到m条记录且符合多条件的字段信息,对上述方法的重载
	public List<User> findAllPage(int start,int end,String name,Integer age);
	//根据name模糊查找信息
	public List<User> findDimByName(String name);
	//多条件查询
	public List<User> findMulByNameAndAge(String name,Integer age);
	
	//由num删除记录
	public void deleteUserByNum(String num) throws SQLException;
	
	//修改
	public int updateUser(User user) throws SQLException;
}

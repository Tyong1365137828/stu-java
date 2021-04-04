package edu.hebeu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import edu.hebeu.po.Student;
import edu.hebeu.po.User;
/**
 * 
 * @author gong
 *
 */
public interface UserDao {
	
	//查询合法用户
	public User findUserByNameAndPassword(User user);
	
	//查询所有用户
	public List<User> findAll();
	
	//按姓名进行模糊查询
	public Vector findUserByName(String name);
	
	//按姓名进行模糊查询
	public ResultSet findUserByNameResult(String name);
	
	//删除前的查询
	public Student findUserByNum(String sno);
	
	//注册用户
	public int insertUser(User user);
	
	//按照标号删除用户
	public void deleteUser(String number);
	
	//更改用户密码
	public void updateUser(String name,String password);

}

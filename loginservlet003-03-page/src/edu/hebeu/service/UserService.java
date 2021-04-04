package edu.hebeu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.dao.UserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.entity.User;
import edu.hebeu.util.PageBean;

public interface UserService {
   /**
    * 登录
    */
	public User login(String username,String password);
	
	
	/**
	 * 下订单
	 */
	//public void add();
	//注册功能
	public int register(User user);
	//检查用户是否存在
	public boolean userExist(String userid);
	
	public void deleteUser(String userid) throws SQLException;
	
	public List<User> findAllUser();
	
	public User findUserById(String userid);


	public int updateUser(User user);


	public List<User> findUser(String username, Integer age1);

    //分页查询
	public void findUser(PageBean pageBean);


	public void findUser(PageBean<User> pageBean, String name, Integer nage);


	//public void findUser(PageBean<User> pageBean, String name, Integer nage);
}

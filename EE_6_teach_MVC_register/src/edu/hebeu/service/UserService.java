package edu.hebeu.service;

import edu.hebeu.dao.UserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.entity.User;

public interface UserService {
   /**
    * 登录
    */
	public User login(String username,String password);
	
	
	/**
	 * 下订单
	 */
	//public void add();
	/**
	 * 注册功能
	 */
	//注册功能   public int save(User user);
	public int register(User user);
	//检查用户是否存在
	public boolean userExist(String userid);
}

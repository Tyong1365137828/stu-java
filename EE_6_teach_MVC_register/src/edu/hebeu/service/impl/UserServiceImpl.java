package edu.hebeu.service.impl;

import edu.hebeu.dao.UserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User login(String username, String password) {
		userDao=new UserDaoImpl();
		User user=userDao.findAll(username, password);
		return user;
	}
	@Override
	public int register(User user) {
		//userDao=new UserDaoImpl();
		//int n=userDao.save(user);
		//return n;
		System.out.println(user.toString());
		return this.userDao.save(user);
	
	}
	@Override
	public boolean userExist(String userid) {
		
		return this.userDao.userIsExist(userid);
	}

}

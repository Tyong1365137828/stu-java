package edu.hebeu.service.impl;

import edu.hebeu.dao.UserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(String num, String password) {
		// TODO Auto-generated method stub
		return this.userDao.FindAllByIdAndPasswd(num, password);
	}

	@Override
	public int register(User user){
		// TODO Auto-generated method stub
		return this.userDao.save(user);
	}

}

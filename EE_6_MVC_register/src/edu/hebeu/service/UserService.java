package edu.hebeu.service;

import edu.hebeu.entity.User;

public interface UserService {
	
	//µÇÂ¼
	public User login(String num,String password);
	
	//×¢²á
	public int register(User user);
	
}

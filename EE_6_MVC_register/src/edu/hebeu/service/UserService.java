package edu.hebeu.service;

import edu.hebeu.entity.User;

public interface UserService {
	
	//��¼
	public User login(String num,String password);
	
	//ע��
	public int register(User user);
	
}

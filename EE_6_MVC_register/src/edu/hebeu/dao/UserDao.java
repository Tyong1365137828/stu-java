package edu.hebeu.dao;

import edu.hebeu.entity.User;

public interface UserDao {
	
	//由用户id和密码查找全部信息
	public User FindAllByIdAndPasswd(String id,String passwd);
	
	//注册用户使用
	public int save(User user);
	
}

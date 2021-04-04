package edu.hebeu.dao;

import edu.hebeu.entity.User;

public interface UserDao {
	//按照姓名、密码进行查询
    public User findAll(String username,String password);
    //注册
    public int save(User user);
    //判断用户名是否被占用
    public boolean userIsExist(String userid);
}

package edu.hebeu.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.entity.User;

public interface UserDao {
	//按照姓名、密码进行查询
    public User findByNameAndPwd(String username,String password);
    //注册
    public int save(User user);
    //判断用户名是否被占用
    public boolean userIsExist(String userid);
    
    public void delete(String userid) throws SQLException;
    
    public List<User> findAll();
    
    public User findById(String userid);
    
	public int update(User user);
	
	public List<User> findUser(String username, Integer age1);
	public List<User> findPageUser(int start, int end);
	//public List<User> findPageUser(int start, int end, String name, Integer nage);
	public List<User> findPageUser(int start, int end, String name,Integer nage);
	
}

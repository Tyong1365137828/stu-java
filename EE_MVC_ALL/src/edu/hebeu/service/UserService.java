package edu.hebeu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.entity.User;
import edu.hebeu.util.PageBean;

public interface UserService {
	
	/**
	 * �û���¼Service
	 */
	public User login(String num,String password);
	
	/**
	 * ע���û�Service
	 */
	public int register(User user) throws SQLException;
	
	/**
	 * ��ʾȫ���û�Service
	 */
	public List<User> findUserAll();
	
	/**
	 * ��ҳ��ʾȫ���û�,����������(findUserAll()����)������Service
	 * @param pageBean
	 */
	public void findUserAll(PageBean<User> pageBean);
	
	/**
	 * ��ҳ��ʾ������ģ����ѯ���û�Service
	 */
	public void findUserAll(User user,PageBean<User> pageBean);
	
	/**
	 * ��ȷ��ѯ�û�Service
	 */
	public User findUserSingle(User user);
	
	/**
	 * ģ����ѯ�û�Service
	 */
	public List<User> findUserMul(User user);
	
	/**
	 * ɾ���û�Service
	 * @return 
	 */
	public int deleteUser(String num) throws SQLException;
}

package edu.hebeu.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.entity.User;

public interface UserDao {
	
//	/**
//	 * ���û�id�������ѯ��ȫ����ϢDao
//	 */
//	public User FindAllByIdAndPasswd(String id,String passwd);
//	
	/**
	 * ����һ���û�Dao
	 */
	public int save(User user) throws SQLException;
	
	/**
	 * ����ȫ����ϢDao
	 */
	public List<User> findAll();
	
	/**
	 * ��ȷ��ѯ�û���ϢDao
	 */
	public User singleFind(User user);
	
	/**
	 * ��ѯ��n��m����¼���ֶ���ϢDao
	 */
	public List<User> allFindPage(int start,int end);
	
	/**
	 * ��ѯ��n��m����¼�ҷ��϶��������ֶ���ϢDao,����
	 */
	public List<User> allFindPage(int start,int end,User user);
	
	/**
	 * ģ����ѯ�û�Dao
	 */
	public List<User> mulFind(User user);
	
	/**
	 * ɾ���û�
	 */
	public int delete(String num) throws SQLException;
}

package edu.hebeu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.util.PageBean;

public interface UserService {
	/**
	 * �û���¼Service
	 */
	public UserCustom login(String account,String password) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 * ע�Ṧ��Service
	 * @throws Exception 
	 */
	public int register(User user) throws Exception;
	
	/**
	 * ����User��Ϣ����Service
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updateuser(User user) throws Exception;
	
	/**
	 * �û�������Ϣ��ѯ
	 * @param userQueryVo
	 * @return
	 * @throws Exception
	 */
	public UserCustom personinform(User user) throws Exception;
	
	/**
	 * ��ҳ��ʾȫ���û�
	 * @param pageBean
	 * @throws Exception
	 */
	public void findalluser(PageBean<UserCustom> pageBean) throws Exception;

	/**
	 * ��ҳ��������ʾ
	 * @param userCustom
	 * @param pageBean
	 * @throws Exception
	 */
	public void findalluser(UserCustom userCustom , PageBean<UserCustom> pageBean) throws Exception;
	
	/**
	 * ɾ���û�
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int deleteuser(User user) throws Exception;
	
	/**
	 * ģ����ѯ�û�
	 * @param userCustom
	 * @param pageBean
	 * @throws Exception
	 */
	public List<UserCustom> findsermul(UserCustom userCustom) throws Exception;
	
	
	/**
	 * ��ҳչʾ�û������¼
	 * @param userCustom
	 * @param pageBean
	 * @throws Exception
	 */
	public void finduserbuyitems(UserCustom userCustom , PageBean<UserCustom> pageBean) throws Exception;
	
	/**
	 * �����û��������Ʒ
	 * @param userCustom
	 * @return
	 */
	public List<UserCustom> findUserBuyItems(UserCustom userCustom) throws Exception;
	
	
}

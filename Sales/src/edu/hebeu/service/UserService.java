package edu.hebeu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.util.PageBean;

public interface UserService {
	/**
	 * 用户登录Service
	 */
	public UserCustom login(String account,String password) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 * 注册功能Service
	 * @throws Exception 
	 */
	public int register(User user) throws Exception;
	
	/**
	 * 更改User信息功能Service
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updateuser(User user) throws Exception;
	
	/**
	 * 用户个人信息查询
	 * @param userQueryVo
	 * @return
	 * @throws Exception
	 */
	public UserCustom personinform(User user) throws Exception;
	
	/**
	 * 分页显示全部用户
	 * @param pageBean
	 * @throws Exception
	 */
	public void findalluser(PageBean<UserCustom> pageBean) throws Exception;

	/**
	 * 分页多条件显示
	 * @param userCustom
	 * @param pageBean
	 * @throws Exception
	 */
	public void findalluser(UserCustom userCustom , PageBean<UserCustom> pageBean) throws Exception;
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int deleteuser(User user) throws Exception;
	
	/**
	 * 模糊查询用户
	 * @param userCustom
	 * @param pageBean
	 * @throws Exception
	 */
	public List<UserCustom> findsermul(UserCustom userCustom) throws Exception;
	
	
	/**
	 * 分页展示用户购买记录
	 * @param userCustom
	 * @param pageBean
	 * @throws Exception
	 */
	public void finduserbuyitems(UserCustom userCustom , PageBean<UserCustom> pageBean) throws Exception;
	
	/**
	 * 查找用户购买的商品
	 * @param userCustom
	 * @return
	 */
	public List<UserCustom> findUserBuyItems(UserCustom userCustom) throws Exception;
	
	
}

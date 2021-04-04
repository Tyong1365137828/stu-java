package edu.hebeu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.po.UserQueryVo;

/**
 * @author Tyong(汤勇)
 * UserDao.java
 * Jul 6, 2020
 * 用户接口
 */
public interface UserDao {
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * 模糊查询用户
	 */
	public List<UserCustom> findUserDim(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 精确查询用户
	 * @param userQueryVo
	 * @return
	 * @throws Exception
	 */
	public UserCustom findUserSingle(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * 插入一条数据
	 */
	public void save(User user) throws Exception;
	
	/**
	 * 计算用户表的第n到m条的记录数,这里必须要用多参数传递
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<UserCustom> findUserByCount(@Param("start")int start , @Param("end")int end) throws Exception;
	
	/**
	 * 用户表的更新
	 * @param user
	 * @throws Exception
	 */
	public void update(User user) throws Exception;
	
	/**
	 * 删除用户的一条记录
	 * @param user
	 * @throws Exception
	 */
	public void delete(User user) throws Exception;

	/**
	 * 通过用户account查找其买的商品
	 * @return
	 * @throws Exception
	 */
	public List<UserCustom> findOrderToItemsByUserAccount(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 通过用户account查找其买的商品，实现分页展示
	 * @param start
	 * @param end
	 * @param userQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<UserCustom> findOrderToItemsByUserAccountForCount(@Param("start")int start,  @Param("end")int end, @Param("userQueryVo")UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 查询第n到m条符合条件的用户
	 * @param start
	 * @param end
	 * @param userCustom
	 * @return
	 */
	public List<UserCustom> findUserByCountMul(@Param("start")int start,  @Param("end")int end,  @Param("userCustom")UserCustom userCustom);
	
}

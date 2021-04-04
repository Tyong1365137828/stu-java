package edu.hebeu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.hebeu.po.Order;

/**
 * @author Tyong(汤勇)
 * Order.java
 * Jul 8, 2020
 * 订单
 */
public interface OrderDao {
	
	/**
	 * 精确查询订单号
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public Order findOrderExa(Order order) throws Exception;
	
	/**
	 * 查询全部订单
	 * @return
	 * @throws Exception
	 */
	public List<Order> findOrderAll() throws Exception;
	
	/**
	 * 查询n到m条记录的字段信息
	 */
	public List<Order> findOrderByCount(@Param("start")int start , @Param("end")int end) throws Exception;
}

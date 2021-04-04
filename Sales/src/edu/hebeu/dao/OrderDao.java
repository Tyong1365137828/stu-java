package edu.hebeu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.hebeu.po.Order;

/**
 * @author Tyong(����)
 * Order.java
 * Jul 8, 2020
 * ����
 */
public interface OrderDao {
	
	/**
	 * ��ȷ��ѯ������
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public Order findOrderExa(Order order) throws Exception;
	
	/**
	 * ��ѯȫ������
	 * @return
	 * @throws Exception
	 */
	public List<Order> findOrderAll() throws Exception;
	
	/**
	 * ��ѯn��m����¼���ֶ���Ϣ
	 */
	public List<Order> findOrderByCount(@Param("start")int start , @Param("end")int end) throws Exception;
}

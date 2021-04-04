package edu.hebeu.service;

import java.util.List;

import edu.hebeu.po.Order;
import edu.hebeu.util.PageBean;

public interface OrderService {
	
	/**
	 * 全部订单显示
	 * @return
	 * @throws Exception
	 */
	public List<Order> findallorder() throws Exception;
	
	/**
	 * 分页显示全部订单
	 * @param pageBean
	 * @throws Exception 
	 */
	public void findallorder(PageBean<Order> pageBean) throws Exception;

}

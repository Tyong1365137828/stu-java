package edu.hebeu.service;

import java.util.List;

import edu.hebeu.po.Order;
import edu.hebeu.util.PageBean;

public interface OrderService {
	
	/**
	 * ȫ��������ʾ
	 * @return
	 * @throws Exception
	 */
	public List<Order> findallorder() throws Exception;
	
	/**
	 * ��ҳ��ʾȫ������
	 * @param pageBean
	 * @throws Exception 
	 */
	public void findallorder(PageBean<Order> pageBean) throws Exception;

}

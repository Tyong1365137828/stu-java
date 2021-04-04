package edu.hebeu.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.hebeu.dao.OrderDao;
import edu.hebeu.po.Order;
import edu.hebeu.service.OrderService;
import edu.hebeu.util.PageBean;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao;
	private SqlSessionFactory sqlSessionFactory;
	
	public OrderServiceImpl() throws IOException{	//���ɴ˶���ʱ����ִ�й��췽�����Ի�ȡ������Ϣ��
		// ��ȡ��
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ��ȡSqlSessionFactory,�����Ự����.���������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Override
	public List<Order> findallorder() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		orderDao = sqlSession.getMapper(OrderDao.class);
		
		List<Order> list = orderDao.findOrderAll();
		sqlSession.close();
		return list;
	}

	/**
	 * ��ҳ��ʾ�˵���ֱ����������ķ���
	 */
	@Override
	public void findallorder(PageBean<Order> pageBean) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		orderDao = sqlSession.getMapper(OrderDao.class);
		
		// ��ȡ����ѯ����ܼ�¼,��pageBean�д�ǰ̨������index(չʾ��ҳ��ֵ)��size(ÿҳҪչʾ�ļ�¼��)���ý�������Ĳ���
		int totalCount = this.orderDao.findOrderAll().size();

		pageBean.setTotalCount(
					totalCount);/*
									 * ��ֵ��PageBean,ʹ����ͨ�����ܼ�¼���õ�����(��list��)������ֵ,
									 * ��setTotalCount()��
									 * ����������ѯ����ܼ�¼����ס,Ȼ�����setTotalPageCountByRs()����,
									 * �÷���������ܼ�
									 * ¼����֮ǰ��õ�size(ÿҳ��ʾ�ļ�¼��)������ҳ��,Ȼ���ٵ���setNumbers(
									 * totalPageCount)��
									 * ��,�˷������ȡչʾҳ������(��1��2��3��4��5��6),��������;
									 * ��ȡPageBean��totalCount��number�� totalPageCount,��������
									 */

				// 3.��ȡ��ǰҳ���û����ݣ�������PageBean
				// List<User> userList=this.userDao.findPageUser(pageBean);
				// ��Ҫ��DAO�㴫��ȥһ�����ݣ����ý�������һ�鹤��Ӧ����ҵ���е�
				/**
				 * size=5 ҳ�� ��ʼ���� ����ҳ�� 1 1 5 2 6 10 3 11 15
				 * 
				 * index >=(index-1)*size+1 <=index*size index >(index-1)*size
				 * <=index*size
				 * 
				 */
				// ָ����������¼��ʼ(start)��������¼����(end)
				// int start=(pageBean.getIndex()-1)*pageBean.getSize();
				// int end=pageBean.getIndex()*pageBean.getSize();
				// ����ʹ�����·���
				int start = pageBean.getStartRow();
				int end = pageBean.getEndRow();
				
				
				
				List<Order> list = this.orderDao.findOrderByCount(start, end);
				pageBean.setList(list);	//��ȡpagebean��list����
				
				System.out.println("ServiceImpl��list"+list);
				
				System.out.println("TotalCount=" + pageBean.getTotalCount());
				System.out.println("TotalPageCount=" + pageBean.getTotalPageCount());
				System.out.println("Numbers=" + pageBean.getNumbers());
				System.out.println("StartRow=" + pageBean.getStartRow() + ";	EndRow" + pageBean.getEndRow());
				System.out.println("Index=" + pageBean.getIndex() + ";		Size" + pageBean.getSize());
				System.out.println("List=" + pageBean.getList());
				System.out.println("Class=" + pageBean.getClass());

				System.out.println("]ServiceImpl��AllPageBean()����------------");
				sqlSession.close();
//				List<Order> list = this.orderDao.al
	}
	
	

}

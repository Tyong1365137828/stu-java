package edu.hebeu.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import edu.hebeu.po.Order;

public class OrderDaoTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {//��ȡ������
		// ��ȡ��
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ��ȡSqlSessionFactory,�����Ự����.���������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * ���Ծ�ȷ��ѯ����
	 * @throws Exception
	 */
	@Test
	public void testFindOrderExa() throws Exception {
		System.err.println("Map��ʽ�Ĳ���");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);//ʹ����仰���ɴ������ ���� ����
		System.err.println(sqlSession);
		
		Order order  =new Order();
		order.setNum("20200706202641");
		
		Order order2 = orderDao.findOrderExa(order);
		System.out.println(order2);
		sqlSession.close();
	}
	
	/**
	 * ���Բ鿴ȫ������
	 * @throws Exception
	 */
	@Test
	public void testFindOrderAll() throws Exception {
		System.err.println("�鿴ȫ���Ĳ���");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);//ʹ����仰���ɴ������ ���� ����
		System.err.println(sqlSession);
		
		List<Order> list = orderDao.findOrderAll();
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * ���Է�ҳ�鿴ȫ���˵�
	 * @throws Exception
	 */
	@Test
	public void testFindOrderByCount() throws Exception{
		System.err.println("�鿴��Count��ѯ�Ĳ���");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);//ʹ����仰���ɴ������ ���� ����
		System.err.println(sqlSession);
		
		List<Order> list  = orderDao.findOrderByCount(0, 2);
		System.out.println(list);
		sqlSession.close();
	}

}

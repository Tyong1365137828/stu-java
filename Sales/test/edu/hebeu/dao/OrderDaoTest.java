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
	public void setUp() throws Exception {//获取工厂流
		// 获取流
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 获取SqlSessionFactory,创建会话工厂.传入配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 测试精确查询订单
	 * @throws Exception
	 */
	@Test
	public void testFindOrderExa() throws Exception {
		System.err.println("Map方式的测试");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);//使用这句话生成代理对象 代理 反射
		System.err.println(sqlSession);
		
		Order order  =new Order();
		order.setNum("20200706202641");
		
		Order order2 = orderDao.findOrderExa(order);
		System.out.println(order2);
		sqlSession.close();
	}
	
	/**
	 * 测试查看全部订单
	 * @throws Exception
	 */
	@Test
	public void testFindOrderAll() throws Exception {
		System.err.println("查看全部的测试");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);//使用这句话生成代理对象 代理 反射
		System.err.println(sqlSession);
		
		List<Order> list = orderDao.findOrderAll();
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * 测试分页查看全部账单
	 * @throws Exception
	 */
	@Test
	public void testFindOrderByCount() throws Exception{
		System.err.println("查看由Count查询的测试");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);//使用这句话生成代理对象 代理 反射
		System.err.println(sqlSession);
		
		List<Order> list  = orderDao.findOrderByCount(0, 2);
		System.out.println(list);
		sqlSession.close();
	}

}

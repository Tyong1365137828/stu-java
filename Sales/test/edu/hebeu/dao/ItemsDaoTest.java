package edu.hebeu.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import edu.hebeu.po.Items;

public class ItemsDaoTest {

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
	 * 测试模糊查询方法
	 * @throws Exception
	 */
	@Test
	public void testFindMulItems() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsDao itemsDao = sqlSession.getMapper(ItemsDao.class);//使用这句话生成代理对象 代理 反射
		System.err.println(sqlSession);
		
		Items items = new Items();
		items.setName("本");
//		items.setPrice(50.0);
		
		List<Items> list = itemsDao.FindMulItems(items);
		System.out.println("list="+list);
		
		sqlSession.close();
	}
	
	/**
	 * 测试全部商品查询方法
	 * @throws Exception
	 */
	@Test
	public void testFindAllItems() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsDao itemsDao = sqlSession.getMapper(ItemsDao.class);//使用这句话生成代理对象 代理 反射
		System.err.println(sqlSession);
		
		List<Items> list = itemsDao.FindAllItems();
		System.out.println("list="+list);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindItemsByCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsDao itemsDao = sqlSession.getMapper(ItemsDao.class);//使用这句话生成代理对象 代理 反射
		System.err.println(sqlSession);
		
		List<Items> list = itemsDao.findItemsByCount(0,3);
		System.out.println("list="+list);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindItemsByCode() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsDao itemsDao = sqlSession.getMapper(ItemsDao.class);//使用这句话生成代理对象 代理 反射
		System.err.println(sqlSession);
		
		Items items = new Items();
		items.setCode("0001");
		
		Items items2 = itemsDao.findItemsByCode(items);
		System.out.println(items2);
		sqlSession.close();
	}
	

}

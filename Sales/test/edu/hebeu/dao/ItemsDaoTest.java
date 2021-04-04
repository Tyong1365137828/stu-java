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
	public void setUp() throws Exception {//��ȡ������
		// ��ȡ��
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ��ȡSqlSessionFactory,�����Ự����.���������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * ����ģ����ѯ����
	 * @throws Exception
	 */
	@Test
	public void testFindMulItems() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsDao itemsDao = sqlSession.getMapper(ItemsDao.class);//ʹ����仰���ɴ������ ���� ����
		System.err.println(sqlSession);
		
		Items items = new Items();
		items.setName("��");
//		items.setPrice(50.0);
		
		List<Items> list = itemsDao.FindMulItems(items);
		System.out.println("list="+list);
		
		sqlSession.close();
	}
	
	/**
	 * ����ȫ����Ʒ��ѯ����
	 * @throws Exception
	 */
	@Test
	public void testFindAllItems() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsDao itemsDao = sqlSession.getMapper(ItemsDao.class);//ʹ����仰���ɴ������ ���� ����
		System.err.println(sqlSession);
		
		List<Items> list = itemsDao.FindAllItems();
		System.out.println("list="+list);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindItemsByCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsDao itemsDao = sqlSession.getMapper(ItemsDao.class);//ʹ����仰���ɴ������ ���� ����
		System.err.println(sqlSession);
		
		List<Items> list = itemsDao.findItemsByCount(0,3);
		System.out.println("list="+list);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindItemsByCode() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsDao itemsDao = sqlSession.getMapper(ItemsDao.class);//ʹ����仰���ɴ������ ���� ����
		System.err.println(sqlSession);
		
		Items items = new Items();
		items.setCode("0001");
		
		Items items2 = itemsDao.findItemsByCode(items);
		System.out.println(items2);
		sqlSession.close();
	}
	

}

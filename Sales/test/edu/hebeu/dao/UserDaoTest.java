package edu.hebeu.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.po.UserQueryVo;

public class UserDaoTest {
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
	 * ���Բ�ѯ�û�����
	 * @throws Exception
	 */
	@Test
	public void testFindUserDim() throws Exception{
		System.out.println("��ѯ���Կ�ʼ");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//ģ��ҵ���
		UserCustom userCustom = new UserCustom();
//		userCustom.setPassword("072731");
//		userCustom.setAccount("1365137828");
//		userCustom.setAge(19);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> list = userDao.findUserDim(userQueryVo);
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * ���Ծ�ȷ��ѯ�û�����
	 * @throws Exception
	 */
	@Test
	public void testFindUserSingle() throws Exception{
		System.out.println("��ȷ��ѯ���Կ�ʼ");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//ģ��ҵ���
		UserCustom userCustom = new UserCustom();
		userCustom.setAccount("1365137828");
		userCustom.setPassword("072731");
//		userCustom.setAge(10);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		UserCustom userCustom2 = userDao.findUserSingle(userQueryVo);
		System.out.println(userCustom2);
		sqlSession.close();
	}
	
	//���Բ�ѯ��n��m����¼�ķ���
	@Test
	public void testFindUserByCount() throws Exception{
		System.out.println("count���Կ�ʼ");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		List<UserCustom> list = userDao.findUserByCount(0, 20);
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	//���Ը����û�account��ѯ������Ʒ�ķ���
	@Test
	public void testFindOrderToItemsByUserAccount() throws Exception{
		System.out.println("count���Կ�ʼ");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		UserCustom userCustom = new UserCustom();
		userCustom.setAccount("1365137828");
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> list = userDao.findOrderToItemsByUserAccount(userQueryVo);
		
		System.out.println("list="+list);
		sqlSession.close();
	}
	
	//���Ը����û�account��ѯ������Ʒ�ķ���
		@Test
		public void testFindOrderToItemsByUserAccountForCount() throws Exception{
			System.out.println("count���Կ�ʼ");
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			
			UserCustom userCustom = new UserCustom();
			userCustom.setAccount("1365137828");
			
			UserQueryVo userQueryVo = new UserQueryVo();
			userQueryVo.setUserCustom(userCustom);
			
			List<UserCustom> list = userDao.findOrderToItemsByUserAccountForCount(0, 2, userQueryVo);
			
			System.out.println("list="+list);
			sqlSession.close();
		}
	
	
	//�������¼����
	@Test
	public void testsave() throws Exception{
		System.out.println("save���Կ�ʼ");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//ģ��ҵ���
		User user = new User();
		user.setAccount("4856456");
		user.setPassword("0258");
		user.setName("����");
		user.setSex("��");
		user.setTel("15897623");
		user.setAddress("�Ĵ�ʡ�ɶ���");
		
		userDao.save(user);
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	//�����޸��û���Ϣ����
	@Test
	public void testUpdate() throws Exception{
		System.out.println("update���Կ�ʼ");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//ģ��ҵ���
		User user = new User();
		user.setAccount("315153");
		user.setPassword("111111");
		user.setName("????");
		user.setSex("��");
		user.setTel("*******");
		user.setAddress("δ֪");
		
		userDao.update(user);
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	@Test
	public void testDelete() throws Exception{
		System.out.println("update���Կ�ʼ");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//ģ��ҵ���
		User user = new User();
		user.setAccount("4224");
		
		userDao.delete(user);
		sqlSession.commit();
	}
	
	//��鷽��
	@Test
	public void testFindUserByCountMul() throws Exception{
			System.out.println("count���Կ�ʼ");
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			UserCustom userCustom = new UserCustom();
//			userCustom.setName("��");
//			userCustom.setAge(100);
			
			List<UserCustom> list = userDao.findUserByCountMul(0, 2, userCustom);
			
			System.out.println(list);
	}

}

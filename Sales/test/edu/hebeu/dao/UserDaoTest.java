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
	public void setUp() throws Exception {//获取工厂流
		// 获取流
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 获取SqlSessionFactory,创建会话工厂.传入配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 测试查询用户方法
	 * @throws Exception
	 */
	@Test
	public void testFindUserDim() throws Exception{
		System.out.println("查询测试开始");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//模拟业务层
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
	 * 测试精确查询用户方法
	 * @throws Exception
	 */
	@Test
	public void testFindUserSingle() throws Exception{
		System.out.println("精确查询测试开始");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//模拟业务层
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
	
	//测试查询第n到m条记录的方法
	@Test
	public void testFindUserByCount() throws Exception{
		System.out.println("count测试开始");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		List<UserCustom> list = userDao.findUserByCount(0, 20);
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	//测试根据用户account查询购买商品的方法
	@Test
	public void testFindOrderToItemsByUserAccount() throws Exception{
		System.out.println("count测试开始");
		
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
	
	//测试根据用户account查询购买商品的方法
		@Test
		public void testFindOrderToItemsByUserAccountForCount() throws Exception{
			System.out.println("count测试开始");
			
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
	
	
	//检查插入记录方法
	@Test
	public void testsave() throws Exception{
		System.out.println("save测试开始");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//模拟业务层
		User user = new User();
		user.setAccount("4856456");
		user.setPassword("0258");
		user.setName("测试");
		user.setSex("男");
		user.setTel("15897623");
		user.setAddress("四川省成都市");
		
		userDao.save(user);
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	//测试修改用户信息方法
	@Test
	public void testUpdate() throws Exception{
		System.out.println("update测试开始");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//模拟业务层
		User user = new User();
		user.setAccount("315153");
		user.setPassword("111111");
		user.setName("????");
		user.setSex("男");
		user.setTel("*******");
		user.setAddress("未知");
		
		userDao.update(user);
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	@Test
	public void testDelete() throws Exception{
		System.out.println("update测试开始");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		//模拟业务层
		User user = new User();
		user.setAccount("4224");
		
		userDao.delete(user);
		sqlSession.commit();
	}
	
	//检查方法
	@Test
	public void testFindUserByCountMul() throws Exception{
			System.out.println("count测试开始");
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			UserCustom userCustom = new UserCustom();
//			userCustom.setName("测");
//			userCustom.setAge(100);
			
			List<UserCustom> list = userDao.findUserByCountMul(0, 2, userCustom);
			
			System.out.println(list);
	}

}

package edu.hebeu.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.hebeu.dao.UserDao;
import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.po.UserQueryVo;
import edu.hebeu.service.UserService;
import edu.hebeu.util.PageBean;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	private SqlSessionFactory sqlSessionFactory;
	
	public UserServiceImpl() throws IOException{	//生成此对象时，先执行构造方法，以获取配置信息流
		// 获取流
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 获取SqlSessionFactory,创建会话工厂.传入配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * 登录ServiceImpl
	 * @throws Exception 
	 */
	@Override
	public UserCustom login(String account, String password) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
		
		UserCustom userCustom = new UserCustom();
		userCustom.setAccount(account);
		userCustom.setPassword(password);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		UserCustom userCustom2 = userDao.findUserSingle(userQueryVo);
		sqlSession.close();
		
		return userCustom2;
	}

	/**
	 * 用户注册serviceImpl
	 * @throws Exception 
	 */
	@Override
	public int register(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
		
		UserCustom userCustom = new UserCustom();
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		int n = userDao.findUserDim(userQueryVo).size();	//插入之前的总记录条数
		int i;	//声明插入后的记录数
		
		try{
			userDao.save(user);	//插入
			sqlSession.commit();
			
			int m  = userDao.findUserDim(userQueryVo).size();	//插入之后的总记录条数
			i = m-n;	//得到此时增加的条数
			
		}catch(InvocationTargetException e){
			i=0;	//若出错，另i等于0，即没插入
		}
		sqlSession.close();
		
		return i;
	}


	/*更新用户信息
	 * (non-Javadoc)
	 * @see edu.hebeu.service.UserService#updateuser(edu.hebeu.po.User)
	 */
	@Override
	public int updateuser(User user) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
		
		userDao.update(user);
		sqlSession.commit();
		sqlSession.close();
		
		return 1;
	}

	
	/**
	 * 用户查询
	 */
	@Override
	public UserCustom personinform(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
		
		UserCustom userCustom=new UserCustom();
		userCustom.setAccount(user.getAccount());
		userCustom.setAddress(user.getAddress());
		userCustom.setBirthday(user.getBirthday());
		userCustom.setName(user.getName());
		userCustom.setPassword(user.getPassword());
		userCustom.setSex(user.getSex());
		userCustom.setTel(user.getTel());
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		UserCustom userCustom2 = userDao.findUserSingle(userQueryVo);
		System.out.println(userCustom2);
		sqlSession.close();
		
		return userCustom2;
	}
	
	
	
	/**
	 * 由系统时间与生日计算年龄
	 * @param birthday
	 * @return
	 */
	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthday)) {
		throw new IllegalArgumentException(
		"The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
		if (monthNow == monthBirth) {
		// monthNow==monthBirth 
		if (dayOfMonthNow < dayOfMonthBirth) {
		age--;
		}
		} else {
		// monthNow>monthBirth 
		age--;
		}
		}
		return age;
		}

	@Override
	public void findalluser(PageBean<UserCustom> pageBean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
		
		UserCustom userCustom = new UserCustom();
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);	//传入空对象，相当于查询全部
		
		// 获取所查询表的总记录,与pageBean中从前台传来的index(展示的页面值)和size(每页要展示的记录数)连用进行下面的操作
		int totalCount = this.userDao.findUserDim(userQueryVo).size();
		
		pageBean.setTotalCount(
				totalCount);/*
								 * 赋值给PageBean,使其能通过此总记录数得到其他(出list外)的属性值,
								 * 此setTotalCount()方
								 * 法里会把所查询表的总记录数记住,然后调用setTotalPageCountByRs()方法,
								 * 该方法会根据总记
								 * 录除以之前获得的size(每页显示的记录数)计算总页数,然后再调用setNumbers(
								 * totalPageCount)方
								 * 法,此方法会获取展示页数集合(如1、2、3、4、5、6),引起连锁;
								 * 获取PageBean的totalCount、number、 totalPageCount,三个参数
								 */

			// 3.获取当前页的用户数据，并赋给PageBean
			// List<User> userList=this.userDao.findPageUser(pageBean);
			// 不要给DAO层传进去一堆数据，还得解析，这一块工作应该由业务层承担
			/**
			 * size=5 页号 起始面数 结束页数 1 1 5 2 6 10 3 11 15
			 * 
			 * index >=(index-1)*size+1 <=index*size index >(index-1)*size
			 * <=index*size
			 * 
			 */
			// 指定从那条记录开始(start)到那条记录结束(end)
			// int start=(pageBean.getIndex()-1)*pageBean.getSize();
			// int end=pageBean.getIndex()*pageBean.getSize();
			// 或者使用如下方法
			int start = pageBean.getStartRow();
			int end = pageBean.getEndRow();
			
			List<UserCustom> list = this.userDao.findUserByCount(start, end);
			pageBean.setList(list);
			
			System.out.println("ServiceImpl的list"+list);
			
			System.out.println("TotalCount=" + pageBean.getTotalCount());
			System.out.println("TotalPageCount=" + pageBean.getTotalPageCount());
			System.out.println("Numbers=" + pageBean.getNumbers());
			System.out.println("StartRow=" + pageBean.getStartRow() + ";	EndRow" + pageBean.getEndRow());
			System.out.println("Index=" + pageBean.getIndex() + ";		Size" + pageBean.getSize());
			System.out.println("List=" + pageBean.getList());
			System.out.println("Class=" + pageBean.getClass());

			System.out.println("]ServiceImpl的AllPageBean()方法------------");
			sqlSession.close();
		
	}

	@Override
	public void findalluser(UserCustom userCustom, PageBean<UserCustom> pageBean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		int totalCount = this.userDao.findUserDim(userQueryVo).size();

		pageBean.setTotalCount(
				totalCount);/*
							 * 赋值给PageBean,使其能通过此总记录数得到其他(出list外)的属性值,
							 * 此setTotalCount()方
							 * 法里会把所查询表的总记录数记住,然后调用setTotalPageCountByRs()方法,
							 * 该方法会根据总记
							 * 录除以之前获得的size(每页显示的记录数)计算总页数,然后再调用setNumbers(
							 * totalPageCount)方
							 * 法,此方法会获取展示页数集合(如1、2、3、4、5、6),引起连锁;
							 * 获取PageBean的totalCount、number、 totalPageCount,三个参数
							 */

		// 3.获取当前页的用户数据，并赋给PageBean
		// List<User> userList=this.userDao.findPageUser(pageBean);
		// 不要给DAO层传进去一堆数据，还得解析，这一块工作应该由业务层承担
		/**
		 * size=5 页号 起始面数 结束页数 1 1 5 2 6 10 3 11 15
		 * 
		 * index >=(index-1)*size+1 <=index*size index >(index-1)*size
		 * <=index*size
		 * 
		 */
		// 指定从那条记录开始(start)到那条记录结束(end)
		// int start=(pageBean.getIndex()-1)*pageBean.getSize();
		// int end=pageBean.getIndex()*pageBean.getSize();
		// 或者使用如下方法
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();
		sqlSession.close();
		
		
		UserDao userDao2;
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		userDao2 = sqlSession2.getMapper(UserDao.class);
		List<UserCustom> list = userDao2.findUserByCountMul(start, end,userCustom);
		pageBean.setList(list);
		sqlSession2.close();
		
		System.out.println("list="+list);
		
	}

	@Override
	public List<UserCustom> findsermul(UserCustom userCustom) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> list = userDao.findUserDim(userQueryVo);
		
		System.out.println("MUL的list="+list);
		return list;
		
	}

	/**
	 * 删除用户
	 */
	@Override
	public int deleteuser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userQueryVo.setUserCustom(userCustom);
		int n = userDao.findUserDim(userQueryVo).size();	//先查询总记录
		
		//模拟业务层
		userDao.delete(user);//执行删除
		sqlSession.commit();
		
		int m = userDao.findUserDim(userQueryVo).size();	//再查询总记录
		
		System.out.print("n="+n+";m="+m+";n-m="+(n-m));
		
		return n-m;
	}

	/**
	 * 一页展示用户购买记录
	 */
	@Override
	public List<UserCustom> findUserBuyItems(UserCustom userCustom) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> list = userDao.findOrderToItemsByUserAccount(userQueryVo);
		System.out.println("查询用户商品list="+list);
		
		sqlSession.close();
		return list;
	}

	/**
	 * 分页展示用户购买记录
	 */
	@Override
	public void finduserbuyitems(UserCustom userCustom, PageBean<UserCustom> pageBean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		int totalCount = this.userDao.findUserDim(userQueryVo).size();

		pageBean.setTotalCount(totalCount);
		
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();
		
		List<UserCustom> list = userDao.findOrderToItemsByUserAccountForCount(start, end, userQueryVo);
		pageBean.setList(list);
		sqlSession.close();
		
		System.out.println("list="+list);
		
		
	}
	
	
}

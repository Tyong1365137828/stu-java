package edu.hebeu.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.hebeu.dao.UserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.util.PageBean;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	private UserDao userDao2 = new UserDaoImpl();/*
													 * UserDaoImpl的构造函数有获取连接conn
													 * ,prepareStatement
													 * 等必要的操作数据库所用的东西,
													 * 而这些东西只会在UserDaoImpl被new时执行一次
													 * ,所以如果某个业务调用几
													 * 次UserDaoImpl类操作数据库,
													 * 就要再new几个UserDaoImpl,
													 * 如本页下的findUserAll(PageBean
													 * )业务方法
													 */

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 用户登录ServiceImpl
	 */
	@Override
	public User login(String num, String password) {
		// TODO Auto-generated method stub
		User user_Login = new User();
		user_Login.setNum(num);
		user_Login.setPassword(password);
		
		return this.userDao.singleFind(user_Login);
	}

	/**
	 * 用户注册ServiceImpl
	 * @throws SQLException 
	 */
	@Override
	public int register(User user) throws SQLException {
		// TODO Auto-generated method stub
		return this.userDao.save(user);
	}

	/**
	 * 全部用户显示ServiceImpl
	 */
	@Override
	public List<User> findUserAll() {
		// TODO Auto-generated method stub
		return this.userDao.findAll();
	}

	/**
	 * 分页显示全部用户,对上述方法(findUserAll()方法)的重载
	 * 
	 * @param pageBean
	 */
	@Override
	public void findUserAll(PageBean<User> pageBean) {
		System.out.println("----------ServiceImpl的AllPageBean()方法[");
		// 获取所查询表的总记录,与pageBean中从前台传来的index(展示的页面值)和size(每页要展示的记录数)连用进行下面的操作
		int totalCount = this.userDao.findAll().size();

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

		List<User> userList = this.userDao2.allFindPage(start, end);
		pageBean.setList(userList);// 获取PageBean的list参数,至此pageBean的6个参数就全部获取了
		System.out.println("TotalCount=" + pageBean.getTotalCount());
		System.out.println("TotalPageCount=" + pageBean.getTotalPageCount());
		System.out.println("Numbers=" + pageBean.getNumbers());
		System.out.println("StartRow=" + pageBean.getStartRow() + ";	EndRow" + pageBean.getEndRow());
		System.out.println("Index=" + pageBean.getIndex() + ";		Size" + pageBean.getSize());
		System.out.println("List=" + pageBean.getList());
		System.out.println("Class=" + pageBean.getClass());

		System.out.println("]ServiceImpl的AllPageBean()方法------------");
	}

	/**
	 * 分页显示多条件模糊查询的用户
	 */
	@Override
	public void findUserAll(User user, PageBean<User> pageBean) {
		// 获取所查询表的部分记录,与pageBean中从前台传来的index(展示的页面值)和size(每页要展示的记录数)连用进行下面的操作
//		User user_All = new User();
//		user_All.setName(name);
//		user_All.setAge(age);
		
		int totalCount = this.userDao.mulFind(user).size();

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
		List<User> userList = this.userDao2.allFindPage(start, end, user);
		pageBean.setList(userList);// 获取PageBean的list参数

	}

	/**
	 * 精确查询用户ServiceImpl
	 */
	@Override
	public User findUserSingle(User user) {
		// TODO Auto-generated method stub
		return this.userDao.singleFind(user);
	}

	/**
	 * 模糊查询用户ServiceImpl
	 */
	@Override
	public List<User> findUserMul(User user) {
		// TODO Auto-generated method stub
		return userDao.mulFind(user);
	}

	/**
	 * 删除用户Service
	 */
	@Override
	public int deleteUser(String num) throws SQLException {
		return userDao.delete(num);
		
	}

}

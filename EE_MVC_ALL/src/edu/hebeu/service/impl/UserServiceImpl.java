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
													 * UserDaoImpl�Ĺ��캯���л�ȡ����conn
													 * ,prepareStatement
													 * �ȱ�Ҫ�Ĳ������ݿ����õĶ���,
													 * ����Щ����ֻ����UserDaoImpl��newʱִ��һ��
													 * ,�������ĳ��ҵ����ü�
													 * ��UserDaoImpl��������ݿ�,
													 * ��Ҫ��new����UserDaoImpl,
													 * �籾ҳ�µ�findUserAll(PageBean
													 * )ҵ�񷽷�
													 */

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * �û���¼ServiceImpl
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
	 * �û�ע��ServiceImpl
	 * @throws SQLException 
	 */
	@Override
	public int register(User user) throws SQLException {
		// TODO Auto-generated method stub
		return this.userDao.save(user);
	}

	/**
	 * ȫ���û���ʾServiceImpl
	 */
	@Override
	public List<User> findUserAll() {
		// TODO Auto-generated method stub
		return this.userDao.findAll();
	}

	/**
	 * ��ҳ��ʾȫ���û�,����������(findUserAll()����)������
	 * 
	 * @param pageBean
	 */
	@Override
	public void findUserAll(PageBean<User> pageBean) {
		System.out.println("----------ServiceImpl��AllPageBean()����[");
		// ��ȡ����ѯ����ܼ�¼,��pageBean�д�ǰ̨������index(չʾ��ҳ��ֵ)��size(ÿҳҪչʾ�ļ�¼��)���ý�������Ĳ���
		int totalCount = this.userDao.findAll().size();

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

		List<User> userList = this.userDao2.allFindPage(start, end);
		pageBean.setList(userList);// ��ȡPageBean��list����,����pageBean��6��������ȫ����ȡ��
		System.out.println("TotalCount=" + pageBean.getTotalCount());
		System.out.println("TotalPageCount=" + pageBean.getTotalPageCount());
		System.out.println("Numbers=" + pageBean.getNumbers());
		System.out.println("StartRow=" + pageBean.getStartRow() + ";	EndRow" + pageBean.getEndRow());
		System.out.println("Index=" + pageBean.getIndex() + ";		Size" + pageBean.getSize());
		System.out.println("List=" + pageBean.getList());
		System.out.println("Class=" + pageBean.getClass());

		System.out.println("]ServiceImpl��AllPageBean()����------------");
	}

	/**
	 * ��ҳ��ʾ������ģ����ѯ���û�
	 */
	@Override
	public void findUserAll(User user, PageBean<User> pageBean) {
		// ��ȡ����ѯ��Ĳ��ּ�¼,��pageBean�д�ǰ̨������index(չʾ��ҳ��ֵ)��size(ÿҳҪչʾ�ļ�¼��)���ý�������Ĳ���
//		User user_All = new User();
//		user_All.setName(name);
//		user_All.setAge(age);
		
		int totalCount = this.userDao.mulFind(user).size();

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
		List<User> userList = this.userDao2.allFindPage(start, end, user);
		pageBean.setList(userList);// ��ȡPageBean��list����

	}

	/**
	 * ��ȷ��ѯ�û�ServiceImpl
	 */
	@Override
	public User findUserSingle(User user) {
		// TODO Auto-generated method stub
		return this.userDao.singleFind(user);
	}

	/**
	 * ģ����ѯ�û�ServiceImpl
	 */
	@Override
	public List<User> findUserMul(User user) {
		// TODO Auto-generated method stub
		return userDao.mulFind(user);
	}

	/**
	 * ɾ���û�Service
	 */
	@Override
	public int deleteUser(String num) throws SQLException {
		return userDao.delete(num);
		
	}

}

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

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(String username, String password) {
		userDao = new UserDaoImpl();
		User user = userDao.findByNameAndPwd(username, password);
		return user;
	}

	@Override
	public int register(User user) {
		// userDao=new UserDaoImpl();
		// int n=userDao.save(user);
		// return n;
		return this.userDao.save(user);

	}

	@Override
	public boolean userExist(String userid) {

		return this.userDao.userIsExist(userid);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void deleteUser(String userid) throws SQLException {
		// 业务层不处理异常，继续上抛
		// try{
		// this.userDao.delete(userid);
		// }catch(SQLException e){
		//
		// }
		this.userDao.delete(userid);

	}

	@Override
	public User findUserById(String userid) {
		// TODO Auto-generated method stub
		return this.userDao.findById(userid);
	}

	@Override
	public int updateUser(User user) {

		return this.userDao.update(user);
	}

	@Override
	public List<User> findUser(String username, Integer age1) {
		
		return this.userDao.findUser(username,age1);
	}
	/**
	 * 完成分页任务：为Bean的六个属性赋值
	 * 关键是总记录数otalCount 
	 */
	@Override
	public void findUser(PageBean pageBean) {
		//1.获取总的记录数
		//查询全部数据，统计count(*)
		int totalCount=this.userDao.findAll().size();
		System.out.println(totalCount);
	    //2.通过总记录数给PageBean的其它属性赋值
		pageBean.setTotalCount(totalCount);//其它都有了，只差list数据了
		//总页数，number[]   3个参数得到，2个控制层已经知道，差1个list
		//dao查询出来1-5   45-82  mysql
		//3.获取当前页的用户数据，并赋给PageBean
		/**
		 * size=5
		 * 页号                           起始记录数                       结束记录数
		 * 1                1                5
		 * 2                6                10
		 * 3               11                15
		 * ......          ......           ......
		 * index    >=(index-1)*size+1    <=index*size
		 * 起始数用大于表示，+1就可以去掉了，如下：
		 * index     >(index-1)*size      <=index*size
		 * 
		 */
		//int start=(pageBean.getIndex()-1)*pageBean.getSize();
		//int end=pageBean.getIndex()*pageBean.getSize();
		int start=pageBean.getStartRow();
		int end=pageBean.getEndRow();
		List<User> userList=this.userDao.findPageUser(start,end);
		pageBean.setList(userList);//6个参数全部搞定
	}

	@Override
	public void findUser(PageBean<User> pageBean, String name, Integer nage) {
		        //1.获取总的记录数
				//查询部分数据，统计count(*)
				//int totalCount=this.userDao.findAll().size();
				int totalCount=this.userDao.findUser(name, nage).size();
				System.out.println(totalCount);
				
			    //2.通过总记录数给PageBean的其它属性赋值
				pageBean.setTotalCount(totalCount);//其它都有了，只差list数据了
				
				int start=pageBean.getStartRow();
				int end=pageBean.getEndRow();
				
				//List<User> userList=this.userDao.findPageUser(start,end);
				List<User> userList=this.userDao.findPageUser(start,end,name,nage);
				pageBean.setList(userList);//6个参数全部搞定
		
	}

	/*
	@Override
	public void findUser(PageBean<User> pageBean, String name, Integer nage) {
		        //1.获取总的记录数
				//查询全部数据，统计count(*)
				int totalCount=this.userDao.findAll().size();
		        //int totalCount=this.userDao.findUser(name, nage).size();
				System.out.println(totalCount);
				//select * from webuser where 1=1 and username like '%龚%' and age>=10
			    //2.通过总记录数给PageBean的其它属性赋值
				pageBean.setTotalCount(totalCount);//其它都有了，只差list数据了
				
				int start=pageBean.getStartRow();
				int end=pageBean.getEndRow();
				List<User> userList=this.userDao.findPageUser(start,end);
				//List<User> userList=this.userDao.findPageUser(start,end,name,nage);
				pageBean.setList(userList);//6个参数全部搞定
		
	}
	*/

}

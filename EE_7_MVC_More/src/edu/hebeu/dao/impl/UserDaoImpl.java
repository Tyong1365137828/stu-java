package edu.hebeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.hebeu.dao.UserDao;
import edu.hebeu.entity.User;
import edu.hebeu.util.DBUtils;

public class UserDaoImpl implements UserDao {

	private Connection conn = null;
	private PreparedStatement prepareStatement = null;
	private ResultSet resultSet = null;
	private Statement statement = null;
	User user_impl = null;

	public UserDaoImpl() {
		conn = DBUtils.getConnection();
	}

	// 由num查找全部信息
	@Override
	public User findSingleByNum(String num) {
		try {
			String sql = "select * from user where num=?";

			// 命令发送器prepareStatement的建立
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, num);
			// 发送命令获得结果
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				String num_impl = resultSet.getString(1);
				String name_impl = resultSet.getString(2);
				String password_impl = resultSet.getString(3);
				int age_impl = resultSet.getInt(4);
				double score_impl = resultSet.getDouble(5);
				Date date_impl = resultSet.getDate(6);
				String hobby_impl = resultSet.getString(7);

				user_impl = new User(num_impl, name_impl, password_impl, age_impl, score_impl, date_impl, hobby_impl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("findSingleByNum方法有误!!!");
		} finally {// 最后关闭连接
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}
		return user_impl;
	}

	// 全部信息查询返回
	@Override
	public List<User> findAll() {
		System.out.println("----------------UserDaoImpl的findAll()方法[");
		List<User> listUser_impl = new ArrayList<User>();
		try {
			String sql = "select * from user";
			prepareStatement = conn.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				String num_impl = resultSet.getString(1);
				String name_impl = resultSet.getString(2);
				String password_impl = resultSet.getString(3);
				int age_impl = resultSet.getInt(4);
				double score_impl = resultSet.getDouble(5);
				Date date_impl = resultSet.getDate(6);
				String hobby_impl = resultSet.getString(7);

				user_impl = new User(num_impl, name_impl, password_impl, age_impl, score_impl, date_impl, hobby_impl);
				listUser_impl.add(user_impl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("findAll方法有问题!!!");
		} finally {
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
			System.out.println("]UserDaoImpl的findAll()方法-------------");
		}
		return listUser_impl;
	}
	
	//由第n条记录开始到第m条记录结束进行查询
	@Override
	public List<User> findAllPage(int start, int end) {
		System.out.println("-------UserDaoImpl的findAllPage()方法[");
		List<User> listUser_impl = new ArrayList<User>();
		System.out.println("start="+start+"		end="+end);
		try {
			String sql="select * from user order by num limit "+start+","+(end-start)+"";
			System.out.println("ascaeddsvrbsergsd");
			System.out.println("sql="+sql);
			prepareStatement = conn.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String num_impl = resultSet.getString(1);
				String name_impl = resultSet.getString(2);
				String password_impl = resultSet.getString(3);
				int age_impl = resultSet.getInt(4);
				double score_impl = resultSet.getDouble(5);
				Date date_impl = resultSet.getDate(6);
				String hobby_impl = resultSet.getString(7);

				user_impl = new User(num_impl, name_impl, password_impl, age_impl, score_impl, date_impl, hobby_impl);
				listUser_impl.add(user_impl);
				
			}
			System.out.println(user_impl);
			System.out.println(listUser_impl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("findAllPage方法有问题!!!");
		}finally{
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
			System.out.println("]-----------");
		}
		return listUser_impl;
	}
	
	// 根据name模糊查找信息
	@Override
	public List<User> findDimByName(String name) {
		List<User> listUser_impl = new ArrayList<User>();
		try {
			StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
			if (name != null && !"".equals(name)) {
				sql.append(" and name like '%" + name + "%'");
			}

			System.out.println(sql.toString());
			prepareStatement = conn.prepareStatement(sql.toString());
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				String num_impl = resultSet.getString(1);
				String name_impl = resultSet.getString(2);
				String password_impl = resultSet.getString(3);
				int age_impl = resultSet.getInt(4);
				double score_impl = resultSet.getDouble(5);
				Date date_impl = resultSet.getDate(6);
				String hobby_impl = resultSet.getString(7);

				user_impl = new User(num_impl, name_impl, password_impl, age_impl, score_impl, date_impl, hobby_impl);
				listUser_impl.add(user_impl);
			}
			System.out.println(user_impl);
			System.out.println(listUser_impl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("findDimByName方法有问题!!!");
		} finally {
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}
		return listUser_impl;
	}

	// 按照name和age进行的查询
	@Override
	public List<User> findMulByNameAndAge(String name, Integer age) {
		List<User> listUser_impl = new ArrayList<User>();
		try {
			StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
			if (name != null && !"".equals(name)) {
				sql.append(" and name like '%" + name + "%'");
			}
			if (age != null && !"".equals(age)) {
				sql.append(" and age >= '" + age + "'");
			}

			System.out.println(sql.toString());
			prepareStatement = conn.prepareStatement(sql.toString());
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				String num_impl = resultSet.getString(1);
				String name_impl = resultSet.getString(2);
				String password_impl = resultSet.getString(3);
				int age_impl = resultSet.getInt(4);
				double score_impl = resultSet.getDouble(5);
				Date date_impl = resultSet.getDate(6);
				String hobby_impl = resultSet.getString(7);

				user_impl = new User(num_impl, name_impl, password_impl, age_impl, score_impl, date_impl, hobby_impl);
				listUser_impl.add(user_impl);
				
			}
			System.out.println("hsdchjbsdhb"+user_impl);
			System.out.println("wrdvwawr"+listUser_impl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("findMulByNameAndAge方法有问题");
		}finally {
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}
		return listUser_impl;
	}
	
	//由num删除该行记录
	@Override
	public void deleteUserByNum(String num) throws SQLException{
			String sql = "delete from user where num= ?";
			Object [] params = {num};
			DBUtils.executeUpdate(sql, params);
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
	}

	//更新数据
	@Override
	public int updateUser(User user) throws SQLException {
		String sql="update user set name=? ,password=? ,age=? ,score=? ,hobbies=? where num=?";
		Object [] params = {user.getName(),user.getPassword(),user.getAge(),user.getScore(),user.getHobbies(),user.getNum()};
		int n = DBUtils.executeUpdate(sql, params);
		System.out.println("User的name是"+user.getName()+"n等于"+n);
		DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		return n;
	}

	//查询由n到m条记录且符合多条件的字段信息
	@Override
	public List<User> findAllPage(int start, int end, String name, Integer age) {
		System.out.println("-------UserDaoImpl的findAllPage(4参)方法[");
		List<User> listUser_impl = new ArrayList<User>();
		System.out.println("start="+start+"		end="+end);
		try {
			StringBuffer sql=new StringBuffer("select * from user where 1=1 ");
			if (name != null && !"".equals(name)) {
				sql.append(" and name like '%" + name + "%'");
			}
			if (age != null && !"".equals(age)) {
				sql.append(" and age >= '" + age + "'");
			}
			sql.append(" order by num limit "+start+","+(end-start)+"");
			
			System.out.println("ascaeddsvrbsergsd");
			System.out.println("sql="+sql);
			prepareStatement = conn.prepareStatement(sql.toString());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String num_impl = resultSet.getString(1);
				String name_impl = resultSet.getString(2);
				String password_impl = resultSet.getString(3);
				int age_impl = resultSet.getInt(4);
				double score_impl = resultSet.getDouble(5);
				Date date_impl = resultSet.getDate(6);
				String hobby_impl = resultSet.getString(7);

				user_impl = new User(num_impl, name_impl, password_impl, age_impl, score_impl, date_impl, hobby_impl);
				listUser_impl.add(user_impl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("findAllPage(4参)方法有问题!!!");
		}finally{
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
			System.out.println("]-----------");
		}
		return listUser_impl;
	}

}

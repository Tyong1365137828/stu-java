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
	private User user_impl = null;

	/**
	 * 创建conn连接
	 */
	public UserDaoImpl() {
		conn = DBUtils.getConnection();
		if (conn != null) {
			System.out.println("获取连接conn成功");
		} else {
			System.err.println("获取连接conn异常");
		}
	}

	/**
	 * 根据用户的id和密码查询其全部信息DaoImpl
	 */
//	@Override
//	public User FindAllByIdAndPasswd(String id, String passwd) {
//		// User user = null;
//
//		try {
//			String sql = "select * from user where num='" + id + "' and password='" + passwd + "'";
//			statement = conn.prepareStatement(sql);
//
//			resultSet = statement.executeQuery(sql);
//
//			if (resultSet.next()) {
//				String num_impl = resultSet.getString(1);
//				String name_impl = resultSet.getString(2);
//				String password_impl = resultSet.getString(3);
//				int age_impl = resultSet.getInt(4);
//				double score_impl = resultSet.getDouble(5);
//				Date date_impl = resultSet.getDate(6);
//				String hobby_impl = resultSet.getString(7);
//
//				user_impl = new User(num_impl, name_impl, password_impl, age_impl, score_impl, date_impl, hobby_impl);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {// 最后关闭连接
//			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
//		}
//
//		return user_impl;
//	}

	/**
	 * 插入一个用户Impl
	 */
	@Override
	public int save(User user) throws SQLException{

//		int n = 0;
//
//		try {
//			String sql = "insert into user (num,name,password,age,score,registerdate,hobbies) values (?,?,?,?,?,?,?)";
//			prepareStatement = conn.prepareStatement(sql);
//
//			prepareStatement.setString(1, user.getNum());
//			prepareStatement.setString(2, user.getName());
//			prepareStatement.setString(3, user.getPassword());
//			prepareStatement.setInt(4, user.getAge());
//			prepareStatement.setDouble(5, user.getScore());
//			prepareStatement.setDate(6, (java.sql.Date) user.getRegisterdate());
//			prepareStatement.setString(7, user.getHobbies());
//
//			n = prepareStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//			System.err.println("num=" + user.getNum() + "的用户插入失败");
//		} finally {// 最后关闭连接
//			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
//		}
//		return n;
		String sql = "insert into user (num,name,password,age,score,registerdate,hobbies) values (?,?,?,?,?,?,?)";
		Object [] params = {user.getNum(),user.getName(),user.getPassword(),user.getAge(),user.getScore(),user.getRegisterdate(),user.getHobbies()};
		int n = DBUtils.executeUpdate(sql, params);
		DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		return n;
		
	}

	/**
	 * 返回全部信息DaoImpl
	 */
	@Override
	public List<User> findAll() {
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
			// e.printStackTrace();
			System.err.println("返回全部信息失败,findAll方法有问题!!!");
		} finally {
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}
		return listUser_impl;
	}

	/**
	 * 详细查询DaoImpl
	 */
	@Override
	public User singleFind(User user) {
		System.out.println("-------[findSingle()方法执行");
		String name = user.getName();
		String num = user.getNum();
		String password = user.getPassword();
		String hobbies = user.getHobbies();
		Integer age = user.getAge();
		Double score = user.getScore();//不能用double,因为double不能把值置为空(null)，从而导致无法判断
		Date date = user.getRegisterdate();
		
		try {
			StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
			if (name != null && !"".equals(name)) {
				sql.append(" and name = '" + name + "'");
			}
			if (num != null && !"".equals(num)) {
				sql.append(" and num = '" + num + "'");
			}
			if (password != null && !"".equals(password)) {
				sql.append(" and password = '" + password + "'");
			}
			if (hobbies != null && !"".equals(hobbies)) {
				sql.append(" and hobbies = '" + hobbies + "'");
			}
			if (age != null && !"".equals(age)) {
				sql.append(" and age = '" + age + "'");
			}
			if (score != null && !"".equals(score)) {
				sql.append(" and score = '" + score + "'");
			}
			if (date != null && !"".equals(date)) {
				sql.append(" and registerdate = '" + date + "'");
			}
			
			System.out.println("ascaeddsvrbsergsd");
			System.out.println("sql=" + sql);
			prepareStatement = conn.prepareStatement(sql.toString());
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
			// e.printStackTrace();
			System.err.println("findSingle()方法有误!!!");
		} finally {// 最后关闭连接
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}
		System.out.println("]findSingle()方法结束----------");
		return user_impl;
	}

	/**
	 * 查询由n到m条记录的字段信息DaoImpl
	 */
	@Override
	public List<User> allFindPage(int start, int end) {
		List<User> listUser_impl = new ArrayList<User>();
		try {
			String sql = "select * from user order by num limit " + start + "," + (end - start) + "";
			System.out.println("page的sql=" + sql);

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
			// e.printStackTrace();
			System.err.println("findAllPage方法有问题!!!");
		} finally {
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}
		return listUser_impl;
	}

	/**
	 * 查询由n到m条记录且符合多条件的字段信息DaoImpl
	 */
	@Override
	public List<User> allFindPage(int start, int end, User user) {
		System.out.println("-------UserDaoImpl的findAllPage(4参)方法[");
		List<User> listUser_impl = new ArrayList<User>();
		String name = user.getName();
		Integer age = user.getAge();
		System.out.println("start=" + start + "		end=" + end);
		try {
			StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
			if (name != null && !"".equals(name)) {
				sql.append(" and name like '%" + name + "%'");
			}
			if (age != null && !"".equals(age)) {
				sql.append(" and age >= '" + age + "'");
			}
			sql.append(" order by num limit " + start + "," + (end - start) + "");

			System.out.println("ascaeddsvrbsergsd");
			System.out.println("sql=" + sql);
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
		} finally {
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
			System.out.println("]-----------");
		}
		return listUser_impl;
	}

	/**
	 * 模糊查询用户DaoImpl
	 */
	@Override
	public List<User> mulFind(User user) {
		String name = user.getName();
		Integer age = user.getAge();
		
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("findMulByNameAndAge方法有问题");
		}finally {
			DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		}
		return listUser_impl;
	}

	@Override
	public int delete(String num) throws SQLException {
		String sql = "delete from user where num= ?";
		Object [] params = {num};
		int n = DBUtils.executeUpdate(sql, params);
		DBUtils.closeAll(resultSet, prepareStatement, statement, conn);
		return n;
	}

}

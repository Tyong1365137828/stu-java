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
	@Override
	public User findByNameAndPwd(String username, String password) {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 加载驱动

		// 获取连接
		try {
			conn = DBUtils.getConnection();

			// 建立命令发送器（prepareStatement）
			String sql = "select * from webuser where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			// 发送命令并得到结果
			// rs=stmt.executeQuery("select * from webuser where username='"+username+"' and password='"+password+"'");
			rs = ps.executeQuery();
			// 处理结果
			if (rs.next()) {
				// 获取各个字段的值
				String userid = rs.getString("userid");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				Date entrydate = rs.getDate("entrydate");
				String hobby = rs.getString("hobby");
				// 封装到对象中
				user = new User(userid, username, password, age, score,
						entrydate, hobby);
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}

		// 返回内容
		return user;
	}

	/*
	 * @Override public int save(User user) { Connection conn = null;
	 * PreparedStatement ps = null; int n = 0; try { // 获取数据库连接 conn =
	 * DBUtils.getConnection(); String sql =
	 * "insert into webuser (userid,username,password,age,score,entrydate,hobby)  values(?,?,?,?,?,?,?)"
	 * ; ps = conn.prepareStatement(sql); ps.setString(1, user.getUserid());
	 * ps.setString(2, user.getUsername()); ps.setString(3, user.getPassword());
	 * ps.setInt(4, user.getAge()); ps.setDouble(5, user.getScore());
	 * ps.setDate(6, (java.sql.Date) user.getEntrydate()); ps.setString(7,
	 * user.getHobby()); n = ps.executeUpdate(); ps.close(); } catch
	 * (SQLException e) {
	 * 
	 * } finally { if (conn != null) { try { conn.close(); } catch (SQLException
	 * e) {
	 * 
	 * } }
	 * 
	 * } return n; }
	 */

	public int save(User user) {
		String sql = "insert into webuser(userid,username,password,age,score,entrydate,hobby) values(?,?,?,?,?,?,?)";
		Object[] params = { user.getUserid(), user.getUsername(),
				user.getPassword(), user.getAge(), user.getScore(),
				user.getEntrydate(), user.getHobby() };
		// System.out.println(DBUtils.executeUpdate(sql, params));
		try {
			return DBUtils.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean userIsExist(String userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 加载驱动
		// 获取连接
		try {
			conn = DBUtils.getConnection();
			// 建立命令发送器（prepareStatement）
			String sql = "select * from webuser where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			// 发送命令并得到结果
			// rs=stmt.executeQuery("select * from webuser where username='"+username+"' and password='"+password+"'");
			rs = ps.executeQuery();
			// 处理结果
			if (!rs.next()) {
				// 如果无效，则证明此用户可用
				return true;
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return false;
	}

	@Override
	public List<User> findAll() {
		List<User> stu = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		// 加载驱动
		// 获取连接
		try {
			conn = DBUtils.getConnection();
			// 建立命令发送器（prepareStatement）
			String sql = "select * from webuser ";
			ps = conn.prepareStatement(sql);
			// ps.setString(1, userid);
			// 发送命令并得到结果
			// rs=stmt.executeQuery("select * from webuser where username='"+username+"' and password='"+password+"'");
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				Date entrydate = rs.getDate("entrydate");
				String hobby = rs.getString("hobby");
				// 封装到对象中
				user = new User(userid, username, password, age, score,
						entrydate, hobby);
				stu.add(user);
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return stu;
	}

	@Override
	public void delete(String userid) throws SQLException {
		String sql = "delete from webuser where userid=?";
		Object[] params = { userid };
		// System.out.println(DBUtils.executeUpdate(sql, params));
		DBUtils.executeUpdate(sql, params);

	}

	@Override
	public User findById(String userid) {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 加载驱动
		// 获取连接
		try {
			conn = DBUtils.getConnection();
			// 建立命令发送器（prepareStatement）
			String sql = "select * from webuser where userid=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			// 发送命令并得到结果
			rs = ps.executeQuery();
			// 处理结果
			if (rs.next()) {
				// 获取各个字段的值
				// String userid = rs.getString("userid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				Date entrydate = rs.getDate("entrydate");
				String hobby = rs.getString("hobby");
				// 封装到对象中
				user = new User(userid, username, password, age, score,
						entrydate, hobby);
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return user;
	}

	@Override
	public int update(User user) {
		String sql = "update webuser set username=?,password=?,age=?,score=?,entrydate=?,hobby=? where userid=?";
		Object[] params = { user.getUsername(),
				user.getPassword(), user.getAge(), user.getScore(),
				user.getEntrydate(), user.getHobby(),user.getUserid() };
		try {
			return DBUtils.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public List<User> findUser(String username, Integer age1) {
		//System.out.println(age1);
		List<User> stu = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		// 加载驱动
		// 获取连接
		try {
			conn = DBUtils.getConnection();
			// 建立命令发送器（prepareStatement）
			StringBuffer sql=new StringBuffer("select * from webuser where 1=1 ");
			if(username!=null && !"".equals(username)){
				sql.append(" and username like '%"+username+"%'");
			}
			if(age1!=null && !"".equals(age1)){
				sql.append(" and age >= '"+age1+"'");
			}
			//System.out.println(sql.toString());
			ps = conn.prepareStatement(sql.toString());
			// ps.setString(1, userid);
			// 发送命令并得到结果
			// rs=stmt.executeQuery("select * from webuser where username='"+username+"' and password='"+password+"'");
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String userid = rs.getString("userid");
				String username1 = rs.getString("username");
				String password = rs.getString("password");
				int age2 = rs.getInt("age");
				double score = rs.getDouble("score");
				Date entrydate = rs.getDate("entrydate");
				String hobby = rs.getString("hobby");
				// 封装到对象中
				user = new User(userid, username1, password, age2, score,
						entrydate, hobby);
				stu.add(user);
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return stu;
	}
	
	@Override
	public List<User> findPageUser(int start, int end) {
		List<User> stu = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		// 加载驱动
		// 获取连接
		try {
			conn = DBUtils.getConnection();
			// 建立命令发送器（prepareStatement）
			//String sql = "select * from webuser ";
			String sql="select * from webuser order by id limit "+start+","+(end-start)+"";
			//select * from webuser where username like '%龚%' and age >= 35 order by id limit 0,5
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				Date entrydate = rs.getDate("entrydate");
				String hobby = rs.getString("hobby");
				// 封装到对象中
				user = new User(userid, username, password, age, score,
						entrydate, hobby);
				stu.add(user);
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return stu;
	}

	
	@Override
	public List<User> findPageUser(int start, int end, String name, Integer nage) {
		List<User> stu = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		// 加载驱动
		// 获取连接
		try {
			conn = DBUtils.getConnection();
			// 建立命令发送器（prepareStatement）
			//String sql = "select * from webuser ";
			//String sql="select * from webuser order by id limit "+start+","+(end-start)+"";
			//select * from webuser where username like '%龚%' and age >= 35 order by id limit 0,5
			String sql="select * from webuser where username like '%"+name+"%' and age >= "+nage+ " order by id limit "+start+","+(end-start)+"";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				Date entrydate = rs.getDate("entrydate");
				String hobby = rs.getString("hobby");
				// 封装到对象中
				user = new User(userid, username, password, age, score,
						entrydate, hobby);
				stu.add(user);
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return stu;
	}

	
	/*
	@Override
	public List<User> findPageUser(int start, int end, String name, Integer nage) {
		List<User> stu = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		// 加载驱动
		// 获取连接
		try {
			conn = DBUtils.getConnection();
			// 建立命令发送器（prepareStatement）
			//String sql = "select * from webuser ";
			//String sql="select * from webuser order by id limit "+start+","+(end-start)+"";
			//select * from webuser where username like '%龚%' and age >= 35 order by id limit 0,5
			
			String sql="select * from webuser where username like '%"+name+"%' and age >= "+nage +" order by id limit "+start+","+(end-start)+"";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				Date entrydate = rs.getDate("entrydate");
				String hobby = rs.getString("hobby");
				// 封装到对象中
				user = new User(userid, username, password, age, score,
						entrydate, hobby);
				stu.add(user);
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return stu;
	}
    */
}

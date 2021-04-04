package edu.hebeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import edu.hebeu.dao.UserDao;
import edu.hebeu.entity.User;
import edu.hebeu.util.DBUtils;

public class UserDaoImpl implements UserDao {
	@Override
	public User findAll(String username, String password) {
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

	@Override
	public int save(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		System.out.println("UserDaoimpl的"+user.toString());
		try {
			// 获取数据库连接
			conn = DBUtils.getConnection();
			System.out.println("这个是："+conn);
			String sql = "insert into webuser (userid,username,password,age,score,entrydate,hobby)  values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			System.out.println("gggffhf");
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getAge());
			ps.setDouble(5, user.getScore());
			ps.setDate(6, (java.sql.Date) user.getEntrydate());
			ps.setString(7, user.getHobby());
			n = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}

		}
		return n;
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
			  //如果无效，则证明此用户可用
			  return true;	
			}
		} catch (SQLException e) {

		} finally {// 关闭资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return false;
	}
}

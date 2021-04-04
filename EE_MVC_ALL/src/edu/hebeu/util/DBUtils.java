package edu.hebeu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC公共类
 * 用户用这个连接,系统自带的连接池,方便监控,但是要配置web.xml文件以调用servlet自带的连接池
 * @author tyong
 *
 */
public class DBUtils {
	/**
	 * 创建一个连接
	 */
	public static Connection getConnection() {
		Connection conn = null;

		/*
		 * 传统技术
		 */
		// conn=ConectPoolFactory.getInstance().getConnection();
		try {
			// 加载驱动
			// Class.forName("com.mysql.jdbc.Driver");
			// 数据库连接url
			// String url = "jdbc:mysql://localhost:3306/ume";
			// 获取数据库连接
			// conn = DriverManager.getConnection(url, "root", "root");

			/*
			 * 连接池技术
			 */
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn = DriverManager.getConnection("proxool.DB_MVC_ALL");

			return conn;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 关闭数据库连接等资源
	 */
	public static void closeAll(ResultSet resultSet, PreparedStatement prepareStatement, Statement statement,
			Connection conn) {
		System.out.println("----DButils(servlet自带连接池,user用)[");
		try {
			if (resultSet != null) {
				resultSet.close();
				System.out.println("resultSet已断开");
			}
		} catch (SQLException e) {
			System.out.println("resultSet断开异常!!");
		}
		try {
			if (prepareStatement != null) {
				prepareStatement.close();
				System.out.println("prepareStatement已断开");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement断开异常!!");
		}
		try {
			if (statement != null) {
				statement.close();
				System.out.println("statement已断开");
			}
		} catch (SQLException e) {
			System.out.println("statement断开异常!!");
		}
		try {
			if (conn != null) {// conn(连接)最后断掉,否则会出现意想不到的异常
				conn.close();
				System.out.println("conn已断开");
			}
		} catch (SQLException e) {
			System.out.println("conn断开异常!!");
		}
		System.out.println("]----");
	}

	/**
	 * 执行insert、update、delete三个DML操作
	 */
	public static int executeUpdate(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = getConnection();
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			n = pstmt.executeUpdate();
		} catch (SQLException e) {

		}

		return n;
	}
}

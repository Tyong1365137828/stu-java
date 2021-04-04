package edu.hebeu.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC公共类
 * 
 * @author think
 *
 */
public class DBUtils {
	/**
	 * 创建一个连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
//			// 加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			// 数据库连接url
//			String url = "jdbc:mysql://localhost:3306/my_mvc_test?serverTimezone=UTC";
//			// 获取数据库连接
//			conn = DriverManager.getConnection(url, "root", "072731");
			
			
			//使用连接池技术，因为连接池在servlet已经支持(有类似于Factory工场的类，所以直接调用即可)
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			System.out.println("shbhdsbhsdbhjhj");
			conn=DriverManager.getConnection("proxool.MYDB");
			System.out.println("conn="+conn);
			return conn;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 关闭数据库连接等资源
	 */
	public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn ) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {

		}
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {

		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

		}
		
	}
}

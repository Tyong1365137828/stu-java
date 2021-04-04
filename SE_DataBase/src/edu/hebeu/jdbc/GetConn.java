package edu.hebeu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {
	public Connection connection = null;// 生成一个connection空对象

	public Connection getConnection() {// 生成一个getConnection方法
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?serverTimezone=UTC", "root",
					"072731");
			if (connection != null) {
				System.out.println("数据库连接成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

}
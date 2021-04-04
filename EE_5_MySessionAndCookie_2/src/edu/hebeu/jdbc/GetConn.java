package edu.hebeu.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;

public class GetConn {
	public Connection connection = null; 
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/webtest?serverTimezone=UTC", "root", "072731");
//			if (connection != null) {												//要在数据库的url后跟"?serverTimezone=UTC"
//				System.out.println("获取数据库成功!!!");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
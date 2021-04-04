package edu.hebeu.denglu;
import java.sql.Connection;
import java.sql.DriverManager;

public class GetConn {
	public Connection conn = null; 
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			//if (conn != null) {
				//System.out.println("数据库连接成功");
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
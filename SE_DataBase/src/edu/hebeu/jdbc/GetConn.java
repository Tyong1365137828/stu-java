package edu.hebeu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {
	public Connection connection = null;// ����һ��connection�ն���

	public Connection getConnection() {// ����һ��getConnection����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?serverTimezone=UTC", "root",
					"072731");
			if (connection != null) {
				System.out.println("���ݿ����ӳɹ�");
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
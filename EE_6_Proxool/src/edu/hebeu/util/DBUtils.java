package edu.hebeu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC公共类
 * 
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
		 *传统技术 
		 */
		//conn=ConectPoolFactory.getInstance().getConnection();
		try {
			// 加载驱动
			//Class.forName("com.mysql.jdbc.Driver");
			// 数据库连接url
			//String url = "jdbc:mysql://localhost:3306/ume";
			// 获取数据库连接
			//conn = DriverManager.getConnection(url, "root", "root");
			
			
			/*
			 * 连接池技术
			 */
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn=DriverManager.getConnection("proxool.DB");
			
			return conn; 
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 关闭数据库连接等资源
	 */
	public static void closeAll(ResultSet rs, PreparedStatement ps, Statement statement, Connection conn) {
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
			if (statement != null) {
				statement.close();
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
	/**
	 * 执行insert、update、delete三个DML操作 
	 */
	public static int executeUpdate(String sql,Object [] params){
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=getConnection();
		int n=0;
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			n=pstmt.executeUpdate();
		}catch(SQLException e){
			
		}
		
		return n;
	}
}

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
			// 加载驱动
			//Class.forName("com.mysql.jdbc.Driver");
			// 数据库连接url
			//String url = "jdbc:mysql://localhost:3306/ume";
			// 获取数据库连接
			//conn = DriverManager.getConnection(url, "root", "root");
			
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
	public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
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
	/**
	 * 执行insert、update、delete三个DML操作 
	 * @throws SQLException 
	 */
	
	public static int executeUpdate(String sql,Object [] params) throws SQLException{
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
			//在该层次处理异常，上层见不到
			e.printStackTrace();
			//如果需要，再抛给上一层
			throw e;
		}
		
		return n;
	}
	
}

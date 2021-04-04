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
 * @author think
 *
 */
public class DBUtils {
	/**
	 * 创建生成一个连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			
			//传统连接方式
//			// 加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			// 数据库连接url
//			String url = "jdbc:mysql://localhost:3306/my_mvc_test?serverTimezone=UTC";
//			// 获取数据库连接
//			conn = DriverManager.getConnection(url, "root", "072731");
			
			
			//使用连接池技术，因为连接池在servlet已经支持(有类似于Factory工场的类，所以直接调用即可)
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn=DriverManager.getConnection("proxool.MYDB");
			System.out.println("获取连接成功,conn="+conn);
			
			return conn;
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("获取连接有误");
		}
		return null;
	}

	/**
	 * 关闭数据库连接等资源
	 */
	public static void closeAll(ResultSet resultSet, PreparedStatement prepareStatement, Statement statement, Connection conn) {
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
			if (conn != null) {
				conn.close();
				System.out.println("conn已断开");
			}
		} catch (SQLException e) {
			System.out.println("conn断开异常!!");
		}
		
	}
	
	/**
	 * 执行insert、update、delete三个DML操作 
	 */
	public static int executeUpdate(String sql,Object [] params){
		Connection conn=null;
		PreparedStatement prepareStatement=null;
		conn=getConnection();
		int n=0;
		try{
			prepareStatement=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				prepareStatement.setObject(i+1, params[i]);
			}
			n=prepareStatement.executeUpdate();
			System.out.println("Update操作正常");
		}catch(SQLException e){
//			e.printStackTrace();
			System.err.println("DButil的executeUpdate方法异常");
		}
		return n;
	}
}

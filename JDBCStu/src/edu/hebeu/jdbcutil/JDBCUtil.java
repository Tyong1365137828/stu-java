package edu.hebeu.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 封装一个自定义工具类；
 * 	工具类中的构造方法一般都是私有的，因为工具类中的方法一般都是静态的，
 * 私有的构造方法可以防止new对象，在使用所需要的方法时直接通过  类名.方法  调用；
 * @author 13651
 *
 */
public class JDBCUtil {
	
	/**
	 * 私有化构造方法，使该类不能 new对象
	 */
	private JDBCUtil() {}
	
	/***********************************以下的静态变量和静态代码块都在类加载时执行，且只执行一次***************************************/
	private static final ResourceBundle rb = ResourceBundle.getBundle("db/db");
	
	static {
		try {
			Class.forName(rb.getString("driver")); // 1、注册驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/***********************************以下的静态变量和静态代码块都在类加载时执行，且只执行一次***************************************/
	
	/**
	 * 获取数据库连接对象的方法
	 * @return 新的连接对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		return conn;
	}
	
	/**
	 * 关闭资源的方法
	 * 	为什么写Statement，而不是PreparedStatement，因为Statement是PreparedStatement的父类，
	 * 写Statement将来也可以通过多态将PreparedStatement传过来！！！
	 * 
	 * 注意关闭顺序是先ResultSet，然后Statement/PreparedStatement，在Connection！！！
	 * 
	 * @param rs ResultSet查询结果集对象
	 * @param s Statement数据库操作对象
	 * @param conn Connection连接对象
	 */
	public static void closeAll(ResultSet rs, Statement s, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

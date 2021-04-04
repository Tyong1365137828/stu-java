package edu.hebeu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

/**
 * 连接池创建、连接
 * 管理员用这个连接,自定以的连接池
 * @author gbj 体现点一、单例的创建(一个池子一个对象) 体现点二、连接
 *         自己写的一个连接池工厂,不用在web.xml文件里配置调用servlet自带的连接池
 */
public class ConectPoolFactory {
	private static ConectPoolFactory connectPoolFactory = null;// 构造自己的对象变量，单例模式特有
	
	/**
	 * 调用init()方法
	 */
	private ConectPoolFactory() {// 私有构造函数，单例特有
		init();
	}
	
	/**
	 * 放入proxool.properties配置文件,加载连接(物理连接),一次连接好数据库,以后就不用连了,
	 * 直接连接创建的连接池就行
	 */
	public void init() {
		InputStream is = ConectPoolFactory.class.getResourceAsStream("/proxool.properties");// 从proxool.properties配置文件中获取的资源变成流，这里是反射机制
		Properties properties = new Properties();
		try {
			properties.load(is);// 把流放入
			PropertyConfigurator.configure(properties);// 加载,链接对象，，修路，，物理连接(连接池与数据库连接)做好
		} catch (Exception e) {

		}
	}


	/**
	 * 创建连接池
	 */
	public static ConectPoolFactory getInstance() {
		if (null == connectPoolFactory) {// 如果连接池为空,即第一次使用
			connectPoolFactory = new ConectPoolFactory();// 生成连接池
		}
		return connectPoolFactory;// 否则,即连接池不为空,直接返回
	}
	
	/**
	 * 创建连接
	 * 
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");// 变成连接池驱动
			conn = DriverManager.getConnection("proxool.DB_MVC_ALL");
		} catch (Exception e) {

		}
		return conn;
	}

	/**
	 * 关闭数据库连接等资源
	 */
	public static void closeAll(ResultSet resultSet, PreparedStatement prepareStatement, Statement statement,
			Connection conn) {
		System.out.println("----ConectPoolFactory(自定义连接池,Administrator用)[");
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
			if (conn != null) {// conn(连接)要最后断掉,否则会出现意想不到的异常
				conn.close();
				System.out.println("conn已断开");
			}
		} catch (SQLException e) {
			System.out.println("conn断开异常!!");
		}
		System.out.println("]-------");
	}

	/**
	 * 执行insert、update、delete三个DML操作
	 */
	public static int executeUpdate(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		conn = getConnection();
		int n = 0;
		try {
			prepareStatement = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				prepareStatement.setObject(i + 1, params[i]);
			}
			n = prepareStatement.executeUpdate();
		} catch (SQLException e) {

		}
		return n;
	}
}

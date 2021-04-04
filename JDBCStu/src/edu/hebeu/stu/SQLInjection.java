package edu.hebeu.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 这个例子展示SQL注入问题
 * 
 *     当接收用户名时，因为用户名在数据库中是varchar类型的，所有，使用Scanner的实例方法nextLine()接收一行数据，
 * 此时当用户名输入为  xkjkj' OR '1' = '1 这中形式的数据时(有意或无意的拼接导致了SQL语句的拼接，造成SQL语句
 * 的执行结果不正确，与预期产生偏离)，即用户提供的信息参与了SQL语句的编译，此时称这种现象为 SQL注入现象！
 * 
 * 注意因素：程序先进行了字符串的拼接，然后再进行SQL语句的编译，产生注入
 * 
 * 如下例子所示：
 * 	请输入查询的姓名：
	xkjkj' OR '1' = '1
	请输入查询的班级编号：
	12
	sql = SELECT no, name, cno FROM t_student WHERE cno = 12 OR name = 'xkjkj' OR '1' = '1'; name = xkjkj' OR '1' = '1; cno = 12
	
	解决SQL注入问题：
		java.sql.Statement的特点：先进行字符串的拼接，然后再进行SQL语句的编译
			优点：可以进行SQL语句的拼接
			缺点：因为拼接的存在可能会产生SQL注入
			
		java.sql.PreparedStatement的特点：先进行SQL语句的编译，再进行SQL语句的传值
			优点：避免SQL注入、
			缺点：没有办法进行SQL语句的拼接，只能对SQL语句进行传值
			
			
注意：JDBC中所有的下标都是从1开始，以1递增！！！
	
 * @author 13651
 *
 */
public class SQLInjection {

	public static void main(String[] args) {
		Map<String, String> selectMap = indexUI();
		boolean isRes = select(selectMap.get("name"), selectMap.get("cno"));
		System.out.println("查询是否有结果？" + isRes);
	}
	
	/**
	 * 系统初始化页面，接收用户的输入，返回用户输入的用户名和密码信息，以Map集合的形式返回
	 * @return
	 */
	private static Map<String, String> indexUI() {
		System.out.println("欢迎使用该系统！");
		Scanner s = new Scanner(System.in);
		System.out.println("请输入查询的姓名：");
//		String name = s.next();
		String name = s.nextLine(); // 接收一行输入(包括空格)
		System.out.println("请输入查询的班级编号：");String cno = s.next();
		s.close();
		
		Map<String, String> selectMap = new HashMap<>();
		selectMap.put("name", name);
		selectMap.put("cno", cno);
		
		return selectMap;
	}
	
	/**
	 * 查询信息的条件
	 * @param selectName
	 * @param selectCno
	 * @return
	 */
	private static boolean select(String selectName, String selectCno) {		
//		boolean hasResult = useStatement(selectName, selectCno);
		boolean hasResult = usePreparedStatement(selectName, selectCno);
		
		return hasResult;
	}

	/**
	 * 使用Statement执行SQL语句
	 * @param selectName
	 * @param selectCno
	 * @return
	 */
	private static boolean useStatement(String selectName, String selectCno) {
		boolean hasResult = false;
		
		ResourceBundle bundle = ResourceBundle.getBundle("db/db"); // 通过资源绑定器读取db/db.properties文件的信息
		// 将读取到的配置信息赋值到以下变量
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		
		ResultSet rs = null;
		Statement statement = null;
		Connection conn = null;
		try {
			/**1、注册驱动*/
			Class.forName(driver); // 加载 com.mysql.jdbc.Driver 类，使 com.mysql.jdbc.Driver 类的静态代码块执行(静态代码块中有注册驱动的代码)
			
			/**2、获取连接*/
			conn = DriverManager.getConnection(url, username, password);
			
			/**3、获取数据库操作对象*/
			statement = conn.createStatement();
			
			/**4、执行SQL语句*/
			String sql = "SELECT no, name, cno FROM t_student WHERE cno = " + selectCno + " AND name = '" + selectName + "'";
			System.out.println("sql = " + sql + "; name = " + selectName + "; cno = " + selectCno);
			rs = statement.executeQuery(sql);
			
			/**5、处理查询结果集*/
			while(rs.next()) { // 如果 rs.next() 等于 true，表示查询有值
				System.out.println("no = " + rs.getInt("no") + ", name = " + rs.getString("name") + ", cno = " + rs.getInt("cno"));
				hasResult = true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { /**6、关闭资源*/
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
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
		
		return hasResult;
	}
	
	/**
	 * 使用PreparedStatement执行SQL语句
	 * @param selectName
	 * @param selectCno
	 * @return
	 */
	private static boolean usePreparedStatement(String selectName, String selectCno) {
		boolean hasResult = false;
		
		ResourceBundle bundle = ResourceBundle.getBundle("db/db"); // 通过资源绑定器读取db/db.properties文件的信息
		// 将读取到的配置信息赋值到以下变量
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			/**1、注册驱动*/
			Class.forName(driver); // 加载 com.mysql.jdbc.Driver 类，使 com.mysql.jdbc.Driver 类的静态代码块执行(静态代码块中有注册驱动的代码)
			
			/**2、获取连接*/
			conn = DriverManager.getConnection(url, username, password);
			
			/**3、获取数据库操作对象*/
			String sql = "SELECT no, name, cno FROM t_student WHERE cno = ? AND name LIKE ?"; // 1个 ? 是一个占位符，1个占位符只能接收1个 值/数据，注意占位符不要用 ''括起来，另外在进行模糊查询等业务时，不能使用 %将? 联用，而是要把 ? 单独放到SQL语句中，%和值 在SQL语句编写完后再与 ? 进行替换！！！；
			pStatement = conn.prepareStatement(sql); // 此时会发送SQL给DBMS，进行SQL语句的编译
			// 给占位符(?)传值，即对编译好的SQL语句传值
			pStatement.setInt(1, Integer.parseInt(selectCno));
			pStatement.setString(2, '%' + selectName + '%');
			
			/**4、执行SQL语句*/
			System.out.println("sql = " + sql + "; name = " + selectName + "; cno = " + selectCno);
			rs = pStatement.executeQuery(); // 注意所有PreparedStatement就不要将SQL语句传入，而是直接使用PreparedStatement对象执行SQL语句
			
			/**5、处理查询结果集*/
			while(rs.next()) { // 如果 rs.next() 等于 true，表示查询有值
				System.out.println("no = " + rs.getInt("no") + ", name = " + rs.getString("name") + ", cno = " + rs.getInt("cno"));
				hasResult = true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { /**6、关闭资源*/
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pStatement != null) {
				try {
					pStatement.close();
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
		
		return hasResult;
	}

}

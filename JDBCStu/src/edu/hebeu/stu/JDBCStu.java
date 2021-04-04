package edu.hebeu.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 这个例子学习JDBC基本的编写流程
 * @author 13651
 *
 */
public class JDBCStu {
	public static void main(String[] args) {
		
		ResultSet rs = null;
		Statement statement = null;
		Connection conn = null;
		
		try {
			// 1、注册驱动，
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			// 或者可以借助反射机制实现类加载，执行Class的forName(String 类全限定名)，使com.mysql.jdbc.Driver类的静态代码块执行实现驱动的注册，如下所示：
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 2、获取数据库连接
			String url = "jdbc:mysql://localhost:3306/stu_mysql"; // URL,同一资源定位符，任何一个URL都包括 协议 + IP地址 + 端口号 + 资源名
			String username = "root";
			String password = "072731";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn); // com.mysql.jdbc.JDBC4Connection@4d405ef7
			
			// 3、获取数据库操作对象;通过Connection连接对象创建Statement对象，注意，可以创建多个Statement对象
			statement = conn.createStatement();
//			Statement statement1 = conn.createStatement();
			
			// 4、执行的SQL语句，JDBC中的SQL语句不需要以分号结尾
//			String sql = "INSERT INTO t_student(no, name, cno) values(13, '汤勇', 100), (14, '测试', 101), (15, '测试2', 101)"; // 增
//			String sql = "UPDATE t_student SET name = '修改测试', cno = 101 WHERE no = 14"; // 改
//			String sql = "DELETE FROM t_student WHERE no = 14"; // 删 
			
			String sql = "SELECT no, name, cno FROM t_student ORDER BY cno DESC";
			/**
			 * 注意：int executeUpdate(String DMLSQL); // 该方法会将增、删、改DML类型的SQL语句送到数据库并执行，且会将执行后的受影响行数返回
			 */
//			int rows = statement.executeUpdate(sql); // 执行DML类型的SQL语句，并存放执行增、删、改之后受影响的行数
//			System.out.println("受影响的行数：" + rows);
			/**
			 * ResultSet executeQuery(String DQLSQL); // 执行查询DQL类型的SQL语句，并将查询到的结果放到ResultSet结果集中
			 */
			rs = statement.executeQuery(sql);
			
			
			// 5、如果第4步的SQL语句是DQL类型的，即是查询类型的SQL，就需要进行这一步骤，处理查询结果集
			/**
			 * boolean next(); // ResultSet的方法，会将指针下移，下移之后如果指针的指向有值，则返回true
			 */
			while(rs.next()) {
				/*String no = rs.getString(1); // 获取查询结果的当前指针指向的当前行第1列的数据，即no字段
				String name = rs.getString(2); // 获取查询结果的当前指针指向的当前行第2列的数据，即name字段
				String cno = rs.getString(3); // 获取查询结果的当前指针指向的当前行第3列的数据，即cno字段
				*/
				
				// 根据字段值的类型取值
				/*int no = rs.getInt(1);
				String name = rs.getString(2);
				int cno = rs.getInt(3);
				*/
				
				// 根据“查询结果”的列名取值相比于上面的两种方式，以后最好使用这种方式，因为这种方式相比于上面的两种方式更加健壮！
				int no  = rs.getInt("no");
				String name = rs.getString("name");
				int cno = rs.getInt("cno");
				
				System.out.println("no = " + no + ", name = " + name + ", cno = " + cno + ";");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 6、最后进行资源的释放，注意释放资源时先释放ResultSet，再释放Statement，最后释放Connection；分别try{}catch(){}
			if(null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != statement) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

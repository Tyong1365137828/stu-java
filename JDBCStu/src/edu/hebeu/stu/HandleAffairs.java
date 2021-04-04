package edu.hebeu.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 这个例子展示JDBC如何进行事务处理;
 * 	模拟转账业务；
 * 
 * 
 * 结论：在实际开发中必须将JDBC的自动提交机制关闭掉，改为手动提交，当一个完整的事务结束之后再提交；
 * 	在获取连接成功之后，使用java.sql.	Connection类的方法：
 * 		setAutomCommit(false); // 将该连接自动提交事务机制关闭
 * 在try{}内的最后一行代码写上java.sql.Connection类的方法：
 * 		commit(); // 手动提交事务
 * 如果代码执行到catch(SQLException e){...}内，就表示conn出现问题，为了保证数据的安全，最好对该连接进行回滚，执行java.sql.Connection类的方法：
 * 		rollback(); // 手动回滚至上一次的事务提交处的数据
 * @author 13651
 *
 */
public class HandleAffairs {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("db/db");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			// 1、注册驱动
			Class.forName(driver);
			
			// 2、获取连接
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false); // 将该连接的自动提交机制关闭
			
			// 3、获取数据库操作对象
			String sql = "UPDATE t_account SET balance = ? WHERE account_username = ?"; // 通过用户名更新用户的余额信息的SQL语句
			ps = conn.prepareStatement(sql); // 编译SQL语句
			
			// 4、执行SQL语句
			// 给 ? 占位符传值
			/**给 136513 账户减少 10000 元*/
			ps.setDouble(1, 1990000);
			ps.setString(2, "136513");
			int rows = ps.executeUpdate(); // 执行传值之后的SQL语句
			
			/*********************************************此处20秒模拟异常！！！请在此20秒内打开数据库，会发现数据安全问题很大！(先将将第43、69行，以及catch(SQLException e){...} 内的回滚事务的代码注释掉后再进行验证)**************************************/
//			Thread.sleep(20 * 1000); // MySQL默认是执行一条DML语句就提交一次事务，所以，此时异常发生后，刷新数据库会发现 136513 用户已经减少了 10000元，但是 292501 用户还没有收到 10000 元！！！！使用java.sql.Connection类的setAutomCommit(boolean b)方法和commit()方法解决
			
			// 利用空指针异常模拟异常，在异常出现后使用java.sql.Connection类的rollback()方法解决
			String s = null;
			s.toString();
			/*********************************************此处模拟20秒异常！！！请在此20秒内打开数据库，会发现数据安全问题很大！(先将将第43、69行，以及catch(SQLException e){...} 内的回滚事务的代码注释掉后再进行验证)**************************************/
			
			/**给 292501 账户增加 10000 元*/
			ps.setDouble(1, 10000);
			ps.setString(2, "292501");
			rows += ps.executeUpdate(); // 执行传值之后的SQL语句
			
			// 5、处理查询结果集
			
			System.out.println(rows == 2 ? "转账成功！" : "转账失败！！！"); // 如果受影响行等于2，即表示事务成功
			
			conn.commit(); // 提交事务
		} catch(NullPointerException e) {
			System.err.println("出现异常了");
			/**为了数据的安全，当代码执行到此处，表示此次事务出现问题，所以最好进行事务回滚，以撤销这次失败的事务的DML语句对数据库的表的修改！*/
//			if(conn != null) {
//				try {
//					System.out.println("转账事务出现异常！已经回滚事务(撤销本事务已经执行的DML语句)");
//					conn.rollback(); // 对该连接的事务回滚
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) { // 如果代码执行到此处，表示conn出现异常1
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 6、关闭资源
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
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
}



/*
drop table if exists t_account;

create table t_account (
		account_username char(6) primary key,
		balance double(10, 2), /* 10位有效数字个数，两位小数位个数
);
INSERT INTO t_account(account_username, balance) values('136513', 2000000.00), ('292501', 0.00);
SELECT * FROM t_account;
*/
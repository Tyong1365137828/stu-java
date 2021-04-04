package edu.hebeu.forupdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.hebeu.jdbcutil.JDBCUtil;

/**
 * 这个例子展示MySQL的for uopdate关键字的作用
 * 
 * 	关于DQL语句的悲观锁<也有乐观锁概念>：
 * 		对于一个DQL语句，末尾可以添加for update 关键字：
 * 			SELECT no, name, cno FROM t_student WHERE cno = 101 FOR UPDATE
 * 		含义：在本次事务的执行过程中，cno = 101 的记录被查询，并且这些记录在查询过程中，任何事务都不能对
 * 		这些记录进行修改操作，直到当前事务结束(与隔离级别没关系！)之后才能进行修改，这种机制称为 行级锁机制/悲观锁机制；
 * 
 * 
 * 注意：以上在Oracle中是成立的，但是在MySQL中，如果 cno 没有索引或者没有unique字段约束，以上会将表锁住！！！
 * MySQL中当使用 SELECT ... FROM ... WHERE ... FOR UPDATE; 语句时，是行锁(rows lock)或者表锁(table lock)，只取决于
 * 是否能使用索引(例如主键、unique字段)，能则为行锁，反之则为表锁，未查到数据则无锁。而使用 <> 、LIKE 等操作时索引会失效，
 * 自然进行的是表锁；
 * 总结：
 * 	使用 FOR UPDATE 关键字时最好是锁主键值，或者具有unique约束的字段值，锁其他的字段会导致这个表锁住；
 * 	锁住不影响查询，只影响修改！
 * 	整个表锁住后效率会降低，所以要谨慎使用！
 * 所以：FOR UPDATE 关键字要谨慎使用！！！
 * 
 * @author 13651
 *
 */
public class Select {
	public static void main(String[] args) {

		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection(); // 获取连接
			conn.setAutoCommit(false); // 关闭自动提交事务机制(默认)
			
			String sql = "SELECT no, name, cno FROM t_student WHERE cno = ? FOR UPDATE";
			ps = conn.prepareStatement(sql); // 编译SQL语句
			
			// 给占位符赋值
			ps.setInt(1, 100);
			
			rs = ps.executeQuery(); // 执行SQL语句
			
			// 处理查询结果集
			while(rs.next()) {
				System.out.println("no = " + rs.getInt("no") + "; name = " + rs.getString("name") + "; cno = " + rs.getInt("cno"));
			}
			
			Thread.sleep(20 * 1000); // 模拟延迟，请在此时间段内执行Update类进行测试
			
			conn.commit(); // 手动提交事务
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(conn != null) {
				try {
					conn.rollback(); // 回滚至上一次的事务点处
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(rs, ps, conn);
		}
		
		
	}
}

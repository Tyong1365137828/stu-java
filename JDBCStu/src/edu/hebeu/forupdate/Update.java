package edu.hebeu.forupdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.hebeu.jdbcutil.JDBCUtil;

/**
 * 这个类模拟另一个事务，在Select事务运行时，看能不能进行修改，
 * @author 13651
 *
 */
public class Update {
	public static void main(String[] args) {
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			// 2、获取连接
			conn = JDBCUtil.getConnection();
			
			// 3、获取数据库操作对象
			String sql = "UPDATE t_student SET name = '100班修改' WHERE cno = ?";
			ps = conn.prepareStatement(sql); // 编译DML类型的SQL语句
			// 给 占位符? 赋值
			ps.setInt(1, 100);
			
			// 4、执行SQL语句
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				System.out.println("修改成功！" + "受影响行数：" + rows);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 6、关闭资源
			JDBCUtil.closeAll(null, ps, conn);
		}
		
	}
}

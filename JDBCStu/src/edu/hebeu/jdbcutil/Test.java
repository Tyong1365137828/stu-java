package edu.hebeu.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试JDBCUtil工具类
 * @author 13651
 *
 */
public class Test {
	public static void main(String[] args) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			// 2、获取连接
			conn = JDBCUtil.getConnection();
			
			// 3、获取预编译的数据库操作对象
			String sql = "SELECT no, name, cno FROM t_student WHERE cno = ? AND name LIKE ?";
			ps = conn.prepareStatement(sql); // 编译SQL语句
			// 给占位符?传值
			ps.setInt(1, 101);
			ps.setString(2, "%i%");
			
			// 4、执行编译传值之后的SQL语句
			rs = ps.executeQuery();
			System.out.println("sql = " + sql);
			
			// 5、处理查询结果集
			while(rs.next()) {
				System.out.println("no = " + rs.getInt("no") + ", name = " + rs.getString("name") + ", cno = " + rs.getInt("cno"));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 关闭资源
			JDBCUtil.closeAll(rs, ps, conn);
//			JDBCUtil.closeAll(null, ps, conn); // 如果SQL语句是DML，即没有结果集对象，可以传值为 null 即可
		}
		
	}
}

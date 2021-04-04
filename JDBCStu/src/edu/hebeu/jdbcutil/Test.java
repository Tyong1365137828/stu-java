package edu.hebeu.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ����JDBCUtil������
 * @author 13651
 *
 */
public class Test {
	public static void main(String[] args) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			// 2����ȡ����
			conn = JDBCUtil.getConnection();
			
			// 3����ȡԤ��������ݿ��������
			String sql = "SELECT no, name, cno FROM t_student WHERE cno = ? AND name LIKE ?";
			ps = conn.prepareStatement(sql); // ����SQL���
			// ��ռλ��?��ֵ
			ps.setInt(1, 101);
			ps.setString(2, "%i%");
			
			// 4��ִ�б��봫ֵ֮���SQL���
			rs = ps.executeQuery();
			System.out.println("sql = " + sql);
			
			// 5�������ѯ�����
			while(rs.next()) {
				System.out.println("no = " + rs.getInt("no") + ", name = " + rs.getString("name") + ", cno = " + rs.getInt("cno"));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // �ر���Դ
			JDBCUtil.closeAll(rs, ps, conn);
//			JDBCUtil.closeAll(null, ps, conn); // ���SQL�����DML����û�н�������󣬿��Դ�ֵΪ null ����
		}
		
	}
}

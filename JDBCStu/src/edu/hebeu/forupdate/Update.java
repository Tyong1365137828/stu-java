package edu.hebeu.forupdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.hebeu.jdbcutil.JDBCUtil;

/**
 * �����ģ����һ��������Select��������ʱ�����ܲ��ܽ����޸ģ�
 * @author 13651
 *
 */
public class Update {
	public static void main(String[] args) {
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			// 2����ȡ����
			conn = JDBCUtil.getConnection();
			
			// 3����ȡ���ݿ��������
			String sql = "UPDATE t_student SET name = '100���޸�' WHERE cno = ?";
			ps = conn.prepareStatement(sql); // ����DML���͵�SQL���
			// �� ռλ��? ��ֵ
			ps.setInt(1, 100);
			
			// 4��ִ��SQL���
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				System.out.println("�޸ĳɹ���" + "��Ӱ��������" + rows);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 6���ر���Դ
			JDBCUtil.closeAll(null, ps, conn);
		}
		
	}
}

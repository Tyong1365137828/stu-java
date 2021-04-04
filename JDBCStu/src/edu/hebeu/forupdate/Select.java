package edu.hebeu.forupdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.hebeu.jdbcutil.JDBCUtil;

/**
 * �������չʾMySQL��for uopdate�ؼ��ֵ�����
 * 
 * 	����DQL���ı�����<Ҳ���ֹ�������>��
 * 		����һ��DQL��䣬ĩβ�������for update �ؼ��֣�
 * 			SELECT no, name, cno FROM t_student WHERE cno = 101 FOR UPDATE
 * 		���壺�ڱ��������ִ�й����У�cno = 101 �ļ�¼����ѯ��������Щ��¼�ڲ�ѯ�����У��κ����񶼲��ܶ�
 * 		��Щ��¼�����޸Ĳ�����ֱ����ǰ�������(����뼶��û��ϵ��)֮����ܽ����޸ģ����ֻ��Ƴ�Ϊ �м�������/���������ƣ�
 * 
 * 
 * ע�⣺������Oracle���ǳ����ģ�������MySQL�У���� cno û����������û��unique�ֶ�Լ�������ϻὫ����ס������
 * MySQL�е�ʹ�� SELECT ... FROM ... WHERE ... FOR UPDATE; ���ʱ��������(rows lock)���߱���(table lock)��ֻȡ����
 * �Ƿ���ʹ������(����������unique�ֶ�)������Ϊ��������֮��Ϊ������δ�鵽��������������ʹ�� <> ��LIKE �Ȳ���ʱ������ʧЧ��
 * ��Ȼ���е��Ǳ�����
 * �ܽ᣺
 * 	ʹ�� FOR UPDATE �ؼ���ʱ�����������ֵ�����߾���uniqueԼ�����ֶ�ֵ�����������ֶλᵼ���������ס��
 * 	��ס��Ӱ���ѯ��ֻӰ���޸ģ�
 * 	��������ס��Ч�ʻή�ͣ�����Ҫ����ʹ�ã�
 * ���ԣ�FOR UPDATE �ؼ���Ҫ����ʹ�ã�����
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
			conn = JDBCUtil.getConnection(); // ��ȡ����
			conn.setAutoCommit(false); // �ر��Զ��ύ�������(Ĭ��)
			
			String sql = "SELECT no, name, cno FROM t_student WHERE cno = ? FOR UPDATE";
			ps = conn.prepareStatement(sql); // ����SQL���
			
			// ��ռλ����ֵ
			ps.setInt(1, 100);
			
			rs = ps.executeQuery(); // ִ��SQL���
			
			// �����ѯ�����
			while(rs.next()) {
				System.out.println("no = " + rs.getInt("no") + "; name = " + rs.getString("name") + "; cno = " + rs.getInt("cno"));
			}
			
			Thread.sleep(20 * 1000); // ģ���ӳ٣����ڴ�ʱ�����ִ��Update����в���
			
			conn.commit(); // �ֶ��ύ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(conn != null) {
				try {
					conn.rollback(); // �ع�����һ�ε�����㴦
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

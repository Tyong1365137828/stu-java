package edu.hebeu.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * �������չʾJDBC��ν���������;
 * 	ģ��ת��ҵ��
 * 
 * 
 * ���ۣ���ʵ�ʿ����б��뽫JDBC���Զ��ύ���ƹرյ�����Ϊ�ֶ��ύ����һ���������������֮�����ύ��
 * 	�ڻ�ȡ���ӳɹ�֮��ʹ��java.sql.	Connection��ķ�����
 * 		setAutomCommit(false); // ���������Զ��ύ������ƹر�
 * ��try{}�ڵ����һ�д���д��java.sql.Connection��ķ�����
 * 		commit(); // �ֶ��ύ����
 * �������ִ�е�catch(SQLException e){...}�ڣ��ͱ�ʾconn�������⣬Ϊ�˱�֤���ݵİ�ȫ����öԸ����ӽ��лع���ִ��java.sql.Connection��ķ�����
 * 		rollback(); // �ֶ��ع�����һ�ε������ύ��������
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
			// 1��ע������
			Class.forName(driver);
			
			// 2����ȡ����
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false); // �������ӵ��Զ��ύ���ƹر�
			
			// 3����ȡ���ݿ��������
			String sql = "UPDATE t_account SET balance = ? WHERE account_username = ?"; // ͨ���û��������û��������Ϣ��SQL���
			ps = conn.prepareStatement(sql); // ����SQL���
			
			// 4��ִ��SQL���
			// �� ? ռλ����ֵ
			/**�� 136513 �˻����� 10000 Ԫ*/
			ps.setDouble(1, 1990000);
			ps.setString(2, "136513");
			int rows = ps.executeUpdate(); // ִ�д�ֵ֮���SQL���
			
			/*********************************************�˴�20��ģ���쳣���������ڴ�20���ڴ����ݿ⣬�ᷢ�����ݰ�ȫ����ܴ�(�Ƚ�����43��69�У��Լ�catch(SQLException e){...} �ڵĻع�����Ĵ���ע�͵����ٽ�����֤)**************************************/
//			Thread.sleep(20 * 1000); // MySQLĬ����ִ��һ��DML�����ύһ���������ԣ���ʱ�쳣������ˢ�����ݿ�ᷢ�� 136513 �û��Ѿ������� 10000Ԫ������ 292501 �û���û���յ� 10000 Ԫ��������ʹ��java.sql.Connection���setAutomCommit(boolean b)������commit()�������
			
			// ���ÿ�ָ���쳣ģ���쳣�����쳣���ֺ�ʹ��java.sql.Connection���rollback()�������
			String s = null;
			s.toString();
			/*********************************************�˴�ģ��20���쳣���������ڴ�20���ڴ����ݿ⣬�ᷢ�����ݰ�ȫ����ܴ�(�Ƚ�����43��69�У��Լ�catch(SQLException e){...} �ڵĻع�����Ĵ���ע�͵����ٽ�����֤)**************************************/
			
			/**�� 292501 �˻����� 10000 Ԫ*/
			ps.setDouble(1, 10000);
			ps.setString(2, "292501");
			rows += ps.executeUpdate(); // ִ�д�ֵ֮���SQL���
			
			// 5�������ѯ�����
			
			System.out.println(rows == 2 ? "ת�˳ɹ���" : "ת��ʧ�ܣ�����"); // �����Ӱ���е���2������ʾ����ɹ�
			
			conn.commit(); // �ύ����
		} catch(NullPointerException e) {
			System.err.println("�����쳣��");
			/**Ϊ�����ݵİ�ȫ��������ִ�е��˴�����ʾ�˴�����������⣬������ý�������ع����Գ������ʧ�ܵ������DML�������ݿ�ı���޸ģ�*/
//			if(conn != null) {
//				try {
//					System.out.println("ת����������쳣���Ѿ��ع�����(�����������Ѿ�ִ�е�DML���)");
//					conn.rollback(); // �Ը����ӵ�����ع�
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) { // �������ִ�е��˴�����ʾconn�����쳣1
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 6���ر���Դ
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
		balance double(10, 2), /* 10λ��Ч���ָ�������λС��λ����
);
INSERT INTO t_account(account_username, balance) values('136513', 2000000.00), ('292501', 0.00);
SELECT * FROM t_account;
*/
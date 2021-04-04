package edu.hebeu.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �������ѧϰJDBC�����ı�д����
 * @author 13651
 *
 */
public class JDBCStu {
	public static void main(String[] args) {
		
		ResultSet rs = null;
		Statement statement = null;
		Connection conn = null;
		
		try {
			// 1��ע��������
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			// ���߿��Խ����������ʵ������أ�ִ��Class��forName(String ��ȫ�޶���)��ʹcom.mysql.jdbc.Driver��ľ�̬�����ִ��ʵ��������ע�ᣬ������ʾ��
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 2����ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3306/stu_mysql"; // URL,ͬһ��Դ��λ�����κ�һ��URL������ Э�� + IP��ַ + �˿ں� + ��Դ��
			String username = "root";
			String password = "072731";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn); // com.mysql.jdbc.JDBC4Connection@4d405ef7
			
			// 3����ȡ���ݿ��������;ͨ��Connection���Ӷ��󴴽�Statement����ע�⣬���Դ������Statement����
			statement = conn.createStatement();
//			Statement statement1 = conn.createStatement();
			
			// 4��ִ�е�SQL��䣬JDBC�е�SQL��䲻��Ҫ�ԷֺŽ�β
//			String sql = "INSERT INTO t_student(no, name, cno) values(13, '����', 100), (14, '����', 101), (15, '����2', 101)"; // ��
//			String sql = "UPDATE t_student SET name = '�޸Ĳ���', cno = 101 WHERE no = 14"; // ��
//			String sql = "DELETE FROM t_student WHERE no = 14"; // ɾ 
			
			String sql = "SELECT no, name, cno FROM t_student ORDER BY cno DESC";
			/**
			 * ע�⣺int executeUpdate(String DMLSQL); // �÷����Ὣ����ɾ����DML���͵�SQL����͵����ݿⲢִ�У��һὫִ�к����Ӱ����������
			 */
//			int rows = statement.executeUpdate(sql); // ִ��DML���͵�SQL��䣬�����ִ������ɾ����֮����Ӱ�������
//			System.out.println("��Ӱ���������" + rows);
			/**
			 * ResultSet executeQuery(String DQLSQL); // ִ�в�ѯDQL���͵�SQL��䣬������ѯ���Ľ���ŵ�ResultSet�������
			 */
			rs = statement.executeQuery(sql);
			
			
			// 5�������4����SQL�����DQL���͵ģ����ǲ�ѯ���͵�SQL������Ҫ������һ���裬�����ѯ�����
			/**
			 * boolean next(); // ResultSet�ķ������Ὣָ�����ƣ�����֮�����ָ���ָ����ֵ���򷵻�true
			 */
			while(rs.next()) {
				/*String no = rs.getString(1); // ��ȡ��ѯ����ĵ�ǰָ��ָ��ĵ�ǰ�е�1�е����ݣ���no�ֶ�
				String name = rs.getString(2); // ��ȡ��ѯ����ĵ�ǰָ��ָ��ĵ�ǰ�е�2�е����ݣ���name�ֶ�
				String cno = rs.getString(3); // ��ȡ��ѯ����ĵ�ǰָ��ָ��ĵ�ǰ�е�3�е����ݣ���cno�ֶ�
				*/
				
				// �����ֶ�ֵ������ȡֵ
				/*int no = rs.getInt(1);
				String name = rs.getString(2);
				int cno = rs.getInt(3);
				*/
				
				// ���ݡ���ѯ�����������ȡֵ�������������ַ�ʽ���Ժ����ʹ�����ַ�ʽ����Ϊ���ַ�ʽ�������������ַ�ʽ���ӽ�׳��
				int no  = rs.getInt("no");
				String name = rs.getString("name");
				int cno = rs.getInt("cno");
				
				System.out.println("no = " + no + ", name = " + name + ", cno = " + cno + ";");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 6����������Դ���ͷţ�ע���ͷ���Դʱ���ͷ�ResultSet�����ͷ�Statement������ͷ�Connection���ֱ�try{}catch(){}
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

package edu.hebeu.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * �������չʾSQLע������
 * 
 *     �������û���ʱ����Ϊ�û��������ݿ�����varchar���͵ģ����У�ʹ��Scanner��ʵ������nextLine()����һ�����ݣ�
 * ��ʱ���û�������Ϊ  xkjkj' OR '1' = '1 ������ʽ������ʱ(����������ƴ�ӵ�����SQL����ƴ�ӣ����SQL���
 * ��ִ�н������ȷ����Ԥ�ڲ���ƫ��)�����û��ṩ����Ϣ������SQL���ı��룬��ʱ����������Ϊ SQLע������
 * 
 * ע�����أ������Ƚ������ַ�����ƴ�ӣ�Ȼ���ٽ���SQL���ı��룬����ע��
 * 
 * ����������ʾ��
 * 	�������ѯ��������
	xkjkj' OR '1' = '1
	�������ѯ�İ༶��ţ�
	12
	sql = SELECT no, name, cno FROM t_student WHERE cno = 12 OR name = 'xkjkj' OR '1' = '1'; name = xkjkj' OR '1' = '1; cno = 12
	
	���SQLע�����⣺
		java.sql.Statement���ص㣺�Ƚ����ַ�����ƴ�ӣ�Ȼ���ٽ���SQL���ı���
			�ŵ㣺���Խ���SQL����ƴ��
			ȱ�㣺��Ϊƴ�ӵĴ��ڿ��ܻ����SQLע��
			
		java.sql.PreparedStatement���ص㣺�Ƚ���SQL���ı��룬�ٽ���SQL���Ĵ�ֵ
			�ŵ㣺����SQLע�롢
			ȱ�㣺û�а취����SQL����ƴ�ӣ�ֻ�ܶ�SQL�����д�ֵ
			
			
ע�⣺JDBC�����е��±궼�Ǵ�1��ʼ����1����������
	
 * @author 13651
 *
 */
public class SQLInjection {

	public static void main(String[] args) {
		Map<String, String> selectMap = indexUI();
		boolean isRes = select(selectMap.get("name"), selectMap.get("cno"));
		System.out.println("��ѯ�Ƿ��н����" + isRes);
	}
	
	/**
	 * ϵͳ��ʼ��ҳ�棬�����û������룬�����û�������û�����������Ϣ����Map���ϵ���ʽ����
	 * @return
	 */
	private static Map<String, String> indexUI() {
		System.out.println("��ӭʹ�ø�ϵͳ��");
		Scanner s = new Scanner(System.in);
		System.out.println("�������ѯ��������");
//		String name = s.next();
		String name = s.nextLine(); // ����һ������(�����ո�)
		System.out.println("�������ѯ�İ༶��ţ�");String cno = s.next();
		s.close();
		
		Map<String, String> selectMap = new HashMap<>();
		selectMap.put("name", name);
		selectMap.put("cno", cno);
		
		return selectMap;
	}
	
	/**
	 * ��ѯ��Ϣ������
	 * @param selectName
	 * @param selectCno
	 * @return
	 */
	private static boolean select(String selectName, String selectCno) {		
//		boolean hasResult = useStatement(selectName, selectCno);
		boolean hasResult = usePreparedStatement(selectName, selectCno);
		
		return hasResult;
	}

	/**
	 * ʹ��Statementִ��SQL���
	 * @param selectName
	 * @param selectCno
	 * @return
	 */
	private static boolean useStatement(String selectName, String selectCno) {
		boolean hasResult = false;
		
		ResourceBundle bundle = ResourceBundle.getBundle("db/db"); // ͨ����Դ������ȡdb/db.properties�ļ�����Ϣ
		// ����ȡ����������Ϣ��ֵ�����±���
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		
		ResultSet rs = null;
		Statement statement = null;
		Connection conn = null;
		try {
			/**1��ע������*/
			Class.forName(driver); // ���� com.mysql.jdbc.Driver �࣬ʹ com.mysql.jdbc.Driver ��ľ�̬�����ִ��(��̬���������ע�������Ĵ���)
			
			/**2����ȡ����*/
			conn = DriverManager.getConnection(url, username, password);
			
			/**3����ȡ���ݿ��������*/
			statement = conn.createStatement();
			
			/**4��ִ��SQL���*/
			String sql = "SELECT no, name, cno FROM t_student WHERE cno = " + selectCno + " AND name = '" + selectName + "'";
			System.out.println("sql = " + sql + "; name = " + selectName + "; cno = " + selectCno);
			rs = statement.executeQuery(sql);
			
			/**5�������ѯ�����*/
			while(rs.next()) { // ��� rs.next() ���� true����ʾ��ѯ��ֵ
				System.out.println("no = " + rs.getInt("no") + ", name = " + rs.getString("name") + ", cno = " + rs.getInt("cno"));
				hasResult = true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { /**6���ر���Դ*/
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
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
		
		return hasResult;
	}
	
	/**
	 * ʹ��PreparedStatementִ��SQL���
	 * @param selectName
	 * @param selectCno
	 * @return
	 */
	private static boolean usePreparedStatement(String selectName, String selectCno) {
		boolean hasResult = false;
		
		ResourceBundle bundle = ResourceBundle.getBundle("db/db"); // ͨ����Դ������ȡdb/db.properties�ļ�����Ϣ
		// ����ȡ����������Ϣ��ֵ�����±���
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			/**1��ע������*/
			Class.forName(driver); // ���� com.mysql.jdbc.Driver �࣬ʹ com.mysql.jdbc.Driver ��ľ�̬�����ִ��(��̬���������ע�������Ĵ���)
			
			/**2����ȡ����*/
			conn = DriverManager.getConnection(url, username, password);
			
			/**3����ȡ���ݿ��������*/
			String sql = "SELECT no, name, cno FROM t_student WHERE cno = ? AND name LIKE ?"; // 1�� ? ��һ��ռλ����1��ռλ��ֻ�ܽ���1�� ֵ/���ݣ�ע��ռλ����Ҫ�� ''�������������ڽ���ģ����ѯ��ҵ��ʱ������ʹ�� %��? ���ã�����Ҫ�� ? �����ŵ�SQL����У�%��ֵ ��SQL����д������� ? �����滻��������
			pStatement = conn.prepareStatement(sql); // ��ʱ�ᷢ��SQL��DBMS������SQL���ı���
			// ��ռλ��(?)��ֵ�����Ա���õ�SQL��䴫ֵ
			pStatement.setInt(1, Integer.parseInt(selectCno));
			pStatement.setString(2, '%' + selectName + '%');
			
			/**4��ִ��SQL���*/
			System.out.println("sql = " + sql + "; name = " + selectName + "; cno = " + selectCno);
			rs = pStatement.executeQuery(); // ע������PreparedStatement�Ͳ�Ҫ��SQL��䴫�룬����ֱ��ʹ��PreparedStatement����ִ��SQL���
			
			/**5�������ѯ�����*/
			while(rs.next()) { // ��� rs.next() ���� true����ʾ��ѯ��ֵ
				System.out.println("no = " + rs.getInt("no") + ", name = " + rs.getString("name") + ", cno = " + rs.getInt("cno"));
				hasResult = true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { /**6���ر���Դ*/
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pStatement != null) {
				try {
					pStatement.close();
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
		
		return hasResult;
	}

}

package edu.hebeu.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * ��װһ���Զ��幤���ࣻ
 * 	�������еĹ��췽��һ�㶼��˽�еģ���Ϊ�������еķ���һ�㶼�Ǿ�̬�ģ�
 * ˽�еĹ��췽�����Է�ֹnew������ʹ������Ҫ�ķ���ʱֱ��ͨ��  ����.����  ���ã�
 * @author 13651
 *
 */
public class JDBCUtil {
	
	/**
	 * ˽�л����췽����ʹ���಻�� new����
	 */
	private JDBCUtil() {}
	
	/***********************************���µľ�̬�����;�̬����鶼�������ʱִ�У���ִֻ��һ��***************************************/
	private static final ResourceBundle rb = ResourceBundle.getBundle("db/db");
	
	static {
		try {
			Class.forName(rb.getString("driver")); // 1��ע������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/***********************************���µľ�̬�����;�̬����鶼�������ʱִ�У���ִֻ��һ��***************************************/
	
	/**
	 * ��ȡ���ݿ����Ӷ���ķ���
	 * @return �µ����Ӷ���
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		return conn;
	}
	
	/**
	 * �ر���Դ�ķ���
	 * 	ΪʲôдStatement��������PreparedStatement����ΪStatement��PreparedStatement�ĸ��࣬
	 * дStatement����Ҳ����ͨ����̬��PreparedStatement������������
	 * 
	 * ע��ر�˳������ResultSet��Ȼ��Statement/PreparedStatement����Connection������
	 * 
	 * @param rs ResultSet��ѯ���������
	 * @param s Statement���ݿ��������
	 * @param conn Connection���Ӷ���
	 */
	public static void closeAll(ResultSet rs, Statement s, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(s != null) {
			try {
				s.close();
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

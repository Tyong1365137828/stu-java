package edu.hebeu.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.StudentDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public Student findIdByPassword(String id, String password) {
		
		Student student = null;
		
		Connection connection = null;
		
		Statement statement = null;
		
		ResultSet resultSet = null;
		
		try {
			// 1����ȡconnection
			connection = new GetConn().getConnection();
			System.out.println("fdbsvf");

			// 2���õ�statement(�������)
			statement = connection.createStatement();
		
			String sql = "select * from student where id='"+id+"' and password='"+password+"'";
			
			// 3�������������ý��
			resultSet = statement.executeQuery(sql);
			
			// 4��������
			if(resultSet.next()) {//�����Ϊ��
				
				String id2 = resultSet.getString(1);
				String password2 = resultSet.getString(2);
				
				student = new Student(id2, password2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {// 5���ر���Դ
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 6������
		return student;
	}
	
}

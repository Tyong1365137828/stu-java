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
			// 1、获取connection
			connection = new GetConn().getConnection();
			System.out.println("fdbsvf");

			// 2、得到statement(命令发送器)
			statement = connection.createStatement();
		
			String sql = "select * from student where id='"+id+"' and password='"+password+"'";
			
			// 3、发生命令，并获得结果
			resultSet = statement.executeQuery(sql);
			
			// 4、处理结果
			if(resultSet.next()) {//如果不为空
				
				String id2 = resultSet.getString(1);
				String password2 = resultSet.getString(2);
				
				student = new Student(id2, password2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {// 5、关闭资源
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 6、返回
		return student;
	}
	
}

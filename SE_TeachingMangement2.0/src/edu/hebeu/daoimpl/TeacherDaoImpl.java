package edu.hebeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.TeacherDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Teacher;

public class TeacherDaoImpl implements TeacherDao {

	private Connection connection;

	public TeacherDaoImpl() {
		connection = new GetConn().getConnection();
	}

	@Override
	public Teacher FindTeacherByIdAndPassword(Teacher teacher) {// ��ɺ����û���ѯ������¼
		PreparedStatement preparedStatement = null;
		Teacher teacher2 = null;

		String sql = "select tea_id,tea_password from teacher where tea_id=? and tea_password=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, teacher.getTea_id());
			preparedStatement.setString(2, teacher.getTea_password());

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				teacher2 = new Teacher();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teacher2;
	}
	
	
	@Override//���˺Ų��ҽ�ʦȫ����Ϣ
	public ResultSet SelectTea(String id) {
		ResultSet resultSet = null;
		
		String sql ="select * from teacher where tea_id='"+id+"'";
		try {
			Statement statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}
	

	@Override
	public int registerTeacher(Teacher teacher) {// ��ʦ���ע����
		int count = 0;

		try {
			String sql = "insert into teacher (tea_id,tea_password) value (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getTea_id());
			preparedStatement.setString(2, teacher.getTea_password());
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ע��ɹ�");
		return count;
	}
	
	@Override//���˺Ų�ѯ�Լ��Ľ���
	public ResultSet FindAwardByNum(String id) {
		ResultSet resultSet = null;
		
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from teaaward where teaid ='" + id + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}

	@Override // �һ�����
	public void FindPasswordByNamAndAccount(Teacher teacher) {

		try {
			Statement statement = connection.createStatement();

			String sql = "update teacher set tea_password = '" + teacher.getTea_password() + "'" + " where tea_name = '"
					+ teacher.getTea_name() + "'" + " and tea_id = '" + teacher.getTea_id() + "'" + "and tea_idcard = '"
					+ teacher.getTea_idcard() + "'";

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("idcard=" + teacher.getTea_idcard());
	}

	@Override//������Ϣ
	public void perfectinformation(Teacher teacher) {

		String sql = "update teacher set tea_name='" + teacher.getTea_name() + "'" + ",tea_gender='"
				+ teacher.getTea_gender() + "'" + ",tea_tel='" + teacher.getTea_tel() + "'" + ",tea_idcard='"
				+ teacher.getTea_idcard() + "'" + ",tea_age='" + teacher.getTea_age() + "'" + "where tea_id='" 
				+ teacher.getTea_id() + "'";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override // ��ʦ�޸�����
	public void UpdateTea(String id, String repassword) {

		try {
			String sql = "update teacher set tea_password ='" + repassword + "' where tea_id='" + id + "'";
			
			Statement statement = connection.createStatement();
			
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

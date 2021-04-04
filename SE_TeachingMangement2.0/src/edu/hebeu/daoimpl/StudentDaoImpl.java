package edu.hebeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.StudentDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Student;

/**
 * @author ����
 *
 *         2019��12��13��
 */
public class StudentDaoImpl implements StudentDao {
	private Connection connection;// ����java.sql.Connection�Ķ���

	ResultSet resultSet;

	public StudentDaoImpl() {
		connection = new GetConn().getConnection();
	}

	@Override // ��ѯ�Ϸ��û�,����¼
	public Student FindStudentBynumberAndPassword(Student student) {
		PreparedStatement preparedStatement = null;
		Student student2 = null;

		String sql = "select stu_number,stu_password from student where stu_number=? and stu_password=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, student.getStu_number());
			preparedStatement.setString(2, student.getStu_password());

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				student2 = new Student();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return student2;
	}

	@Override//���˺Ų�ѯ�Լ���ȫ����Ϣ
	public ResultSet FindAllStudentByNumber(String number) {
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from student where stu_number ='" + number + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override//ѧ��������Ϣ
	public void perfectinformation(Student student) {
//		Student student2 = new Student();
		String sql = "update student set stu_gender='" + student.getStu_gender() + "'" + ",stu_name='"
				+ student.getStu_name() + "'" + ",stu_address='" + student.getStu_address() + "'" + ",stu_tel='"
				+ student.getStu_tel() + "'" + ",stu_idcard='"+ student.getStu_idcard() + "'" + ",stu_age='"
				+ student.getStu_age() + "'" + " where stu_number = ?";
		System.out.println("stu_name=" + student.getStu_name());
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getStu_number());
			preparedStatement.executeUpdate();
			System.out.println("Stu_gender" + student.getStu_gender());
			System.out.println("Stu_tel" + student.getStu_tel());
			System.out.println("number=" + student.getStu_number());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override//��ѯ�Լ��Ľ���
	public ResultSet FindAwardByNum(String id) {
		
		ResultSet resultSet = null;
		
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from stuaward where stuid ='" + id + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
		
	}
	
	@Override // ���ע���û���
	public int registerStudent(Student student) {
		int count = 0;
		try {
			String sql = "insert into student (stu_number,stu_password) value (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getStu_number());
			preparedStatement.setString(2, student.getStu_password());
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ע��ɹ�");
		return count;
	}

	@Override // �һ�����
	public void FindPasswordByNamAndAccount(Student student) {

		try {
			Statement statement = connection.createStatement();

			String sql = "update student set stu_password = '" + student.getStu_password() + "'" + " where stu_name = '"
					+ student.getStu_name() + "'" + " and stu_number = '" + student.getStu_number() + "'"
					+ "and stu_idcard = '" + student.getStu_idcard() + "'";

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("����");
		System.out.println("name" + student.getStu_name());

	}

	@Override // ����޸�������
	public void UpdateStu(String id, String repassword) {

		try {
			String sql = "update student set stu_password='" + repassword + "'where stu_number='" + id + "'";

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
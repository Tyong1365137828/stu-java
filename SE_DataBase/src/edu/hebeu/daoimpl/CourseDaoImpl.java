package edu.hebeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.CourseDao;
import edu.hebeu.jdbc.GetConn;

public class CourseDaoImpl implements CourseDao {

	private Connection connection;// 生成java.sql.Connection的对象

	public CourseDaoImpl() {
		connection = new GetConn().getConnection();// 连接数据库
	}

	@Override
	public void InsertCou(String number, String coures) {

		try {
			String sql = "insert into stu_id_cou_key (stu_id,stu_cou,stu_credit) value (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, number);
			preparedStatement.setString(2, coures);
			preparedStatement.setString(3, "0");

			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet SelectCou() {
		ResultSet resultSet = null;

		String sql = "select * from courseinfromation;";

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
	public ResultSet FindCreditBynumber(String number) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();

			String sql = "select * from stu_id_cou_key where stu_id = '" + number + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public ResultSet FindCouInformation(String coures) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();

			String sql = "select * from courseinfromation where couin_name = '" + coures + "'";

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	@Override
	public void DeleteCou(String cou, String number) {
		try {
			String sql = "delete from stu_id_cou_key where stu_cou='" + cou + "'" + "and stu_id = '" + number + "'";

			Statement statement = connection.createStatement();

			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

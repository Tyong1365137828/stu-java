package edu.hebeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.CourseDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Department;
import edu.hebeu.po.StuAndCou;

public class CourseDaoImpl implements CourseDao {

	private Connection connection;// 生成java.sql.Connection的对象

	public CourseDaoImpl() {
		connection = new GetConn().getConnection();// 连接数据库
	}

	@Override
	public ResultSet FindStuCouBynumber(String number) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from stu_cou where stu_id='" + number + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	
	@Override//	//由学生学号和教师id录入学分
	public void addCredit(String stuId, String teaId, String credit) {
		
		try {
			Statement statement = connection.createStatement();

			String sql = "update credit set credit ='"+credit+"'"
					+"where stu_id='"+stuId+"' and tea_id ='"+teaId+"'";
			
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public ResultSet FindInformationByCou(StuAndCou stuAndCou) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from courseinfromation where couin_name = '" + stuAndCou.getCou1() + "'"
					+ "or couin_name = '" + stuAndCou.getCou2() + "'" + "or'" + "or couin_name = ''"
					+ stuAndCou.getCou3() + "'" + "or couin_name = '" + stuAndCou.getCou4() + "'" + "or couin_name = '"
					+ stuAndCou.getCou5() + "'" + "or couin_name = '" + stuAndCou.getCou6() + "'";

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}

	@Override
	public ResultSet FindCouInformation(String coures, String teaId) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();

			String sql = "select * from courseinfromation where couin_name = '" + coures + "'" + "and couin_tea='"
					+ teaId + "'";

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public ResultSet FindCouInformationByTea(String teaId) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();

			String sql = "select * from courseinfromation where couin_tea='" + teaId + "'";

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	
	
	@Override//由教师账号查询所选此课的学生
	public ResultSet FindCreditByTeanumber(String number) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();

			String sql = "select * from credit where tea_id = '" + number + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	

	@Override//通过学生账号查询所有选修课与所得学分
	public ResultSet FindCreditBynumber(String number) {

		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();

			String sql = "select * from credit where stu_id = '" + number + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override//由学生账号添加课程
	public void InsertCou(String number, String coures, String teaId) {

		try {
			String sql = "insert into credit (stu_id,cou,credit,tea_id) value (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, number);
			preparedStatement.setString(2, coures);
			preparedStatement.setString(3, "0");
			preparedStatement.setString(4, teaId);

			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override	//由学生的账号和课程名删除课程
	public void DeleteCou(String cou, String number) {
		try {
			String sql = "delete from credit where cou='" + cou + "'" + "and stu_id = '" + number + "'";

			Statement statement = connection.createStatement();

			statement.execute(sql);
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
	public String TeaByCou(String couid) {

		String teacher = "";

		try {
			String sql = "select * from teacher where tea_cou='" + couid + "'";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				teacher = resultSet.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teacher;
	}

	@Override // 完成用系号查找系类
	public String FindDepNam(Department department) {
		String depnam="";
		try {
			String sql = "select dep_name from department where dep_num ='" + department.getDepnum() +"'";
			Statement statement=connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				depnam = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return depnam;
}

}

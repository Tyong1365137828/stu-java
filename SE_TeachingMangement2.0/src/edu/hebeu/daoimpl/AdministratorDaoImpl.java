package edu.hebeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import edu.hebeu.dao.AdministratorDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Administrator;
import edu.hebeu.po.CouInformination;
import edu.hebeu.po.Teacher;

/**
 * @author 汤勇
 *
 *         2019年12月13日
 */

public class AdministratorDaoImpl implements AdministratorDao {

	private Connection connection;// 生成java.sql.Connection的对象

	public AdministratorDaoImpl() {
		connection = new GetConn().getConnection();// 连接数据库
	}

	@Override // 查询合法用户实现方法,即登录 /*这个是将entry中得到的用来做参数*/
	public Administrator FindadministratorByAccountAndPassword(Administrator administrator) {

		PreparedStatement preparedStatement = null;
		Administrator administrator2 = null;// 将Administrator生成对象administrator2并置空,以盛放

		String sql = "select * from administrator where adm_account=? and adm_password=?;";

		try {
			System.out.println("qwertfdsaSD");
			preparedStatement = connection.prepareStatement(sql);// 执行sql语句

			preparedStatement.setString(1, administrator.getAdm_account());// 第一个?的值即为从entry得到的参数以po的方法所得的Adm_number
			preparedStatement.setString(2, administrator.getAdm_password());// 第二个?的值即为从entry得到的参数以po的方法所得的Adm_password

			ResultSet resultSet = preparedStatement.executeQuery();// 将sql执行的结果放在resultset中
			while (resultSet.next()) {// 将resultset结果放入administrator2中
				administrator2 = new Administrator();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return administrator2;// 返回administrator2的值
	}

	@Override // 找回密码
	public void FindPasswordByNamAndAccount(Administrator administrator) {
		try {
			Statement statement = connection.createStatement();

			String sql = "update administrator set adm_password = '" + administrator.getAdm_password() + "'"
					+ " where adm_name = '" + administrator.getAdm_name() + "'" + " and adm_account = '"
					+ administrator.getAdm_account() + "'" + "and adm_idcard = '" + administrator.getAdm_idcard() + "'";

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override // 完成修改密码类
	public void UpdateAdm(String id, String repassword) {
		try {
			String sql = "update administrator set adm_password='" + repassword + "'where adm_account='" + id + "'";

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 
	 * 教师
	 * 
	 */

	@Override // 查询全部教师
	public ResultSet SelectAllTea() {
		ResultSet resultSet = null;
		String sql = "select * from teacher";

		try {
			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 按教师名字模糊查教师
	public ResultSet SelectTeaByNam(String name) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from teacher  where tea_name like '%" + name + "%'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 按教师id号模糊查教师
	public ResultSet SelectTeaByNum(String number) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from teacher  where tea_id like '%" + number + "%'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 完成用教师id精确查找教师
	public ResultSet JSelectTeaByNum(String number) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from teacher  where tea_id ='" + number + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 由姓名精确查询教师
	public ResultSet JSelectTeaByNam(String name) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from teacher  where tea_name= '" + name + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 教师注册
	public int InsertTeacher(Teacher teacher) {
		int count = 0;
		String sql = "insert into teacher value(?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getTea_id());
			preparedStatement.setString(3, teacher.getTea_password());
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override // 添加教师
	public void AddTea(String teaId, String teaPass, String teaDep) {
		try {
			String sql = "insert into teacher (tea_id,tea_password,tea_depnum) value (?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teaId);
			preparedStatement.setString(2, teaPass);
			preparedStatement.setString(3, teaDep);

			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override//修改教师重要信息
	public void AlterTeaByteaId(String depNum, String password, String id) {
		
		try {
			String sql = "update teacher set tea_password ='" + password + "',tea_depnum ='" + depNum + "'"
					+ "where tea_id = '" + id + "'";

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override // 奖励教师
	public void AddAwardForTea(String teaId, String award) {

		try {
			String sql = "insert into teaaward (teaid,award,date) value (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			Date date = new Date();

			preparedStatement.setString(1, teaId);
			preparedStatement.setString(2, award);
			preparedStatement.setString(3, date.toString());

			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 
	 * 学生
	 * 
	 */

	@Override // 删除学生
	public void DeleteStu(String stuId) {

		try {
			String sql1 = "delete from student where stu_number = '" + stuId + "'";
			String sql2 = "delete from credit where stu_id = '" + stuId + "'";

			Statement statement1 = connection.createStatement();
			statement1.execute(sql1);
			Statement statement2 = connection.createStatement();
			statement2.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override // 查询全部学生
	public ResultSet SelectAllStu() {
		ResultSet resultSet = null;
		String sql = "select * from student";

		try {
			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 按名模糊查找学生
	public ResultSet SelectStudentByNam(String name) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from student  where stu_name like '%" + name + "%'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 按号模糊查找学生
	public ResultSet SelectStudentByNum(String number) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from student  where stu_number like '%" + number + "%'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 由名字精确查找学生
	public ResultSet JSelectStudentByNam(String name) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from student  where stu_name='" + name + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 由id精确查找学生
	public ResultSet JSelectStudentByNum(String number) {
		ResultSet resultSet = null;

		try {
			Statement statement = connection.createStatement();
			String sql = "select * from student  where stu_number= '" + number + "'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 添加学生
	public void AddStu(String stuId, String stuPass, String stuDep) {

		try {
			String sql = "insert into student (stu_number,stu_password,stu_depnum) value (?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, stuId);
			preparedStatement.setString(2, stuPass);
			preparedStatement.setString(3, stuDep);

			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override // 修改学生重要信息
	public void AlterStuBystuId(String depNum, String password, String id) {

		try {
			String sql = "update student set stu_password ='" + password + "',stu_depnum ='" + depNum + "'"
					+ "where stu_number = '" + id + "'";

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override // 奖励学生
	public void AddAwardForStu(String stuId, String award) {

		try {
			String sql = "insert into stuaward (stuid,award,date) value (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			Date date = new Date();

			preparedStatement.setString(1, stuId);
			preparedStatement.setString(2, award);
			preparedStatement.setString(3, date.toString());

			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 
	 * 课程
	 * 
	 */

	@Override
	public void DeleteTea(String teaId) {
		try {
			String sql1 = "delete from teacher where stu_id = '" + teaId + "'";
			String sql2 = "delete from courseinfromation where couin_tea = '" + teaId + "'";

			Statement statement1 = connection.createStatement();
			statement1.execute(sql1);
			Statement statement2 = connection.createStatement();
			statement2.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override // 查询全部课程
	public ResultSet SelectAllCou() {
		ResultSet resultSet = null;
		String sql = "select * from courseinfromation";

		try {
			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 由教师id模糊查询课程
	public ResultSet SelectCouByTeaNum(String number) {
		ResultSet resultSet = null;
		String sql = "select * from courseinfromation where couin_tea like '%" + number + "%'";

		try {
			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 由教师id精确查询课程
	public ResultSet JSelectCouByTeaNum(String number) {
		ResultSet resultSet = null;
		String sql = "select * from courseinfromation where couin_tea ='" + number + "'";

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
	public ResultSet SelectByCou(String cou) {
		ResultSet resultSet = null;
		String sql = "select * from courseinfromation where couin_name ='" + cou + "'";

		try {
			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override // 查看是否存在此课
	public ResultSet selectCou(String teaId) {

		ResultSet resultSet = null;
		try {
			String sql = "select * from courseinfromation where couin_tea = '" + teaId + "'";

			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}

	@Override // 添加课程
	public void addCou(CouInformination couInformination) {

		String sql = "insert into courseinfromation (couin_number,couin_name,couin_period,couin_place,couin_test,couin_tea) value(?,?,?,?,?,?);";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, couInformination.getCouid());
			preparedStatement.setString(2, couInformination.getCoures());
			preparedStatement.setString(3, couInformination.getPeriod());
			preparedStatement.setString(4, couInformination.getPlace());
			preparedStatement.setString(5, couInformination.getTest());
			preparedStatement.setString(6, couInformination.getTea_id());

			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override // 删除课程
	public void deleteCou(String teaId) {

		String sql = "delete from courseinfromation where couin_tea='" + teaId + "'";
		String sql2 = "delete from credit where tea_id='" + teaId + "'";

		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);

			Statement statement2 = connection.createStatement();
			statement2.execute(sql2);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

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
 * @author ����
 *
 *         2019��12��13��
 */

public class AdministratorDaoImpl implements AdministratorDao {

	private Connection connection;// ����java.sql.Connection�Ķ���

	public AdministratorDaoImpl() {
		connection = new GetConn().getConnection();// �������ݿ�
	}

	@Override // ��ѯ�Ϸ��û�ʵ�ַ���,����¼ /*����ǽ�entry�еõ�������������*/
	public Administrator FindadministratorByAccountAndPassword(Administrator administrator) {

		PreparedStatement preparedStatement = null;
		Administrator administrator2 = null;// ��Administrator���ɶ���administrator2���ÿ�,��ʢ��

		String sql = "select * from administrator where adm_account=? and adm_password=?;";

		try {
			System.out.println("qwertfdsaSD");
			preparedStatement = connection.prepareStatement(sql);// ִ��sql���

			preparedStatement.setString(1, administrator.getAdm_account());// ��һ��?��ֵ��Ϊ��entry�õ��Ĳ�����po�ķ������õ�Adm_number
			preparedStatement.setString(2, administrator.getAdm_password());// �ڶ���?��ֵ��Ϊ��entry�õ��Ĳ�����po�ķ������õ�Adm_password

			ResultSet resultSet = preparedStatement.executeQuery();// ��sqlִ�еĽ������resultset��
			while (resultSet.next()) {// ��resultset�������administrator2��
				administrator2 = new Administrator();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return administrator2;// ����administrator2��ֵ
	}

	@Override // �һ�����
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

	@Override // ����޸�������
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
	 * ��ʦ
	 * 
	 */

	@Override // ��ѯȫ����ʦ
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

	@Override // ����ʦ����ģ�����ʦ
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

	@Override // ����ʦid��ģ�����ʦ
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

	@Override // ����ý�ʦid��ȷ���ҽ�ʦ
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

	@Override // ��������ȷ��ѯ��ʦ
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

	@Override // ��ʦע��
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

	@Override // ��ӽ�ʦ
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
	
	@Override//�޸Ľ�ʦ��Ҫ��Ϣ
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

	@Override // ������ʦ
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
	 * ѧ��
	 * 
	 */

	@Override // ɾ��ѧ��
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

	@Override // ��ѯȫ��ѧ��
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

	@Override // ����ģ������ѧ��
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

	@Override // ����ģ������ѧ��
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

	@Override // �����־�ȷ����ѧ��
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

	@Override // ��id��ȷ����ѧ��
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

	@Override // ���ѧ��
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

	@Override // �޸�ѧ����Ҫ��Ϣ
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

	@Override // ����ѧ��
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
	 * �γ�
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

	@Override // ��ѯȫ���γ�
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

	@Override // �ɽ�ʦidģ����ѯ�γ�
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

	@Override // �ɽ�ʦid��ȷ��ѯ�γ�
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

	@Override // �鿴�Ƿ���ڴ˿�
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

	@Override // ��ӿγ�
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

	@Override // ɾ���γ�
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

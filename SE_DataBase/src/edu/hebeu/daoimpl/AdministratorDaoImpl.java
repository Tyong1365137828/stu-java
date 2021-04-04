package edu.hebeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.AdministratorDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Administrator;
import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Id_Key;
import edu.hebeu.po.Stu_Name_Cou_Key;

public class AdministratorDaoImpl implements AdministratorDao {
	private Connection connection;

	public AdministratorDaoImpl() {
		connection = new GetConn().getConnection();
	}

	
	@Override// 完成合法用户的查询，即登录
	public Administrator FindAdmByIdAndPassword(Administrator administrator) {

		PreparedStatement preparedStatement = null;
		Administrator administrator2 = null;
		String sql = "select adm_id,adm_password from administrator where adm_id = ? and adm_password = ? ;";

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, administrator.getAdm_id());
			preparedStatement.setString(2, administrator.getAdm_password());

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				administrator2 = new Administrator();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return administrator2;
	}

	@Override // 注册管理员完成类
	public int registerAdministrator(Administrator administrator) {

		int count = 0;
		String sql = "insert into administrator (adm_id , adm_password) value (? , ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, administrator.getAdm_id());
			preparedStatement.setString(2, administrator.getAdm_password());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override // 完成按id查找学生类
	public Stu_Id_Key FindStuById(String id) {
		Stu_Id_Key stu_Id_Key = new Stu_Id_Key();
		try {
			String sql = "select * from stu_id_key where stu_id = ?;";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				stu_Id_Key.setStu_id(resultSet.getString(1));
				stu_Id_Key.setStu_name(resultSet.getString(2));
				stu_Id_Key.setStu_depid(resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stu_Id_Key;
	}
	
	
	@Override//完成用名字查找学生类
	public Stu_Id_Key FindById(String name) {
		
		Stu_Id_Key stu_Id_Key = new Stu_Id_Key();
		
		try {
			String sql = "select * from stu_id_key where stu_name = ?;";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				stu_Id_Key.setStu_id(resultSet.getString(1));
				stu_Id_Key.setStu_name(resultSet.getString(2));
				stu_Id_Key.setStu_depid(resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stu_Id_Key;
	}

	@Override//完成用系号查找系类
	public Dep_Id_Key FindDepByDepid(String depid) {

		Dep_Id_Key dep_Id_Key = new Dep_Id_Key();

		String sql = "select * from dep_id_key where dep_id = ?;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, depid);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				dep_Id_Key.setDep_id(resultSet.getString(1));
				dep_Id_Key.setDep_name(resultSet.getString(2));
				dep_Id_Key.setDep_address(resultSet.getString(3));
				dep_Id_Key.setDep_tel(resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dep_Id_Key;
	}
	
	
	@Override//完成删除用户类
	public void DeleteStu(String id , String name) {
		
		String sql1 = "delete from stu_id_key where stu_id = ?;";
		String sql2 = "delete from stu_name_key where stu_name = ?;";
		
		PreparedStatement preparedStatement1;
		PreparedStatement preparedStatement2;
		try {
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setString(1, id);
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setString(1,name);
			preparedStatement2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override//实现查找全部用户
	public ResultSet Findstu() {
		ResultSet resultSet = null;
		try {
			String sql = "select * from stu_name_key";
			
			Statement statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	
	@Override//实现添加用户信息类
	public void AddStu(String id, String password) {
		
		String sql = "insert into stu_id_key (stu_id,stu_password) value (?,?);";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override//实现修改密码类
	public void UpDateStu(String id, String repassword) {
		try {
			Statement statement = connection.createStatement();
			String sql = "update administrator set adm_password='"+repassword+"'where adm_id = '"+id+"'";
			
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet SelectStuBycou(String cou) {
		ResultSet resultSet = null;
		
		try {
			Statement statement = connection.createStatement();
			
			String sql ="select * from stu_id_cou_key where stu_cou='"+cou+"'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	@Override
	public void AddCredit(Stu_Name_Cou_Key stu_Name_Cou_Key) {
		
		try {
			Statement statement = connection.createStatement();
			String sql = "update stu_id_cou_key set stu_credit ='"+stu_Name_Cou_Key.getStu_credit()+"'"
					+"where stu_id = '"+stu_Name_Cou_Key.getStu_id()+"'and stu_cou = '"+stu_Name_Cou_Key.getStu_cou()+"'";
			
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

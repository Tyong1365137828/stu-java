package edu.hebeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hebeu.dao.StudentDao;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Id_Key;
import edu.hebeu.po.Stu_Name_Key;

public class StudentDaoImpl implements StudentDao {
	private Connection connection;

	public StudentDaoImpl() {
		connection = new GetConn().getConnection();
	}

	// 完成合法用户查询，即登录
	@Override
	public Stu_Id_Key FindStudentByIdAndPassword(Stu_Id_Key stu_Id_Key) {

		PreparedStatement preparedStatement = null;
		Stu_Id_Key stu_Id_Key2 = null;
		String sql = "select stu_id,stu_password from stu_id_key where stu_id=? and stu_password=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, stu_Id_Key.getStu_id());
			preparedStatement.setString(2, stu_Id_Key.getStu_password());

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				stu_Id_Key2 = new Stu_Id_Key();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu_Id_Key2;
	}

	@Override // 注册学生完成类
	public int registrStudent(Stu_Id_Key stu_Id_Key) {

		int count = 0;
		String sql = "insert into stu_id_key (stu_id,stu_password) value (?,?);";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, stu_Id_Key.getStu_id());
			preparedStatement.setString(2, stu_Id_Key.getStu_password());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override // 完成按名字查找学分类
	public ResultSet FindCreditByName(String id) {
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from stu_id_cou_key where stu_id ='"+id+"'";
			
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override//完成用id查找学生类
	public ResultSet FindStuById(String id) {
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from stu_id_key where stu_id = '"+id+"'";
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("asd ");
		return resultSet;
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
	
	
	@Override//用于完成按姓名查找学生信息类
	public Stu_Name_Key FindStuByName(String name) {
		
		Stu_Name_Key stu_Name_Key = new Stu_Name_Key();
		
		String sql ="select * from stu_name_key where stu_name = ?;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				stu_Name_Key.setStu_name(resultSet.getString(1));
				stu_Name_Key.setStu_tel(resultSet.getString(2));
				stu_Name_Key.setStu_address(resultSet.getString(3));
				stu_Name_Key.setStu_age(resultSet.getString(4));
				stu_Name_Key.setStu_sex(resultSet.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu_Name_Key;
	}
	
	
	@Override
	public void UpDateStu(String id, String repassword) {
		String sql ="update stu_id_key set stu_password = '"+repassword+"'where stu_id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override//完成用户修改信息类
	public void perfectinformation(Stu_Name_Key stu_Name_Key) {
		
		String sql ="insert into stu_name_key (stu_name,stu_address,stu_tel,stu_age,stu_sex) value (?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, stu_Name_Key.getStu_name());
			preparedStatement.setString(2, stu_Name_Key.getStu_address());
			preparedStatement.setString(3, stu_Name_Key.getStu_tel());
			preparedStatement.setString(4, stu_Name_Key.getStu_age());
			preparedStatement.setString(5, stu_Name_Key.getStu_sex());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public void perfectinformation(Stu_Id_Key stu_Id_Key) {//完成修改
		
		String sql ="update stu_id_key set stu_name='"+stu_Id_Key.getStu_name()+"'"
					+",stu_depid='"+stu_Id_Key.getStu_depid()+"'"
					+" where stu_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, stu_Id_Key.getStu_id());
			System.out.println("id="+stu_Id_Key.getStu_id());
			System.out.println("name="+stu_Id_Key.getStu_name());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void DeleteStu(String name) {
		
		String sql ="delete from stu_name_key where stu_name = ?;";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

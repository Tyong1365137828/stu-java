package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Administrator;
import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Id_Key;
import edu.hebeu.po.Stu_Name_Cou_Key;

public interface AdministratorDao {
	//查询合法用户，即登录
	public Administrator FindAdmByIdAndPassword(Administrator administrator);
	
	//注册管理员
	public int registerAdministrator(Administrator administrator);
	
	//按id查找，以删除此用户的以id为主键的表的信息
	public Stu_Id_Key FindStuById(String id);
	
	//按名字查找，以删除此用户的以name为主键的表的信息
	public Stu_Id_Key FindById(String name);
	
	//按系id查找系
	public Dep_Id_Key FindDepByDepid(String depid);
	
	//删除用户
	public void DeleteStu(String id , String name);
	
	//显示全部用户
	public ResultSet Findstu();
	
	//添加学生
	public void AddStu(String id,String password);
	
	//修改密码
	public void UpDateStu(String id, String repassword);
	
	//由课程号查询选修此课的学生
	public ResultSet SelectStuBycou(String cou);
	
	//通过学生的学号和课程号录入学分
	public void AddCredit(Stu_Name_Cou_Key stu_Name_Cou_Key);
}

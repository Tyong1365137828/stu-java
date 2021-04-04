package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Id_Key;
import edu.hebeu.po.Stu_Name_Key;

public interface StudentDao {
	//查询合法用户,即登录
	public Stu_Id_Key FindStudentByIdAndPassword(Stu_Id_Key stu_Id_Key);
	
	//注册用户
	public int registrStudent(Stu_Id_Key stu_Id_Key);
	
	//查询本人的学分
	public ResultSet FindCreditByName(String id);
	
	//按学号查找
	public ResultSet FindStuById(String id);
	
	//用系号查找系
	public Dep_Id_Key FindDepByDepid(String depid);
	
	//用姓名查找信息
	public Stu_Name_Key FindStuByName(String name);
	
	//修改密码
	public void UpDateStu(String id,String repassword);
	
	//完善信息
	public void perfectinformation (Stu_Name_Key stu_Name_Key);
	
	//通过id完善名字，系号
	public void perfectinformation (Stu_Id_Key stu_Id_Key);
	
	//删除以name为主键的表的信息
	public void DeleteStu(String name);
	
}
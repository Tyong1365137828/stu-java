package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Teacher;

public interface TeacherDao {
	
	//查询合法用户
	public Teacher FindTeacherByIdAndPassword(Teacher teacher);
	
	//注册教师
	public int registerTeacher(Teacher teacher);
	
	//找回密码
	public void FindPasswordByNamAndAccount(Teacher teacher);
	
	//完善教师个人信息
	public void perfectinformation(Teacher teacher);
	
	//修改密码
	public void UpdateTea(String id , String repassword);
	
	//由教师id查询教师信息
	public ResultSet SelectTea(String id);
	
	//由账号查询自己的奖励
	public ResultSet FindAwardByNum(String id);
		
	
}

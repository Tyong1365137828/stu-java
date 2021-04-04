package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Student;

public interface StudentDao {
	//查询合法用户
	public Student FindStudentBynumberAndPassword(Student student);
	
	//由账号查询用户信息
	public ResultSet FindAllStudentByNumber(String number);
	
	
	//完善修改信息
	public void perfectinformation(Student student);
	
	//注册用户
	public int registerStudent(Student student);
	
	//由账号查询自己的奖励
	public ResultSet FindAwardByNum(String id);
	
	//找回密码
	public void FindPasswordByNamAndAccount(Student student);
	
	//修改密码
	public void UpdateStu(String id , String repassword);
	
	
}

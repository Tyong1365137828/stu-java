package edu.hebeu.dao;

import java.sql.ResultSet;

public interface CourseDao {

	//由账号添加学生
	public void InsertCou (String number,String coures);
	
	//查询全部课程
	public ResultSet SelectCou();
	
	//通过账号查询所有选修课与所得学分
	public ResultSet FindCreditBynumber(String number);
	
	//通过课程查找课程信息
	public ResultSet FindCouInformation (String coures);	
	
	//由学生的账号和课程名删除课程
	public void DeleteCou(String cou,String number);
	
	
	
	
}

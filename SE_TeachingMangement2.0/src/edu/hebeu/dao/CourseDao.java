package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Department;
import edu.hebeu.po.StuAndCou;

public interface CourseDao {
	
	//由学生学号和教师id录入学分
	public void addCredit (String stuId,String teaId,String credit);
	
	//通过学号查找学生的课程
	public ResultSet FindStuCouBynumber(String number);
	
	//通过课程和教师id查找课程信息
	public ResultSet FindCouInformation (String coures,String teaId);
	
	//由教师id查询课程
	public ResultSet FindCouInformationByTea (String teaId);
	
	//由教师账号查询所选此课的学生
	public ResultSet FindCreditByTeanumber(String number);
	
	//通过课程号查找课程信息
	public ResultSet FindInformationByCou(StuAndCou stuAndCou);
	
	//通过学生账号查询所有选修课与所得学分
	public ResultSet FindCreditBynumber(String number);
	
	//由学生账号添加课程
	public void InsertCou (String number,String coures,String teaId);
	
	//由学生的账号和课程名删除课程
	public void DeleteCou(String cou,String number);
	
	//查询所有课程
	public ResultSet SelectCou();
	
	//用课程号查询教师
	public String TeaByCou(String couid);
	
	//由系号查找系
	public String FindDepNam(Department department);
	
	
}

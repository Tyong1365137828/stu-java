package edu.hebeu.dao;

import java.sql.ResultSet;
import edu.hebeu.po.Administrator;
import edu.hebeu.po.CouInformination;
import edu.hebeu.po.Teacher;

public interface AdministratorDao {
	// 查询合法用户
	public Administrator FindadministratorByAccountAndPassword(Administrator administrator);
	
	
	/*
	 * 
	 * 
	 * */
	
	// 注册教师
	public int InsertTeacher(Teacher teacher);
	
	//添加教师
	public void AddTea(String teaId, String teaPass,String teaDep);

	// 删除教师
	public void DeleteTea(String teaId);
	
	//修改教师重要信息
	public void AlterTeaByteaId(String depNum,String password,String id);

	// 查询全部教师
	public ResultSet SelectAllTea();
	
	// 按名字模糊查询教师
	public ResultSet SelectTeaByNam(String name);

	// 按id模糊查找教师
	public ResultSet SelectTeaByNum(String number);

	// 按id精确查询教师
	public ResultSet JSelectTeaByNum(String number);
	
	// 按姓名精确查询教师
	public ResultSet JSelectTeaByNam(String name);
	
	//奖励学生
	public void AddAwardForTea(String teaId,String award);
		
	
	/*
	 * 
	 * 
	 * */

	// 添加学生
	public void AddStu(String stuId, String stuPass,String stuDep);
	
	// 删除学生
	public void DeleteStu(String stuId);

	// 查询全部学生
	public ResultSet SelectAllStu();
	
	//修改学生重要信息
	public void AlterStuBystuId(String depNum,String password,String id);

	// 按名字模糊查询学生
	public ResultSet SelectStudentByNam(String name);

	// 按账号模糊查找学生
	public ResultSet SelectStudentByNum(String number);

	// 按名字精确查询学生
	public ResultSet JSelectStudentByNam(String name);

	// 按账号精确查找学生
	public ResultSet JSelectStudentByNum(String number);
	
	//奖励学生
	public void AddAwardForStu(String stuId,String award);
	
	/*
	 * 
	 * 
	 * */

	// 按教师id模糊查找课程
	public ResultSet SelectCouByTeaNum(String number);

	// 按教师id精确查找课程
	public ResultSet JSelectCouByTeaNum(String number);

	// 查询全部课程
	public ResultSet SelectAllCou();
	
	//由课程名查询课程信息
	public ResultSet SelectByCou(String cou);
	
	//添加课程
	public void addCou(CouInformination couInformination);
	
	//删除课程
	public void deleteCou(String teaId);
	
	//由教师id和课程号查看是否存在此课
	public ResultSet selectCou(String teaId);
	
	/*
	 * 
	 * 
	 * */

	// 找回密码
	public void FindPasswordByNamAndAccount(Administrator administrator);

	// 管理员修改密码
	public void UpdateAdm(String id, String repassword);

}

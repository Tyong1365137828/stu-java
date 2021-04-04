package edu.hebeu.dao;
/*
 * 学生操作
 * 
 * */

import edu.hebeu.po.Student;

public interface StudentDao {
	//由id和密码查询合法身份，实现登录验证功能
	public Student findIdByPassword(String id,String password);
}
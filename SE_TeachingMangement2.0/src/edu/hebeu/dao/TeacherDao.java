package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Teacher;

public interface TeacherDao {
	
	//��ѯ�Ϸ��û�
	public Teacher FindTeacherByIdAndPassword(Teacher teacher);
	
	//ע���ʦ
	public int registerTeacher(Teacher teacher);
	
	//�һ�����
	public void FindPasswordByNamAndAccount(Teacher teacher);
	
	//���ƽ�ʦ������Ϣ
	public void perfectinformation(Teacher teacher);
	
	//�޸�����
	public void UpdateTea(String id , String repassword);
	
	//�ɽ�ʦid��ѯ��ʦ��Ϣ
	public ResultSet SelectTea(String id);
	
	//���˺Ų�ѯ�Լ��Ľ���
	public ResultSet FindAwardByNum(String id);
		
	
}

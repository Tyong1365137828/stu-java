package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Student;

public interface StudentDao {
	//��ѯ�Ϸ��û�
	public Student FindStudentBynumberAndPassword(Student student);
	
	//���˺Ų�ѯ�û���Ϣ
	public ResultSet FindAllStudentByNumber(String number);
	
	
	//�����޸���Ϣ
	public void perfectinformation(Student student);
	
	//ע���û�
	public int registerStudent(Student student);
	
	//���˺Ų�ѯ�Լ��Ľ���
	public ResultSet FindAwardByNum(String id);
	
	//�һ�����
	public void FindPasswordByNamAndAccount(Student student);
	
	//�޸�����
	public void UpdateStu(String id , String repassword);
	
	
}

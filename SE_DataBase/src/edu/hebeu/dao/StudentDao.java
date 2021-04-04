package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Id_Key;
import edu.hebeu.po.Stu_Name_Key;

public interface StudentDao {
	//��ѯ�Ϸ��û�,����¼
	public Stu_Id_Key FindStudentByIdAndPassword(Stu_Id_Key stu_Id_Key);
	
	//ע���û�
	public int registrStudent(Stu_Id_Key stu_Id_Key);
	
	//��ѯ���˵�ѧ��
	public ResultSet FindCreditByName(String id);
	
	//��ѧ�Ų���
	public ResultSet FindStuById(String id);
	
	//��ϵ�Ų���ϵ
	public Dep_Id_Key FindDepByDepid(String depid);
	
	//������������Ϣ
	public Stu_Name_Key FindStuByName(String name);
	
	//�޸�����
	public void UpDateStu(String id,String repassword);
	
	//������Ϣ
	public void perfectinformation (Stu_Name_Key stu_Name_Key);
	
	//ͨ��id�������֣�ϵ��
	public void perfectinformation (Stu_Id_Key stu_Id_Key);
	
	//ɾ����nameΪ�����ı����Ϣ
	public void DeleteStu(String name);
	
}
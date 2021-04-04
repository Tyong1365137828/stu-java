package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Administrator;
import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Id_Key;
import edu.hebeu.po.Stu_Name_Cou_Key;

public interface AdministratorDao {
	//��ѯ�Ϸ��û�������¼
	public Administrator FindAdmByIdAndPassword(Administrator administrator);
	
	//ע�����Ա
	public int registerAdministrator(Administrator administrator);
	
	//��id���ң���ɾ�����û�����idΪ�����ı����Ϣ
	public Stu_Id_Key FindStuById(String id);
	
	//�����ֲ��ң���ɾ�����û�����nameΪ�����ı����Ϣ
	public Stu_Id_Key FindById(String name);
	
	//��ϵid����ϵ
	public Dep_Id_Key FindDepByDepid(String depid);
	
	//ɾ���û�
	public void DeleteStu(String id , String name);
	
	//��ʾȫ���û�
	public ResultSet Findstu();
	
	//���ѧ��
	public void AddStu(String id,String password);
	
	//�޸�����
	public void UpDateStu(String id, String repassword);
	
	//�ɿγ̺Ų�ѯѡ�޴˿ε�ѧ��
	public ResultSet SelectStuBycou(String cou);
	
	//ͨ��ѧ����ѧ�źͿγ̺�¼��ѧ��
	public void AddCredit(Stu_Name_Cou_Key stu_Name_Cou_Key);
}

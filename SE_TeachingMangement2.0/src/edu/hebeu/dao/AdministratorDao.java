package edu.hebeu.dao;

import java.sql.ResultSet;
import edu.hebeu.po.Administrator;
import edu.hebeu.po.CouInformination;
import edu.hebeu.po.Teacher;

public interface AdministratorDao {
	// ��ѯ�Ϸ��û�
	public Administrator FindadministratorByAccountAndPassword(Administrator administrator);
	
	
	/*
	 * 
	 * 
	 * */
	
	// ע���ʦ
	public int InsertTeacher(Teacher teacher);
	
	//��ӽ�ʦ
	public void AddTea(String teaId, String teaPass,String teaDep);

	// ɾ����ʦ
	public void DeleteTea(String teaId);
	
	//�޸Ľ�ʦ��Ҫ��Ϣ
	public void AlterTeaByteaId(String depNum,String password,String id);

	// ��ѯȫ����ʦ
	public ResultSet SelectAllTea();
	
	// ������ģ����ѯ��ʦ
	public ResultSet SelectTeaByNam(String name);

	// ��idģ�����ҽ�ʦ
	public ResultSet SelectTeaByNum(String number);

	// ��id��ȷ��ѯ��ʦ
	public ResultSet JSelectTeaByNum(String number);
	
	// ��������ȷ��ѯ��ʦ
	public ResultSet JSelectTeaByNam(String name);
	
	//����ѧ��
	public void AddAwardForTea(String teaId,String award);
		
	
	/*
	 * 
	 * 
	 * */

	// ���ѧ��
	public void AddStu(String stuId, String stuPass,String stuDep);
	
	// ɾ��ѧ��
	public void DeleteStu(String stuId);

	// ��ѯȫ��ѧ��
	public ResultSet SelectAllStu();
	
	//�޸�ѧ����Ҫ��Ϣ
	public void AlterStuBystuId(String depNum,String password,String id);

	// ������ģ����ѯѧ��
	public ResultSet SelectStudentByNam(String name);

	// ���˺�ģ������ѧ��
	public ResultSet SelectStudentByNum(String number);

	// �����־�ȷ��ѯѧ��
	public ResultSet JSelectStudentByNam(String name);

	// ���˺ž�ȷ����ѧ��
	public ResultSet JSelectStudentByNum(String number);
	
	//����ѧ��
	public void AddAwardForStu(String stuId,String award);
	
	/*
	 * 
	 * 
	 * */

	// ����ʦidģ�����ҿγ�
	public ResultSet SelectCouByTeaNum(String number);

	// ����ʦid��ȷ���ҿγ�
	public ResultSet JSelectCouByTeaNum(String number);

	// ��ѯȫ���γ�
	public ResultSet SelectAllCou();
	
	//�ɿγ�����ѯ�γ���Ϣ
	public ResultSet SelectByCou(String cou);
	
	//��ӿγ�
	public void addCou(CouInformination couInformination);
	
	//ɾ���γ�
	public void deleteCou(String teaId);
	
	//�ɽ�ʦid�Ϳγ̺Ų鿴�Ƿ���ڴ˿�
	public ResultSet selectCou(String teaId);
	
	/*
	 * 
	 * 
	 * */

	// �һ�����
	public void FindPasswordByNamAndAccount(Administrator administrator);

	// ����Ա�޸�����
	public void UpdateAdm(String id, String repassword);

}

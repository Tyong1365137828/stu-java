package edu.hebeu.dao;

import java.sql.ResultSet;

import edu.hebeu.po.Department;
import edu.hebeu.po.StuAndCou;

public interface CourseDao {
	
	//��ѧ��ѧ�źͽ�ʦid¼��ѧ��
	public void addCredit (String stuId,String teaId,String credit);
	
	//ͨ��ѧ�Ų���ѧ���Ŀγ�
	public ResultSet FindStuCouBynumber(String number);
	
	//ͨ���γ̺ͽ�ʦid���ҿγ���Ϣ
	public ResultSet FindCouInformation (String coures,String teaId);
	
	//�ɽ�ʦid��ѯ�γ�
	public ResultSet FindCouInformationByTea (String teaId);
	
	//�ɽ�ʦ�˺Ų�ѯ��ѡ�˿ε�ѧ��
	public ResultSet FindCreditByTeanumber(String number);
	
	//ͨ���γ̺Ų��ҿγ���Ϣ
	public ResultSet FindInformationByCou(StuAndCou stuAndCou);
	
	//ͨ��ѧ���˺Ų�ѯ����ѡ�޿�������ѧ��
	public ResultSet FindCreditBynumber(String number);
	
	//��ѧ���˺���ӿγ�
	public void InsertCou (String number,String coures,String teaId);
	
	//��ѧ�����˺źͿγ���ɾ���γ�
	public void DeleteCou(String cou,String number);
	
	//��ѯ���пγ�
	public ResultSet SelectCou();
	
	//�ÿγ̺Ų�ѯ��ʦ
	public String TeaByCou(String couid);
	
	//��ϵ�Ų���ϵ
	public String FindDepNam(Department department);
	
	
}

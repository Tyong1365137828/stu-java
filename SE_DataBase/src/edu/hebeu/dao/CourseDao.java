package edu.hebeu.dao;

import java.sql.ResultSet;

public interface CourseDao {

	//���˺����ѧ��
	public void InsertCou (String number,String coures);
	
	//��ѯȫ���γ�
	public ResultSet SelectCou();
	
	//ͨ���˺Ų�ѯ����ѡ�޿�������ѧ��
	public ResultSet FindCreditBynumber(String number);
	
	//ͨ���γ̲��ҿγ���Ϣ
	public ResultSet FindCouInformation (String coures);	
	
	//��ѧ�����˺źͿγ���ɾ���γ�
	public void DeleteCou(String cou,String number);
	
	
	
	
}

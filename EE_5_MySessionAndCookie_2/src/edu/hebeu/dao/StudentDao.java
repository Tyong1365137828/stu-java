package edu.hebeu.dao;
/*
 * ѧ������
 * 
 * */

import edu.hebeu.po.Student;

public interface StudentDao {
	//��id�������ѯ�Ϸ���ݣ�ʵ�ֵ�¼��֤����
	public Student findIdByPassword(String id,String password);
}
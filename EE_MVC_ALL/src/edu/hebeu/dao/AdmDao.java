package edu.hebeu.dao;

import edu.hebeu.entity.Administrator;

public interface AdmDao {
	
	//���û�id���������ȫ����Ϣ
	public Administrator FindAllByNumAndPasswd(String num,String passwd);
	
	//ע���û�ʹ��
	public int save(Administrator administrator);
	
}

package edu.hebeu.dao;

import edu.hebeu.entity.User;

public interface UserDao {
	
	//���û�id���������ȫ����Ϣ
	public User FindAllByIdAndPasswd(String id,String passwd);
	
	//ע���û�ʹ��
	public int save(User user);
	
}

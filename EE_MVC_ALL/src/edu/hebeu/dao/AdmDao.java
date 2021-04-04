package edu.hebeu.dao;

import edu.hebeu.entity.Administrator;

public interface AdmDao {
	
	//由用户id和密码查找全部信息
	public Administrator FindAllByNumAndPasswd(String num,String passwd);
	
	//注册用户使用
	public int save(Administrator administrator);
	
}

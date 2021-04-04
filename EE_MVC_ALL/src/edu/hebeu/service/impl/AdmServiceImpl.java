package edu.hebeu.service.impl;

import edu.hebeu.dao.AdmDao;
import edu.hebeu.dao.impl.AdmDaoImpl;
import edu.hebeu.entity.Administrator;
import edu.hebeu.service.AdmService;

public class AdmServiceImpl implements AdmService{
	
	private AdmDao admDao = new AdmDaoImpl();
	
	public AdmDao getAdmDao() {
		return admDao;
	}

	public void setAdmDao(AdmDao admDao) {
		this.admDao = admDao;
	}

	@Override
	public Administrator login(String num, String password) {
		// TODO Auto-generated method stub
		return this.admDao.FindAllByNumAndPasswd(num, password);
	}

}

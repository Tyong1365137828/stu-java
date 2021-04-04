package edu.hebeu.po;

public class Administrator {

	private String adm_id;
	private String adm_password;

	public Administrator() {
		super();
	}

	public Administrator(String adm_id, String adm_password) {
		super();
		this.adm_id = adm_id;
		this.adm_password = adm_password;
	}

	public String getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(String adm_id) {
		this.adm_id = adm_id;
	}

	public String getAdm_password() {
		return adm_password;
	}

	public void setAdm_password(String adm_password) {
		this.adm_password = adm_password;
	}

}

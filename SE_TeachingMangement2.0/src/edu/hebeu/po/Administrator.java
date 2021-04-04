package edu.hebeu.po;

public class Administrator {

	private String adm_account;
	private String adm_password;
	private String adm_name;
	private String adm_idcard;
	
	public Administrator() {
		super();
	}

	public Administrator(String adm_account, String adm_password) {
		super();
		this.adm_account = adm_account;
		this.adm_password = adm_password;
	}

	public Administrator(String adm_account, String adm_name, String adm_idcard) {
		super();
		this.adm_account = adm_account;
		this.adm_name = adm_name;
		this.adm_idcard = adm_idcard;
	}

	public String getAdm_account() {
		return adm_account;
	}

	public void setAdm_account(String adm_account) {
		this.adm_account = adm_account;
	}

	public String getAdm_password() {
		return adm_password;
	}

	public void setAdm_password(String adm_password) {
		this.adm_password = adm_password;
	}

	public String getAdm_name() {
		return adm_name;
	}

	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}
	
	public String getAdm_idcard() {
		return adm_idcard;
	}

	public void setAdm_idcard(String adm_idcard) {
		this.adm_idcard = adm_idcard;
	}
}

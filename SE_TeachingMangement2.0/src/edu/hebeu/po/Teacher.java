package edu.hebeu.po;

public class Teacher {

	private String tea_id;
	private String tea_password;
	private String tea_name;
	private String tea_idcard;
	private String tea_age;
	private String tea_gender;
	private String tea_tel;
	private String tea_depnum;

	public Teacher() {
		super();
	}

	public Teacher(String tea_id, String tea_password) {
		super();
		this.tea_id = tea_id;
		this.tea_password = tea_password;
	}

	public Teacher(String tea_id, String tea_name, String tea_idcard) {
		super();
		this.tea_id = tea_id;
		this.tea_name = tea_name;
		this.tea_idcard = tea_idcard;
	}

	public Teacher(String tea_id, String tea_password, String tea_name, String tea_idcard, String tea_age,
			String tea_gender, String tea_tel, String tea_depnum) {
		super();
		this.tea_id = tea_id;
		this.tea_password = tea_password;
		this.tea_name = tea_name;
		this.tea_idcard = tea_idcard;
		this.tea_age = tea_age;
		this.tea_gender = tea_gender;
		this.tea_tel = tea_tel;
		this.tea_depnum = tea_depnum;
	}

	public String getTea_id() {
		return tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}

	public String getTea_password() {
		return tea_password;
	}

	public void setTea_password(String tea_password) {
		this.tea_password = tea_password;
	}

	public String getTea_name() {
		return tea_name;
	}

	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}

	public String getTea_idcard() {
		return tea_idcard;
	}

	public void setTea_idcard(String tea_idcard) {
		this.tea_idcard = tea_idcard;
	}

	public String getTea_age() {
		return tea_age;
	}

	public void setTea_age(String tea_age) {
		this.tea_age = tea_age;
	}

	public String getTea_gender() {
		return tea_gender;
	}

	public void setTea_gender(String tea_gender) {
		this.tea_gender = tea_gender;
	}

	public String getTea_tel() {
		return tea_tel;
	}

	public void setTea_tel(String tea_tel) {
		this.tea_tel = tea_tel;
	}

	public String getTea_depnum() {
		return tea_depnum;
	}

	public void setTea_depnum(String tea_depnum) {
		this.tea_depnum = tea_depnum;
	}

}

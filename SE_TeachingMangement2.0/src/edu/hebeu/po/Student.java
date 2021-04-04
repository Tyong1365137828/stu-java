package edu.hebeu.po;

public class Student {

	private String stu_number;
	private String stu_password;
	private String stu_name;
	private String stu_age;
	private String stu_gender;
	private String stu_tel;
	private String stu_address;
	private String stu_depnum;
	private String stu_idcard;

	public Student(String stu_number, String stu_password) {
		super();
		this.stu_number = stu_number;
		this.stu_password = stu_password;
	}

	public Student(String stu_number, String stu_name, String stu_idcard) {
		super();
		this.stu_number = stu_number;
		this.stu_name = stu_name;
		this.stu_idcard = stu_idcard;
	}

	
	

	public Student(String stu_number, String stu_password, String stu_name, String stu_age, String stu_gender,
			String stu_tel, String stu_address, String stu_depnum, String stu_idcard) {
		super();
		this.stu_number = stu_number;
		this.stu_password = stu_password;
		this.stu_name = stu_name;
		this.stu_age = stu_age;
		this.stu_gender = stu_gender;
		this.stu_tel = stu_tel;
		this.stu_address = stu_address;
		this.stu_depnum = stu_depnum;
		this.stu_idcard = stu_idcard;
	}

	public String getStu_age() {
		return stu_age;
	}

	public void setStu_age(String stu_age) {
		this.stu_age = stu_age;
	}

	public String getStu_gender() {
		return stu_gender;
	}

	public void setStu_gender(String stu_gender) {
		this.stu_gender = stu_gender;
	}

	public String getStu_tel() {
		return stu_tel;
	}

	public void setStu_tel(String stu_tel) {
		this.stu_tel = stu_tel;
	}

	public String getStu_address() {
		return stu_address;
	}

	public void setStu_address(String stu_address) {
		this.stu_address = stu_address;
	}

	public String getStu_depnum() {
		return stu_depnum;
	}

	public void setStu_depnum(String stu_depnum) {
		this.stu_depnum = stu_depnum;
	}

	public Student() {
		super();
	}

	public String getStu_number() {
		return stu_number;
	}

	public void setStu_number(String stu_number) {
		this.stu_number = stu_number;
	}

	public String getStu_password() {
		return stu_password;
	}

	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_idcard() {
		return stu_idcard;
	}

	public void setStu_idcard(String stu_idcard) {
		this.stu_idcard = stu_idcard;
	}

}

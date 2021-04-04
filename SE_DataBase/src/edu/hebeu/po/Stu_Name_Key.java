package edu.hebeu.po;

public class Stu_Name_Key {

	private String stu_name;
	private String stu_tel;
	private String stu_address;
	private String stu_age;
	private String stu_sex;

	public Stu_Name_Key(String stu_name, String stu_tel, String stu_address, String stu_age, String stu_sex) {
		super();
		this.stu_name = stu_name;
		this.stu_tel = stu_tel;
		this.stu_address = stu_address;
		this.stu_age = stu_age;
		this.stu_sex = stu_sex;
	}
	
	@Override
	public String toString() {
		return "Stu_Name_Key [stu_name=" + stu_name + ", stu_tel=" + stu_tel + ", stu_address=" + stu_address
				+ ", stu_age=" + stu_age + ", stu_sex=" + stu_sex + "]";
	}
	
	public Stu_Name_Key() {
		super();
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
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

	
	
	public String getStu_age() {
		return stu_age;
	}

	public void setStu_age(String stu_age) {
		this.stu_age = stu_age;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

}

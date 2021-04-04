package edu.hebeu.po;

public class Stu_Id_Key {

	private String stu_id;
	private String stu_name;
	private String stu_depid;
	private String stu_password;

	public Stu_Id_Key(String stu_id, String stu_name, String stu_depid, String stu_password) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_depid = stu_depid;
		this.stu_password = stu_password;
	}

	public Stu_Id_Key() {
		super();
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_depid() {
		return stu_depid;
	}

	public void setStu_depid(String stu_depid) {
		this.stu_depid = stu_depid;
	}

	public String getStu_password() {
		return stu_password;
	}

	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}

}

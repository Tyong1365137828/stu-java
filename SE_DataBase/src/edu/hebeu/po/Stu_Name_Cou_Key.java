package edu.hebeu.po;

public class Stu_Name_Cou_Key {
	
	private String stu_id;
	private String stu_cou;
	private String stu_credit;

	

	public Stu_Name_Cou_Key() {
		super();
	}

	public Stu_Name_Cou_Key(String stu_id, String stu_cou, String stu_credit) {
		super();
		this.stu_id = stu_id;
		this.stu_cou = stu_cou;
		this.stu_credit = stu_credit;
	}

	public String getStu_cou() {
		return stu_cou;
	}

	public void setStu_cou(String stu_cou) {
		this.stu_cou = stu_cou;
	}

	public String getStu_credit() {
		return stu_credit;
	}

	public void setStu_credit(String stu_credit) {
		this.stu_credit = stu_credit;
	}
	
	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	
}

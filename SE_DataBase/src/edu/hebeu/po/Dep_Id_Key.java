package edu.hebeu.po;

public class Dep_Id_Key {
	private String dep_id;
	private String dep_name;
	private String dep_address;
	private String dep_tel;

	public Dep_Id_Key(String dep_id, String dep_name, String dep_address, String dep_tel) {
		super();
		this.dep_id = dep_id;
		this.dep_name = dep_name;
		this.dep_address = dep_address;
		this.dep_tel = dep_tel;
	}

	public Dep_Id_Key() {
		super();
	}

	public String getDep_id() {
		return dep_id;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public String getDep_address() {
		return dep_address;
	}

	public void setDep_address(String dep_address) {
		this.dep_address = dep_address;
	}

	public String getDep_tel() {
		return dep_tel;
	}

	public void setDep_tel(String dep_tel) {
		this.dep_tel = dep_tel;
	}

}

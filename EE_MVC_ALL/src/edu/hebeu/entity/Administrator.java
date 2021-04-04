package edu.hebeu.entity;

public class Administrator {
	private String num = "";
	private String password = "";
	private String name = "";

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Administrator(String num, String password, String name) {
		super();
		this.num = num;
		this.password = password;
		this.name = name;
	}

	public Administrator() {
		super();
	}

	@Override
	public String toString() {
		return "administrator [num=" + num + ", password=" + password + ", name=" + name + "]";
	}

}

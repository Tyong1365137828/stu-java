package edu.hebeu.po;

public class User {
	String usename;
	String password;
	
	
	public User() {
		super();
	}
	public User(String usename, String password) {
		super();
		this.usename = usename;
		this.password = password;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

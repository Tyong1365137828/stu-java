package edu.hebeu.po;

import java.util.Date;

/**
 * @author Tyong(汤勇) User.java Jul 6, 2020 用户类
 */
public class User {
	private String account; // 用户账号
	private String password; // 用户密码
	private String name; // 用户名
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date birthday; // 出生日期
	private String sex; // 用户性别
	private String address; // 用户地址
	private String tel; // 用户手机号
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	public User() {
		super();
	}

	public User(String account, String password, String name, Date birthday, String sex, String address, String tel) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", name=" + name + ", birthday=" + birthday
				+ ", sex=" + sex + ", address=" + address + ", tel=" + tel + "]";
	}

}

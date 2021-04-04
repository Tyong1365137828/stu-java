package edu.hebeu.entity;

import java.util.Date;

public class User {

	private String num;
	private String name;
	private String password;
	private Integer age;
	private Double score;
	private Date registerdate;
	private String hobbies;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public User(String num, String name, String password, Integer age, Double score, Date registerdate,
			String hobbies) {
		super();
		this.num = num;
		this.name = name;
		this.password = password;
		this.age = age;
		this.score = score;
		this.registerdate = registerdate;
		this.hobbies = hobbies;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", password=" + password + ", age=" + age + ", score=" + score
				+ ", registerdate=" + registerdate + ", hobbies=" + hobbies + "]";
	}

}

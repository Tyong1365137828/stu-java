package edu.hebeu.entity;

import java.util.Date;
/**
 * 用户类
 * @author think
 *
 */
public class User {
    private String userid;//用户帐号
    private String username;//用户名
    private String password;//用户密码
    private Integer age;
    private Double score;
    private Date entrydate;
    private String hobby;
           
	public User() {
		
	}
	public User(String userid, String username, String password, Integer age,
			Double score, Date entrydate, String hobby) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.age = age;
		this.score = score;
		this.entrydate = entrydate;
		this.hobby = hobby;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Date getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", score="
				+ score + ", entrydate=" + entrydate + ", hobby=" + hobby + "]";
	}
   
}

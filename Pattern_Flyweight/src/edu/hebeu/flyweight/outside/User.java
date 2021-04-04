package edu.hebeu.flyweight.outside;

// 这个类表示网站的使用者
public class User {
	private String name;
	
	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

package edu.hebeu.entity;

public class User {
	private String num;
	private String name;
	private Integer age;
	
	public User() {
		super();
		System.out.println("�޲ι��췽�����ã�");
	}
	
	public User(String num, String name, Integer age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		System.out.println("�вι��췽�����ã�");
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
	
	/**
	 * ��̬����飺
	 * 	��̬������� ����� ʱִ�У���ִֻ��һ��
	 */
	static {
		System.out.println("User��ľ�̬�����ִ����");
	}
	
}

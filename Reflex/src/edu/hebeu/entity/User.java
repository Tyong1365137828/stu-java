package edu.hebeu.entity;

public class User {
	private String num;
	private String name;
	private Integer age;
	
	public User() {
		super();
		System.out.println("无参构造方法调用！");
	}
	
	public User(String num, String name, Integer age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		System.out.println("有参构造方法调用！");
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
	 * 静态代码块：
	 * 	静态代码块在 类加载 时执行，且只执行一次
	 */
	static {
		System.out.println("User类的静态代码块执行了");
	}
	
}

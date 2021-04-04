package edu.hebeu.prototype;

public class Sheep implements Cloneable {
	private String flag = "001";
	
	private String name;
	private Integer age;
	private String color;
	
	public Sheep(String name, Integer age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	public String getName() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public String getColor() {
		return color;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Sheep [flag=" + flag + ", name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	
	/**
	 * 重新Object类的clone()方法
	 */
	@Override
	protected Object clone() {
		Object cloneObj = null;
		
		try {
			cloneObj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloneObj;
	}
	
}

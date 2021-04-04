package edu.hebeu.extend.shallowcopy;

public class Sheep implements Cloneable {
	
	private String name;
	private Integer age;
	private String color;
	
	public Sheep friendSheep;
	
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
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Sheep [name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	
	public Sheep(String name, Integer age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	@Override
	protected Object clone(){
		Object cloneObj = null;
		try {
			cloneObj =  super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloneObj;
	}
	
}

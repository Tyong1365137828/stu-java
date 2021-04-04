package edu.hebeu.original;

public class Sheep {
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
		return "TomSheep [name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	
}

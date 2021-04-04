package edu.hebeu.interfacefactory.pizza;

public abstract class Pizza {
	
	private String name; // 这个属性用来接收披萨的名字
	
	public abstract void prepare(); // 该方法是按照披萨的名字准备该披萨的原材料
	
	public void bake() {
		System.out.println(name + "：烘烤中");
	}
	
	public void cut() {
		System.out.println(name + "：切分中");
	}
	
	public void box() {
		System.out.println(name + "打包中...，制作完成！");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

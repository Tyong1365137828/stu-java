package edu.hebeu.simplefactory.pizza;

public class ChinaPizza extends Pizza { // 增加一个披萨种类

	@Override
	public void prepare() {
		System.out.println("正在准备中式披萨的原材料...");
	}
}

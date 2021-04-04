package edu.hebeu.simplefactory.pizza;

public class CheessPizza extends Pizza {

	@Override
	public void prepare() {
		System.out.println("正在准备奶酪披萨的原材料...");
	}
	
}

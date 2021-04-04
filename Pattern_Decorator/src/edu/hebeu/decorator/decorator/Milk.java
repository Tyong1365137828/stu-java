package edu.hebeu.decorator.decorator;

import edu.hebeu.decorator.component.DrinkComponent;

public class Milk extends Decorator { // 牛奶调味品

	public Milk(DrinkComponent drink) {
		super(drink); // 调用父类的构造器
		super.setDesc("牛奶"); // 调味品描述
		super.setPrice(2.00f); // 调味品描述
	}

}

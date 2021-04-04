package edu.hebeu.decorator.decorator;

import edu.hebeu.decorator.component.DrinkComponent;

public class Chocolate extends Decorator {

	public Chocolate(DrinkComponent drink) {
		super(drink); // 调用父类的构造器
		setDesc("巧克力");
		setPrice(3.00f);
	}

}

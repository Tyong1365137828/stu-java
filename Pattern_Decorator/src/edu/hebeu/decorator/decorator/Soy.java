package edu.hebeu.decorator.decorator;

import edu.hebeu.decorator.component.DrinkComponent;

public class Soy extends Decorator {

	public Soy(DrinkComponent drink) {
		super(drink); // 调用父类的构造器
		setDesc("豆浆");
		setPrice(1.50f);
	}

}

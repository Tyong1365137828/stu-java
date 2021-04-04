package edu.hebeu.decorator.decorator;

import edu.hebeu.decorator.component.DrinkComponent;

public class Chocolate extends Decorator {

	public Chocolate(DrinkComponent drink) {
		super(drink); // ���ø���Ĺ�����
		setDesc("�ɿ���");
		setPrice(3.00f);
	}

}

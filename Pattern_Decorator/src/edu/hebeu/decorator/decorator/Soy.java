package edu.hebeu.decorator.decorator;

import edu.hebeu.decorator.component.DrinkComponent;

public class Soy extends Decorator {

	public Soy(DrinkComponent drink) {
		super(drink); // ���ø���Ĺ�����
		setDesc("����");
		setPrice(1.50f);
	}

}

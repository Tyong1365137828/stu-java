package edu.hebeu.decorator.decorator;

import edu.hebeu.decorator.component.DrinkComponent;

public class Milk extends Decorator { // ţ�̵�ζƷ

	public Milk(DrinkComponent drink) {
		super(drink); // ���ø���Ĺ�����
		super.setDesc("ţ��"); // ��ζƷ����
		super.setPrice(2.00f); // ��ζƷ����
	}

}

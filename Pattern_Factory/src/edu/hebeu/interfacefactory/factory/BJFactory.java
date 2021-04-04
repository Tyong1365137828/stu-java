package edu.hebeu.interfacefactory.factory;

import edu.hebeu.interfacefactory.pizza.Pizza;
import edu.hebeu.interfacefactory.pizza.BJCheessPizza;
import edu.hebeu.interfacefactory.pizza.BJGreekPizza;

public class BJFactory implements AbsFactory { // һ�����๤��

	@Override
	public Pizza createPizza(String name) {
		Pizza pizza = null;
		
		if("��������".equals(name)) {
			pizza = new BJCheessPizza();
			pizza.setName("������������");
		} else if("ϣ������".equals(name)) {
			pizza = new BJGreekPizza();
			pizza.setName("����ϣ������");
		}
		
		return pizza;
	}

}

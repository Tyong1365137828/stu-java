package edu.hebeu.interfacefactory.factory;

import edu.hebeu.interfacefactory.pizza.Pizza;
import edu.hebeu.interfacefactory.pizza.LDCheessPizza;
import edu.hebeu.interfacefactory.pizza.LDGreekPizza;

public class LDFactory implements AbsFactory { // һ�����๤��

	@Override
	public Pizza createPizza(String name) {
		Pizza pizza = null;
		
		if("��������".equals(name)) {
			pizza = new LDCheessPizza();
			pizza.setName("�׶���������");
		} else if("ϣ������".equals(name)) {
			pizza = new LDGreekPizza();
			pizza.setName("�׶�ϣ������");
		}
		
		return pizza;
	}

}

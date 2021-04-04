package edu.hebeu.methodfactory.order;

import edu.hebeu.methodfactory.pizza.LDCheessPizza;
import edu.hebeu.methodfactory.pizza.LDGreekPizza;
import edu.hebeu.methodfactory.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {

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

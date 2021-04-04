package edu.hebeu.methodfactory.order;

import edu.hebeu.methodfactory.pizza.Pizza;
import edu.hebeu.methodfactory.pizza.BJCheessPizza;
import edu.hebeu.methodfactory.pizza.BJGreekPizza;

public class BJOrederPizza extends OrderPizza {

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

package edu.hebeu.interfacefactory.factory;

import edu.hebeu.interfacefactory.pizza.Pizza;
import edu.hebeu.interfacefactory.pizza.BJCheessPizza;
import edu.hebeu.interfacefactory.pizza.BJGreekPizza;

public class BJFactory implements AbsFactory { // 一个子类工厂

	@Override
	public Pizza createPizza(String name) {
		Pizza pizza = null;
		
		if("奶酪披萨".equals(name)) {
			pizza = new BJCheessPizza();
			pizza.setName("北京奶酪披萨");
		} else if("希腊披萨".equals(name)) {
			pizza = new BJGreekPizza();
			pizza.setName("北京希腊披萨");
		}
		
		return pizza;
	}

}

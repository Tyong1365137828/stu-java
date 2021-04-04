package edu.hebeu.interfacefactory.factory;

import edu.hebeu.interfacefactory.pizza.Pizza;
import edu.hebeu.interfacefactory.pizza.LDCheessPizza;
import edu.hebeu.interfacefactory.pizza.LDGreekPizza;

public class LDFactory implements AbsFactory { // Ò»¸ö×ÓÀà¹¤³§

	@Override
	public Pizza createPizza(String name) {
		Pizza pizza = null;
		
		if("ÄÌÀÒÅûÈø".equals(name)) {
			pizza = new LDCheessPizza();
			pizza.setName("Â×¶ØÄÌÀÒÅûÈø");
		} else if("Ï£À°ÅûÈø".equals(name)) {
			pizza = new LDGreekPizza();
			pizza.setName("Â×¶ØÏ£À°ÅûÈø");
		}
		
		return pizza;
	}

}

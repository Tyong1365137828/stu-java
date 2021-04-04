package edu.hebeu.methodfactory.order;

import edu.hebeu.methodfactory.pizza.LDCheessPizza;
import edu.hebeu.methodfactory.pizza.LDGreekPizza;
import edu.hebeu.methodfactory.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {

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

package edu.hebeu.simplefactory.order;

import edu.hebeu.simplefactory.pizza.CheessPizza;
import edu.hebeu.simplefactory.pizza.ChinaPizza;
import edu.hebeu.simplefactory.pizza.GreekPizza;
import edu.hebeu.simplefactory.pizza.Pizza;

public class PizzaSimpleFactory {
	
	public Pizza createPizza(String name) { // 根据披萨名创建相应的披萨
		Pizza pizza = null;
		
		if("奶酪披萨".equals(name)) {
			pizza = new CheessPizza();
			pizza.setName("奶酪披萨");
		} else if("希腊披萨".equals(name)) {
			pizza = new GreekPizza();
			pizza.setName("希腊披萨");
		} else if("中式披萨".equals(name)) {
			pizza = new ChinaPizza();
			pizza.setName("中式披萨");
		}
		
		return pizza;
	}
	
	public static Pizza createPizza2(String name) { // 根据披萨名创建相应的披萨，对上述的方法进行改进(声明为静态的)
		Pizza pizza = null;
		
		if("奶酪披萨".equals(name)) {
			pizza = new CheessPizza();
			pizza.setName("奶酪披萨");
		} else if("希腊披萨".equals(name)) {
			pizza = new GreekPizza();
			pizza.setName("希腊披萨");
		} else if("中式披萨".equals(name)) {
			pizza = new ChinaPizza();
			pizza.setName("中式披萨");
		}
		
		return pizza;
	}
}

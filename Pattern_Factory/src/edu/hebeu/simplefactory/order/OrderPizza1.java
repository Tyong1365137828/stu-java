package edu.hebeu.simplefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.simplefactory.pizza.Pizza;

public class OrderPizza1 {
	
	private PizzaSimpleFactory pizzaFactory = null; // 定义一个简单工厂对象
	private Pizza pizza = null;
	
	public OrderPizza1(PizzaSimpleFactory factory) {
		String name = null;
		setFactory(factory);
		
		do {
			name = getName();
			pizza = this.pizzaFactory.createPizza(name);
			
			if(pizza == null) {
				System.out.println("~~~不知道您要的是什么披萨，交易结束~~~");
				break;
			}
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		} while(true);
	}
	
	public void setFactory(PizzaSimpleFactory factory) { //
		this.pizzaFactory = factory;
	}
	
	private String getName() { // 这个方法用来接收用户输入的披萨名
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入购买的披萨名：");
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}

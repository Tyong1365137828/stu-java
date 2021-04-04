package edu.hebeu.simplefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.simplefactory.pizza.Pizza;

public class OrderPizza1 {
	
	private PizzaSimpleFactory pizzaFactory = null; // ����һ���򵥹�������
	private Pizza pizza = null;
	
	public OrderPizza1(PizzaSimpleFactory factory) {
		String name = null;
		setFactory(factory);
		
		do {
			name = getName();
			pizza = this.pizzaFactory.createPizza(name);
			
			if(pizza == null) {
				System.out.println("~~~��֪����Ҫ����ʲô���������׽���~~~");
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
	
	private String getName() { // ����������������û������������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����빺�����������");
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}

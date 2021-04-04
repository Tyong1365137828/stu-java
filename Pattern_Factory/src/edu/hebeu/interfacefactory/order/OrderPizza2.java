package edu.hebeu.interfacefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.interfacefactory.factory.AbsFactory;
import edu.hebeu.interfacefactory.pizza.Pizza;

public class OrderPizza2 {
	
	public OrderPizza2(AbsFactory factory) {
		String name = null;
		Pizza pizza = null;
		
		do {
			name = getName();
			pizza = factory.createPizza(name);
			
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

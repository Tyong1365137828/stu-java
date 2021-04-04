package edu.hebeu.methodfactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.methodfactory.pizza.Pizza;

public abstract class OrderPizza {
	
	public OrderPizza() {
		String name = null;
		Pizza pizza = null;
		System.out.println("开始制作披萨");
		
		do {
			name = getName();
			pizza = this.createPizza(name);
			
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
	
	public abstract Pizza createPizza(String name); // 创建披萨方法抽象成抽象方法，具体细节交由具体的子类实现
	
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

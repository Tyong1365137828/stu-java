package edu.hebeu.original.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.original.pizza.CheessPizza;
import edu.hebeu.original.pizza.GreekPizza;
import edu.hebeu.original.pizza.Pizza;

public class OrderPizza1 {
	
	public OrderPizza1() {
		Pizza pizza = null;
		String name; // 购买披萨的披萨名字
		
		do {
			name = getName();
			if("奶酪披萨".equals(name)) {
				pizza = new CheessPizza();
				pizza.setName("奶酪披萨");
			} else if("希腊披萨".equals(name)) {
				pizza = new GreekPizza();
				pizza.setName("希腊披萨");
			} else if("中式披萨".equals(name)) {
				pizza = new CheessPizza();
				pizza.setName("中式披萨");
			} else {
				System.out.println("~~~不知道您要的是什么披萨，交易结束~~~");
				break;
			}
			
			// 输出披萨的制作过程
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

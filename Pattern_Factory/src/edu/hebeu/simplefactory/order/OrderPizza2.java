package edu.hebeu.simplefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.simplefactory.pizza.Pizza;

/*
 * 使用静态的createPizza2()方法来订购披萨，不需要工厂对象，直接调用，所以就不需要传入创建工厂类实例
 *
 */
public class OrderPizza2 {

	private Pizza pizza = null;
	
	public OrderPizza2() {
		String name = null;
		
		do {
			name = getName();
			pizza = PizzaSimpleFactory.createPizza2(name);
			
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

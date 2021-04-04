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
				System.out.println("~~~��֪����Ҫ����ʲô���������׽���~~~");
				break;
			}
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		} while(true);
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

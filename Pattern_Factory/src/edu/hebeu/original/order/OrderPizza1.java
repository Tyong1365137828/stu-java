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
		String name; // ������������������
		
		do {
			name = getName();
			if("��������".equals(name)) {
				pizza = new CheessPizza();
				pizza.setName("��������");
			} else if("ϣ������".equals(name)) {
				pizza = new GreekPizza();
				pizza.setName("ϣ������");
			} else if("��ʽ����".equals(name)) {
				pizza = new CheessPizza();
				pizza.setName("��ʽ����");
			} else {
				System.out.println("~~~��֪����Ҫ����ʲô���������׽���~~~");
				break;
			}
			
			// �����������������
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

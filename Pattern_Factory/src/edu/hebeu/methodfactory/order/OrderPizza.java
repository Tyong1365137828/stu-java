package edu.hebeu.methodfactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.methodfactory.pizza.Pizza;

public abstract class OrderPizza {
	
	public OrderPizza() {
		String name = null;
		Pizza pizza = null;
		System.out.println("��ʼ��������");
		
		do {
			name = getName();
			pizza = this.createPizza(name);
			
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
	
	public abstract Pizza createPizza(String name); // ����������������ɳ��󷽷�������ϸ�ڽ��ɾ��������ʵ��
	
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

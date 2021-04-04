package edu.hebeu.simplefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.simplefactory.pizza.Pizza;

/*
 * ʹ�þ�̬��createPizza2()��������������������Ҫ��������ֱ�ӵ��ã����ԾͲ���Ҫ���봴��������ʵ��
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

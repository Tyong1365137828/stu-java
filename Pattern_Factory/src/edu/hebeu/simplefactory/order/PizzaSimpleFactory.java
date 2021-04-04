package edu.hebeu.simplefactory.order;

import edu.hebeu.simplefactory.pizza.CheessPizza;
import edu.hebeu.simplefactory.pizza.ChinaPizza;
import edu.hebeu.simplefactory.pizza.GreekPizza;
import edu.hebeu.simplefactory.pizza.Pizza;

public class PizzaSimpleFactory {
	
	public Pizza createPizza(String name) { // ����������������Ӧ������
		Pizza pizza = null;
		
		if("��������".equals(name)) {
			pizza = new CheessPizza();
			pizza.setName("��������");
		} else if("ϣ������".equals(name)) {
			pizza = new GreekPizza();
			pizza.setName("ϣ������");
		} else if("��ʽ����".equals(name)) {
			pizza = new ChinaPizza();
			pizza.setName("��ʽ����");
		}
		
		return pizza;
	}
	
	public static Pizza createPizza2(String name) { // ����������������Ӧ���������������ķ������иĽ�(����Ϊ��̬��)
		Pizza pizza = null;
		
		if("��������".equals(name)) {
			pizza = new CheessPizza();
			pizza.setName("��������");
		} else if("ϣ������".equals(name)) {
			pizza = new GreekPizza();
			pizza.setName("ϣ������");
		} else if("��ʽ����".equals(name)) {
			pizza = new ChinaPizza();
			pizza.setName("��ʽ����");
		}
		
		return pizza;
	}
}

package edu.hebeu.decorator;

import edu.hebeu.decorator.component.Decaf;
import edu.hebeu.decorator.component.DrinkComponent;
import edu.hebeu.decorator.component.Espresso;
import edu.hebeu.decorator.component.LongBlack;
import edu.hebeu.decorator.component.ShortBlack;
import edu.hebeu.decorator.decorator.Chocolate;
import edu.hebeu.decorator.decorator.Milk;
import edu.hebeu.decorator.decorator.Soy;

public class Client {
	
	public static void main(String[] args) {
		
		// ��һ�����������
		DrinkComponent drink = new Espresso();
//		System.out.println("���ã�" + drink.coast());
//		System.out.println("������" + drink.getDesc());
		
		// ��һ��ţ��
		drink = new Milk(drink);
//		System.out.println("���ã�" + drink.coast());
//		System.out.println("���������룺" + drink.getDesc());
		
		// ��һ���ɿ���
		drink = new Chocolate(drink);
//		System.out.println("���ã�" + drink.coast());
//		System.out.println("���������룺" + drink.getDesc());
		
		// �ټ�һ��ţ��
		drink = new Milk(drink);
//		System.out.println("���ã�" + drink.coast());
//		System.out.println("���������룺" + drink.getDesc());
		
		// �ټ���һ�ݶ���
		drink = new Soy(drink);
		System.out.println("���ã�" + drink.coast());
		System.out.println("���������룺" + drink.getDesc());	
		
		
		System.out.println("--------------------------------------------");
		
		DrinkComponent drink2 = new LongBlack(); // ��һ����ʽ����
		Float coffeePrice = drink2.getPrice(); // ��ȡ�����ȵĵ��۲����б���
		drink2 = new Milk(drink2); // ��һ��ţ��
		drink2 = new Chocolate(drink2); // ��һ���ɿ���
		drink2 = new Milk(drink2); // ��һ��ţ��
		System.out.println("���ã�" + drink2.coast());
		System.out.println("���������룺" + drink2.getDesc() + " " + coffeePrice);
		
		System.out.println("--------------------------------------------");
		
		DrinkComponent drink3 = new ShortBlack(); // ��һ��ShortBlack����
		drink3 = new Soy(drink3); // ��һ�ݶ���
		drink3 = new Chocolate(drink3); // ��һ���ɿ���
		System.out.println("���ã�" + drink3.coast());
		System.out.println("���������룺" + drink3.getDesc());
		
		System.out.println("--------------------------------------------");
		
		DrinkComponent drink4 = new Decaf(); // ��һ�����򿧷�
		System.out.println("���ã�" + drink4.coast());
		System.out.println("������" + drink4.getDesc());
		
	}
}

package edu.hebeu.generic;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * ͨ����������ѧϰ����
 * 
 * JDK5.0֮���Ƴ������ԣ�����
 * 1�����������﷨���ƣ�ֻ�ڳ������׶������ã�ֻ�Ǹ��������ο���(���н׶η���û��)
 * 2��ʹ�÷��͵ĺô���
 * 		��һ�������д洢��Ԫ������ͳһ�ˣ�
 * 		�ڶ����Ӽ�����ȡ����Ԫ���Ƿ���ָ�������ͣ�����Ҫ����������ת�ͣ�
 * 3�����͵�ȱ�㣺
 * 		���¼����д洢��Ԫȱ�������ԣ�
 * 4�������ҵ���У������ڵ�Ԫ����ͳһ�ģ������������Եõ��ƹ�
 * 
 * 
 * JDK8.0֮���������Զ������ƶϻ���(��ʯ���ʽ)
 * ��ˣ�List<Animal> l = new ArrayList<>();
 * 
 * @author 13651
 *
 */
public class GenericStu {
	public static void main(String[] args) {
		/**����ʹ�÷���ʱ*/
		List l1 = new ArrayList();
		
		Cat cat = new Cat();
		Dog dog = new Dog();
		Bird bird = new Bird();
		
		l1.add(cat);
		l1.add(dog);
		l1.add(bird);
		
		Iterator it1 = l1.iterator(); // ����l1���ϵĵ�����
		System.out.println("��ʹ�÷��ͣ�");
		while(it1.hasNext()) {
//			Animal a = it1.next(); // ����ֱ��ʹ��Animal����
			Object obj = it1.next(); // ��ʹ�÷��ͣ���ȡ��Ԫ��ʱֻ����Object���ͽ��н���
			if(obj instanceof Animal) { // �����Ҫʹ�ò���Object���͵��࣬��Ҫ��������ת��
				Animal a = (Animal)obj;
				a.move();
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		/**��ʹ�÷��ͺ�*/
		List<Animal> l2 = new ArrayList<Animal>(); // ��ʱ������ֻ�ܴ洢Animal���͵�Ԫ����
		
		Cat cat2 = new Cat();
		Dog dog2 = new Dog();
		Bird bird2 = new Bird();
		
		l2.add(cat2);
		l2.add(dog2);
		l2.add(bird2);
//		l2.add(25); // ��ʱ�ᷢ�֣��������Ĳ���Animal���͵�Ԫ�ػᱨ���±��벻ͨ��
		
		Iterator<Animal> it2 = l2.iterator(); // ����l2���ϵĵ�������ע�������ҲӦ��ʹ�÷���
		System.out.println("ʹ�÷��ͣ�");
		while(it2.hasNext()) {
			Animal a = it2.next();
			a.move();
			
			// ����ע�⣺�����Ҫ����Animal�����������еķ�����������Ҫ��һ����ת�͵�
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		/**
		 * �Զ������ƶϻ���<��ʯ���ʽ>
		 * new ArrayList<>()�����List<Animal>�Զ��ƶϳ�����
		 */
		List<Animal> l3 = new ArrayList<>(); // ��ʱ������ֻ�ܴ洢Animal���͵�Ԫ����
		
		Cat cat3 = new Cat();
		Dog dog3 = new Dog();
		Bird bird3 = new Bird();
		
		l3.add(cat3);
		l3.add(dog3);
		l3.add(bird3);
		
		Iterator<Animal> it3 = l3.iterator();
		System.out.println("ʹ�÷��͡���ʯ���ʽ����");
		while(it3.hasNext()) {
			Animal a = it3.next();
			a.move();
			
			// ����ע�⣺�����Ҫ����Animal�����������еķ�����������Ҫ��һ����ת�͵�
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
}

class Animal {
	public void move() {
		System.out.println("�������ƶ�");
	}
}

class Cat extends Animal {
	public void go() {
		System.out.println("è����·");
	}
}

class Dog extends Animal {
	public void run() {
		System.out.println("������");
	}
}

class Bird extends Animal {
	public void fly() {
		System.out.println("���ڷ�");
	}
}
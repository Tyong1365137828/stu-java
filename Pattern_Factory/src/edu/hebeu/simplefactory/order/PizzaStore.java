package edu.hebeu.simplefactory.order;

/**
 * 
 * ��������� ͨ���򵥹���ģʽ ��ʵ�������Ĺ���(�൱��һ���ͻ��ˣ���������Ķ�������)
 * 
 * �����ʱ��Ŀ�����µ����󣻿ͻ��ڵ�����ʱ��������ѡ��ص㣬Ȼ���ڸõص�ѡ���������磺����������������
 * ������ϣ���������׶ص������������׶ص�ϣ�������ȣ�
 * 
 * ˼·�������ʱ����ʹ������ �򵥹���ģʽ������Ҫ������ͬ�ļ򵥹����࣬�磺BJPizzaSimpleFactory�ࡢ
 * LDPizzaSimpleFactory��ȣ����������ӻᵼ�¹�������࣬����Ŀ����չ�ԡ�ά���Բ����ر�ã�
 * 	��ʱ���ǿ���ʹ�ù�������ģʽȥʵ�ָ��������methodfactory��ʾ
 * 	
 * @author 13651
 *
 */
public class PizzaStore {

	public static void main(String[] args) {
//		System.out.println("***ʹ�ü򵥹���ģʽ***");
//		new OrderPizza1(new PizzaSimpleFactory());
		
		System.out.println("***ʹ�ü򵥹���ģʽ�ĵڶ���д��(��̬����ģʽ)***");
		new OrderPizza2();
	}
}

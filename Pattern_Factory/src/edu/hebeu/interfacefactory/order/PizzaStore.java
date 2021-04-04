package edu.hebeu.interfacefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.interfacefactory.factory.BJFactory;
import edu.hebeu.interfacefactory.factory.LDFactory;

public class PizzaStore {
	public static void main(String[] args) {
		System.out.println("***���󹤳�ģʽʵ��***");
		String location = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����빺����ĸ��ط���������");
		try {
			location = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("����".equals(location)) {
			new OrderPizza1(new BJFactory());
		} else if("�׶�".contentEquals(location)) {
			new OrderPizza1(new LDFactory());
		} else {
			System.out.println("û���ҵ��˵ط�~~~");
		}
	}
}

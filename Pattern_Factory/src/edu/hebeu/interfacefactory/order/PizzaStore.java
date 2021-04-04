package edu.hebeu.interfacefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.hebeu.interfacefactory.factory.BJFactory;
import edu.hebeu.interfacefactory.factory.LDFactory;

public class PizzaStore {
	public static void main(String[] args) {
		System.out.println("***抽象工厂模式实现***");
		String location = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入购买的哪个地方的披萨：");
		try {
			location = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("北京".equals(location)) {
			new OrderPizza1(new BJFactory());
		} else if("伦敦".contentEquals(location)) {
			new OrderPizza1(new LDFactory());
		} else {
			System.out.println("没有找到此地方~~~");
		}
	}
}

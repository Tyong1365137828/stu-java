package edu.hebeu.methodfactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 这个例子 通过工厂方法模式 来实现披萨的购买
 * 
 * 设计方案：将披萨项目的实例化功能抽象成抽象方法，在不同的口味点餐子类中具体实现；
 * 
 * @author 13651
 *
 */
public class PizzaStore {
	public static void main(String[] args) {
		System.out.println("***工厂方法模式实现***");
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
			new BJOrederPizza();
		} else if("伦敦".contentEquals(location)) {
			new LDOrderPizza();
		} else {
			System.out.println("没有找到此地方~~~");
		}
	}
}

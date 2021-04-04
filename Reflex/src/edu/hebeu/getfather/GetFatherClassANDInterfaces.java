package edu.hebeu.getfather;

import java.util.Scanner;

/**
 * 这个例子展示如何获取一个类的父类和实现的所有父接口
 * @author 13651
 *
 */
public class GetFatherClassANDInterfaces {
	public static void main(String[] args) {
		Class cClass = null;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("请输入要查询父类和实现接口的类：");
			String className = scanner.next();
			scanner.close();
			cClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**获取这个类的父类(因为直接父类只能是一个，所以返回值类型是Class)*/
		Class fatherClass = cClass.getSuperclass();
		System.out.println("这个类的直接父类是：" + fatherClass.getName());
		
		/**获取这个类的所有实现的接口(接口可能有多个，所以返回值类型是Class[]数组)*/
		Class[] fatherIntefaces = cClass.getInterfaces();
		System.out.print("这个类实现的接口有：");
		for(Class i : fatherIntefaces) {
			System.out.print(i.getName() + "		");
		}System.out.println();
		
	}
}

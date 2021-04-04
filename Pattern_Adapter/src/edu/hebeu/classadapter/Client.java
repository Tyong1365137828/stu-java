package edu.hebeu.classadapter;

/**
 * 这个例子使用类适配器
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) {
		System.out.println("---------类适配器----------");
		Phone phone = new Phone();
		phone.charging(new VoltageAdapter());
	}
}

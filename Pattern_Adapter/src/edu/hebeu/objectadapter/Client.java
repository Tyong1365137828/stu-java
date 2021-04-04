package edu.hebeu.objectadapter;

/**
 * 这个例子使用对象适配器
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) {
		System.out.println("-------对象适配器-------");
		Phone phone = new Phone();
		phone.charging(new VoltageAdapter(new Voltage220V()));
	}
}

package edu.hebeu.classadapter;

/**
 * �������ʹ����������
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) {
		System.out.println("---------��������----------");
		Phone phone = new Phone();
		phone.charging(new VoltageAdapter());
	}
}

package edu.hebeu.pattern.type8;

/**
 * �������ʾ ö�� ��ʽʵ�ֵ���ģʽ
 * 
 * ��ȱ��˵����
 * 	1������JDK1.5��������ö������ʵ�ֵ���ģʽ�������ܱ�����߳�ͬ�����⣬���һ��ܷ�ֹ�����л����´����µ�
 * ����
 * 	2�����ַ�ʽ�� Effective JAVA ���� Josh Bloch �ᳫ�ķ�ʽ��
 * 
 * ���ۣ��Ƽ�ʹ��
 * 
 * @author 13651
 *
 */
public class Type8Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.INSTANCE;
		Singleton instance2 = Singleton.INSTANCE;
		
		System.out.println("instance1��hashCode = " + instance1.hashCode() + "; instance2��hashCode = " + instance2.hashCode());
		System.out.println("instance1��instance2�Ƿ���ͬһ������" + (instance1 == instance2));
		
		instance1.method1();
		instance2.method1();
	}
}

enum Singleton {
	INSTANCE;
	public void method1() {
		System.out.println("����method1ִ����...");
	}
}

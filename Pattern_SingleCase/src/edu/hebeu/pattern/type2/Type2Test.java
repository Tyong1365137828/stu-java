package edu.hebeu.pattern.type2;

/**
 * ���������ʾ ����ʽ(��̬�����) ʵ�ֵ���ģʽ
 * 
 * ��ȱ��˵����
 * 	1�����ַ���������ķ�����ʵ���ƣ�ֻ��������ʵ�����Ĺ��̷ŵ��˾�̬������У�Ҳ������װ�ص�ʱ���ִ�о�̬
 * ������еĴ��룬��ʼ�����ʵ�����ŵ��ȱ���뷽ʽһһ����
 * 
 * ���ۣ����ַ�ʽʵ�ֵĵ���ģʽ���ã����ǿ�������ڴ��˷ѣ�
 * @author 13651
 *
 */
public class Type2Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1��hashCode = " + instance1.hashCode() + "; instance2��hashCode = " + instance2.hashCode());
		System.out.println("instance1��instance2�Ƿ���ͬһ������" + (instance1 == instance2));
		
	}
}

class Singleton {
	
	// 1��˽�л�������
	private Singleton() {}
	
	private static Singleton instance;
	// 2����̬�����
	static {
		instance = new Singleton();
	}
	
	// 3�������ṩһ����̬�Ĺ�����������ȡinstanceʵ������
	public static Singleton getInstance() {
		return instance;
	}
	
}

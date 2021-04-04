package edu.hebeu.pattern.type3;

/**
 * �������ʾ ����ʽ(�̲߳���ȫ) ʵ�ֵ���ģʽ
 * 
 * ��ȱ��˵����
 * 	1�����������ص�Ч��������ֻ���ڵ��߳���ʹ�ã�
 * 	2������ڶ��߳��£�һ���߳̽���if(instance == null)�ж���䣬���ܻ�δ���ü�����ִ�У���һ���߳�Ҳͨ��
 * ������ж���䣬��ʱ���������ʵ���������ڶ��̻߳����²�����ʹ�����ַ�ʽ��
 * 
 * ���ۣ���ʵ�ʿ����У���Ҫʹ�����ַ�ʽʵ�ֵ���ģʽ��
 * 
 * 
 * @author 13651
 *
 */
public class Type3Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1��hashCode = " + instance1.hashCode() + "; instance2��hashCode = " + instance2.hashCode());
		System.out.println("instance1��instance2�Ƿ���ͬһ������" + (instance1 == instance2));
		
	}
}

class Singleton {
	
	private static Singleton instance;
	
	// 1��˽�л�������
	private Singleton() {}
	
	// 2�������ṩһ����̬�Ĺ�����������ȡinstanceʵ������
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}

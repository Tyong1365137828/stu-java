package edu.hebeu.pattern.type4;

/**
 * �������ʾ ����ʽ(�̰߳�ȫ��ͬ������) ʵ�ֵ���ģʽ
 * 
 * ��ȱ��˵����
 * 	1��������̲߳���ȫ���⣻
 * 	2��Ч��̫���ˣ�ÿ���߳������ȡ���ʵ��ʱ��ִ��getInstance()������Ҫ����ͬ��������ʵ�������ֻҪִ��һ
 * ��ʵ��������͹��ˣ����������������ʵ����ֱ��return���У�����ʹ�ô˷�ʽʱ�Ƿ�����ȫ��ͬ���ģ�Ч��
 * ̫���ˣ�
 * 
 * ���ۣ���ʵ�ʿ����У����Ƽ�ʹ�����ַ�ʽʵ�ֵ���ģʽ��
 * 
 * @author 13651
 *
 */
public class Type4Test {
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
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}

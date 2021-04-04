package edu.hebeu.pattern.type7;

/**
 * �������ʾ ��̬�ڲ��� ��ʽʵ�ֵ���ģʽ
 * 
 * ��ȱ��˵����
 * 	1�����ַ�ʽ����������صĻ�������֤��ʼ��ʵ��ʱֻ��һ���߳�(�̰߳�ȫ)
 * 	2�����´��룬��̬�ڲ��෽ʽ��Singleton�����ʱ����������ʵ��������������Ҫʵ����ʱ������getInstance()
 * �����Żᵼ��SingletonInstance��װ�أ��Ӷ���ɶ�Singleton��ʵ������
 * 	3����ľ�̬����ֻ���ڵ�һ�μ������ʱ���ʼ��������������JVM�������Ǳ�֤���̵߳İ�ȫ�ԣ�������г�ʼ��
 * ʱ����߳����޷�����ģ�
 * 	4���ŵ㣺�������̲߳���ȫ�����þ�̬�ڲ����ص�ʵ���ӳټ��أ�Ч�ʸߣ�
 * 
 * ���ۣ��Ƽ�ʹ�ã�
 * 
 * �ܽ᣺
 * 
 * @author 13651
 *
 */
public class Type7Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1��hashCode = " + instance1.hashCode() + "; instance2��hashCode = " + instance2.hashCode());
		System.out.println("instance1��instance2�Ƿ���ͬһ������" + (instance1 == instance2));
		
	}
}

/*
 * ��֪��
 * 	��̬�ڲ�����ص㣺
 * 		1�������������װ��ʱ����̬�ڲ��಻�ᱻװ�أ�
 * 		2����������þ�̬�ڲ���ľ�̬����ʱ���ᵼ�¾�̬�ڲ���װ�أ�
 * 
 */
class Singleton {
	
	// 1��˽�л�������
	private Singleton() {}
	
	// 2��������̬�ڲ��࣬�������ڲ�ʵ����һ��Singleton��ʵ��
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	// 3�������ṩһ����̬�Ĺ�����������ȡinstanceʵ������
	public static Singleton getInstance() {
		return SingletonInstance.INSTANCE;
	}
	
}

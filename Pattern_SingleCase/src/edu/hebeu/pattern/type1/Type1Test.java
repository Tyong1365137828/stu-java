package edu.hebeu.pattern.type1;

/**
 * ���������ʾ ����ʽ(��̬����) ʵ�ֵ���ģʽ
 * ���裺
 * 		1��������˽�л�
 * 		2������ڲ���������
 * 		3�����Ⱪ¶һ����̬�Ĺ���������getInstance()
 * 
 * ��ȱ��˵����
 * 	1���ŵ㣺���ַ�ʽд���򵥣���������װ�ص�ʱ��ȥ���ʵ�������������߳�ͬ�����⣬���̰߳�ȫ�ģ�
 * 	2��ȱ�㣺����װ�ص�ʱ������ʵ������û�дﵽ�����ص�Ч���������ʼ���ն�δʹ�����ʵ�����������ڴ�
 * ���˷ѣ�
 * 	3�����ַ�ʽ����classLoader���Ʊ����˶��̵߳�ͬ�����⣬����instance����װ��ʱ��ʵ�����ˣ��ڵ���ģʽ��
 * ��������ǵ���getInstance()��������ʱ������װ�ص�ԭ���кܶ࣬��˲���ȷ���������ķ�ʽ(���������ľ�̬��
 * ��)������װ�أ���ʱ���ʼ��instance��û�дﵽ�����ص�Ч����
 * 
 * ���ۣ����ַ�ʽʵ�ֵĵ���ģʽ���ã����ǿ�������ڴ���˷ѣ�
 * 
 * @author 13651
 *
 */
public class Type1Test {

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
	
	// 2������ڲ���������
	private static final Singleton instance = new Singleton();
	
	// 3�������ṩһ����̬�Ĺ�����������ȡinstanceʵ������
	public static Singleton getInstance() {
		return instance;
	}
	
}

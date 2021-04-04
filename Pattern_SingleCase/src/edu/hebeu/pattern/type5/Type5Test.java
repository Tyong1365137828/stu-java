package edu.hebeu.pattern.type5;

/**
 * �������ʾ ����ʽ(�̰߳�ȫ��ͬ�������) ��ʽʵ�ֵ���ģʽ��ע��÷�ʽ��ʵû��ʵ��ͬ��
 * 
 * ��ȱ��˵����
 * 	1�����ַ�ʽ��������Ե����ַ�ʽ���иĽ�����Ϊǰ�ߵ�Ч��̫���ˣ�
 * 	2��������ϸ�������ָ÷�ʽ������ʵ��ͬ�������ã���Ϊ�����ֵ����ַ�ʽ���龰ʱ������߳̽���
 * if(instance == null)�У���ʱsynchronized(){}ֻ������Щ�߳�һ��һ���Ĵ���ʵ��instance����
 * ʱ��������instanceʵ����
 * 
 * ���ۣ���ʵ�ʿ����У�����ʹ�����ַ�ʽʵ�ֵ���ģʽ��
 * 
 * @author 13651
 *
 */
public class Type5Test {
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
			synchronized(Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}
	
}

package edu.hebeu.pattern.type6;

/**
 * �������ʾ ˫�ؼ�� ��ʽʵ�ֵ���ģʽ
 * 
 * ��ȱ��˵����
 * 	1��˫�ؼ��(Double Check)�Ƕ��߳̿����г�ʹ�õ��ģ�
 * 	2��������Ĵ�����ʾʹ������if(instance == null)��飬��֤�̸߳��Ӱ�ȫ������ʵ��������ֻ��ִ��һ�Σ�
 * ���״�ִ�������������ʹ�ⲿ��if(instance == null)�������̣߳����ڲ�������һ��if(instance == null)
 * ��ֻ֤�ܳ���һ��instance�����ᴴ�����instance�������ٴη���ʱ����ͨ������if(instance == null)���
 * �Ǻ�ֱ��return��instance��������ִ��ͬ���Ĵ����synchronized(Singleton.class)��ִ�У�����������
 * Ч�ʣ�
 * 	3���˷�ʽʵ�ֵĵ���ģʽ�̰߳�ȫ�����ӳټ��ء�Ч�ʽϸߣ�
 * 
 * ���ۣ���ʵ�ʿ����У��Ƽ�ʹ�����ַ�ʽʵ�ֵ���ģʽ��
 * 
 * @author 13651
 *
 */
public class Type6Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1��hashCode = " + instance1.hashCode() + "; instance2��hashCode = " + instance2.hashCode());
		System.out.println("instance1��instance2�Ƿ���ͬһ������" + (instance1 == instance2));
		
	}
}

class Singleton {
	
	private static volatile Singleton instance; // volatile�������������ʾ����������������仯��ֵ���̻�ˢ�������У���һ���̶��ϴﵽͬ����Ч��
	
	// 1��˽�л�������
	private Singleton() {}
	
	// 2�������ṩһ����̬�Ĺ�����������ȡinstanceʵ������
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized(Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
}

package edu.hebeu.multithreading;

/**
 * ��ȡ�߳���Ϣ��
 * 	String getName(); // ��ȡ�߳����֣�Ĭ��Ϊ��Thread-n��ע�⣺n��0��ʼ����1����
 * 	void setName(String name); // �����߳�����
 * 
 * 	static Thread currentThread(); // ��ȡ��ǰ�̶߳���
 * 	
 * @author 13651
 *
 */
public class GetThreadInfo {
	public static void main(String[] args) {
		
		Thread currentThread = Thread.currentThread(); // ��ȡ��ǰ�̶߳�����Ϊ��δ�����main()�����֣����Ե�ǰ�̶߳�������߳�
		System.out.println("��ǰ�߳�" + currentThread.getName()); // main
		
		MyThread4 mr1 = new MyThread4(); // �����̶߳���
		System.out.println("�߳�����" + mr1.getName()); // ��ȡ�߳�����
		mr1.setName("�߳�1"); // �����߳�����
		System.out.println("�޸��߳���֮���߳����֣�" + mr1.getName());
		mr1.start(); // �����߳�1
		
		MyThread4 mr2 = new MyThread4(); // �����̶߳���
		System.out.println("�߳�����" + mr2.getName()); // ��ȡ�߳�����
		mr2.setName("�߳�2"); // �����߳�����
		System.out.println("�޸��߳���֮���߳����֣�" + mr2.getName());
		mr2.start(); // �����߳�2
	}
}

class MyThread4 extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			Thread currentThread = Thread.currentThread(); // ��ȡ��ǰ�̶߳���
			
			System.out.println("��ǰ�̡߳�" + currentThread.getName() + "����i=" + i);
			
			// super��thisҲ����
//			System.out.println("��ǰ�̡߳�" + super.getName() + "����i=" + i);
//			System.out.println("��ǰ�̡߳�" + this.getName() + "����i=" + i);
		}
	}
	
}
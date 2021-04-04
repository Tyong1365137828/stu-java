package edu.hebeu.threadscheduling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * �������ѧϰJava�е��̵߳��ȵ��߳����ȼ��йصķ���
 * 	void setPriority(int newPriority); // �����̵߳����ȼ�
 *	int getPriority(); // ��ȡ�̵߳����ȼ�
 * 	
 * ע�⣺Java��������ȼ���1��������ȼ���10��Ĭ�����ȼ���5�����ȼ���ߵĻ�ȡCPUʱ��Ƭ���ܻ��һЩ(��Ҳ����ȫ�ǣ�������Ƕ��)
 * 
 * @author 13651
 *
 */
public class ThreadsSchedulingOfPriority {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("��Ϣ\\�̵߳���\\�߳����ȼ�", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ����������ķ���ı��� ��Ϣ\\�̵߳���\\�߳����ȼ� �ļ�������ָ�����̨
		System.setOut(ps); // ͨ������Ķ����޸�������򣬽���������ķ���ı��� ��Ϣ\\�̵߳���\\�߳����ȼ� �ļ�������ָ�����̨
		
		
		System.out.println("�߳����ȼ���ߣ�" + Thread.MAX_PRIORITY);
		System.out.println("�߳����ȼ���ͣ�" + Thread.MIN_PRIORITY);
		System.out.println("�߳����ȼ�Ĭ�ϣ�" + Thread.NORM_PRIORITY);
		
		Thread currentThread = Thread.currentThread(); // ��ȡ��ǰ�̣߳������߳�main
		System.out.println("���߳�main��Ĭ�����ȼ���" + currentThread.getPriority());
		
		currentThread.setPriority(1); // �������߳�main�����ȼ�Ϊ1
		System.out.println("���߳�main��ʱ�����ȼ���" + currentThread.getPriority());
		
		
		
		Thread t1 = new Thread(new MyRunnable5()); // ͨ����������Ķ��󴴽��̶߳���
		t1.setName("t1"); // �����߳�����
		System.out.println("t1�̵߳�Ĭ�����ȼ���" + t1.getPriority());
		
		t1.setPriority(10); // ����t1�̵߳����ȼ�Ϊ10
		System.out.println("t1�̴߳�ʱ�����ȼ���" + t1.getPriority());
		
		t1.start(); // ����t1�߳�

		for(int i = 0; i < 10000; i++) {
			System.out.println("��ǰ�̡߳�" + currentThread.getName() + "����i=" + i);
		}
		
		
	}
}

class MyRunnable5 implements Runnable {

	@Override
	public void run() {
		System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "�������ȼ�" + Thread.currentThread().getPriority());
		for(int i = 0; i < 10000; i++) {
			System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "����i=" + i);
		}
		
	}
	
}

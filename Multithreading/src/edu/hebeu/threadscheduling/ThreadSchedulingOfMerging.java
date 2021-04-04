package edu.hebeu.threadscheduling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * ���������ʾѧϰ�̺߳ϲ�
 * 	void join(); // �ϲ��̣߳��ȴ����߳���ֹ��
	void join(long millisecond) // �����Ǻ��룻�ϲ��̣߳��ȴ����߳���ֹ��ʱ���Ϊmillisecond���룻
	void join(long millisecond, long nanosecond) // ����1�Ǻ��룬�����������룻�ϲ��̣߳��ȴ����߳���ֹ��ʱ���Ϊmillisecond���� + nanosecond���룻
	// �ϲ��߳�(���̱߳�ɵ��߳�)������
	class MyThread1 extends Thread { // MyThread1�߳���
		public void doSonme() {
			MyThread2 mt2 = new MyThread2(); // ����MyThread2�߳���Ķ���
			mt2.join(); // ��ǰ�߳̽���������mt2�߳�ִ�У�ֱ��mt2�߳�ִ����ϣ���ǰ�̲߳ſ��Լ�������ִ��
		}
	}
	class MyThread2 extends Thread { // MyThread2�߳���
	}
	
	ע�⣺���ַ�ʽ���̺߳ϲ����ǽ��̵߳�����ջ�ϲ��ˣ���������ջ֮�������Э���ȴ��Ĺ�ϵ������
	
 * @author 13651
 *
 */
public class ThreadSchedulingOfMerging {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("��Ϣ\\�̵߳���\\�̺߳ϲ�", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ����������ķ���ı��� ��Ϣ\\�̵߳���\\�̺߳ϲ� �ļ�������ָ�����̨
		System.setOut(ps); // ͨ������Ķ����޸�������򣬽���������ķ���ı��� ��Ϣ\\�̵߳���\\�̺߳ϲ� �ļ�������ָ�����̨
		
		
		Thread t1 = new Thread(new MyRunnable3()); // ͨ����������Ķ��󴴽��̶߳���
		t1.setName("t1"); // �����̵߳�����Ϊt1
		t1.setPriority(1); // ����t1���߳����ȼ�Ϊ1
		t1.start(); // ����t1�߳�
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "����i=" + i);
			
			if(i == 998) { // ������߳�main��ʣ1��ѭ�����
				try {
					System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "��������");
					t1.join(); // t1�ϲ�����ǰ�߳��У���ǰ�߳����裬ֱ��t1�߳�ִ�н���
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}

class MyRunnable3 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "����i=" + i);
		}
		System.out.println(Thread.currentThread().getName() + "ִ����ϣ�����");
	}
	
}

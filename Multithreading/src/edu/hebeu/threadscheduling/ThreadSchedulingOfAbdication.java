package edu.hebeu.threadscheduling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * �������չʾѧϰ�̵߳��ȵ��߳���λ����
 * 	static void yield(); // �߳���λ����ͣ��ǰ����ִ�е��̣߳���ִ�������߳�
 * 
 * yield()���������������õ�ǰ�߳���λ���ø������߳�ʹ�ã�yield()������ִ�л��õ�ǰ�̴߳� ����״̬ �ص� ����״̬��
	ע�⣺�ڻص�����״̬֮���п��ܻ���������
 * @author 13651
 *
 */
public class ThreadSchedulingOfAbdication {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("��Ϣ\\�̵߳���\\�߳���λ", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ����������ķ���ı��� ��Ϣ\\�̵߳���\\�߳���λ �ļ�������ָ�����̨
		System.setOut(ps); // ͨ������Ķ����޸�������򣬽���������ķ���ı��� ��Ϣ\\�̵߳���\\�߳���λ �ļ�������ָ�����̨
		
		
		Thread t1 = new Thread(new MyRunnable()); // ͨ����������Ķ��󴴽��̶߳���
		t1.setName("t1"); // �����̵߳�����
		t1.start(); // ����t1�߳�
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "����i=" + i);
		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			if(i % 100 == 0) { // ����100��������0(��ÿ100��)
				System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "���Ѿ���λ��������״̬��ɾ���״̬");
				Thread.yield(); // ������λ
			}
			System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "����i=" + i);
		}
	}
	
}

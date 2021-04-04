package edu.hebeu.multithreading;

/**
 * ͨ���ڶ��ַ�ʽʵ���̣߳�
 * 	��дһ���࣬ʵ��java.lang.Runnable�ӿڣ���дrun()������(ע���ʱ����಻���߳��࣬����һ���������࣬��������һ���߳�)
 * 	ͨ��Thread��Ĺ��췽����������Ŀ�������Ķ����룬�����̶߳���
 * 	����start()���������߳�
 * 
 * @author 13651
 *
 */
public class Multithreading02 {
	public static void main(String[] args) {
//		MyRunnable mr = new MyRunnable(); // ������������Ķ���
//		Thread myThread = new Thread(mr); // ͨ����������Ķ��󴴽��̶߳���
		Thread myThread = new Thread(new MyRunnable()); // �ϲ���������
		
		myThread.start(); // �����߳�
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("Main��ջ�̣߳�i=" + i);
		}
		
	}
}

// ������������
class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("��������(��֧�߳�)��i=" + i);
		}
	}
	
}
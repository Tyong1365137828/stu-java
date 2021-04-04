package edu.hebeu.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �����������ѧϰLock���ʹ�÷���
 * 
 * ֮ǰΪ�˽���̰߳�ȫ����ʹ�õķ�����ʹ��synchronized
 * 	1��ͬ�������
 * 	2��ͬ������
 * ���Է��֣����ϵĶ���ʹ��JVM�ṩ����������ʽ������
 * 
 * ��JDK1.5�󣬿���ʹ��Lock�����̰߳�ȫ���⣻
 * ��������ʾ��������Ҫͨ��lock()������������������ͨ��unlock()�����ͷ�����
 * 
 * @author 13651
 *
 */
public class LockStu {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(ticket, "1�Ŵ���").start();
		new Thread(ticket, "2�Ŵ���").start();
		new Thread(ticket, "3�Ŵ���").start();
	}
}

class Ticket implements Runnable {

	private int tickCount = 100; // 100��Ʊ
	
	private Lock myLock = new ReentrantLock(); // ����Lock����ʵ��
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(200); // ˯200ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			myLock.lock(); // ��ס
			try {
				if(tickCount == 0) {
					System.out.println("Ʊ���ۿ�");
					break;
				}
				System.out.println(Thread.currentThread().getName() + "�����۳�Ʊ��ʣ��Ʊ����" + --tickCount);
			} finally {
				myLock.unlock(); // ������ͷ���
			}
		}
	}
	
}

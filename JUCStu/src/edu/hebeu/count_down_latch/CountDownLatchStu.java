package edu.hebeu.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * �������չʾCountDownLatch���ʹ��
 * 
 * ����(CountDownLatch)��ָ�����ĳЩ����ʱ��ֻ�����������̵߳�����ȫ����ɣ���ǰ����ż���ִ�У�
 * 
 * �籾��ļ��������߳�ȫ��ִ���������ʱ��
 * 
 * @author 13651
 *
 */
public class CountDownLatchStu {

	public static void main(String[] args) {
		
		final CountDownLatch cdLatch = new CountDownLatch(10); // ��ʾ��10���߳�ʹ�������������
		
		MyRunnable myRunnable = new MyRunnable(cdLatch);
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10; i++) { // ����10���߳�
			new Thread(myRunnable).start();
		}
		try {
			cdLatch.await(); // �ж�
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("�����߳�ִ����ĺķ�ʱ����" + (end - start) + "ms");
		
	}
}

class MyRunnable implements Runnable {

	private CountDownLatch cdLatch;
	
	public MyRunnable(CountDownLatch cdLatch) {
		this.cdLatch = cdLatch;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			try {
				for(int i = 0; i <= 5000000; i++) {
					if(i %2 == 0) {
						System.out.println("ThreadName = " + Thread.currentThread().getName() +"---" + i);
					}
				}
			} finally {
				cdLatch.countDown(); // ���߳�ִ��������һ�������ñ��������count--
			}
		}
	}
}

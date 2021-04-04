package edu.hebeu.multithreading;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ���������ʾʹ���̳߳ش����̶߳���
 * ʹ���̳߳ش�������ĺô���
 * 	1�������Ӧ�ٶ�(�����˴����̵߳�ʱ��)
 * 	2��������Դ����(�ظ������̳߳��е��̣߳�����Ҫÿ�ζ�����)
 * 	3�������̹߳���
 * 	
 * ���÷�����
 * 	setCorePoolSize(int corePoolSize); // ���ĳصĴ�С
 * 	maximumPoolSize(int maximumPoolSize); // ����߳���
 * 	keepAliveTime(long time, TimeUnit unit); // �߳�û������ʱ����ౣ��೤ʱ������ֹ
 * 
 * ��֪��
 * 	Executors���̳߳صĹ����ࡢ������
 * 	ExecutorService���������̳߳ؽӿڣ�������ʵ������ThreadPoolExecutor
 * 
 * 
 * ��˽��ǰ���������̵߳����ӣ����Ե�֪һ��������Ĵ𰸣������̵߳ķ�ʽ�� 4��
 * @author 13651
 *
 */
public class Multithreading05 {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("��Ϣ\\�̳߳�\\��־��Ϣ", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setOut(ps);
		
		ExecutorService executorService = Executors.newFixedThreadPool(10); // ����һ�����10���̵߳��̳߳�
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService; // ��ExecutorService��ǿתΪThreadPoolExecutor
		
		// ִ��ָ�����̲߳���
		threadPoolExecutor.execute(new MyThread1()); // �ʺ���ʵ��Runnable�ӿڵ��߳����ʵ������
		threadPoolExecutor.execute(new MyThread2()); // �ʺ���ʵ��Runnable�ӿڵ��߳����ʵ������
//		threadPoolExecutor.submit(Callable callable); // �ʺ���ʵ��Callable�ӿڵ��߳����ʵ������
		
		// �ر��̳߳ض���
		threadPoolExecutor.shutdown();
		
	}
}


class MyThread1 implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			if(i % 2 != 0) System.out.println(Thread.currentThread().getName() + "��i = " + i);
		}
	}
}

class MyThread2 implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			if(i % 2 == 0) System.out.println(Thread.currentThread().getName() + "��i = " + i);
		}
		
	}
}

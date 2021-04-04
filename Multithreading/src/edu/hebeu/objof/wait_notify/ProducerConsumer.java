package edu.hebeu.objof.wait_notify;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ʹ��wait()������notify()����ʵ�� "�����ߺ�������ģʽ";
 * 
 * ʲô�� "�����ߺ�������ģʽ" ��
 * 	�����̸߳��������������̸߳������ѣ�
 * 	�����̺߳������߳�Ҫ�ﵽ���⣻
 * 	����һ�������ҵ������������������������Ҫʹ��wait()������notify()������
 * 
 * wait()������notify()���������̶߳���ķ�����������ͨJava�����еķ�����
 * 
 * wait()������notify()�����������߳�ͬ���Ļ���֮�ϡ���Ϊ���߳�Ҫͬʱ����һ���ֿ⣬���̰߳�ȫ���⣻
 * 
 * wait()���������ã�Object o = new Object(); o.wait(); ��ʾ������o�����ϻ���߳�t����ȴ�״̬�������ͷŵ�t�߳�֮ǰռ�е�o���������
 * 
 * notify()���������ã�Object o = new Object(); o.notify(); ��ʾ������o�����ϵȴ����߳�t���ѣ�ֻ��֪ͨ�������ͷ�o����֮ǰռ�е�����
 * 
 * ģ���������£�
 * 	�ֿ����List���ϣ�
 * 	List���ϼ���ֻ�ܴ洢1��Ԫ�أ�1��Ԫ�ؾͱ�ʾ�ֿ����ˣ�0��Ԫ�ؾͱ�ʾ�ֿ���ˣ�
 * 	��֤List������Զ�������洢1��Ԫ�أ�
 * 	ʵ������Ч��������һ��������һ����
 * 
 * @author 13651
 *
 */
public class ProducerConsumer {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("��Ϣ\\�����ߺ�������ģʽ\\��־��Ϣ", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ����������ķ���ı��� ��Ϣ\\�����ߺ�������ģʽ\\��־��Ϣ �ļ�������ָ�����̨
		System.setOut(ps); // ͨ������Ķ����޸�������򣬽���������ķ���ı��� ��Ϣ\\�����ߺ�������ģʽ\\��־��Ϣ �ļ�������ָ�����̨
		
		
		List<Object> list = new ArrayList<>(); // ����һ���ֿ����һ2ʹ�����̶߳���������̶߳���������ֿ�
		
		Thread producerThread = new Thread(new Producer(list)); // �����������̶߳���
		Thread consumerThread = new Thread(new Consumer(list)); // �����������̶߳���
		
		producerThread.setName("-�������߳�-");
		consumerThread.setName("-�������߳�-");
		
		consumerThread.start(); // �������̶߳�������
		producerThread.start(); // �������̶߳�������
//		consumerThread.start(); // �������̶߳�������
		
		
	}
}

// �����߳�
class Producer implements Runnable {
	
	private List<Object> list; // �ֿ�
	public Producer(List<Object> list) {
		this.list = list;
	}

	@Override
	public void run() {
		while(true) {
			synchronized(list) {
				if(list.size() > 0) { // ����ֿ��ڵ�Ԫ�ش���0�����ֿ�����
//				if(list.size() == 10) { // ����ֿ��ڵĵ���10�����ֿ�����
					try {
						System.out.println(Thread.currentThread().getName() + "�ȴ����ֿ�Ԫ�أ�" + list.size() + "���ͷŲֿ���...");
						list.wait(); // �����߳̽���ȴ�״̬�������ͷŵ�list������
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// ����ִ�е��ˣ���ʾ�ֿ�û�������������̻߳��ܼ�������
				Object obj = new Object();
				list.add(obj);
				System.out.println(Thread.currentThread().getName() + "����������Ԫ�أ�" + obj + "���ֿ�Ԫ�أ�" + list.size() + "�������������߳�");
				
//				list.notify(); // �����������߳�
				list.notifyAll(); // �����������߳�
			}
		}
	}
	
}

// �����߳�
class Consumer implements Runnable {
	
	private List<Object> list; // �ֿ�
	public Consumer(List<Object> list) {
		this.list = list;
	}
	@Override
	public void run() {
		while(true) {
			synchronized(list) {
				if(list.size() == 0) { // ����ֿ��ڵ�Ԫ�ص���0����ʾ�ֿ����
					try {
						System.out.println(Thread.currentThread().getName() + "�ȴ����ֿ�Ԫ�أ�" + list.size() + "���ͷŲֿ���...");
						list.wait(); // �������߳̽���ȴ����ͷ�list������
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// ����ִ�е��ˣ���ʾ�ֿⲻΪ�գ��������̻߳��ܼ�������
				Object obj = list.remove(0);
				System.out.println(Thread.currentThread().getName() + "����������Ԫ�أ�" + obj + "���ֿ�Ԫ�أ�" + list.size() + "�������������߳�");
				
//				list.notify(); // �����������߳�
				list.notifyAll(); // �����������߳�
			}
		}
	}
	
}

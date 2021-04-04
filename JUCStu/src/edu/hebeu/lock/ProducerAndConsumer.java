package edu.hebeu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �������չʾ��ͳ�������������߰���
 * @author 13651
 *
 */
public class ProducerAndConsumer {
	public static void main(String[] args) {
//		Store store1 = new Store(); // ��ͳ��ʽ����
		Store2 store2 = new Store2(); // Lock��ʽ����
		
//		Producer producer = new Producer(store1);
//		Consumer consumer = new Consumer(store1);
		Producer producer = new Producer(store2);
		Consumer consumer = new Consumer(store2);
		
		new Thread(producer, "������A").start();
		new Thread(producer, "������B").start();
		new Thread(producer, "������C").start();
		new Thread(consumer, "������1").start();	
		new Thread(consumer, "������2").start();	
		new Thread(consumer, "������3").start();	
	}
}

/**
 * �ֿ�
 * ʹ�ô�ͳ�ķ�ʽʵ��
 * @author 13651
 *
 */
class Store {
	
	private int productCount = 0; // �ֿ�Ĳ�Ʒ����
	
	/**
	 * ����
	 */
	public synchronized void put() {
		// �����Ʒ���������ڵ���10����������ע��Ҫʹ��while����wait()�����������ж�������ߺ��������߳�����ʱ�������ٵȴ���
		while(productCount >= 1) {
			System.out.println("�����������ߵȴ���");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * ���ｨ�鲻ʹ��else���������else�����Է��������ĳ���߳���û��ֹͣ�ģ�
		 * ��Ϊ��else��䣬��ʱ��һ���߳������������һ��ִ�У���������ִ��if������else�������
		 * ��ִ��(else�ڵ�notfiyAll()�޷�ִ�У���������wait�����޷����ѣ��Ҹ��̴߳�ʱ�Ѿ�ִ������)��
		 * ��ĳ���߳���if�ڵ�wait()���޷�����һ���̻߳��ѣ����̻߳�����һֱwait()��״̬�����³����޷�
		 * ��ֹ��
		 */
		System.out.println(Thread.currentThread().getName() + "���ѽ�������Ʒ��" + ++productCount);
		this.notifyAll();
	}
	
	/**
	 * ����
	 */
	public synchronized void out() {
		// �����Ʒ������С�ڵ���0����ȱ����ע��Ҫʹ��while����wait()�����������ж�������ߺ��������߳�����ʱ�������ٵȴ���
		while(productCount <= 0) {
			System.out.println("ȱ���������ߵȴ���");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * ���ｨ�鲻ʹ��else���������else�����Է��������ĳ���߳���û��ֹͣ�ģ�
		 * ��Ϊ��else��䣬��ʱ��һ���߳������������һ��ִ�У���������ִ��if������else�������
		 * ��ִ��(else�ڵ�notfiyAll()�޷�ִ�У���������wait�����޷����ѣ��Ҹ��̴߳�ʱ�Ѿ�ִ������)��
		 * ��ĳ���߳���if�ڵ�wait()���޷�����һ���̻߳��ѣ����̻߳�����һֱwait()��״̬�����³����޷�
		 * ��ֹ��
		 */
		System.out.println(Thread.currentThread().getName() + "���ѳ�������Ʒ��" + --productCount);
		this.notifyAll();
	}
	
}

/**
 * �ֿ�
 * ʹ��Lock�ķ�ʽʵ��
 * @author 13651
 *
 */
class Store2 {
	
	private int productCount = 0; // �ֿ�Ĳ�Ʒ����
	private Lock lock = new ReentrantLock(); // ��
	private Condition condition = lock.newCondition(); // ͨ���������ȡ������󣬸ö�������ʵ��������wait��notify�Ĳ���
	
	
	/**
	 * ����
	 */
	public void put() {
		lock.lock(); // ����
		try {
			// �����Ʒ���������ڵ���10����������ע��Ҫʹ��while����wait()�����������ж�������ߺ��������߳�����ʱ�������ٵȴ���
			while(productCount >= 1) {
				System.out.println("�����������ߵȴ���");
				try {
					condition.await(); // �൱��wait
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "���ѽ�������Ʒ��" + ++productCount);
			condition.signalAll(); // �൱��notifyAll
		} finally {
			lock.unlock(); // �ͷ���
		}
	}
	
	/**
	 * ����
	 */
	public void out() {
		lock.lock(); // ����
		try {
			// �����Ʒ������С�ڵ���0����ȱ����ע��Ҫʹ��while����wait()�����������ж�������ߺ��������߳�����ʱ�������ٵȴ���
			while(productCount <= 0) {
				System.out.println("ȱ���������ߵȴ���");
				try {
					condition.await(); // �൱��wait
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "���ѳ�������Ʒ��" + --productCount);
			condition.signalAll(); // �൱��notifyAll
		} finally {
			lock.unlock(); // �ͷ���
		}
	}
}

/**
 * ������
 * @author 13651
 *
 */
class Producer implements Runnable {
	private Store store;
	
	private Store2 store2;
	
	public Producer(Store store) {
		this.store = store;
	}
	
	public Producer(Store2 store2) {
		this.store2 = store2;
	}

	@Override
	public void run() {
		for(int i = 0; i < 30; i++) { // ����30��
			try {
				Thread.sleep(200); // ģ���ӳ�200ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			store.put(); // ��������������
			store2.put(); // ��������������
		}
	}
}

/**
 * ������
 * @author 13651
 *
 */
class Consumer implements Runnable {
	private Store store;
	
	private Store2 store2;
	
	public Consumer(Store store) {
		this.store = store;
	}
	
	public Consumer(Store2 store2) {
		this.store2 = store2;
	}

	@Override
	public void run() {
		for(int i = 0; i < 30; i++) { // ����30��
//			store.out(); // ��������������
			store2.out(); // ��������������
		}
	}
}

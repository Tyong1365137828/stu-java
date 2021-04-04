package edu.hebeu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这个例子展示传统的生产者消费者案例
 * @author 13651
 *
 */
public class ProducerAndConsumer {
	public static void main(String[] args) {
//		Store store1 = new Store(); // 传统方式控制
		Store2 store2 = new Store2(); // Lock方式控制
		
//		Producer producer = new Producer(store1);
//		Consumer consumer = new Consumer(store1);
		Producer producer = new Producer(store2);
		Consumer consumer = new Consumer(store2);
		
		new Thread(producer, "生产者A").start();
		new Thread(producer, "生产者B").start();
		new Thread(producer, "生产者C").start();
		new Thread(consumer, "消费者1").start();	
		new Thread(consumer, "消费者2").start();	
		new Thread(consumer, "消费者3").start();	
	}
}

/**
 * 仓库
 * 使用传统的方式实现
 * @author 13651
 *
 */
class Store {
	
	private int productCount = 0; // 仓库的产品数量
	
	/**
	 * 进货
	 */
	public synchronized void put() {
		// 如果产品的数量大于等于10，即货满；注意要使用while包裹wait()方法，否则当有多个生产者和消费者线程启动时会出现虚假等待！
		while(productCount >= 1) {
			System.out.println("货满，生产者等待！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * 这里建议不使用else，如果加上else，可以分析在最后某个线程是没有停止的，
		 * 因为有else语句，此时另一个线程如果如果是最后一次执行，导致其在执行if的语句后，else的语句无
		 * 法执行(else内的notfiyAll()无法执行，则其他的wait进程无法唤醒，且该线程此时已经执行完了)，
		 * 当某个线程在if内的wait()就无法被另一个线程唤醒，该线程会陷入一直wait()的状态，导致程序无法
		 * 终止！
		 */
		System.out.println(Thread.currentThread().getName() + "：已进货，产品：" + ++productCount);
		this.notifyAll();
	}
	
	/**
	 * 出货
	 */
	public synchronized void out() {
		// 如果产品的数量小于等于0，即缺货；注意要使用while包裹wait()方法，否则当有多个生产者和消费者线程启动时会出现虚假等待！
		while(productCount <= 0) {
			System.out.println("缺货，消费者等待！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * 这里建议不使用else，如果加上else，可以分析在最后某个线程是没有停止的，
		 * 因为有else语句，此时另一个线程如果如果是最后一次执行，导致其在执行if的语句后，else的语句无
		 * 法执行(else内的notfiyAll()无法执行，则其他的wait进程无法唤醒，且该线程此时已经执行完了)，
		 * 当某个线程在if内的wait()就无法被另一个线程唤醒，该线程会陷入一直wait()的状态，导致程序无法
		 * 终止！
		 */
		System.out.println(Thread.currentThread().getName() + "：已出货，产品：" + --productCount);
		this.notifyAll();
	}
	
}

/**
 * 仓库
 * 使用Lock的方式实现
 * @author 13651
 *
 */
class Store2 {
	
	private int productCount = 0; // 仓库的产品数量
	private Lock lock = new ReentrantLock(); // 锁
	private Condition condition = lock.newCondition(); // 通过锁对象获取这个对象，该对象用来实现类似于wait、notify的操作
	
	
	/**
	 * 进货
	 */
	public void put() {
		lock.lock(); // 上锁
		try {
			// 如果产品的数量大于等于10，即货满；注意要使用while包裹wait()方法，否则当有多个生产者和消费者线程启动时会出现虚假等待！
			while(productCount >= 1) {
				System.out.println("货满，生产者等待！");
				try {
					condition.await(); // 相当于wait
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "：已进货，产品：" + ++productCount);
			condition.signalAll(); // 相当于notifyAll
		} finally {
			lock.unlock(); // 释放锁
		}
	}
	
	/**
	 * 出货
	 */
	public void out() {
		lock.lock(); // 上锁
		try {
			// 如果产品的数量小于等于0，即缺货；注意要使用while包裹wait()方法，否则当有多个生产者和消费者线程启动时会出现虚假等待！
			while(productCount <= 0) {
				System.out.println("缺货，消费者等待！");
				try {
					condition.await(); // 相当于wait
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "：已出货，产品：" + --productCount);
			condition.signalAll(); // 相当于notifyAll
		} finally {
			lock.unlock(); // 释放锁
		}
	}
}

/**
 * 生产者
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
		for(int i = 0; i < 30; i++) { // 生产30次
			try {
				Thread.sleep(200); // 模拟延迟200ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			store.put(); // 进货，进行生产
			store2.put(); // 进货，进行生产
		}
	}
}

/**
 * 消费者
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
		for(int i = 0; i < 30; i++) { // 消费30次
//			store.out(); // 出货，进行消费
			store2.out(); // 进货，进行生产
		}
	}
}

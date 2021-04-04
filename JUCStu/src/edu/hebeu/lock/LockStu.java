package edu.hebeu.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这个例子用来学习Lock类的使用方法
 * 
 * 之前为了解决线程安全问题使用的方法：使用synchronized
 * 	1、同步代码块
 * 	2、同步方法
 * 可以发现，以上的都是使用JVM提供的锁，是隐式的锁！
 * 
 * 自JDK1.5后，可以使用Lock类解决线程安全问题；
 * 该锁是显示的锁，需要通过lock()方法上锁，且最后必须通过unlock()方法释放锁！
 * 
 * @author 13651
 *
 */
public class LockStu {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(ticket, "1号窗口").start();
		new Thread(ticket, "2号窗口").start();
		new Thread(ticket, "3号窗口").start();
	}
}

class Ticket implements Runnable {

	private int tickCount = 100; // 100张票
	
	private Lock myLock = new ReentrantLock(); // 创建Lock对象实例
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(200); // 睡200ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			myLock.lock(); // 锁住
			try {
				if(tickCount == 0) {
					System.out.println("票已售空");
					break;
				}
				System.out.println(Thread.currentThread().getName() + "：已售出票，剩余票数：" + --tickCount);
			} finally {
				myLock.unlock(); // 在最后释放锁
			}
		}
	}
	
}

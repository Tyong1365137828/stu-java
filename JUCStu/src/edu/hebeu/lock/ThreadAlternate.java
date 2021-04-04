package edu.hebeu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这个例子演示线程交替执行
 * 
 * 编写一个程序，开启3个线程，这三个线程的名字分别是A、B、C，每个线程
 * 将自己的名字在控制台打印10遍，要求输出的结果必须按顺序显示；
 * 如：ABCABCABC......或AABBBCCCCCCAABBBCCCCCC......
 * @author 13651
 *
 */
public class ThreadAlternate {
	public static void main(String[] args) {
		
		MyAlternate alternate = new MyAlternate();
		
		new Thread(() -> {
			for(int i = 0; i < 6; i++) { // 打印六次A，即轮询6次
				alternate.loopA();
			}
		}, "A").start(); // 启动A线程，执行loopA()方法打印A
		
		new Thread(() -> {
			for(int i = 0; i < 6; i++) { // 打印六次C，即轮询6次
				alternate.loopB();
			}
		}, "B").start(); // 启动B线程，执行loopB()方法打印B
		
		new Thread(() -> {
			for(int i = 0; i < 6; i++) { // 打印六次C，即轮询6次
				alternate.loopC();
			}
		}, "C").start(); // 启动C线程，执行loopC()方法打印C
		
	}
}

class MyAlternate {
	private int number = 1; // 用来表示当前执行的线程，1就是A、2就是B，3就是C
	private Lock lock = new ReentrantLock();
	
	private Condition conditionA = lock.newCondition(); // A的通信对象
	private Condition conditionB = lock.newCondition(); // B的通信对象
	private Condition conditionC = lock.newCondition(); // C的通信对象
	
	public void loopA() {
		lock.lock(); // 上锁
		try {
			/*判断*/
			if(number != 1) { // 如果标记不是1，即不是A线程
				try {
					conditionA.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*程序执行到此，说明是A线程，则打印*/
			System.out.print(Thread.currentThread().getName() + "\t");
			/*唤醒B线程*/
			number = 2; // 修改标记为2
			conditionB.signal();
		} finally {
			lock.unlock(); // 释放锁
		}
	}
	
	public void loopB() {
		lock.lock(); // 上锁
		try {
			/*判断*/
			if(number != 2) { // 如果标记不是2，即不是B线程
				try {
					conditionB.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*程序执行到此，说明是B线程，则打印*/
			System.out.print(Thread.currentThread().getName() + "\t");
			/*唤醒C线程*/
			number = 3; // 修改标记为3
			conditionC.signal();
		} finally {
			lock.unlock(); // 释放锁
		}
	}
	
	public void loopC() {
		lock.lock(); // 上锁
		try {
			/*判断*/
			if(number != 3) { // 如果标记不是3，即不是C线程
				try {
					conditionC.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*程序执行到此，说明是C线程，则打印*/
			System.out.print(Thread.currentThread().getName() + "\t");
			/*唤醒A线程*/
			number = 1; // 修改标记为1
			conditionA.signal();
		} finally {
			lock.unlock(); // 释放锁
		}
	}
	
}

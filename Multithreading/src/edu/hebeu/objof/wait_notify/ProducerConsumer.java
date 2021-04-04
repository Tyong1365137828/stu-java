package edu.hebeu.objof.wait_notify;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用wait()方法和notify()方法实现 "生产者和消费者模式";
 * 
 * 什么是 "生产者和消费者模式" ？
 * 	生产线程负责生产，消费线程负责消费；
 * 	生产线程和消费线程要达到均衡；
 * 	这是一种特殊的业务需求，在这种特殊的情况下需要使用wait()方法和notify()方法；
 * 
 * wait()方法和notify()方法不是线程对象的方法，而是普通Java对象都有的方法；
 * 
 * wait()方法和notify()方法建立在线程同步的基础之上。因为多线程要同时操作一个仓库，有线程安全问题；
 * 
 * wait()方法的作用：Object o = new Object(); o.wait(); 表示让正在o对象上活动的线程t进入等待状态；并且释放掉t线程之前占有的o对象的锁；
 * 
 * notify()方法的作用：Object o = new Object(); o.notify(); 表示让正在o对象上等待的线程t唤醒，只是通知，不会释放o对象之前占有的锁；
 * 
 * 模拟需求如下：
 * 	仓库采用List集合；
 * 	List集合假设只能存储1个元素，1个元素就表示仓库满了，0个元素就表示仓库空了；
 * 	保证List集合永远都是最多存储1个元素；
 * 	实现这种效果：生产一个，消费一个；
 * 
 * @author 13651
 *
 */
public class ProducerConsumer {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("信息\\生产者和消费者模式\\日志信息", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 将此输出流的方向改变至 信息\\生产者和消费者模式\\日志信息 文件，不在指向控制台
		System.setOut(ps); // 通过上面的对象修改输出方向，将此输出流的方向改变至 信息\\生产者和消费者模式\\日志信息 文件，不在指向控制台
		
		
		List<Object> list = new ArrayList<>(); // 创建一个仓库对象，一2使生产线程对象和消费线程对象共享这个仓库
		
		Thread producerThread = new Thread(new Producer(list)); // 创建生产者线程对象
		Thread consumerThread = new Thread(new Consumer(list)); // 创建消费者线程对象
		
		producerThread.setName("-生产者线程-");
		consumerThread.setName("-消费者线程-");
		
		consumerThread.start(); // 消费者线程对象启动
		producerThread.start(); // 生产者线程对象启动
//		consumerThread.start(); // 消费者线程对象启动
		
		
	}
}

// 生产线程
class Producer implements Runnable {
	
	private List<Object> list; // 仓库
	public Producer(List<Object> list) {
		this.list = list;
	}

	@Override
	public void run() {
		while(true) {
			synchronized(list) {
				if(list.size() > 0) { // 如果仓库内的元素大于0，即仓库满了
//				if(list.size() == 10) { // 如果仓库内的等于10，即仓库满了
					try {
						System.out.println(Thread.currentThread().getName() + "等待，仓库元素：" + list.size() + "，释放仓库锁...");
						list.wait(); // 生产线程进入等待状态，并且释放掉list对象锁
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// 程序执行到此，表示仓库没有满，则生产线程还能继续生产
				Object obj = new Object();
				list.add(obj);
				System.out.println(Thread.currentThread().getName() + "运作，生产元素：" + obj + "，仓库元素：" + list.size() + "；唤醒消费者线程");
				
//				list.notify(); // 唤醒消费者线程
				list.notifyAll(); // 唤醒消费者线程
			}
		}
	}
	
}

// 消费线程
class Consumer implements Runnable {
	
	private List<Object> list; // 仓库
	public Consumer(List<Object> list) {
		this.list = list;
	}
	@Override
	public void run() {
		while(true) {
			synchronized(list) {
				if(list.size() == 0) { // 如果仓库内的元素等于0，表示仓库空了
					try {
						System.out.println(Thread.currentThread().getName() + "等待，仓库元素：" + list.size() + "，释放仓库锁...");
						list.wait(); // 消费者线程进入等待，释放list对象锁
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// 程序执行到此，表示仓库不为空，消费者线程还能继续消费
				Object obj = list.remove(0);
				System.out.println(Thread.currentThread().getName() + "运作，消费元素：" + obj + "，仓库元素：" + list.size() + "；唤醒生产者线程");
				
//				list.notify(); // 唤醒生产者线程
				list.notifyAll(); // 唤醒生产者线程
			}
		}
	}
	
}

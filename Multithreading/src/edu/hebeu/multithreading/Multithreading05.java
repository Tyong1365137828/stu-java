package edu.hebeu.multithreading;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 这个例子演示使用线程池创建线程对象，
 * 使用线程池创建对象的好处：
 * 	1、提高响应速度(减少了创建线程的时间)
 * 	2、降低资源消耗(重复利用线程池中的线程，不需要每次都创建)
 * 	3、便于线程管理：
 * 	
 * 常用方法：
 * 	setCorePoolSize(int corePoolSize); // 核心池的大小
 * 	maximumPoolSize(int maximumPoolSize); // 最大线程数
 * 	keepAliveTime(long time, TimeUnit unit); // 线程没有任务时，最多保存多长时间后会终止
 * 
 * 须知：
 * 	Executors：线程池的工具类、工厂类
 * 	ExecutorService：真正的线程池接口，常见的实现类是ThreadPoolExecutor
 * 
 * 
 * 因此结合前几个创建线程的例子，可以得知一个面试题的答案：创建线程的方式有 4种
 * @author 13651
 *
 */
public class Multithreading05 {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("信息\\线程池\\日志信息", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setOut(ps);
		
		ExecutorService executorService = Executors.newFixedThreadPool(10); // 创建一个最多10个线程的线程池
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService; // 将ExecutorService类强转为ThreadPoolExecutor
		
		// 执行指定的线程操作
		threadPoolExecutor.execute(new MyThread1()); // 适合于实现Runnable接口的线程类的实例对象
		threadPoolExecutor.execute(new MyThread2()); // 适合于实现Runnable接口的线程类的实例对象
//		threadPoolExecutor.submit(Callable callable); // 适合于实现Callable接口的线程类的实例对象
		
		// 关闭线程池对象
		threadPoolExecutor.shutdown();
		
	}
}


class MyThread1 implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			if(i % 2 != 0) System.out.println(Thread.currentThread().getName() + "：i = " + i);
		}
	}
}

class MyThread2 implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			if(i % 2 == 0) System.out.println(Thread.currentThread().getName() + "：i = " + i);
		}
		
	}
}

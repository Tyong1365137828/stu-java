package edu.hebeu.thread_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池：提供一个线程队列，队列中保存着所有等待状态的线程，避免了创建/销毁线程的一些额外开销，提高了响应的速度
 * 
 * 线程池的体系结构：
 * 	java.util.concurrent.Executor：负责线程使用与调度的根接口
 * 		|--ExecutorService：子接口，负责线程主要接口
 * 			|--ThreadPoolExecutor：线程池的实现类
 * 			|--ScheduledExecutorService：子接口，负责线程的调度
 * 				|--ScheduleThreadPoolExecutor：实现类，继承了ThreadPoolExecutor，又实现了ScheduleExecutorService
 * 
 * 线程池的工具类：Executors
 * 	ExecutorService newFixedThreadPool(int nThreads); // 创建固定容量大小的线程池
 * 	ExecutorService newCachedThreadPool(); // 创建缓存线程池，容量不固定，可以根据需求自动的更改数量
 * 	ExecutorService newSingleThreadExecutor(); // 创建容量为单个的线程池，即线程池中只有一个线程
 * 	ScheduledExecutorService new ScheduledThreadPool(); // 创建固定容量的线程池，可以延迟或定时的执行任务
 * 
 * @author 13651
 *
 */
public class ThreadPoolStu {
	public static void main(String[] args) {
//		runnableType(); // 调用Runnable方式
//		callableType(); // 调用Callable方式
		newScheduledThreadPoolMethod(); // 使用newScheduledThreadPool()创建的线程池来学习线程调度

	}
	
	/**
	 * Runnable的方式
	 */
	private static void runnableType() {
		MyRunnable myRunnable = new MyRunnable();
		
		// 1、创建线程池对象
		ExecutorService pool = Executors.newFixedThreadPool(5); // 创建容量为5的线程池对象，即最多5个线程
		// 2、为线程池中的线程分配任务
		for(int i = 0; i < 10; i++) { // 分配10个任务
			pool.submit(myRunnable);
		}
		// 3、关闭线程池，注意：shutdown()是比较平和的关闭线程池对象；shutdownNow()是立即关闭线程池对象
		pool.shutdown();
	}
	
	/**
	 * Callable的方式
	 */
	private static void callableType() {
		MyCallable callable = new MyCallable();
		List<Future<Integer>> futureList = new ArrayList<>();
		
		// 1、创建线程池对象
		ExecutorService pool = Executors.newFixedThreadPool(3); // 创建容量为3的线程池对象，即最多3个线程
		// 2、为线程池中的线程分配任务
		for(int i = 0; i < 10; i++) { // 分配10个任务
			Future<Integer> future = pool.submit(callable);
			
			futureList.add(future);
		}
		// 3、关闭线程池
		pool.shutdown();
		
		for(Future<Integer> f : futureList) {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 使用newScheduledThreadPool()方法创建线程池对象
	 */
	private static void newScheduledThreadPoolMethod() {
		// 1、创建线程池对象
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		// 2、分配任务
		for(int i = 0; i <= 5; i++) { // 分配5个任务
			Future<Integer> res = pool.schedule(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int i = new Random().nextInt(100);
					System.out.println(Thread.currentThread().getName() + ": " + i);
					return i;
				}
			}, 3, TimeUnit.SECONDS); // 该任务会在3秒之后执行
			
			try {
				System.out.println(res.get()); // 输出线程执行的结果
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 3、关闭线程池
		pool.shutdown();
	}
}

class MyRunnable implements Runnable {

	private int i = 0;
	
	@Override
	public void run() {
		while(i <= 100) {
			System.out.println(Thread.currentThread().getName() + " : " + ++i);
		}
	}
}

class MyCallable implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 0; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}
}

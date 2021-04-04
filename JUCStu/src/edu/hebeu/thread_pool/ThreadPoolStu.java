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
 * �̳߳أ��ṩһ���̶߳��У������б��������еȴ�״̬���̣߳������˴���/�����̵߳�һЩ���⿪�����������Ӧ���ٶ�
 * 
 * �̳߳ص���ϵ�ṹ��
 * 	java.util.concurrent.Executor�������߳�ʹ������ȵĸ��ӿ�
 * 		|--ExecutorService���ӽӿڣ������߳���Ҫ�ӿ�
 * 			|--ThreadPoolExecutor���̳߳ص�ʵ����
 * 			|--ScheduledExecutorService���ӽӿڣ������̵߳ĵ���
 * 				|--ScheduleThreadPoolExecutor��ʵ���࣬�̳���ThreadPoolExecutor����ʵ����ScheduleExecutorService
 * 
 * �̳߳صĹ����ࣺExecutors
 * 	ExecutorService newFixedThreadPool(int nThreads); // �����̶�������С���̳߳�
 * 	ExecutorService newCachedThreadPool(); // ���������̳߳أ��������̶������Ը��������Զ��ĸ�������
 * 	ExecutorService newSingleThreadExecutor(); // ��������Ϊ�������̳߳أ����̳߳���ֻ��һ���߳�
 * 	ScheduledExecutorService new ScheduledThreadPool(); // �����̶��������̳߳أ������ӳٻ�ʱ��ִ������
 * 
 * @author 13651
 *
 */
public class ThreadPoolStu {
	public static void main(String[] args) {
//		runnableType(); // ����Runnable��ʽ
//		callableType(); // ����Callable��ʽ
		newScheduledThreadPoolMethod(); // ʹ��newScheduledThreadPool()�������̳߳���ѧϰ�̵߳���

	}
	
	/**
	 * Runnable�ķ�ʽ
	 */
	private static void runnableType() {
		MyRunnable myRunnable = new MyRunnable();
		
		// 1�������̳߳ض���
		ExecutorService pool = Executors.newFixedThreadPool(5); // ��������Ϊ5���̳߳ض��󣬼����5���߳�
		// 2��Ϊ�̳߳��е��̷߳�������
		for(int i = 0; i < 10; i++) { // ����10������
			pool.submit(myRunnable);
		}
		// 3���ر��̳߳أ�ע�⣺shutdown()�ǱȽ�ƽ�͵Ĺر��̳߳ض���shutdownNow()�������ر��̳߳ض���
		pool.shutdown();
	}
	
	/**
	 * Callable�ķ�ʽ
	 */
	private static void callableType() {
		MyCallable callable = new MyCallable();
		List<Future<Integer>> futureList = new ArrayList<>();
		
		// 1�������̳߳ض���
		ExecutorService pool = Executors.newFixedThreadPool(3); // ��������Ϊ3���̳߳ض��󣬼����3���߳�
		// 2��Ϊ�̳߳��е��̷߳�������
		for(int i = 0; i < 10; i++) { // ����10������
			Future<Integer> future = pool.submit(callable);
			
			futureList.add(future);
		}
		// 3���ر��̳߳�
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
	 * ʹ��newScheduledThreadPool()���������̳߳ض���
	 */
	private static void newScheduledThreadPoolMethod() {
		// 1�������̳߳ض���
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		// 2����������
		for(int i = 0; i <= 5; i++) { // ����5������
			Future<Integer> res = pool.schedule(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int i = new Random().nextInt(100);
					System.out.println(Thread.currentThread().getName() + ": " + i);
					return i;
				}
			}, 3, TimeUnit.SECONDS); // ���������3��֮��ִ��
			
			try {
				System.out.println(res.get()); // ����߳�ִ�еĽ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 3���ر��̳߳�
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

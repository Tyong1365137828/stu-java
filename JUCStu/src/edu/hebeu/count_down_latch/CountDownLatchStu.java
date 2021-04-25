package edu.hebeu.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * 这个例子展示CountDownLatch类的使用
 * 
 * 闭锁(CountDownLatch)：指在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行；
 * 
 * 如本类的计算所有线程全部执行完所需的时间
 * 
 * @author 13651
 *
 */
public class CountDownLatchStu {

	public static void main(String[] args) {
		
		final CountDownLatch cdLatch = new CountDownLatch(10); // 表示有10个线程使用这个闭锁对象
		
		MyRunnable myRunnable = new MyRunnable(cdLatch);
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10; i++) { // 启动10个线程
			new Thread(myRunnable).start();
		}
		try {
			cdLatch.await(); // 中断
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("所有线程执行完的耗费时长：" + (end - start) + "ms");
		
	}
}

class MyRunnable implements Runnable {

	private CountDownLatch cdLatch;
	
	public MyRunnable(CountDownLatch cdLatch) {
		this.cdLatch = cdLatch;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			try {
				for(int i = 0; i <= 5000000; i++) {
					if(i %2 == 0) {
						System.out.println("ThreadName = " + Thread.currentThread().getName() +"---" + i);
					}
				}
			} finally {
				cdLatch.countDown(); // 在线程执行完的最后一步，将该闭锁对象的count--
			}
		}
	}
}

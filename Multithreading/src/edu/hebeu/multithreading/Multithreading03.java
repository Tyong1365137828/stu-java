package edu.hebeu.multithreading;

/**
 * 采用第三种方式实现线程，匿名内部类
 * 
 * @author 13651
 *
 */
public class Multithreading03 {
	public static void main (String[] args) {
		/**创建线程类对象，采用匿名内部类方式*/
		Thread myThread = new Thread(new Runnable() { // Runnable是接口，new对象时要加上大括号

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++) {
					System.out.println("支线程，i=" + i);
				}
			}
			
		});
		
		myThread.start(); // 启动线程
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("Main主线程，i=" + i);
		}
	}
}

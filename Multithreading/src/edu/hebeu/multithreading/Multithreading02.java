package edu.hebeu.multithreading;

/**
 * 通过第二种方式实现线程：
 * 	编写一个类，实现java.lang.Runnable接口，重写run()方法；(注意此时这个类不是线程类，而是一个可运行类，它还不是一个线程)
 * 	通过Thread类的构造方法，将上面的可运行类的对象传入，创建线程对象；
 * 	调用start()方法启动线程
 * 
 * @author 13651
 *
 */
public class Multithreading02 {
	public static void main(String[] args) {
//		MyRunnable mr = new MyRunnable(); // 创建可运行类的对象
//		Thread myThread = new Thread(mr); // 通过可运行类的对象创建线程对象
		Thread myThread = new Thread(new MyRunnable()); // 合并上述代码
		
		myThread.start(); // 启动线程
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("Main主栈线程，i=" + i);
		}
		
	}
}

// 创建可运行类
class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("可运行类(分支线程)，i=" + i);
		}
	}
	
}
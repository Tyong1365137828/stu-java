package edu.hebeu.multithreading;

/**
 * 通过第一种方式实现线程：
 * 	编写一个类，继承java.long.Thread类(此时这个类就是线程类了)
 * 	使用 new 创建线程对象；
 * 	使用start()方法启动线程()
 * 
 * 
 * 注意：
 * 	Java中方法体内的代码都是自顶向下依次逐行执行的，上面的代码不执行完，下面的代码就不可能执行！！！(亘古不变)
 * 
 * @author 13651
 *
 */
public class Multithreading01 {
	public static void main(String[] args) { // main方法内的代码是在主栈中运行的，
		
		// 新建一个线程对象
		MyThread myThread = new MyThread();
		
		// 启动线程
//		myThread.run(); /**错误启动线程示范，这样写是不会启动线程的(不会分配新的栈空间)，导致run()方法内的代码只能在Main主栈中执行(相当于调用了run()方法)，就是单线程*/
		
		myThread.start(); /**这段代码是运行在主线程中，start()方法的作用，启动一个分支线程，在JVM中开辟新的栈空间，
		这段代码的任务是开辟一个新的栈空间，只要新的栈空间开出来，start()方法就结束了，线程就启动成功了，任务完成之
		后这段代码瞬间就结束了，启动成功的线程会自动调用run()方法，并且run()方法在分支栈的栈底部(压栈)；
		注意：run()方法在分支栈的最底部，main()方法在主栈的最底部，这两个方法是"平级的"，*/
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("主线程Main，i=" + i);
		}
	}
}

/**
 * 定义线程类
 * @author 13651
 *
 */
class MyThread extends Thread {

	@Override
	public void run() {
		// 在这个方法内的代码会运行在分支线程中(分支栈中)
		for(int i = 0; i < 1000; i++) {
			System.out.println("分支线程Thread1，i=" + i);
		}
	}
	
}

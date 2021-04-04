package edu.hebeu.threadscheduling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 这个例子学习Java中的线程调度的线程优先级有关的方法
 * 	void setPriority(int newPriority); // 设置线程的优先级
 *	int getPriority(); // 获取线程的优先级
 * 	
 * 注意：Java中最低优先级是1，最高优先级是10，默认优先级是5；优先级别高的获取CPU时间片可能会多一些(但也不完全是，大概率是多的)
 * 
 * @author 13651
 *
 */
public class ThreadsSchedulingOfPriority {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("信息\\线程调度\\线程优先级", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 将此输出流的方向改变至 信息\\线程调度\\线程优先级 文件，不在指向控制台
		System.setOut(ps); // 通过上面的对象修改输出方向，将此输出流的方向改变至 信息\\线程调度\\线程优先级 文件，不在指向控制台
		
		
		System.out.println("线程优先级最高：" + Thread.MAX_PRIORITY);
		System.out.println("线程优先级最低：" + Thread.MIN_PRIORITY);
		System.out.println("线程优先级默认：" + Thread.NORM_PRIORITY);
		
		Thread currentThread = Thread.currentThread(); // 获取当前线程，即主线程main
		System.out.println("主线程main的默认优先级：" + currentThread.getPriority());
		
		currentThread.setPriority(1); // 设置主线程main的优先级为1
		System.out.println("主线程main此时的优先级：" + currentThread.getPriority());
		
		
		
		Thread t1 = new Thread(new MyRunnable5()); // 通过可运行类的对象创建线程对象
		t1.setName("t1"); // 设置线程名字
		System.out.println("t1线程的默认优先级：" + t1.getPriority());
		
		t1.setPriority(10); // 设置t1线程的优先级为10
		System.out.println("t1线程此时的优先级：" + t1.getPriority());
		
		t1.start(); // 启动t1线程

		for(int i = 0; i < 10000; i++) {
			System.out.println("当前线程《" + currentThread.getName() + "》，i=" + i);
		}
		
		
	}
}

class MyRunnable5 implements Runnable {

	@Override
	public void run() {
		System.out.println("当前线程《" + Thread.currentThread().getName() + "》的优先级" + Thread.currentThread().getPriority());
		for(int i = 0; i < 10000; i++) {
			System.out.println("当前线程《" + Thread.currentThread().getName() + "》，i=" + i);
		}
		
	}
	
}

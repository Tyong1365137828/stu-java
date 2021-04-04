package edu.hebeu.threadscheduling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 这个例子演示学习线程合并
 * 	void join(); // 合并线程，等待该线程终止；
	void join(long millisecond) // 参数是毫秒；合并线程，等待该线程终止的时间最长为millisecond毫秒；
	void join(long millisecond, long nanosecond) // 参数1是毫秒，参数二是纳秒；合并线程，等待该线程终止的时间最长为millisecond毫秒 + nanosecond纳秒；
	// 合并线程(多线程变成单线程)的例子
	class MyThread1 extends Thread { // MyThread1线程类
		public void doSonme() {
			MyThread2 mt2 = new MyThread2(); // 创建MyThread2线程类的对象
			mt2.join(); // 当前线程进入阻塞，mt2线程执行，直到mt2线程执行完毕，当前线程才可以继续继续执行
		}
	}
	class MyThread2 extends Thread { // MyThread2线程类
	}
	
	注意：这种方式的线程合并不是将线程的两个栈合并了，而是两个栈之间产生了协调等待的关系！！！
	
 * @author 13651
 *
 */
public class ThreadSchedulingOfMerging {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("信息\\线程调度\\线程合并", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 将此输出流的方向改变至 信息\\线程调度\\线程合并 文件，不在指向控制台
		System.setOut(ps); // 通过上面的对象修改输出方向，将此输出流的方向改变至 信息\\线程调度\\线程合并 文件，不在指向控制台
		
		
		Thread t1 = new Thread(new MyRunnable3()); // 通过可运行类的对象创建线程对象
		t1.setName("t1"); // 设置线程的名字为t1
		t1.setPriority(1); // 设置t1的线程优先级为1
		t1.start(); // 启动t1线程
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("当前线程《" + Thread.currentThread().getName() + "》，i=" + i);
			
			if(i == 998) { // 如果主线程main还剩1次循环完毕
				try {
					System.out.println("当前线程《" + Thread.currentThread().getName() + "》将受阻");
					t1.join(); // t1合并到当前线程中，当前线程受阻，直到t1线程执行结束
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}

class MyRunnable3 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("当前线程《" + Thread.currentThread().getName() + "》，i=" + i);
		}
		System.out.println(Thread.currentThread().getName() + "执行完毕！！！");
	}
	
}

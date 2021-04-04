package edu.hebeu.threadscheduling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 这个例子展示学习线程调度的线程让位问题
 * 	static void yield(); // 线程让位，暂停当前正在执行的线程，并执行其他线程
 * 
 * yield()方法不是阻塞，让当前线程让位，让给其他线程使用；yield()方法的执行会让当前线程从 运行状态 回到 就绪状态；
	注意：在回到就绪状态之后，有可能还会再抢到
 * @author 13651
 *
 */
public class ThreadSchedulingOfAbdication {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("信息\\线程调度\\线程让位", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 将此输出流的方向改变至 信息\\线程调度\\线程让位 文件，不在指向控制台
		System.setOut(ps); // 通过上面的对象修改输出方向，将此输出流的方向改变至 信息\\线程调度\\线程让位 文件，不在指向控制台
		
		
		Thread t1 = new Thread(new MyRunnable()); // 通过可运行类的对象创建线程对象
		t1.setName("t1"); // 设置线程的名字
		t1.start(); // 启动t1线程
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("当前线程《" + Thread.currentThread().getName() + "》，i=" + i);
		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			if(i % 100 == 0) { // 当除100的余数是0(即每100次)
				System.out.println("当前线程《" + Thread.currentThread().getName() + "》已经让位！从运行状态变成就绪状态");
				Thread.yield(); // 进行让位
			}
			System.out.println("当前线程《" + Thread.currentThread().getName() + "》，i=" + i);
		}
	}
	
}

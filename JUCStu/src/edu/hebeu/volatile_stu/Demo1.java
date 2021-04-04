package edu.hebeu.volatile_stu;

/**
 * 这个类演示以下的例子，以此引出内存不可见和volatile关键字
 * 
 * 	须知：须知：JVM为了提高效率，会在每个线程中开辟独立的缓存区域，将读取到的数据放到此，当修改该数据时，
 * 会先将缓存区域的数据修改，再将该数据更新至主存
 * 
 * 分析原因：
 * 	因为线程1会先sleep200毫秒，导致main线程先读取到主存的数据，之后进入执行速度非常快的while(true)循环中，
 * 而线程1在sleep200毫秒后再将主存的数据读入并修改，但是main线程由于在while(true)中没有其他的操作因而执行
 * 非常快，导致没有延迟的时间去主存中重新读取新的数据(主存内的数据是true，而main线程缓存的却是false)，因此
 * 就会出现下面的情况；
 * 
 * 如上的分析就是内存不可见性！即多个线程操作一个共享数据时彼此之间不可见！
 * 
 * 解决：
 * 	方式一：在 if(myRunnable.isFlag()) 外用synchronized(td)包裹，使同步化，就能解决，但是这样做会导致程序
 * 的效率非常低！
 * 	方式二：在共享的数据上添加volatile关键字；
 * 		1、volatile关键字的作用：当多个线程操作共享数据时，保证内存可见性！
 * 		2、该关键字底层调用的是计算机底层代码，“内存栅栏”，以实时的刷新数据
 * 		3、使用volatile关键字JVM就不能对被其修饰的变量重排序，因此效率会变低！
 * 		4、但是相较于方式一synchronized锁，效率高！
 * 
 * volatile关键字的注意：
 * 	1、相较于synchronized不具有"互斥性"；
 * 	2、不能保证变量的"原子性"；
 * 
 * @author 13651
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		
		new Thread(myRunnable).start(); // 启动线程
		
		while(true) {
//			synchronized(myRunnable) { // 方式一的解决办法
			if(myRunnable.isFlag()) {
				System.out.println("收到flag为" + myRunnable.isFlag() + "；准备结束循环");
				break;
			}
//			}
			
//			System.out.println("flag为：" + myRunnable.isFlag() + "；继续循环..."); // 不要加输出语句，否则会影响while的执行效率，导致本例演示不成功
		}

	}
}

class MyRunnable implements Runnable {

//	private volatile boolean flag = false; // 使用方式二的解决办法

	private boolean flag = false;

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true;
		System.out.println("通知：flag已经变成：" + isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}

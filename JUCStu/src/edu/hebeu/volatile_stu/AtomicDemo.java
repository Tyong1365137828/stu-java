package edu.hebeu.volatile_stu;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性的例子
 * 
 * 先看一个面试题：
 * 		int i = 10;
 * 		i = i++; // 结果：i = 10
 *	因为i++的底层实际是：
 *		int temp = i;
 *		i = i + 1;
 *		i = temp;
 *	所以产生了如上的操作，由此 i++就是"读->改->写"
 *
 *	分析下面的例子，产生的原因就是因为i++操作不是一步的而是多步的(读->改->写)，此时就算使用了volatile关键字
 *保证内存可见，但是分析以后会得知仍然会出现下面的问题！
 *
 *	解决：
 *		使用原子变量代替原先的变量和计算，就不会出现上面的问题了；
 *	原子变量：jdk1.5之后java.util.concurrent.atomic包下提供的常用原子变量；
 *		1、该包下的所有类，类似于包装类，如对Integer的、String的、甚至数组的、...；这些类内部的变量都使用
 *		了volatile关键字来保证内存的可见性；
 *		2、底层使用CAS(Compare-And-Swap)算法保证数据的原子性；
 *			须知CAS算法是硬件对于并发操作共享数据的支持；CAS算法包括了三个操作数：有：内存值 V、预估值 A、
 *			更新值 B；当且仅当 V == A时，V = B，否则将不做任何操作；
 *		
 *
 * @author 13651
 *
 */
public class AtomicDemo {
	public static void main(String[] args) {
		MyRunnable2 myRunnable2 = new MyRunnable2();
		
		for (int i = 0; i < 16; i++) {
			new Thread(myRunnable2).start(); // 会发现出现问题，有可能产生重复数据！！！
		}
	}
}

class MyRunnable2 implements Runnable {
	
	private int i = 0;
//	private AtomicInteger i = new AtomicInteger(); // 使用该对象代替原先的变量

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "; i = " + getAdd());
	}
	
	public int getAdd() {
		return i++;
//		return i.getAndIncrement(); // 使用内部的实例方法代替原先的++操作
	}
}

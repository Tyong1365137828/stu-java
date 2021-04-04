package edu.hebeu.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask; // JDK包下的，属于Java的并发包，老版的JDK没有这个包，是新特性

/**
 * 实现线程的第三种方式，FutureTask方式，实现Callable接口。(JDK8新特性)；
 * 	这种方式实现的线程可以获取线程的返回值，之前的两种方式(1、继承Thread，重写run()方法；
 * 2、实现Runnable，重写run()方法，编写可运行类，通过可运行类创建线程对象；这两种方法都
 * 不能够获取线程返回值，因为run()方法是void)
 * 
 * 如系统委派一个线程去执行一个任务，该线程执行完任务之后，可能会有一个执行结果，我们要拿到这个结果，
 * 如果使用前两种方式创建的线程必然是无法完成这个业务的，因此可以使用第三种方式创建的线程，FutureTask方式，实现Callable接口。(JDK8新特性)；
 * 
 * 缺点：
 * 	取到当前线程中获取另一个线程的返回值结果时，当前线程会产生阻塞，导致效率较低
 * @author 13651
 *
 */
public class Multithreading04 {
	public static void main(String[] args) {
		// 1、创建未来任务类对象
		FutureTask<Object> task = new FutureTask<>(new MyCallable());
//		FutureTask<Object> task = new FutureTask<Object>(new Callable<Object>(){ // 使用匿名内部类的方式
//
//			@Override
//			public Object call() throws Exception {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		});
		
		// 创建线程对象
		Thread t = new Thread(task);
		
		// 启动线程
		t.start();
		
		/**
		 * 
		 * 注意：这里是main()方法内，所有是在主线程中，通过FutureTask的对象 .get()方法可以获取call()方法的返回值;
		 * 
		 * 这个get()方法的执行会导致当前线程(即主线程，main()方法)阻塞！
		 * 	因为call()方法有返回值，而get()方法是在当前线程(主线程，main()方法)内获取另一个线程的返回值，所以当前线程(主线程，main()方法)要等待另一个线程的call()方法执行完毕(call()方法相当于run()方法，即等待另一个线程执行完毕！！！)
		 */
		Object obj = null;
		try {
			obj = task.get(); // 获取线程的返回值结果
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("拿到了线程返回值结果！");
		
	}
}

// 
class MyCallable implements Callable<Object> {

	@Override
	public Object call() throws Exception { // 相当于run()方法，只不过call()方法有返回值
		// 这里写线程执行的任务代码，执行完成之后可能会获取一个结果作为返回值
		System.out.println("call start");
		Thread.sleep(1000 * 3); // 睡眠3秒，模拟执行
		System.out.println("call end");
		int a = 100;
		int b = 200;
		return a + b; // 自动装箱机制
	}
	
}

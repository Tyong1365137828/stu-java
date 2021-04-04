package edu.hebeu.multithreading;

/**
 * 这个例子演示如何强行终止一个线程
 * 	void stop(); // 直接销毁(杀死)掉这个线程；这种方式已经过时，不建议使用，
 * 		// 因为这种方式直接将线程杀死了，线程没有保存的数据会丢失！！
 * 
 * 	在可运行类中设置一个线程运行的标记，如果标记为true，就进行线程业务；否则就return掉 run()方法，结束线程；
 * 此时要想结束线程只需要通过更改可运行类的对象的标记为false即可return掉 run()方法，结束线程，并且在结束线
 * 程之前可以进行结束之前的业务，如保存数据等；
 * 	
 * @author 13651
 *
 */
public class ForceFinishThread {
	public static void main(String[] args) {
		/**没有使用标记创建的可运行类创建的线程对象*/
//		Thread thread = new Thread(new MyRunnable3()); // 创建线程对象
//		thread.setName("t1"); // 设置线程名字
//		thread.start(); // 启动线程
		
		/**使用标记创建的可运行类创建的线程对象*/
		MyRunnable4 mr = new MyRunnable4(); // 创建可运行类对象
		Thread thread2 = new Thread(mr); // 通过可运行类对象创建线程对象
		thread2.setName("t2"); // 设置线程名字
		thread2.start(); // 启动线程
		
		try {
			Thread.sleep(1000 * 6); // 当前线程(主线程main)睡眠5秒
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 强行终止线程，直接销毁(杀死)掉这个线程
//		thread.stop(); // 已过时，不建议使用；因为这种方式直接将线程杀死了，线程没有保存的数据会丢失！！
		/**将可运行类的对象的标记修改为false，正常的结束线程*/
		mr.runnFlag = false;
		
		System.out.println("END!!!");
	}
}

class MyRunnable3 implements Runnable {
	@Override
	public void run() {
		// 以下代码表示每一秒循环一次
		for(int i = 0; i < 20; i++) {
			System.out.println("当前线程《" + Thread.currentThread().getName() + "》，i=" + i);
			
			try {
				Thread.sleep(1000); // 睡眠一秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyRunnable4 implements Runnable {

	boolean runnFlag = true; // 做一个线程运行布尔标记
	
	@Override
	public void run() {
		// 以下代码表示每一秒循环一次
		for(int i = 0; i < 20; i++) {
			if(runnFlag) { // 如果标记为true，就进行线程的业务代码
				System.out.println("当前线程《" + Thread.currentThread().getName() + "》，i=" + i);
				
				try {
					Thread.sleep(1000); // 睡眠一秒
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			} else { // 否则
				
				/**在return之前将要保存的数据进行保存等业务*/
				return; // 就结束run()方法，即终止当前线程
			}
		}
	}
	
}

package edu.hebeu.multithreading;

/**
 * 这个例子演示如何让线程睡眠和终止线程睡眠；
 * 	static void sleep(long sleepTime); // 让当前线程进入睡眠状态(阻塞状态)，放弃占有的CPU时间片，将资源让给其他线程使用，参数是睡眠时间，单位是毫秒；
 * 		// 这行代码出现在A线程，A线程就进入睡眠；出现在B线程，B线程就进入睡眠；
 * 	
 * 	void interrupt(); // 干扰，这段代码会让线程调用sleep()方法的代码抛出异常，此时异常被try后，自然会进入catch(){}，执行完catch(){}内的代码后，自然就会往下执行，以此打断线程的睡眠；
 * 		// 因此这种中断睡眠的方式是靠Java的异常机制实现的！！！！
 * 
 * 	
 * 
 * @author 13651
 *
 */
public class SleepThreadAndWakeThread {
	public static void main(String[] args) {
		System.out.println("main START");
		
		Thread mt = new Thread(new MyRunnable1()); // 创建线程对象
		mt.setName("T1"); // 设置线程名字		
		mt.start(); // 启动线程
		
		try {
			Thread.sleep(1000 * 6); // 将当前线程(main方法中，即主线程)进入睡眠没状态6秒
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 // 此时中断t线程的睡眠
		mt.interrupt(); /**干扰，这段代码会让线程调用sleep()方法的代码抛出异常，此时异常被try后，自然会进入catch(){}，
		执行完catch(){}内的代码后，自然就会往下执行，以此打断线程的睡眠；因此这种中断睡眠的方式是靠Java的异常机制实现的！！！！*/
		
		System.out.println("main END!!!");
	}
}

// 定义可运行类
class MyRunnable1 implements Runnable {

	@Override
	public void run() {
		System.out.println("线程《" + Thread.currentThread().getName() + "》------>begin...");
		try { // 子类方法重写，子类方法不能抛出比父类方法更多的异常，run()方法在父类中没有抛出异常，所以在子类中只能try{}catch(){}
			Thread.sleep(1000 * 60 * 60 * 24); // 睡眠1天
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("线程《" + Thread.currentThread().getName() + "》睡眠出现异常！" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("线程《" + Thread.currentThread().getName() + "》------>end!!!");
	}
	
}

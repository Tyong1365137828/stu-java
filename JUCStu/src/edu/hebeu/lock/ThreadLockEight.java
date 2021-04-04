package edu.hebeu.lock;

/**
 * 这个例子演示线程八锁
 * 
 * 题目：判断打印：
 * 	第一锁. 创建一个Myprint对象，调用loopONE()、调用loopTwo()，打印结果为：one、two
 * 	第二锁. 创建一个Myprint对象，调用loopONESL()、调用loopTWO()，打印结果为：(延迟3秒) one two
 * 	第三锁：创建一个Myprint对象，调用loopONESL()、调用loopTWO()、调用loop_three()，打印结果：three (延迟3秒) one two
 * 	第四锁：创建两个Myprint对象，分别这两个一个调用loopONESL()、一个调用loopTWO()，打印结果：two (延迟3秒) one
 * 	第五锁：创建两个Myprint对象，分别这两个一个调用loopONESS()、一个调用loopTWO()，打印结果：two (延迟3秒) one
 * 	第六锁：创建一个Myprint对象，调用loopONESS()、调用loopTWOS()，打印结果：(延迟3秒) one two
 * 	第七锁：创建两个Myprint对象，分别这两个一个调用loopONESS()、一个调用loopTWO()，打印结果：two (延迟3秒) one
 * 	第八锁：创建两个MyPrint对象，分别这两个一个调用loopONESS()、一个调用loopTWOS()，打印结果为：(延迟3秒) one two
 * 
 * 线程八锁的注意：
 * 	① 非静态方法的锁默认为this，静态方法的锁默认为字节码(对应的Class实例)
 * 	② 某一个时刻内，只能有一个线程持有锁，无论几个方法
 * 	
 * @author 13651
 *
 */
public class ThreadLockEight {
	
	public static void main(String[] args) {
		ThreadLockEight eight = new ThreadLockEight();
		
//		eight.lock1(); // 第一种锁
//		eight.lock2(); // 第二种锁
//		eight.lock3(); // 第三种锁
//		eight.lock4(); // 第四种锁
//		eight.lock5(); // 第五种锁
//		eight.lock6(); // 第六种锁
//		eight.lock7(); // 第七种锁
		eight.lock8(); // 第八种锁
		
		
	}
	
	/**
	 * 第一种锁
	 */
	private void lock1() {
		Myprint myprint = new Myprint();
		
		new Thread(() -> {
			myprint.loopONE();
		}).start();
		
		new Thread(() -> {
			myprint.loopTWO();
		}).start();
	}
	
	private void lock2() {
		Myprint myprint = new Myprint();
		
		new Thread(() -> {
			myprint.loopONESL();
		}).start();
		
		new Thread(() -> {
			myprint.loopTWO();
		}).start();
	}
	
	private void lock3() {
		Myprint myprint = new Myprint();
		
		new Thread(() -> {
			myprint.loopONESL();
		}).start();
		
		new Thread(() -> {
			myprint.loopTWO();
		}).start();
		
		new Thread(() -> {
			myprint.loop_three();
		}).start();
	}
	
	private void lock4() {
		Myprint myprint1 = new Myprint();
		Myprint myprint2= new Myprint();
		
		new Thread(() -> {
			myprint1.loopONESL();
		}).start();
		
		new Thread(() -> {
			myprint2.loopTWO();
		}).start();
	}
	
	private void lock5() {
		Myprint myprint1 = new Myprint();
		Myprint myprint2= new Myprint();
		
		new Thread(() -> {
			myprint1.loopONESS();
		}).start();
		
		new Thread(() -> {
			myprint2.loopTWO();
		}).start();
	}
	
	private void lock6() {
		Myprint myprint = new Myprint();
		
		new Thread(() -> {
			myprint.loopONESS();
		}).start();
		
		new Thread(() -> {
			myprint.loopTWOS();
		}).start();
	}
	
	private void lock7() {
		Myprint myprint1 = new Myprint();
		Myprint myprint2 = new Myprint();
		
		new Thread(() -> {
			myprint1.loopONESS();
		}).start();
		
		new Thread(() -> {
			myprint2.loopTWO();
		}).start();
	}
	
	private void lock8() {
		Myprint myprint1 = new Myprint();
		Myprint myprint2 = new Myprint();
		
		new Thread(() -> {
			myprint1.loopONESS();
		}).start();
		
		new Thread(() -> {
			myprint2.loopTWOS();
		}).start();
	}
}

class Myprint {
	
	public static synchronized void loopONES() {
		System.out.println("one");
	}
	
	public static synchronized void loopTWOS() {
		System.out.println("two");
	}
	
	public static synchronized void loopThreeS() {
		System.out.println("three");
	}
	
	public static synchronized void loopONESS() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("one");
	}
	
	public static synchronized void loopTWOSS() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("two");
	}
	
	public static synchronized void loopThreeSS() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("three");
	}
	
	public synchronized void loopONE() {
		System.out.println("one");
	}
	
	public synchronized void loopTWO() {
		System.out.println("two");
	}
	
	public synchronized void loopThree() {
		System.out.println("three");
	}
	
	public synchronized void loopONESL() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("one");
	}
	
	public synchronized void loopTWOSL() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("two");
	}
	
	public synchronized void loopThreeSL() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("three");
	}
	
	public void loop_one() {
		System.out.println("one");
	}
	
	public void loop_two() {
		System.out.println("two");
	}
	
	public void loop_three() {
		System.out.println("three");
	}
}

package edu.hebeu.threadsafety;

/**
 * 死锁的例子
 * @author 13651
 *
 */
public class Deadlock {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		// 线程t1和t2共享obj1和obj2对象
		MThread1 t1 = new MThread1(obj1, obj2);
		MThread2 t2 = new MThread2(obj1, obj2);
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		t2.start();
		/**
		 * 此时运行程序会发现代码不会出错，不会出异常，但是代码不会再往下执行了，分析原因，这是由于对象锁死锁；
		 * 
		 * 总结：开发中尽量少使用synchronized嵌套；
		 */
	}
}

// MThread1线程类
class MThread1 extends Thread {

	private Object obj1;
	private Object obj2;

	public MThread1(Object obj1, Object obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		synchronized(obj1) {
			System.out.println("MThread1类：obj1对象锁定！");
			try {
				Thread.sleep(1000); // 睡眠1秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(obj2) {
				System.out.println("MThread1类：obj2对象锁定！");
			}
		}
		
		System.out.println("MThread1类：run()方法执行完毕");
	}
}

// MThread2线程类
class MThread2 extends Thread {
	
	private Object obj1;
	private Object obj2;

	public MThread2(Object obj1, Object obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		synchronized(obj2) {
			System.out.println("MThread2类：obj2对象锁定！");
			try {
				Thread.sleep(1000); // 睡眠1秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(obj1) {
				System.out.println("MThread2类：obj2对象锁定！");
			}
		}
		
		System.out.println("MThread2类：run()方法执行完毕");
	}
}


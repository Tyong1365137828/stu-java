package edu.hebeu.threadsafety;

/**
 * 关于synchronized的面试题：
 * 	问，如下代码所示，t2线程执行的doOther()方法会等待t1线程执行完doSome()方法结束才执行吗？
 * 		不会等待，虽然两个线程的共享对象一样(对象锁一样)，都是MyClass类的myClass对象；doSome()方法使用了synchronized关键字，但是doOther()方法没有使用synchronized关键字修饰，所以不会出现等待关系；
 * @author 13651
 *
 */
public class SynchronizedInterview1 {
	public static void main(String[] args) {
		MyClass myClass = new MyClass(); // 创建MyClass对象
		
		Thread t1 = new MyThread(myClass); // 创建线程t1
		Thread t2 = new MyThread(myClass); // 创建线程t2
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		try {
			Thread.sleep(1000 * 1); // 睡眠1秒，这个睡眠是为了让t1线程先启动，以调用doSome()方法[通过synchronized关键字修饰的，对象锁是this，即myClass对象]，以在执行t2线程之前拿到对象锁myClass
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}

class MyThread extends Thread {
	
	private MyClass myClass;

	public MyThread(MyClass myClass) {
		super();
		this.myClass = myClass;
	}

	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("t1")) {
			myClass.doSome();			
		}
		if(Thread.currentThread().getName().equals("t2")) {
			myClass.doOther();
		}
	}
	
}


class MyClass {
	
	/**
	 * 这个方法是synchronized关键字修饰，对象锁是this,
	 */
	public synchronized void doSome() {
		System.out.println("doSome 开始执行");
		try {
			Thread.sleep(1000 * 6); // 当前线程睡眠6秒
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doSome 执行结束");
	}
	
	public void doOther() {
		System.out.println("doOther 开始执行");
		System.out.println("doOther 开始执行");
	}
}

package edu.hebeu.threadsafety;

/**
 * 关于synchronized的面试题：
 * 	问，如下代码所示，t2线程执行的doOther()方法会等待t1线程执行完doSome()方法结束才执行吗？
 * 		会等待，doSome()和doOther()方法都是静态方法且都有synchronized关键字修饰，则锁是类锁，一个类不论new多少个对象，都只有一把类锁；
 * 		所以会出现等待关系；
 * @author 13651
 *
 */
public class SynchronizedInterview4 {
	public static void main(String[] args) {
		MyClass4 myClass1 = new MyClass4(); // 创建MyClass4的对象
		MyClass4 myClass2 = new MyClass4(); // 创建MyClass4的对象
		
		Thread t1 = new MyThread4(myClass1); // 创建线程t1
		Thread t2 = new MyThread4(myClass2); // 创建线程t2
		
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

class MyThread4 extends Thread {
	
	private MyClass4 myClass;

	public MyThread4(MyClass4 myClass) {
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

class MyClass4 {
	
	/**
	 * 这个静态方法是synchronized关键字修饰，锁就是类锁
	 */
	public synchronized static void doSome() {
		System.out.println("doSome 开始执行");
		try {
			Thread.sleep(1000 * 6); // 当前线程睡眠6秒
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doSome 执行结束");
	}
	
	/**
	 * 这个静态方法是synchronized关键字修饰，锁就是类锁
	 */
	public synchronized static void doOther() {
		System.out.println("doOther 开始执行");
		System.out.println("doOther 开始执行");
	}
}

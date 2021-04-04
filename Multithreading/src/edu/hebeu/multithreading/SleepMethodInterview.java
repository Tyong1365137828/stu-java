package edu.hebeu.multithreading;

/**
 * 这个例子引出线程的sleep()方法的面试题；
 * 如下所示，下面的代码会让线程 t1 进入休眠状态吗？
 * 		不会，sleep()方法是静态的，在执行上面的这一行代码 t.sleep() 时还是会转换成 Thread.sleep()；
		这行代码的作用是：让当前线程进入睡眠状态，这行代码出现在main()方法中，也就是说main线程进入睡眠状态；
 * @author 13651
 *
 */
public class SleepMethodInterview {
	public static void main(String[] args) {
		Thread t = new MyThread5(); // 使用多态创建线程对象
		t.setName("t1"); // 设置线程名字
		t.start(); // 启动线程
		
		try {
			t.sleep(1000 * 5); // 将线程睡眠5秒
			/**注意，sleep()方法是静态的，在执行上面的这一行代码 t.sleep() 时还是会转换成 Thread.sleep()；
			 * 这行代码的作用是：让当前线程进入睡眠状态，这行代码出现在main()方法中，也就是说main线程进入睡眠状态；*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("END!!!");
		
	}
}

class MyThread5 extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("线程---->" + i);
		}
	}
	
}
package edu.hebeu.multithreading;

/**
 * 获取线程信息：
 * 	String getName(); // 获取线程名字，默认为：Thread-n，注意：n从0开始，以1递增
 * 	void setName(String name); // 设置线程名字
 * 
 * 	static Thread currentThread(); // 获取当前线程对象
 * 	
 * @author 13651
 *
 */
public class GetThreadInfo {
	public static void main(String[] args) {
		
		Thread currentThread = Thread.currentThread(); // 获取当前线程对象，因为这段代码在main()方法种，所以当前线程对象就主线程
		System.out.println("当前线程" + currentThread.getName()); // main
		
		MyThread4 mr1 = new MyThread4(); // 创建线程对象
		System.out.println("线程名：" + mr1.getName()); // 获取线程名字
		mr1.setName("线程1"); // 设置线程名字
		System.out.println("修改线程名之后，线程名字：" + mr1.getName());
		mr1.start(); // 启动线程1
		
		MyThread4 mr2 = new MyThread4(); // 创建线程对象
		System.out.println("线程名：" + mr2.getName()); // 获取线程名字
		mr2.setName("线程2"); // 设置线程名字
		System.out.println("修改线程名之后，线程名字：" + mr2.getName());
		mr2.start(); // 启动线程2
	}
}

class MyThread4 extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			Thread currentThread = Thread.currentThread(); // 获取当前线程对象
			
			System.out.println("当前线程《" + currentThread.getName() + "》，i=" + i);
			
			// super和this也可以
//			System.out.println("当前线程《" + super.getName() + "》，i=" + i);
//			System.out.println("当前线程《" + this.getName() + "》，i=" + i);
		}
	}
	
}
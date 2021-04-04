package edu.hebeu.daemonthread;

/**
 * 实现一个守护线程
 * @author 13651
 *
 */
public class DaemonThread {
	public static void main(String[] args) {
		Thread daemonThread = new BackupThread(); // 创建线程对象
		daemonThread.setName("守护线程1(备份)");
		daemonThread.setDaemon(true); // 启动线程之前设置这个线程对象为守护线程，当用户线程都运行完毕，这个线程对象就会强行自动结束
		daemonThread.start(); // 启动线程
		
		for(int i = 0; i < 20; i++) {
			System.out.println("主线程执行，第" + (i + 1) + "次");
			try {
				Thread.sleep(1000); // 睡眠1秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class BackupThread extends Thread {

	@Override
	public void run() {
		int i = 0;
		while(true) { // 如果将这个线程类创建的线程对象设置为守护线程，当用户线程执行完毕，这里即使是永真循环也会结束！！！
			System.out.println(Thread.currentThread().getName() + "线程，备份次数：" + (++i) + "，备份中...");
			try {
				Thread.sleep(3000); // 睡眠3秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

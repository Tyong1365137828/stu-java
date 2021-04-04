package edu.hebeu.lock;

/**
 * ���������ʾ�̰߳���
 * 
 * ��Ŀ���жϴ�ӡ��
 * 	��һ��. ����һ��Myprint���󣬵���loopONE()������loopTwo()����ӡ���Ϊ��one��two
 * 	�ڶ���. ����һ��Myprint���󣬵���loopONESL()������loopTWO()����ӡ���Ϊ��(�ӳ�3��) one two
 * 	������������һ��Myprint���󣬵���loopONESL()������loopTWO()������loop_three()����ӡ�����three (�ӳ�3��) one two
 * 	����������������Myprint���󣬷ֱ�������һ������loopONESL()��һ������loopTWO()����ӡ�����two (�ӳ�3��) one
 * 	����������������Myprint���󣬷ֱ�������һ������loopONESS()��һ������loopTWO()����ӡ�����two (�ӳ�3��) one
 * 	������������һ��Myprint���󣬵���loopONESS()������loopTWOS()����ӡ�����(�ӳ�3��) one two
 * 	����������������Myprint���󣬷ֱ�������һ������loopONESS()��һ������loopTWO()����ӡ�����two (�ӳ�3��) one
 * 	�ڰ�������������MyPrint���󣬷ֱ�������һ������loopONESS()��һ������loopTWOS()����ӡ���Ϊ��(�ӳ�3��) one two
 * 
 * �̰߳�����ע�⣺
 * 	�� �Ǿ�̬��������Ĭ��Ϊthis����̬��������Ĭ��Ϊ�ֽ���(��Ӧ��Classʵ��)
 * 	�� ĳһ��ʱ���ڣ�ֻ����һ���̳߳����������ۼ�������
 * 	
 * @author 13651
 *
 */
public class ThreadLockEight {
	
	public static void main(String[] args) {
		ThreadLockEight eight = new ThreadLockEight();
		
//		eight.lock1(); // ��һ����
//		eight.lock2(); // �ڶ�����
//		eight.lock3(); // ��������
//		eight.lock4(); // ��������
//		eight.lock5(); // ��������
//		eight.lock6(); // ��������
//		eight.lock7(); // ��������
		eight.lock8(); // �ڰ�����
		
		
	}
	
	/**
	 * ��һ����
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

package edu.hebeu.multithreading;

/**
 * ���������ʾ������߳�˯�ߺ���ֹ�߳�˯�ߣ�
 * 	static void sleep(long sleepTime); // �õ�ǰ�߳̽���˯��״̬(����״̬)������ռ�е�CPUʱ��Ƭ������Դ�ø������߳�ʹ�ã�������˯��ʱ�䣬��λ�Ǻ��룻
 * 		// ���д��������A�̣߳�A�߳̾ͽ���˯�ߣ�������B�̣߳�B�߳̾ͽ���˯�ߣ�
 * 	
 * 	void interrupt(); // ���ţ���δ�������̵߳���sleep()�����Ĵ����׳��쳣����ʱ�쳣��try����Ȼ�����catch(){}��ִ����catch(){}�ڵĴ������Ȼ�ͻ�����ִ�У��Դ˴���̵߳�˯�ߣ�
 * 		// ��������ж�˯�ߵķ�ʽ�ǿ�Java���쳣����ʵ�ֵģ�������
 * 
 * 	
 * 
 * @author 13651
 *
 */
public class SleepThreadAndWakeThread {
	public static void main(String[] args) {
		System.out.println("main START");
		
		Thread mt = new Thread(new MyRunnable1()); // �����̶߳���
		mt.setName("T1"); // �����߳�����		
		mt.start(); // �����߳�
		
		try {
			Thread.sleep(1000 * 6); // ����ǰ�߳�(main�����У������߳�)����˯��û״̬6��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 // ��ʱ�ж�t�̵߳�˯��
		mt.interrupt(); /**���ţ���δ�������̵߳���sleep()�����Ĵ����׳��쳣����ʱ�쳣��try����Ȼ�����catch(){}��
		ִ����catch(){}�ڵĴ������Ȼ�ͻ�����ִ�У��Դ˴���̵߳�˯�ߣ���������ж�˯�ߵķ�ʽ�ǿ�Java���쳣����ʵ�ֵģ�������*/
		
		System.out.println("main END!!!");
	}
}

// �����������
class MyRunnable1 implements Runnable {

	@Override
	public void run() {
		System.out.println("�̡߳�" + Thread.currentThread().getName() + "��------>begin...");
		try { // ���෽����д�����෽�������׳��ȸ��෽��������쳣��run()�����ڸ�����û���׳��쳣��������������ֻ��try{}catch(){}
			Thread.sleep(1000 * 60 * 60 * 24); // ˯��1��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("�̡߳�" + Thread.currentThread().getName() + "��˯�߳����쳣��" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("�̡߳�" + Thread.currentThread().getName() + "��------>end!!!");
	}
	
}

package edu.hebeu.threadsafety;

/**
 * ����������
 * @author 13651
 *
 */
public class Deadlock {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		// �߳�t1��t2����obj1��obj2����
		MThread1 t1 = new MThread1(obj1, obj2);
		MThread2 t2 = new MThread2(obj1, obj2);
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		t2.start();
		/**
		 * ��ʱ���г���ᷢ�ִ��벻�����������쳣�����Ǵ��벻��������ִ���ˣ�����ԭ���������ڶ�����������
		 * 
		 * �ܽ᣺�����о�����ʹ��synchronizedǶ�ף�
		 */
	}
}

// MThread1�߳���
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
			System.out.println("MThread1�ࣺobj1����������");
			try {
				Thread.sleep(1000); // ˯��1��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(obj2) {
				System.out.println("MThread1�ࣺobj2����������");
			}
		}
		
		System.out.println("MThread1�ࣺrun()����ִ�����");
	}
}

// MThread2�߳���
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
			System.out.println("MThread2�ࣺobj2����������");
			try {
				Thread.sleep(1000); // ˯��1��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(obj1) {
				System.out.println("MThread2�ࣺobj2����������");
			}
		}
		
		System.out.println("MThread2�ࣺrun()����ִ�����");
	}
}


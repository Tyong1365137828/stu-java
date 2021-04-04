package edu.hebeu.threadsafety;

/**
 * ����synchronized�������⣺
 * 	�ʣ����´�����ʾ��t2�߳�ִ�е�doOther()������ȴ�t1�߳�ִ����doSome()����������ִ����
 * 		��ȴ��������̵߳Ĺ������һ��(������һ��)������MyClass2�Ķ���myClass��doOther()��doOther()��������synchronized�ؼ������Σ����Ի���ֵȴ���ϵ��
 * @author 13651
 *
 */
public class SynchronizedInterview2 {
	public static void main(String[] args) {
		MyClass2 myClass = new MyClass2(); // ����MyClass����
		
		Thread t1 = new MyThread2(myClass); // �����߳�t1
		Thread t2 = new MyThread2(myClass); // �����߳�t2
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		try {
			Thread.sleep(1000 * 1); // ˯��1�룬���˯����Ϊ����t1�߳����������Ե���doSome()����[ͨ��synchronized�ؼ������εģ���������this����myClass����]������ִ��t2�߳�֮ǰ�õ�������myClass
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}

class MyThread2 extends Thread {
	
	private MyClass2 myClass;

	public MyThread2(MyClass2 myClass) {
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

class MyClass2 {
	
	/**
	 * ���������synchronized�ؼ������Σ���������this,
	 */
	public synchronized void doSome() {
		System.out.println("doSome ��ʼִ��");
		try {
			Thread.sleep(1000 * 6); // ��ǰ�߳�˯��6��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doSome ִ�н���");
	}
	
	public synchronized void doOther() {
		System.out.println("doOther ��ʼִ��");
		System.out.println("doOther ��ʼִ��");
	}
}

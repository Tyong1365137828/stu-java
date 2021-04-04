package edu.hebeu.threadsafety;

/**
 * ����synchronized�������⣺
 * 	�ʣ����´�����ʾ��t2�߳�ִ�е�doOther()������ȴ�t1�߳�ִ����doSome()����������ִ����
 * 		����ȴ��������̵߳Ĺ������һ��(��������һ��)��һ����MyClass3���myClass1������һ����MyClass3���myClass2������ȻdoSome()��doOther()��������synchronized�ؼ������Σ�
 * 		���Ƕ�������һ�������Բ�����ֵȴ���ϵ
 * @author 13651
 *
 */
public class SynchronizedInterview3 {
	public static void main(String[] args) {
		MyClass3 myClass1 = new MyClass3(); // ����MyClass1����
		MyClass3 myClass2 = new MyClass3(); // ����MyClass1����
		
		Thread t1 = new MyThread3(myClass1); // �����߳�t1
		Thread t2 = new MyThread3(myClass2); // �����߳�t2
		
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

class MyThread3 extends Thread {
	
	private MyClass3 myClass;

	public MyThread3(MyClass3 myClass) {
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

class MyClass3 {
	
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

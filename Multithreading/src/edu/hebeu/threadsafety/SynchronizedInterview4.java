package edu.hebeu.threadsafety;

/**
 * ����synchronized�������⣺
 * 	�ʣ����´�����ʾ��t2�߳�ִ�е�doOther()������ȴ�t1�߳�ִ����doSome()����������ִ����
 * 		��ȴ���doSome()��doOther()�������Ǿ�̬�����Ҷ���synchronized�ؼ������Σ�������������һ���಻��new���ٸ����󣬶�ֻ��һ��������
 * 		���Ի���ֵȴ���ϵ��
 * @author 13651
 *
 */
public class SynchronizedInterview4 {
	public static void main(String[] args) {
		MyClass4 myClass1 = new MyClass4(); // ����MyClass4�Ķ���
		MyClass4 myClass2 = new MyClass4(); // ����MyClass4�Ķ���
		
		Thread t1 = new MyThread4(myClass1); // �����߳�t1
		Thread t2 = new MyThread4(myClass2); // �����߳�t2
		
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
	 * �����̬������synchronized�ؼ������Σ�����������
	 */
	public synchronized static void doSome() {
		System.out.println("doSome ��ʼִ��");
		try {
			Thread.sleep(1000 * 6); // ��ǰ�߳�˯��6��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doSome ִ�н���");
	}
	
	/**
	 * �����̬������synchronized�ؼ������Σ�����������
	 */
	public synchronized static void doOther() {
		System.out.println("doOther ��ʼִ��");
		System.out.println("doOther ��ʼִ��");
	}
}

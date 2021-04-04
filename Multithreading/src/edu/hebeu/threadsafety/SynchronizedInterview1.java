package edu.hebeu.threadsafety;

/**
 * ����synchronized�������⣺
 * 	�ʣ����´�����ʾ��t2�߳�ִ�е�doOther()������ȴ�t1�߳�ִ����doSome()����������ִ����
 * 		����ȴ�����Ȼ�����̵߳Ĺ������һ��(������һ��)������MyClass���myClass����doSome()����ʹ����synchronized�ؼ��֣�����doOther()����û��ʹ��synchronized�ؼ������Σ����Բ�����ֵȴ���ϵ��
 * @author 13651
 *
 */
public class SynchronizedInterview1 {
	public static void main(String[] args) {
		MyClass myClass = new MyClass(); // ����MyClass����
		
		Thread t1 = new MyThread(myClass); // �����߳�t1
		Thread t2 = new MyThread(myClass); // �����߳�t2
		
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

class MyThread extends Thread {
	
	private MyClass myClass;

	public MyThread(MyClass myClass) {
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


class MyClass {
	
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
	
	public void doOther() {
		System.out.println("doOther ��ʼִ��");
		System.out.println("doOther ��ʼִ��");
	}
}

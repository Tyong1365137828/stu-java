package edu.hebeu.multithreading;

/**
 * ������������̵߳�sleep()�����������⣻
 * ������ʾ������Ĵ�������߳� t1 ��������״̬��
 * 		���ᣬsleep()�����Ǿ�̬�ģ���ִ���������һ�д��� t.sleep() ʱ���ǻ�ת���� Thread.sleep()��
		���д���������ǣ��õ�ǰ�߳̽���˯��״̬�����д��������main()�����У�Ҳ����˵main�߳̽���˯��״̬��
 * @author 13651
 *
 */
public class SleepMethodInterview {
	public static void main(String[] args) {
		Thread t = new MyThread5(); // ʹ�ö�̬�����̶߳���
		t.setName("t1"); // �����߳�����
		t.start(); // �����߳�
		
		try {
			t.sleep(1000 * 5); // ���߳�˯��5��
			/**ע�⣬sleep()�����Ǿ�̬�ģ���ִ���������һ�д��� t.sleep() ʱ���ǻ�ת���� Thread.sleep()��
			 * ���д���������ǣ��õ�ǰ�߳̽���˯��״̬�����д��������main()�����У�Ҳ����˵main�߳̽���˯��״̬��*/
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
			System.out.println("�߳�---->" + i);
		}
	}
	
}
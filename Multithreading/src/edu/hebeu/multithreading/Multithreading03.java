package edu.hebeu.multithreading;

/**
 * ���õ����ַ�ʽʵ���̣߳������ڲ���
 * 
 * @author 13651
 *
 */
public class Multithreading03 {
	public static void main (String[] args) {
		/**�����߳�����󣬲��������ڲ��෽ʽ*/
		Thread myThread = new Thread(new Runnable() { // Runnable�ǽӿڣ�new����ʱҪ���ϴ�����

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++) {
					System.out.println("֧�̣߳�i=" + i);
				}
			}
			
		});
		
		myThread.start(); // �����߳�
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("Main���̣߳�i=" + i);
		}
	}
}

package edu.hebeu.multithreading;

/**
 * ���������ʾ���ǿ����ֹһ���߳�
 * 	void stop(); // ֱ������(ɱ��)������̣߳����ַ�ʽ�Ѿ���ʱ��������ʹ�ã�
 * 		// ��Ϊ���ַ�ʽֱ�ӽ��߳�ɱ���ˣ��߳�û�б�������ݻᶪʧ����
 * 
 * 	�ڿ�������������һ���߳����еı�ǣ�������Ϊtrue���ͽ����߳�ҵ�񣻷����return�� run()�����������̣߳�
 * ��ʱҪ������߳�ֻ��Ҫͨ�����Ŀ�������Ķ���ı��Ϊfalse����return�� run()�����������̣߳������ڽ�����
 * ��֮ǰ���Խ��н���֮ǰ��ҵ���籣�����ݵȣ�
 * 	
 * @author 13651
 *
 */
public class ForceFinishThread {
	public static void main(String[] args) {
		/**û��ʹ�ñ�Ǵ����Ŀ������ഴ�����̶߳���*/
//		Thread thread = new Thread(new MyRunnable3()); // �����̶߳���
//		thread.setName("t1"); // �����߳�����
//		thread.start(); // �����߳�
		
		/**ʹ�ñ�Ǵ����Ŀ������ഴ�����̶߳���*/
		MyRunnable4 mr = new MyRunnable4(); // ���������������
		Thread thread2 = new Thread(mr); // ͨ������������󴴽��̶߳���
		thread2.setName("t2"); // �����߳�����
		thread2.start(); // �����߳�
		
		try {
			Thread.sleep(1000 * 6); // ��ǰ�߳�(���߳�main)˯��5��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ǿ����ֹ�̣߳�ֱ������(ɱ��)������߳�
//		thread.stop(); // �ѹ�ʱ��������ʹ�ã���Ϊ���ַ�ʽֱ�ӽ��߳�ɱ���ˣ��߳�û�б�������ݻᶪʧ����
		/**����������Ķ���ı���޸�Ϊfalse�������Ľ����߳�*/
		mr.runnFlag = false;
		
		System.out.println("END!!!");
	}
}

class MyRunnable3 implements Runnable {
	@Override
	public void run() {
		// ���´����ʾÿһ��ѭ��һ��
		for(int i = 0; i < 20; i++) {
			System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "����i=" + i);
			
			try {
				Thread.sleep(1000); // ˯��һ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyRunnable4 implements Runnable {

	boolean runnFlag = true; // ��һ���߳����в������
	
	@Override
	public void run() {
		// ���´����ʾÿһ��ѭ��һ��
		for(int i = 0; i < 20; i++) {
			if(runnFlag) { // ������Ϊtrue���ͽ����̵߳�ҵ�����
				System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "����i=" + i);
				
				try {
					Thread.sleep(1000); // ˯��һ��
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			} else { // ����
				
				/**��return֮ǰ��Ҫ��������ݽ��б����ҵ��*/
				return; // �ͽ���run()����������ֹ��ǰ�߳�
			}
		}
	}
	
}

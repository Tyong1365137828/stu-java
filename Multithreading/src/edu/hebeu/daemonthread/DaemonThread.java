package edu.hebeu.daemonthread;

/**
 * ʵ��һ���ػ��߳�
 * @author 13651
 *
 */
public class DaemonThread {
	public static void main(String[] args) {
		Thread daemonThread = new BackupThread(); // �����̶߳���
		daemonThread.setName("�ػ��߳�1(����)");
		daemonThread.setDaemon(true); // �����߳�֮ǰ��������̶߳���Ϊ�ػ��̣߳����û��̶߳�������ϣ�����̶߳���ͻ�ǿ���Զ�����
		daemonThread.start(); // �����߳�
		
		for(int i = 0; i < 20; i++) {
			System.out.println("���߳�ִ�У���" + (i + 1) + "��");
			try {
				Thread.sleep(1000); // ˯��1��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class BackupThread extends Thread {

	@Override
	public void run() {
		int i = 0;
		while(true) { // ���������߳��ഴ�����̶߳�������Ϊ�ػ��̣߳����û��߳�ִ����ϣ����Ｔʹ������ѭ��Ҳ�����������
			System.out.println(Thread.currentThread().getName() + "�̣߳����ݴ�����" + (++i) + "��������...");
			try {
				Thread.sleep(3000); // ˯��3��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

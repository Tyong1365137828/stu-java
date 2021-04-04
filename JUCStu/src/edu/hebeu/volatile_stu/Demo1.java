package edu.hebeu.volatile_stu;

/**
 * �������ʾ���µ����ӣ��Դ������ڴ治�ɼ���volatile�ؼ���
 * 
 * 	��֪����֪��JVMΪ�����Ч�ʣ�����ÿ���߳��п��ٶ����Ļ������򣬽���ȡ�������ݷŵ��ˣ����޸ĸ�����ʱ��
 * ���Ƚ���������������޸ģ��ٽ������ݸ���������
 * 
 * ����ԭ��
 * 	��Ϊ�߳�1����sleep200���룬����main�߳��ȶ�ȡ����������ݣ�֮�����ִ���ٶȷǳ����while(true)ѭ���У�
 * ���߳�1��sleep200������ٽ���������ݶ��벢�޸ģ�����main�߳�������while(true)��û�������Ĳ������ִ��
 * �ǳ��죬����û���ӳٵ�ʱ��ȥ���������¶�ȡ�µ�����(�����ڵ�������true����main�̻߳����ȴ��false)�����
 * �ͻ��������������
 * 
 * ���ϵķ��������ڴ治�ɼ��ԣ�������̲߳���һ����������ʱ�˴�֮�䲻�ɼ���
 * 
 * �����
 * 	��ʽһ���� if(myRunnable.isFlag()) ����synchronized(td)������ʹͬ���������ܽ���������������ᵼ�³���
 * ��Ч�ʷǳ��ͣ�
 * 	��ʽ�����ڹ�������������volatile�ؼ��֣�
 * 		1��volatile�ؼ��ֵ����ã�������̲߳�����������ʱ����֤�ڴ�ɼ��ԣ�
 * 		2���ùؼ��ֵײ���õ��Ǽ�����ײ���룬���ڴ�դ��������ʵʱ��ˢ������
 * 		3��ʹ��volatile�ؼ���JVM�Ͳ��ܶԱ������εı������������Ч�ʻ��ͣ�
 * 		4����������ڷ�ʽһsynchronized����Ч�ʸߣ�
 * 
 * volatile�ؼ��ֵ�ע�⣺
 * 	1�������synchronized������"������"��
 * 	2�����ܱ�֤������"ԭ����"��
 * 
 * @author 13651
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		
		new Thread(myRunnable).start(); // �����߳�
		
		while(true) {
//			synchronized(myRunnable) { // ��ʽһ�Ľ���취
			if(myRunnable.isFlag()) {
				System.out.println("�յ�flagΪ" + myRunnable.isFlag() + "��׼������ѭ��");
				break;
			}
//			}
			
//			System.out.println("flagΪ��" + myRunnable.isFlag() + "������ѭ��..."); // ��Ҫ�������䣬�����Ӱ��while��ִ��Ч�ʣ����±�����ʾ���ɹ�
		}

	}
}

class MyRunnable implements Runnable {

//	private volatile boolean flag = false; // ʹ�÷�ʽ���Ľ���취

	private boolean flag = false;

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true;
		System.out.println("֪ͨ��flag�Ѿ���ɣ�" + isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}

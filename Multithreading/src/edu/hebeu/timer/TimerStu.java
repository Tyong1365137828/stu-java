package edu.hebeu.timer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * �������ѧϰjava.util.Timer��
 * 	���췽����
 * 		Timer(); // ����һ����ʱ��
 * 		Timer(boolean isDaemon); // ����һ����ʱ��������ص��߳��Ƿ���Ϊ�ػ��߳����У�true��ʾ��̨�߳�(�ػ��߳�)��false��ʾ�û��߳�
 * 		Timer(String name); // ����һ����ʱ��������ص��߳̾���ָ��������
 * 		Timer(String name, boolean isDaemon); // ����һ����ʱ��������ص��߳̾���ָ�������ƣ���������ص��߳��Ƿ���Ϊ�ػ��߳����У�true��ʾ��̨�߳�(�ػ��߳�)��false��ʾ�û��߳�
 * 
 * 	���÷�����
 * 		schedule(TimerTask task, Date firstTime, long millisecond); // ����ʱ������ί�����񣬲���2����һ��ִ��ʱ�䣻����3���̶��ӳٶ��ִ�У���λ���룻
 * 
 * @author 13651
 *
 */
public class TimerStu {
	public static void main(String[] args) {
		
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("��Ϣ\\��ʱ��\\��־��Ϣ", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ����������ķ���ı��� ��Ϣ\\��ʱ��\\��־��Ϣ �ļ�������ָ�����̨
		System.setOut(ps); // ͨ������Ķ����޸�������򣬽���������ķ���ı��� ��Ϣ\\��ʱ��\\��־��Ϣ �ļ�������ָ�����̨
		
		
//		Timer timer = new Timer(); // ������ʱ������
//		Timer timer = new Timer("����ʱ��"); // ������Ϊ "����ʱ��" �Ķ�ʱ������
//		Timer timer = new Timer(true); // ������ʱ������(�ػ��̵߳ķ�ʽ)����ʱΪ�˱�֤����ػ��̲߳�������Ҫʹ�û��̲߳�����
		Timer timer = new Timer("����ʱ��", true); // ������Ϊ "����ʱ��" �Ķ�ʱ������(�ػ��̵߳ķ�ʽ)����ʱΪ�˱�֤����ػ��̲߳�������Ҫʹ�û��̲߳�����
		
		/**�����һ�ε�ִ��ʱ��*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date firstTime = new Date(); // ���������һ�ε�ִ��ʱ��
		try {
			firstTime = sdf.parse("2021-02-04 08:50:30 000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ����ʱ��ί������
//		timer.schedule(new LogTask(), firstTime, 1000 * 10); // ί������ΪLogTask��Ķ����״δ�firstTimeִ�У�ÿ10��ִ��һ��ί���¼�
		timer.schedule(new TimerTask(){ // ʹ�������ڲ���ķ�ʽ����Ҫί�е��������ί��
			@Override
			public void run() {
				// �����д��Ҫִ�е�����
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
				String nowDate = sdf.format(new Date()); // ��ȡ��ǰʱ��
				
				System.out.println("��ǰʱ��:" + nowDate + ";LogTaskִ�С�" + Thread.currentThread().getName() + "�������ݱ�����...");
			}
			
		}, firstTime, 1000 * 60 * 2); // ί������ΪLogTask��Ķ����״δ�firstTimeִ�У�ÿ2����ִ��һ��ί���¼�
		
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("main��ջ<�û��߳�>����" + Thread.currentThread().getName() + "�������У����д�����" + (i+1) );
			try {
				Thread.sleep(1000); // ˯��1��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

/**
 * ��ʱ���������࣬TimerTask�ǳ����࣬����new������Ҫ����һ����ʱ��������̳���
 * @author 13651
 *
 */
class LogTask extends TimerTask {

	@Override
	public void run() {
		// �����д��Ҫִ�е�����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		String nowDate = sdf.format(new Date()); // ��ȡ��ǰʱ��
		
		System.out.println("��ǰʱ��:" + nowDate + ";LogTaskִ�С�" + Thread.currentThread().getName() + "�������ݱ�����...");
	}
	
}

package edu.hebeu.volatile_stu;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ԭ���Ե�����
 * 
 * �ȿ�һ�������⣺
 * 		int i = 10;
 * 		i = i++; // �����i = 10
 *	��Ϊi++�ĵײ�ʵ���ǣ�
 *		int temp = i;
 *		i = i + 1;
 *		i = temp;
 *	���Բ��������ϵĲ������ɴ� i++����"��->��->д"
 *
 *	������������ӣ�������ԭ�������Ϊi++��������һ���Ķ��Ƕಽ��(��->��->д)����ʱ����ʹ����volatile�ؼ���
 *��֤�ڴ�ɼ������Ƿ����Ժ���֪��Ȼ�������������⣡
 *
 *	�����
 *		ʹ��ԭ�ӱ�������ԭ�ȵı����ͼ��㣬�Ͳ����������������ˣ�
 *	ԭ�ӱ�����jdk1.5֮��java.util.concurrent.atomic�����ṩ�ĳ���ԭ�ӱ�����
 *		1���ð��µ������࣬�����ڰ�װ�࣬���Integer�ġ�String�ġ���������ġ�...����Щ���ڲ��ı�����ʹ��
 *		��volatile�ؼ�������֤�ڴ�Ŀɼ��ԣ�
 *		2���ײ�ʹ��CAS(Compare-And-Swap)�㷨��֤���ݵ�ԭ���ԣ�
 *			��֪CAS�㷨��Ӳ�����ڲ��������������ݵ�֧�֣�CAS�㷨�������������������У��ڴ�ֵ V��Ԥ��ֵ A��
 *			����ֵ B�����ҽ��� V == Aʱ��V = B�����򽫲����κβ�����
 *		
 *
 * @author 13651
 *
 */
public class AtomicDemo {
	public static void main(String[] args) {
		MyRunnable2 myRunnable2 = new MyRunnable2();
		
		for (int i = 0; i < 16; i++) {
			new Thread(myRunnable2).start(); // �ᷢ�ֳ������⣬�п��ܲ����ظ����ݣ�����
		}
	}
}

class MyRunnable2 implements Runnable {
	
	private int i = 0;
//	private AtomicInteger i = new AtomicInteger(); // ʹ�øö������ԭ�ȵı���

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "; i = " + getAdd());
	}
	
	public int getAdd() {
		return i++;
//		return i.getAndIncrement(); // ʹ���ڲ���ʵ����������ԭ�ȵ�++����
	}
}

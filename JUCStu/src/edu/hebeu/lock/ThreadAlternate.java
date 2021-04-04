package edu.hebeu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ���������ʾ�߳̽���ִ��
 * 
 * ��дһ�����򣬿���3���̣߳��������̵߳����ֱַ���A��B��C��ÿ���߳�
 * ���Լ��������ڿ���̨��ӡ10�飬Ҫ������Ľ�����밴˳����ʾ��
 * �磺ABCABCABC......��AABBBCCCCCCAABBBCCCCCC......
 * @author 13651
 *
 */
public class ThreadAlternate {
	public static void main(String[] args) {
		
		MyAlternate alternate = new MyAlternate();
		
		new Thread(() -> {
			for(int i = 0; i < 6; i++) { // ��ӡ����A������ѯ6��
				alternate.loopA();
			}
		}, "A").start(); // ����A�̣߳�ִ��loopA()������ӡA
		
		new Thread(() -> {
			for(int i = 0; i < 6; i++) { // ��ӡ����C������ѯ6��
				alternate.loopB();
			}
		}, "B").start(); // ����B�̣߳�ִ��loopB()������ӡB
		
		new Thread(() -> {
			for(int i = 0; i < 6; i++) { // ��ӡ����C������ѯ6��
				alternate.loopC();
			}
		}, "C").start(); // ����C�̣߳�ִ��loopC()������ӡC
		
	}
}

class MyAlternate {
	private int number = 1; // ������ʾ��ǰִ�е��̣߳�1����A��2����B��3����C
	private Lock lock = new ReentrantLock();
	
	private Condition conditionA = lock.newCondition(); // A��ͨ�Ŷ���
	private Condition conditionB = lock.newCondition(); // B��ͨ�Ŷ���
	private Condition conditionC = lock.newCondition(); // C��ͨ�Ŷ���
	
	public void loopA() {
		lock.lock(); // ����
		try {
			/*�ж�*/
			if(number != 1) { // �����ǲ���1��������A�߳�
				try {
					conditionA.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*����ִ�е��ˣ�˵����A�̣߳����ӡ*/
			System.out.print(Thread.currentThread().getName() + "\t");
			/*����B�߳�*/
			number = 2; // �޸ı��Ϊ2
			conditionB.signal();
		} finally {
			lock.unlock(); // �ͷ���
		}
	}
	
	public void loopB() {
		lock.lock(); // ����
		try {
			/*�ж�*/
			if(number != 2) { // �����ǲ���2��������B�߳�
				try {
					conditionB.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*����ִ�е��ˣ�˵����B�̣߳����ӡ*/
			System.out.print(Thread.currentThread().getName() + "\t");
			/*����C�߳�*/
			number = 3; // �޸ı��Ϊ3
			conditionC.signal();
		} finally {
			lock.unlock(); // �ͷ���
		}
	}
	
	public void loopC() {
		lock.lock(); // ����
		try {
			/*�ж�*/
			if(number != 3) { // �����ǲ���3��������C�߳�
				try {
					conditionC.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*����ִ�е��ˣ�˵����C�̣߳����ӡ*/
			System.out.print(Thread.currentThread().getName() + "\t");
			/*����A�߳�*/
			number = 1; // �޸ı��Ϊ1
			conditionA.signal();
		} finally {
			lock.unlock(); // �ͷ���
		}
	}
	
}

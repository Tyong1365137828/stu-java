package edu.hebeu.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * �������ѧϰ��ʾ��д��
 * 
 * ����������ж���̲߳���һ���������ݣ����������
 * 	1������д��������ʱΪ�˱�֤���ݵİ�ȫ����Ҫ����(����д����ͬʱ����)
 * 	2��д��д��������ʱΪ�˱�֤���ݵİ�ȫ��Ҳ��Ҫ����(д��д֮�䲻��ͬʱ����)
 * 	3�����Ͷ���������ʱ����û�а�ȫ�Ե����⣬����Ҫ����(���Ͷ�֮�����ͬʱ����)
 * 
 * ReadWriteLock
 * 
 * @author 13651
 *
 */
public class ReadWriteLockStu {
	public static void main(String[] args) {
		ReadWrite readWrite = new ReadWrite();
		
		/*�����߳�*/
		for(int i = 1; i <= 4; i++) { // 4�����߳�
			new Thread(() -> {
				while(true) { // һֱ��
					readWrite.read();
				}
			}, "Read" + i).start();
		}
		
		
		/*д���߳�*/
		new Thread(() -> {
			for(int i = 0; i < 2; i++) { // ����д����
				int writeData = (int) (Math.random() * 101);
				readWrite.write(writeData);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Write1").start();
		
		new Thread(() -> {
			for(int i = 0; i < 2; i++) { // ����д����
				int writeData = (int) (Math.random() * 101);
				readWrite.write(writeData);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Write2").start();
	}
}

class ReadWrite {
	
	private int data; // �����Ĺ�������
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // ��д������
	
	/**
	 * ��������ֻ�ж�����ʱ���Ա�����̲߳����Ķ�������Ҫ�����̰߳�ȫ����
	 */
	public void read() {
		try {
			Thread.sleep(50); // ˯50ms
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readWriteLock.readLock().lock(); // ������
		try {
			System.out.println(Thread.currentThread().getName() + "��data=" + data);
		} finally {
			readWriteLock.readLock().unlock(); // ���ͷ���
		}
	}
	
	/**
	 * д��������д����ʱ����Ҫ��֤���ݵİ�ȫ����Ҫ�����̰߳�ȫ����
	 * @param writeData д�������
	 */
	public void write(int writeData) {
		readWriteLock.writeLock().lock(); // д����
		try {
			data = writeData;
			System.out.println(Thread.currentThread().getName() + "��data -> " + data);
		} finally {
			readWriteLock.writeLock().unlock(); // д�ͷ���
		}
	}
	
}

package edu.hebeu.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 这个例子学习演示读写锁
 * 
 * 举例：如果有多个线程操作一个共享数据，如下情况：
 * 	1、读和写操作：此时为了保证数据的安全，需要互斥(读和写不能同时进行)
 * 	2、写和写操作：此时为了保证数据的安全，也需要互斥(写和写之间不能同时进行)
 * 	3、读和读操作：此时数据没有安全性的问题，不需要互斥(读和读之间可以同时进行)
 * 
 * ReadWriteLock
 * 
 * @author 13651
 *
 */
public class ReadWriteLockStu {
	public static void main(String[] args) {
		ReadWrite readWrite = new ReadWrite();
		
		/*读的线程*/
		for(int i = 1; i <= 4; i++) { // 4个读线程
			new Thread(() -> {
				while(true) { // 一直读
					readWrite.read();
				}
			}, "Read" + i).start();
		}
		
		
		/*写的线程*/
		new Thread(() -> {
			for(int i = 0; i < 2; i++) { // 两次写操作
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
			for(int i = 0; i < 2; i++) { // 两次写操作
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
	
	private int data; // 操作的共享数据
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // 读写锁对象
	
	/**
	 * 读操作，只有读操作时可以被多个线程并发的读，不需要考虑线程安全问题
	 */
	public void read() {
		try {
			Thread.sleep(50); // 睡50ms
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readWriteLock.readLock().lock(); // 读上锁
		try {
			System.out.println(Thread.currentThread().getName() + "：data=" + data);
		} finally {
			readWriteLock.readLock().unlock(); // 读释放锁
		}
	}
	
	/**
	 * 写操作，有写操作时就需要保证数据的安全，需要考虑线程安全问题
	 * @param writeData 写入的数据
	 */
	public void write(int writeData) {
		readWriteLock.writeLock().lock(); // 写上锁
		try {
			data = writeData;
			System.out.println(Thread.currentThread().getName() + "：data -> " + data);
		} finally {
			readWriteLock.writeLock().unlock(); // 写释放锁
		}
	}
	
}

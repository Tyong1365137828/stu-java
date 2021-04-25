package edu.hebeu.pipe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.Scanner;


/**
 * �������������ʾ�ܵ�(Pipe)��ʹ��ʵ��
 * @author 13651
 *
 */
public class PipeDemo {
	
	/**
	 * ����һ���ܵ�
	 */
	private static Pipe pipe;
	
	/**
	 * ����һ��������
	 */
	private static ByteBuffer buffer = ByteBuffer.allocate(1024);
	
	static {
		try {
			// ��ȡ�ܵ�����
			pipe = Pipe.open();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �÷������򻺳�����������ݵķ���
	 */
	private static void putDataToBuffer(Object data) {
		buffer.put(data.toString().getBytes());
	}
	
	/**
	 * ���Է���
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * ���շ��߳�
		 */
		new Thread(() -> {
			
			PrintStream ps = null;
			
			try {
				ps = new PrintStream(new FileOutputStream("data\\log", true));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.setOut(ps);
			
			// ͨ���ܵ���ȡSourceChannelͨ��
			Pipe.SourceChannel sourceChannel = pipe.source();
			// ����������ɶ�ģʽ
			buffer.flip();
			// ��ͨ���ڵ����ݶ�ȡ��������������ȡ�������ڵ����ݸ���
			int count = 0;
			try {
				count = sourceChannel.read(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(new String(buffer.array(), 0, count));
		}).start();
		
		/*
		 * ���ͷ�
		 */
		// ͨ���ܵ���ȡSinkChannelͨ��
		Pipe.SinkChannel sinkChannel = pipe.sink();
		// �򻺳����������
		Scanner scanner = new Scanner(System.in);
		System.out.print("�����룺");
		while(scanner.hasNext()) {
			String data = scanner.next();
			putDataToBuffer(data);
			// ����������ɶ�ģʽ
			buffer.flip();
			try {
				// ���������ڵ�����ͨ��д��SinkChannelͨ����pipe�ܵ���
				sinkChannel.write(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// �ر���Դ
		scanner.close();
		try {
			sinkChannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

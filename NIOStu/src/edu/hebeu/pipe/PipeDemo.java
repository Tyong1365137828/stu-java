package edu.hebeu.pipe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.Scanner;


/**
 * 这个例子用来演示管道(Pipe)的使用实例
 * @author 13651
 *
 */
public class PipeDemo {
	
	/**
	 * 声明一个管道
	 */
	private static Pipe pipe;
	
	/**
	 * 创建一个缓冲区
	 */
	private static ByteBuffer buffer = ByteBuffer.allocate(1024);
	
	static {
		try {
			// 获取管道对象
			pipe = Pipe.open();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 该方法是向缓冲区中添加数据的方法
	 */
	private static void putDataToBuffer(Object data) {
		buffer.put(data.toString().getBytes());
	}
	
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * 接收方线程
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
			
			// 通过管道获取SourceChannel通道
			Pipe.SourceChannel sourceChannel = pipe.source();
			// 将缓冲区变成读模式
			buffer.flip();
			// 将通道内的数据读取至缓冲区，并获取缓冲区内的数据个数
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
		 * 发送方
		 */
		// 通过管道获取SinkChannel通道
		Pipe.SinkChannel sinkChannel = pipe.sink();
		// 向缓冲区添加数据
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入：");
		while(scanner.hasNext()) {
			String data = scanner.next();
			putDataToBuffer(data);
			// 将缓冲区变成读模式
			buffer.flip();
			try {
				// 将缓冲区内的数据通过写入SinkChannel通道至pipe管道内
				sinkChannel.write(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 关闭资源
		scanner.close();
		try {
			sinkChannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

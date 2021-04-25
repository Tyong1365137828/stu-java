package edu.hebeu.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/**
 * 这个例子演示TCP方式的传统的网络中IO操作(阻塞式)
 * 
 * 使用NIO完成网络通信的三个核心：
 * 	1、通道(Channel)：负责连接
 * 		java.nio.channels.Channel接口
 * 			|--SelectableChannel // TCP使用
 * 			|--ServerSocketChannel //TCP使用
 * 			|--DatagramChannel	// UDP使用
 * 
 * 			|--Pipe.SinkChannel
 * 			|--Pipe.SourceChannel
 * 	2、缓冲区(Buffer)：负责数据的存取
 * 	3、选择器(Selector)：是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 * 
 * @author 13651
 *
 */
public class TCPBlockingTest {
	
	/**
	 * 客户端
	 * @throws IOException 
	 */
	@Test
	public void client() throws IOException {
		// 1、获取网络通道，通过IP(127.0.0.1)加端口(9898)
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		// 2、分配指定大小的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 3、读取本地文件，并发送到服务器
		FileChannel inChannel = FileChannel.open(Paths.get("client/bianmu.jpg"), 
				StandardOpenOption.READ); // 通过读的方式获取本地的数据并创建通道
		while(inChannel.read(buffer) != -1) {
			buffer.flip(); // 将缓冲区变成读模式
			sChannel.write(buffer); // 将缓冲区内的数据(inChannel本地读的文件通道)写入至sChannel(网络同道)
			buffer.clear(); // 将缓冲区的数据"遗忘"
		}
		// 告知服务端数据发送完毕
		sChannel.shutdownOutput();
		// 4、接收服务端的相应
		int count = 0;
		while((count = sChannel.read(buffer)) != -1) {
			buffer.flip();
			System.out.println(new String(buffer.array(), 0, count));
			buffer.clear(); // 将缓冲区内的数据"遗忘"
		}
		
		
		// 5、关闭管道
		inChannel.close();
		sChannel.close();
	}
	
	/**
	 * 服务端
	 * @throws IOException 
	 */
	@Test
	public void server() throws IOException {
		// 1、获取网络通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		// 2、绑定连接
		ssChannel.bind(new InetSocketAddress(9898));
		// 3、获取客户端连接的通道
		SocketChannel sChannel = ssChannel.accept();
		// 4、分配指定大小的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 5、接收并保存客户端的数据
		FileChannel outChannel = FileChannel.open(Paths.get("server/get1.jpg"), 
				StandardOpenOption.WRITE, StandardOpenOption.CREATE); // 创建本地的写(WRITE)通道，文件不存在就创建，存在就覆盖
		while(sChannel.read(buffer) != -1) {
			buffer.flip(); // 将缓冲区变成读模式
			outChannel.write(buffer); // 将缓冲区内的数据(sChannel用户发来的，网络上的通道)写入至outChannel(本地文件通道
			buffer.clear(); // 将缓冲区内的数据"遗忘"
		}
		// 6、反馈给客户端
		buffer.put("服务器接收数据成功".getBytes());
		buffer.flip(); // 将缓冲区变成读模式
		sChannel.write(buffer); // 将缓冲区内的数据写入sChannel管道内
		// 7、关闭通道
		sChannel.close();
		outChannel.close();
		ssChannel.close();
	}
	
}

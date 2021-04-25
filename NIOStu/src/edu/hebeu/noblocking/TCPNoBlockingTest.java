package edu.hebeu.noblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

/**
 * 这个例子演示TCP方式的非阻塞式IO操作
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
 * 		重要方法：
 * 			register(Selector selector, int ops); // 用于将通道注册选择器时，选择器对通道的监听
 * 			// 事件，需要通过第二个参数ops指定；
 * 			第二个参数ops表示可以监听的事件类型(可使用SelectionKey的四个常量表示)：
 * 				读：SelectionKey.OP_READ (1)
 * 				写：SelectionKey.OP_WRITE (4)
 * 				连接：SelectionKey.OP_CONNECT (8)
 * 				接收：SelectionKey.OP_ACCEPT (16	)
 * 			若注册时不止一个事件，则可以使用"位或"操作符连接，如：int intertSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
 * 
 * @author 13651
 *
 */
public class TCPNoBlockingTest {

	@Test
	public void client() throws IOException {
		// 1、获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		// 2、切换成非阻塞模式
		sChannel.configureBlocking(false);
		// 3、分配指定大小的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		// 4、发送数据给服务端
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String str = scanner.next();
			buffer.put((str + "\t\t" + LocalDateTime.now().toString()).getBytes()); // 给缓冲区buffer中添加数据
			buffer.flip(); // 将缓冲区变成读模式
			sChannel.write(buffer); // 将buffer内的数据写入通道
			buffer.clear(); // 将缓冲区内的数据"遗忘"
		}
		
		// 5、关闭资源
		sChannel.close();
		scanner.close();
	}
	
	@Test
	public void server() throws IOException {
		// 1、获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		// 2、切换成非阻塞模式
		ssChannel.configureBlocking(false);
		// 3、绑定链接
		ssChannel.bind(new InetSocketAddress(9898));
		// 4、获取选择器
		Selector selector = Selector.open();
		// 5、将通道注册到选择器上，并指定监听事件为ACCEPT接收事件，以使选择器能够监控该通道
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		// 6、通过选择器轮询式的获取选择器上已经"准备就绪"的事件
		while(selector.select() > 0) { // 因为监听事件的常量值对应的int都是大于0的，所以当select()方法检测到选择器selector大于0，表示至少有一个事件已经准备就绪
			/*
			 * 方法分析：获取选择器中所有注册的选择键的Set集合对应的迭代器
			 * 		selectedKeys(); // 获取选择器对象上所有注册的事件，以Set<SelectionKey>的集合形式返回
			 * 		iterator(); // 获取选择器上所有注册的事件的集合的迭代器
			 */
			Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
			// 8、迭代所有的选择键
			while(selectionKeyIterator.hasNext()) {
				// 9、获取"准备就绪"的事件
				SelectionKey sk = selectionKeyIterator.next(); // 获取选择键
				// 10、判断具体是什么事件准备就绪
				if(sk.isAcceptable()) { // 如果"接收就绪"
					SocketChannel sChannel = ssChannel.accept(); // 获取客户端连接
					// 11、将客户端的通道切换成非阻塞模式
					sChannel.configureBlocking(false);
					// 12、将该通道注册到选择器上，并指定监听事件为READ接收事件，以使选择器能够监控该通道
					sChannel.register(selector, SelectionKey.OP_READ);
				} else if(sk.isReadable()) { // 13、如果"读就绪"
					// 14、获取当前选择器上"读就绪"状态的通道
					SocketChannel sChannel = (SocketChannel) sk.channel();
					// 15、读取数据
					ByteBuffer buffer = ByteBuffer.allocate(1024); // 设置指定大小的缓冲区
					int count = 0;
					while((count = sChannel.read(buffer)) > 0) {
						buffer.flip(); // 将缓冲区切换成读模式
						System.out.println(new String(buffer.array(), 0, count));
						buffer.clear(); // 将缓冲区内的数据"遗忘"
					}
					sChannel.close(); // 关闭通道
				} else if(sk.isWritable()) { // 如果"写就绪"
					// ...
				} else if(sk.isConnectable()) { // 如果"连接就绪"
					// ...
				} else if(sk.isValid()) { // 如果"是有效的"
					
				}
				// 16、取消选择键SelectionKey
				selectionKeyIterator.remove();
			}
		}
		ssChannel.close(); // 关闭通道
	}
}

package edu.hebeu.noblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

/**
 * 这个类演示使用UDP方式的非阻塞式IO操作
 * @author 13651
 *
 */
public class UDPNoBlockingTest {

	/**
	 * 发送端
	 * @throws IOException 
	 */
	@Test
	public void send() throws IOException {
		// 1、开启网络通道
		DatagramChannel dChannel = DatagramChannel.open();
		// 2、切换成非阻塞模式
		dChannel.configureBlocking(false);
		// 3、创建指定大小的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 4、发送数据
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String str = scanner.next();
			buffer.put((str + "\t\t" + LocalDateTime.now().toString()).getBytes()); // 给缓冲区buffer中添加数据
			buffer.flip(); // 将缓冲区变成读模式
			dChannel.send(buffer, new InetSocketAddress("127.0.0.1", 9898)); // 通过管道将buffer内的数据发送出去(InetSocketAddress对象对应的网络地址)
			buffer.clear(); // 将缓冲区内的数据"遗忘"
		}
		// 5、关闭资源
		dChannel.close();
		scanner.close();
	}
	
	/**
	 * 接收端
	 * @throws IOException 
	 */
	@Test
	public void receive() throws IOException {
		// 1、开启网络通道
		DatagramChannel dChannel = DatagramChannel.open();
		// 2、切换成非阻塞模式
		dChannel.configureBlocking(false);
		// 3、绑定端口号
		dChannel.bind(new InetSocketAddress(9898));
		// 4、获取选择器对象
		Selector selector = Selector.open();
		// 5、将通道注册到选择器上，并指定监听事件为READ接收事件，以使选择器能够监控该通道
		dChannel.register(selector, SelectionKey.OP_READ);
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
				if(sk.isReadable()) { // 13、如果"读就绪"
					// 12、读取数据
					ByteBuffer buffer = ByteBuffer.allocate(1024); // 设置指定大小的缓冲区
					dChannel.receive(buffer);
					buffer.flip(); // 将缓冲区切换成读模式
					System.out.println(new String(buffer.array(), 0, buffer.limit()));
					buffer.clear(); // 将缓冲区中的数据"遗忘"
				} else if(sk.isAcceptable()) { // 如果"接收就绪"
					// ...
				} else if(sk.isWritable()) { // 如果"写就绪"
					// ...
				} else if(sk.isConnectable()) { // 如果"连接就绪"
					// ...
				} else if(sk.isValid()) { // 如果"是有效的"
					
				}
				// 13、取消选择键SelectionKey
				selectionKeyIterator.remove();
			}
		}
		dChannel.close(); // 关闭通道
	}
}

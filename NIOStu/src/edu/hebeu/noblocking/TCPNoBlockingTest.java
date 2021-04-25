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
 * ���������ʾTCP��ʽ�ķ�����ʽIO����
 * 
 * ʹ��NIO�������ͨ�ŵ��������ģ�
 * 	1��ͨ��(Channel)����������
 * 		java.nio.channels.Channel�ӿ�
 * 			|--SelectableChannel // TCPʹ��
 * 			|--ServerSocketChannel //TCPʹ��
 * 			|--DatagramChannel	// UDPʹ��
 * 
 * 			|--Pipe.SinkChannel
 * 			|--Pipe.SourceChannel
 * 	2��������(Buffer)���������ݵĴ�ȡ
 * 	3��ѡ����(Selector)����SelectableChannel�Ķ�·�����������ڼ��SelectableChannel��IO״��
 * 		��Ҫ������
 * 			register(Selector selector, int ops); // ���ڽ�ͨ��ע��ѡ����ʱ��ѡ������ͨ���ļ���
 * 			// �¼�����Ҫͨ���ڶ�������opsָ����
 * 			�ڶ�������ops��ʾ���Լ������¼�����(��ʹ��SelectionKey���ĸ�������ʾ)��
 * 				����SelectionKey.OP_READ (1)
 * 				д��SelectionKey.OP_WRITE (4)
 * 				���ӣ�SelectionKey.OP_CONNECT (8)
 * 				���գ�SelectionKey.OP_ACCEPT (16	)
 * 			��ע��ʱ��ֹһ���¼��������ʹ��"λ��"���������ӣ��磺int intertSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
 * 
 * @author 13651
 *
 */
public class TCPNoBlockingTest {

	@Test
	public void client() throws IOException {
		// 1����ȡͨ��
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		// 2���л��ɷ�����ģʽ
		sChannel.configureBlocking(false);
		// 3������ָ����С�Ļ�����
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		// 4���������ݸ������
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String str = scanner.next();
			buffer.put((str + "\t\t" + LocalDateTime.now().toString()).getBytes()); // ��������buffer���������
			buffer.flip(); // ����������ɶ�ģʽ
			sChannel.write(buffer); // ��buffer�ڵ�����д��ͨ��
			buffer.clear(); // ���������ڵ�����"����"
		}
		
		// 5���ر���Դ
		sChannel.close();
		scanner.close();
	}
	
	@Test
	public void server() throws IOException {
		// 1����ȡͨ��
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		// 2���л��ɷ�����ģʽ
		ssChannel.configureBlocking(false);
		// 3��������
		ssChannel.bind(new InetSocketAddress(9898));
		// 4����ȡѡ����
		Selector selector = Selector.open();
		// 5����ͨ��ע�ᵽѡ�����ϣ���ָ�������¼�ΪACCEPT�����¼�����ʹѡ�����ܹ���ظ�ͨ��
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		// 6��ͨ��ѡ������ѯʽ�Ļ�ȡѡ�������Ѿ�"׼������"���¼�
		while(selector.select() > 0) { // ��Ϊ�����¼��ĳ���ֵ��Ӧ��int���Ǵ���0�ģ����Ե�select()������⵽ѡ����selector����0����ʾ������һ���¼��Ѿ�׼������
			/*
			 * ������������ȡѡ����������ע���ѡ�����Set���϶�Ӧ�ĵ�����
			 * 		selectedKeys(); // ��ȡѡ��������������ע����¼�����Set<SelectionKey>�ļ�����ʽ����
			 * 		iterator(); // ��ȡѡ����������ע����¼��ļ��ϵĵ�����
			 */
			Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
			// 8���������е�ѡ���
			while(selectionKeyIterator.hasNext()) {
				// 9����ȡ"׼������"���¼�
				SelectionKey sk = selectionKeyIterator.next(); // ��ȡѡ���
				// 10���жϾ�����ʲô�¼�׼������
				if(sk.isAcceptable()) { // ���"���վ���"
					SocketChannel sChannel = ssChannel.accept(); // ��ȡ�ͻ�������
					// 11�����ͻ��˵�ͨ���л��ɷ�����ģʽ
					sChannel.configureBlocking(false);
					// 12������ͨ��ע�ᵽѡ�����ϣ���ָ�������¼�ΪREAD�����¼�����ʹѡ�����ܹ���ظ�ͨ��
					sChannel.register(selector, SelectionKey.OP_READ);
				} else if(sk.isReadable()) { // 13�����"������"
					// 14����ȡ��ǰѡ������"������"״̬��ͨ��
					SocketChannel sChannel = (SocketChannel) sk.channel();
					// 15����ȡ����
					ByteBuffer buffer = ByteBuffer.allocate(1024); // ����ָ����С�Ļ�����
					int count = 0;
					while((count = sChannel.read(buffer)) > 0) {
						buffer.flip(); // ���������л��ɶ�ģʽ
						System.out.println(new String(buffer.array(), 0, count));
						buffer.clear(); // ���������ڵ�����"����"
					}
					sChannel.close(); // �ر�ͨ��
				} else if(sk.isWritable()) { // ���"д����"
					// ...
				} else if(sk.isConnectable()) { // ���"���Ӿ���"
					// ...
				} else if(sk.isValid()) { // ���"����Ч��"
					
				}
				// 16��ȡ��ѡ���SelectionKey
				selectionKeyIterator.remove();
			}
		}
		ssChannel.close(); // �ر�ͨ��
	}
}

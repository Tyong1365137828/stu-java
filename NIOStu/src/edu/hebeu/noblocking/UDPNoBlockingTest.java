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
 * �������ʾʹ��UDP��ʽ�ķ�����ʽIO����
 * @author 13651
 *
 */
public class UDPNoBlockingTest {

	/**
	 * ���Ͷ�
	 * @throws IOException 
	 */
	@Test
	public void send() throws IOException {
		// 1����������ͨ��
		DatagramChannel dChannel = DatagramChannel.open();
		// 2���л��ɷ�����ģʽ
		dChannel.configureBlocking(false);
		// 3������ָ����С�Ļ�����
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 4����������
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String str = scanner.next();
			buffer.put((str + "\t\t" + LocalDateTime.now().toString()).getBytes()); // ��������buffer���������
			buffer.flip(); // ����������ɶ�ģʽ
			dChannel.send(buffer, new InetSocketAddress("127.0.0.1", 9898)); // ͨ���ܵ���buffer�ڵ����ݷ��ͳ�ȥ(InetSocketAddress�����Ӧ�������ַ)
			buffer.clear(); // ���������ڵ�����"����"
		}
		// 5���ر���Դ
		dChannel.close();
		scanner.close();
	}
	
	/**
	 * ���ն�
	 * @throws IOException 
	 */
	@Test
	public void receive() throws IOException {
		// 1����������ͨ��
		DatagramChannel dChannel = DatagramChannel.open();
		// 2���л��ɷ�����ģʽ
		dChannel.configureBlocking(false);
		// 3���󶨶˿ں�
		dChannel.bind(new InetSocketAddress(9898));
		// 4����ȡѡ��������
		Selector selector = Selector.open();
		// 5����ͨ��ע�ᵽѡ�����ϣ���ָ�������¼�ΪREAD�����¼�����ʹѡ�����ܹ���ظ�ͨ��
		dChannel.register(selector, SelectionKey.OP_READ);
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
				if(sk.isReadable()) { // 13�����"������"
					// 12����ȡ����
					ByteBuffer buffer = ByteBuffer.allocate(1024); // ����ָ����С�Ļ�����
					dChannel.receive(buffer);
					buffer.flip(); // ���������л��ɶ�ģʽ
					System.out.println(new String(buffer.array(), 0, buffer.limit()));
					buffer.clear(); // ���������е�����"����"
				} else if(sk.isAcceptable()) { // ���"���վ���"
					// ...
				} else if(sk.isWritable()) { // ���"д����"
					// ...
				} else if(sk.isConnectable()) { // ���"���Ӿ���"
					// ...
				} else if(sk.isValid()) { // ���"����Ч��"
					
				}
				// 13��ȡ��ѡ���SelectionKey
				selectionKeyIterator.remove();
			}
		}
		dChannel.close(); // �ر�ͨ��
	}
}

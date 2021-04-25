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
 * ���������ʾTCP��ʽ�Ĵ�ͳ��������IO����(����ʽ)
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
 * 
 * @author 13651
 *
 */
public class TCPBlockingTest {
	
	/**
	 * �ͻ���
	 * @throws IOException 
	 */
	@Test
	public void client() throws IOException {
		// 1����ȡ����ͨ����ͨ��IP(127.0.0.1)�Ӷ˿�(9898)
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		// 2������ָ����С�Ļ�����
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 3����ȡ�����ļ��������͵�������
		FileChannel inChannel = FileChannel.open(Paths.get("client/bianmu.jpg"), 
				StandardOpenOption.READ); // ͨ�����ķ�ʽ��ȡ���ص����ݲ�����ͨ��
		while(inChannel.read(buffer) != -1) {
			buffer.flip(); // ����������ɶ�ģʽ
			sChannel.write(buffer); // ���������ڵ�����(inChannel���ض����ļ�ͨ��)д����sChannel(����ͬ��)
			buffer.clear(); // ��������������"����"
		}
		// ��֪��������ݷ������
		sChannel.shutdownOutput();
		// 4�����շ���˵���Ӧ
		int count = 0;
		while((count = sChannel.read(buffer)) != -1) {
			buffer.flip();
			System.out.println(new String(buffer.array(), 0, count));
			buffer.clear(); // ���������ڵ�����"����"
		}
		
		
		// 5���رչܵ�
		inChannel.close();
		sChannel.close();
	}
	
	/**
	 * �����
	 * @throws IOException 
	 */
	@Test
	public void server() throws IOException {
		// 1����ȡ����ͨ��
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		// 2��������
		ssChannel.bind(new InetSocketAddress(9898));
		// 3����ȡ�ͻ������ӵ�ͨ��
		SocketChannel sChannel = ssChannel.accept();
		// 4������ָ����С�Ļ�����
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 5�����ղ�����ͻ��˵�����
		FileChannel outChannel = FileChannel.open(Paths.get("server/get1.jpg"), 
				StandardOpenOption.WRITE, StandardOpenOption.CREATE); // �������ص�д(WRITE)ͨ�����ļ������ھʹ��������ھ͸���
		while(sChannel.read(buffer) != -1) {
			buffer.flip(); // ����������ɶ�ģʽ
			outChannel.write(buffer); // ���������ڵ�����(sChannel�û������ģ������ϵ�ͨ��)д����outChannel(�����ļ�ͨ��
			buffer.clear(); // ���������ڵ�����"����"
		}
		// 6���������ͻ���
		buffer.put("�������������ݳɹ�".getBytes());
		buffer.flip(); // ����������ɶ�ģʽ
		sChannel.write(buffer); // ���������ڵ�����д��sChannel�ܵ���
		// 7���ر�ͨ��
		sChannel.close();
		outChannel.close();
		ssChannel.close();
	}
	
}

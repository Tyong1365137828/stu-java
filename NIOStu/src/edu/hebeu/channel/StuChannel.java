package edu.hebeu.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * �����������ѧϰͨ��(Channel)������Դ�ڵ���Ŀ��ڵ�����ӣ���Java NIO�и��𻺳��������ݵĴ��䡣
 * Channel�����洢���ݣ������Ҫ��ϻ��������д��䣻
 * 
 * ͨ������Ҫʵ���ࣺ
 * 	java.nio.channels.Channel�ӿ�
 * 		|--FileChannel // ���ڲ��������ļ�
 * 		|--SocketChannel // ��������TCP
 * 		|--ServerSocketChannel // (�׽���)��������TCP
 * 		|--DatagramChannel // ��������UDP
 * 
 * ��λ�ȡͨ����
 * 	��ʽһ��Java���֧��ͨ�������ṩ��getChannel()����
 * 		����IO��
 * 			FileInputStream/FileOutputStream
 * 			RandomAccess
 * 		����IO��
 * 			Socket
 * 			ServerSocket
 * 			DatagramSocket
 * 	��ʽ������JDK1.7�е�NIO.2��Ը���ͨ���ṩ�˾�̬����open()����
 * 	��ʽ������JDK1.7�е�NIO.2��Files�������newByteChannel()����
 * 
 * ͨ��֮������ݴ��䣺
 * 	transferFrom()
 * 	transferTo()
 * 
 * ��ɢ(Scatter)��ۼ�(Gather)
 * 	��ɢ��ȡ(Scattering Reads)����ͨ���е����ݷ�ɢ�������������
 * 	�ۼ�д��(Gathering Writes)��������������е����ݾۼ���ͨ����
 * 
 * �ַ���
 * 	���룺�ַ��� -> �ֽ�����
 * 	���룺�ֽ����� -> �ַ���
 * 
 * @author 13651
 *
 */
public class StuChannel {

	/**
	 * ����ͨ������ļ��ĸ���(��ֱ�ӻ�����)
	 */
	@Test
	public void test1() {
		long start = System.currentTimeMillis(); // ��ʼʱ��
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		try {
			fis = new FileInputStream("D:\\programme\\code\\img\\bianmu.jpg");
			fos = new FileOutputStream("copy\\bianmu.jpg");
			
			// 1����ȡͨ��
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			
			// 2������ָ����С�Ļ�����
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			// 3����ͨ���е����ݴ��뻺������
			while(inChannel.read(buffer) != -1) { // ���ͨ��read()������ȡ�ķ���ֵ����-1������ʾ����������
				buffer.flip(); // ���������л��ɶ�ȡ���ݵ�ģʽ
				// 4�����������е�����д��ͨ��
				outChannel.write(buffer);
				buffer.clear(); // �������������ʱ�������ڵ����ݻ��ڣ�û����գ�ֻ����Щ���ݴ���"������"״̬(��Ϊ������ֵ(ָ��)�Ѿ��䵽�������λ��)
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5���ر���Դ
			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		long end = System.currentTimeMillis(); //����ʱ��
		System.out.println("�ܺ�ʱ��" + (end - start));
		
	}
	
	/**
	 * ʹ��ֱ�ӻ�����ʵ���ļ��ĸ���(�ڴ�ӳ���ļ�)���ڲ������ļ�ʱ���÷�ʽ���ٶ����������ķ�ʽ���
	 */
	@Test
	public void test2() {
		long start = System.currentTimeMillis(); // ��ʼʱ��
		
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			// ͨ����(READ)�ķ�ʽȥ��Ӧ��·���´���һ���ܵ�����
			inChannel = FileChannel.open(Paths.get("D:/programme/code/img/������.jpg"), StandardOpenOption.READ);
			// ͨ����(READ)д(WRITE)�ķ�ʽȥ��Ӧ��·���´���һ���ܵ�����CREATE����ʾ�ļ������ھʹ��������ھͽ��и��ǣ�CREATE_NEW����ʾ�ļ������ھʹ��������ھͱ���
			outChannel = FileChannel.open(Paths.get("copy/����.jpg"), 
					StandardOpenOption.WRITE, StandardOpenOption.READ, 
					StandardOpenOption.CREATE_NEW);
			
			// ͨ��ֻ����ʽ(READ_ONLY)����0��ʼinChannel.size()��С������(�ܵ��ڵ�ȫ������)�������ڴ�ӳ���ļ�
			MappedByteBuffer inMappedBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
			// ͨ����д��ʽ(READ_WRITE)����0��ʼinChannel.size()��С������(�ܵ��ڵ�ȫ������)�������ڴ�ӳ���ļ�
			MappedByteBuffer outMappedBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
			
			// ֱ�Ӷ�ֱ�ӻ��������ж�д����
			byte[] target = new byte[inMappedBuffer.limit()];
			inMappedBuffer.get(target); // ͨ��inMappedBuffer���ļ�����target�ֽ�������
			outMappedBuffer.put(target); // ͨ��outMappedBuffer��target�ֽ������е�����д��
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر���Դ
			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		long end = System.currentTimeMillis(); //����ʱ��
		System.out.println("�ܺ�ʱ��" + (end - start));
		
	}
	
	/**
	 * ͨ��֮������ݴ���(ֱ�ӻ�����)
	 * ��ΪtransferTo()��transferFrom()��������ֱ�ӻ�����
	 */
	@Test
	public void test3() {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		// ͨ����(READ)�ķ�ʽȥ��Ӧ��·���´���һ���ܵ�����
		try {
			inChannel = FileChannel.open(Paths.get("D:/programme/code/img/������.jpg"), StandardOpenOption.READ);
			// ͨ��д(WRITE)�ķ�ʽȥ��Ӧ��·���´���һ���ܵ�����CREATE����ʾ�ļ������ھʹ��������ھͽ��и��ǣ�CREATE_NEW����ʾ�ļ������ھʹ��������ھͱ���
			outChannel = FileChannel.open(Paths.get("copy/������.jpg"), 
					StandardOpenOption.WRITE, StandardOpenOption.READ, 
					StandardOpenOption.CREATE_NEW);
			
			// inChannelͨ����0��inChannel.size()���ȣ���outChannelͨ����
//			inChannel.transferTo(0, inChannel.size(), outChannel);
			// ����outChannelͨ����inChannelͨ����0��inChannel.size()���Ȼ�ȡ������
			outChannel.transferFrom(inChannel, 0, inChannel.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر���Դ
			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * ��ɢ��ۼ�
	 */
	@Test
	public void test4() {
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("data/JavaSEѧϰ�ʼ�.txt", "rw");
			
			// 1����ȡͨ��
			FileChannel channel = raf.getChannel();
			
			// 2���������ɸ�ָ����С�Ļ�����
			ByteBuffer bbuf1 = ByteBuffer.allocate(100);
			ByteBuffer bbuf2 = ByteBuffer.allocate(500);
			ByteBuffer bbuf3 = ByteBuffer.allocate(1024);
			
			// 3����ɢ��ȡ
			ByteBuffer[] bbufs = {bbuf1, bbuf2, bbuf3};
			channel.read(bbufs); // ��ɢ��ȡ��ByteBuffer������������
			
			// �����е�ByteBuffer�������л�Ϊ��ģʽ
			for (ByteBuffer bbuf : bbufs) {
				bbuf.flip(); // �л��ɶ�ģʽ
			}
			
			System.out.println("-----------------------------");
			// bbufs[0].array()��ʾ��ByteBuffer����ĵ�һ��ByteBuffer����Ԫ��ת��Ϊ�ֽ�����
			System.out.println(new String("bbuf1 = {" + new String(bbufs[0].array(), 0, bbufs[0].limit()) + "}"));
			System.out.println("-----------------------------");
			System.out.println(new String("bbuf2 = {" + new String(bbufs[1].array(), 0, bbufs[1].limit()) + "}"));
			System.out.println("-----------------------------");
			System.out.println(new String("bbuf3 = {" + new String(bbufs[2].array(), 0, bbufs[2].limit()) + "}"));
			
			
			// 4���ۼ�д��
			RandomAccessFile rafWrite = new RandomAccessFile("copy/data.txt", "rw");
			FileChannel writeChannel = rafWrite.getChannel(); // ��ȡ�ܵ�
			
			// ��ByteBuffer����(����������)�ۼ�д��ܵ���
			writeChannel.write(bbufs);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �ַ���
	 */
	@Test
	public void test5() {
		// ��ȡ���е��ַ���
		Map<String, Charset> charsetMap = Charset.availableCharsets();
		// ��ap����ת����Set����
		Set<Entry<String, Charset>> charsetSet = charsetMap.entrySet();
		// ����ת�����Set����
		for (Entry<String, Charset> charset : charsetSet) {
			System.out.println(charset.getKey() + " = " + charset.getValue());
		}
		System.out.println("----------------------------------------\n\n");
		
		// ����GBK���ַ���
		Charset csGBK = Charset.forName("GBK");
		// ͨ���ַ�����ȡ��Ӧ�ı�����
		CharsetEncoder ceGBK = csGBK.newEncoder();
		// ͨ���ַ�����ȡ��Ӧ�Ľ�����
		CharsetDecoder cdGBK = csGBK.newDecoder();
		// ����1024�������ַ�������
		CharBuffer cbff = CharBuffer.allocate(1024);
		// ���ַ��������������
		cbff.put("���һ������");
		// ͨ�����������б���
		cbff.flip(); // ����������ɶ�ģʽ
		ByteBuffer bbff = null;
		try {
			bbff = ceGBK.encode(cbff); // ���б���
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("�����");
		for (int i = 0; i < bbff.limit(); i++) {
			System.out.print(bbff.get() + ", ");
		}System.out.println("\n----------------------");
		// ͨ������������
		bbff.flip(); // ����������ɶ�ģʽ
		CharBuffer cb = null;
		try {
			cb = cdGBK.decode(bbff); // ���н���
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�����" + cb);
		System.out.println("-----------------------------");
		
		// ��������������ͽ��������ַ�������һ�µ�
		Charset csUTF8 = Charset.forName("UTF-8"); // ����UTF-8�ַ���
		bbff.flip(); // ����������ɶ�ģʽ
		CharBuffer cb2 = csUTF8.decode(bbff); // ��GBK�ַ��������ı��������ɵĻ��������н���
		System.out.println(cb2); // ����ᷢ���Ѿ�������
		
	}
	
}

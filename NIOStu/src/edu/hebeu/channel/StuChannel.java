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
 * 这个例子用来学习通道(Channel)，用于源节点与目标节点的连接，在Java NIO中负责缓冲区中数据的传输。
 * Channel本身不存储数据，因此需要配合缓冲区进行传输；
 * 
 * 通道的主要实现类：
 * 	java.nio.channels.Channel接口
 * 		|--FileChannel // 用于操作本地文件
 * 		|--SocketChannel // 用于网络TCP
 * 		|--ServerSocketChannel // (套接字)用于网络TCP
 * 		|--DatagramChannel // 用于网络UDP
 * 
 * 如何获取通道？
 * 	方式一、Java针对支持通道的类提供了getChannel()方法
 * 		本地IO：
 * 			FileInputStream/FileOutputStream
 * 			RandomAccess
 * 		网络IO：
 * 			Socket
 * 			ServerSocket
 * 			DatagramSocket
 * 	方式二、在JDK1.7中的NIO.2针对各个通道提供了静态方法open()方法
 * 	方式三、在JDK1.7中的NIO.2的Files工具类的newByteChannel()方法
 * 
 * 通道之间的数据传输：
 * 	transferFrom()
 * 	transferTo()
 * 
 * 分散(Scatter)与聚集(Gather)
 * 	分散读取(Scattering Reads)：将通道中的数据分散到多个缓冲区中
 * 	聚集写入(Gathering Writes)：将多个缓冲区中的数据聚集到通道中
 * 
 * 字符集
 * 	编码：字符串 -> 字节数组
 * 	乱码：字节数组 -> 字符串
 * 
 * @author 13651
 *
 */
public class StuChannel {

	/**
	 * 利用通道完成文件的复制(非直接缓冲区)
	 */
	@Test
	public void test1() {
		long start = System.currentTimeMillis(); // 开始时间
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		try {
			fis = new FileInputStream("D:\\programme\\code\\img\\bianmu.jpg");
			fos = new FileOutputStream("copy\\bianmu.jpg");
			
			// 1、获取通道
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			
			// 2、分配指定大小的缓冲区
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			// 3、将通道中的数据存入缓冲区中
			while(inChannel.read(buffer) != -1) { // 如果通过read()方法读取的返回值不是-1，即表示读到了数据
				buffer.flip(); // 将缓冲区切换成读取数据的模式
				// 4、将缓冲区中的数据写入通道
				outChannel.write(buffer);
				buffer.clear(); // 情况缓冲区，此时缓冲区内的数据还在，没有清空，只是这些数据处于"被遗忘"状态(因为各属性值(指针)已经变到了最初的位置)
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5、关闭资源
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
		long end = System.currentTimeMillis(); //结束时间
		System.out.println("总耗时：" + (end - start));
		
	}
	
	/**
	 * 使用直接缓冲区实现文件的复制(内存映射文件)，在操作大文件时，该方式的速度相较于上面的方式会快
	 */
	@Test
	public void test2() {
		long start = System.currentTimeMillis(); // 开始时间
		
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			// 通过读(READ)的方式去相应的路径下创建一个管道对象
			inChannel = FileChannel.open(Paths.get("D:/programme/code/img/奥利奥.jpg"), StandardOpenOption.READ);
			// 通过读(READ)写(WRITE)的方式去相应的路径下创建一个管道对象，CREATE：表示文件不存在就创建，存在就进行覆盖；CREATE_NEW：表示文件不存在就创建，存在就报错
			outChannel = FileChannel.open(Paths.get("copy/边牧.jpg"), 
					StandardOpenOption.WRITE, StandardOpenOption.READ, 
					StandardOpenOption.CREATE_NEW);
			
			// 通过只读方式(READ_ONLY)，从0开始inChannel.size()大小的数据(管道内的全部数据)，创建内存映射文件
			MappedByteBuffer inMappedBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
			// 通过读写方式(READ_WRITE)，从0开始inChannel.size()大小的数据(管道内的全部数据)，创建内存映射文件
			MappedByteBuffer outMappedBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
			
			// 直接对直接缓冲区进行读写操作
			byte[] target = new byte[inMappedBuffer.limit()];
			inMappedBuffer.get(target); // 通过inMappedBuffer将文件读入target字节数组中
			outMappedBuffer.put(target); // 通过outMappedBuffer将target字节数组中的数据写出
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
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
		
		long end = System.currentTimeMillis(); //结束时间
		System.out.println("总耗时：" + (end - start));
		
	}
	
	/**
	 * 通道之间的数据传输(直接缓冲区)
	 * 因为transferTo()、transferFrom()方法都是直接缓冲区
	 */
	@Test
	public void test3() {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		// 通过读(READ)的方式去相应的路径下创建一个管道对象
		try {
			inChannel = FileChannel.open(Paths.get("D:/programme/code/img/奥利奥.jpg"), StandardOpenOption.READ);
			// 通过写(WRITE)的方式去相应的路径下创建一个管道对象，CREATE：表示文件不存在就创建，存在就进行覆盖；CREATE_NEW：表示文件不存在就创建，存在就报错
			outChannel = FileChannel.open(Paths.get("copy/奥利奥.jpg"), 
					StandardOpenOption.WRITE, StandardOpenOption.READ, 
					StandardOpenOption.CREATE_NEW);
			
			// inChannel通道从0到inChannel.size()长度，到outChannel通道内
//			inChannel.transferTo(0, inChannel.size(), outChannel);
			// 或者outChannel通道从inChannel通道的0到inChannel.size()长度获取其数据
			outChannel.transferFrom(inChannel, 0, inChannel.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
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
	 * 分散与聚集
	 */
	@Test
	public void test4() {
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("data/JavaSE学习笔记.txt", "rw");
			
			// 1、获取通道
			FileChannel channel = raf.getChannel();
			
			// 2、分配若干个指定大小的缓冲区
			ByteBuffer bbuf1 = ByteBuffer.allocate(100);
			ByteBuffer bbuf2 = ByteBuffer.allocate(500);
			ByteBuffer bbuf3 = ByteBuffer.allocate(1024);
			
			// 3、分散读取
			ByteBuffer[] bbufs = {bbuf1, bbuf2, bbuf3};
			channel.read(bbufs); // 分散读取至ByteBuffer缓冲区数组中
			
			// 将所有的ByteBuffer缓冲区切换为读模式
			for (ByteBuffer bbuf : bbufs) {
				bbuf.flip(); // 切换成读模式
			}
			
			System.out.println("-----------------------------");
			// bbufs[0].array()表示将ByteBuffer数组的第一个ByteBuffer对象元素转换为字节数组
			System.out.println(new String("bbuf1 = {" + new String(bbufs[0].array(), 0, bbufs[0].limit()) + "}"));
			System.out.println("-----------------------------");
			System.out.println(new String("bbuf2 = {" + new String(bbufs[1].array(), 0, bbufs[1].limit()) + "}"));
			System.out.println("-----------------------------");
			System.out.println(new String("bbuf3 = {" + new String(bbufs[2].array(), 0, bbufs[2].limit()) + "}"));
			
			
			// 4、聚集写入
			RandomAccessFile rafWrite = new RandomAccessFile("copy/data.txt", "rw");
			FileChannel writeChannel = rafWrite.getChannel(); // 获取管道
			
			// 将ByteBuffer数组(缓冲区数组)聚集写入管道内
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
	 * 字符集
	 */
	@Test
	public void test5() {
		// 获取所有的字符集
		Map<String, Charset> charsetMap = Charset.availableCharsets();
		// 将ap集合转换成Set集合
		Set<Entry<String, Charset>> charsetSet = charsetMap.entrySet();
		// 遍历转换后的Set集合
		for (Entry<String, Charset> charset : charsetSet) {
			System.out.println(charset.getKey() + " = " + charset.getValue());
		}
		System.out.println("----------------------------------------\n\n");
		
		// 创建GBK的字符集
		Charset csGBK = Charset.forName("GBK");
		// 通过字符集获取对应的编码器
		CharsetEncoder ceGBK = csGBK.newEncoder();
		// 通过字符集获取对应的解码器
		CharsetDecoder cdGBK = csGBK.newDecoder();
		// 创建1024容量的字符缓冲区
		CharBuffer cbff = CharBuffer.allocate(1024);
		// 向字符缓冲区添加数据
		cbff.put("添加一点数据");
		// 通过编码器进行编码
		cbff.flip(); // 将缓冲区变成读模式
		ByteBuffer bbff = null;
		try {
			bbff = ceGBK.encode(cbff); // 进行编码
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("编码后：");
		for (int i = 0; i < bbff.limit(); i++) {
			System.out.print(bbff.get() + ", ");
		}System.out.println("\n----------------------");
		// 通过解码器解码
		bbff.flip(); // 将缓冲区变成读模式
		CharBuffer cb = null;
		try {
			cb = cdGBK.decode(bbff); // 进行解码
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("解码后：" + cb);
		System.out.println("-----------------------------");
		
		// 如果创建编码器和解码器的字符集不是一致的
		Charset csUTF8 = Charset.forName("UTF-8"); // 创建UTF-8字符集
		bbff.flip(); // 将缓冲区变成读模式
		CharBuffer cb2 = csUTF8.decode(bbff); // 对GBK字符集创建的编码器生成的缓冲区进行解码
		System.out.println(cb2); // 输出会发现已经乱码了
		
	}
	
}

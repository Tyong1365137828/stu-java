package edu.hebeu.buffer;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * 这个类用来学习缓冲区(Buffer)，在Java NIO中负责数据的存取，用于存储不同数据类型的数据，
 * 根据数据类型不同(boolean除外)，提供了相应类型的缓冲区，如：
 * 		ByteBuffer
 * 		CharBuffer
 * 		ShortBuffer
 * 		IntBuffer
 * 		LongBuffer
 * 		FloatBuffer
 * 		DoubleBuffer
 * 	上述缓冲区的管理方式几乎一致，都是通过allocate()获取缓冲区
 * 
 * 缓冲区存取数据的两个核心方法：
 * 	put() 存入数据到缓冲区中
 * 	get() 获取缓冲区中的数据
 * 
 * 缓冲区中的四个核心属性
 * 	capacity：容量，表示缓冲区中最大存储数据的容量。一旦声明就不能改变；
 * 	limit：界限，表示缓冲区中可以操作数据的大小。(limit后的数据不能进行读写)
 * 	position：位置，表示缓冲区中正在操作数据的位置()
 * 	mark：标记，表示记录当前position的位置，可以通过reset()恢复到mark的位置
 * 注意：0 <= mark <= position <= limit <= capacity
 * 
 * 直接缓冲区与非直接缓冲区
 * 	非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM内存中；
 * 	直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中。因此在
 * 某种情况下可以提高效率
 * 
 * @author 13651
 *
 */
public class StuBuffer {
	
	String dataStr = "abcde"; // 5各英文字符(对应着5个字节大小)

	@Test
	public void test1() {
		// 1、分配一个指定大小的缓冲区
		ByteBuffer bbuf = ByteBuffer.allocate(1024); // 容量为1024 byte
		System.out.println("------------初始化的属性值-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 2、利用put()存入数据到缓冲区中
		bbuf.put(dataStr.getBytes());
		System.out.println("------------写入数据至缓冲区后各属性值的变化-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 3、使用flip()方法将缓冲区切换到读数据的模式
		bbuf.flip();
		System.out.println("------------使用flip()方法切换到读数据模式后的各属性值的变化-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 4、利用get()方法读取缓冲区的数据
		byte[] target = new byte[bbuf.limit()];
		bbuf.get(target); // 将bbuf字节数组内的数据全部读到target字节数组内
		System.out.println("------------使用get()方法读取数据后的各属性值的变化-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 5、利用rewind()方法将缓冲区内的数据变成执行完flip()方法后的形式，实现可重复读数据
		bbuf.rewind();
		System.out.println("------------使用rewind()方法切换到读数据模式后的各属性值的变化-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 6、使用clear()方法清空缓冲区，但是缓冲区内的数据还在，没有清空，只是这些数据处于"被遗忘"状态(因为各属性值(指针)已经变到了最初的位置)
		bbuf.clear();
		System.out.println("------------使用clear()方法清空缓冲区后的各属性值的变化-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		System.out.println("验证：" + (char) bbuf.get());
		
		System.out.println("\n\n读到的数据：" + new String(target, 0, target.length));
	}
	
	@Test
	public void test2() {
		ByteBuffer bbuf = ByteBuffer.allocate(1024);
		
		bbuf.put(dataStr.getBytes());
		
		bbuf.flip();
		
		byte[] target = new byte[bbuf.limit()];
		// 表示将bbuf字节数组，从第0个索引开始，读2个字节，读入target字节数组内
		bbuf.get(target, 0, 2);
		System.out.println("------------使用get()方法读取数据后的各属性值的变化-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		System.out.println("本次读到的数据：" + new String(target, 0, 2) + "\n\n");
		
		// 使用mark()进行标记
		bbuf.mark();
		
		// 表示将bbuf字节数组，从第2个索引开始，读2个字节，读入target字节数组内
		bbuf.get(target, 2, 2);
		System.out.println("------------使用get()方法读取数据后的各属性值的变化-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		System.out.println("本次读到的数据：" + new String(target, 2, 2) + "\n\n");
		
		// 使用reset()方法恢复到mark的位置
		bbuf.reset();
		System.out.println("------------使用reset()方法恢复到mark位置后的各属性值的变化-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 使用hasRemaining()方法判断缓冲区还有没有剩余的数据
		if (bbuf.hasRemaining()) {
			// 通过remaining()获取缓冲区中可以操作的数据的数量
			System.out.println("缓冲区中还可以操作的数据的数量：" + bbuf.remaining());
		}
	}
	
	@Test
	public void test3() {
		 // 分配直接缓冲区
		ByteBuffer bbuf = ByteBuffer.allocateDirect(1024);
		System.out.println("是否为直接缓冲区？" + bbuf.isDirect());
	}
	
}

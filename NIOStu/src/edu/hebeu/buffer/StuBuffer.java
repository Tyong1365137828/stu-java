package edu.hebeu.buffer;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * ���������ѧϰ������(Buffer)����Java NIO�и������ݵĴ�ȡ�����ڴ洢��ͬ�������͵����ݣ�
 * �����������Ͳ�ͬ(boolean����)���ṩ����Ӧ���͵Ļ��������磺
 * 		ByteBuffer
 * 		CharBuffer
 * 		ShortBuffer
 * 		IntBuffer
 * 		LongBuffer
 * 		FloatBuffer
 * 		DoubleBuffer
 * 	�����������Ĺ���ʽ����һ�£�����ͨ��allocate()��ȡ������
 * 
 * ��������ȡ���ݵ��������ķ�����
 * 	put() �������ݵ���������
 * 	get() ��ȡ�������е�����
 * 
 * �������е��ĸ���������
 * 	capacity����������ʾ�����������洢���ݵ�������һ�������Ͳ��ܸı䣻
 * 	limit�����ޣ���ʾ�������п��Բ������ݵĴ�С��(limit������ݲ��ܽ��ж�д)
 * 	position��λ�ã���ʾ�����������ڲ������ݵ�λ��()
 * 	mark����ǣ���ʾ��¼��ǰposition��λ�ã�����ͨ��reset()�ָ���mark��λ��
 * ע�⣺0 <= mark <= position <= limit <= capacity
 * 
 * ֱ�ӻ��������ֱ�ӻ�����
 * 	��ֱ�ӻ�������ͨ��allocate()�������仺��������������������JVM�ڴ��У�
 * 	ֱ�ӻ�������ͨ��allocateDirect()��������ֱ�ӻ��������������������������ڴ��С������
 * ĳ������¿������Ч��
 * 
 * @author 13651
 *
 */
public class StuBuffer {
	
	String dataStr = "abcde"; // 5��Ӣ���ַ�(��Ӧ��5���ֽڴ�С)

	@Test
	public void test1() {
		// 1������һ��ָ����С�Ļ�����
		ByteBuffer bbuf = ByteBuffer.allocate(1024); // ����Ϊ1024 byte
		System.out.println("------------��ʼ��������ֵ-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 2������put()�������ݵ���������
		bbuf.put(dataStr.getBytes());
		System.out.println("------------д���������������������ֵ�ı仯-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 3��ʹ��flip()�������������л��������ݵ�ģʽ
		bbuf.flip();
		System.out.println("------------ʹ��flip()�����л���������ģʽ��ĸ�����ֵ�ı仯-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 4������get()������ȡ������������
		byte[] target = new byte[bbuf.limit()];
		bbuf.get(target); // ��bbuf�ֽ������ڵ�����ȫ������target�ֽ�������
		System.out.println("------------ʹ��get()������ȡ���ݺ�ĸ�����ֵ�ı仯-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 5������rewind()�������������ڵ����ݱ��ִ����flip()���������ʽ��ʵ�ֿ��ظ�������
		bbuf.rewind();
		System.out.println("------------ʹ��rewind()�����л���������ģʽ��ĸ�����ֵ�ı仯-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// 6��ʹ��clear()������ջ����������ǻ������ڵ����ݻ��ڣ�û����գ�ֻ����Щ���ݴ���"������"״̬(��Ϊ������ֵ(ָ��)�Ѿ��䵽�������λ��)
		bbuf.clear();
		System.out.println("------------ʹ��clear()������ջ�������ĸ�����ֵ�ı仯-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		System.out.println("��֤��" + (char) bbuf.get());
		
		System.out.println("\n\n���������ݣ�" + new String(target, 0, target.length));
	}
	
	@Test
	public void test2() {
		ByteBuffer bbuf = ByteBuffer.allocate(1024);
		
		bbuf.put(dataStr.getBytes());
		
		bbuf.flip();
		
		byte[] target = new byte[bbuf.limit()];
		// ��ʾ��bbuf�ֽ����飬�ӵ�0��������ʼ����2���ֽڣ�����target�ֽ�������
		bbuf.get(target, 0, 2);
		System.out.println("------------ʹ��get()������ȡ���ݺ�ĸ�����ֵ�ı仯-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		System.out.println("���ζ��������ݣ�" + new String(target, 0, 2) + "\n\n");
		
		// ʹ��mark()���б��
		bbuf.mark();
		
		// ��ʾ��bbuf�ֽ����飬�ӵ�2��������ʼ����2���ֽڣ�����target�ֽ�������
		bbuf.get(target, 2, 2);
		System.out.println("------------ʹ��get()������ȡ���ݺ�ĸ�����ֵ�ı仯-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		System.out.println("���ζ��������ݣ�" + new String(target, 2, 2) + "\n\n");
		
		// ʹ��reset()�����ָ���mark��λ��
		bbuf.reset();
		System.out.println("------------ʹ��reset()�����ָ���markλ�ú�ĸ�����ֵ�ı仯-------------");
		System.out.println("capacity = " + bbuf.capacity());
		System.out.println("limit = " + bbuf.limit());
		System.out.println("position = " + bbuf.position());
		
		// ʹ��hasRemaining()�����жϻ���������û��ʣ�������
		if (bbuf.hasRemaining()) {
			// ͨ��remaining()��ȡ�������п��Բ��������ݵ�����
			System.out.println("�������л����Բ��������ݵ�������" + bbuf.remaining());
		}
	}
	
	@Test
	public void test3() {
		 // ����ֱ�ӻ�����
		ByteBuffer bbuf = ByteBuffer.allocateDirect(1024);
		System.out.println("�Ƿ�Ϊֱ�ӻ�������" + bbuf.isDirect());
	}
	
}

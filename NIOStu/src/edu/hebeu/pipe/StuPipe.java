package edu.hebeu.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.Test;

/**
 * �����������ѧϰ�ܵ�Pipe
 * @author 13651
 *
 */
public class StuPipe {
	
	@Test
	public void test1() throws IOException {

		// 1����ȡ�ܵ�
		Pipe pipe = Pipe.open();
		
		// 2�����������е�����д��ܵ�
		Pipe.SinkChannel sinkChannel = pipe.sink(); // ��ȡsink�ܵ�
		ByteBuffer buffer = ByteBuffer.allocate(1024); // ����ָ����С�Ļ�����
		buffer.put("�ܵ��ڵ�����...".getBytes()); // ��ܵ����������
		buffer.flip(); // ���ܵ���ɶ�ģʽ
		sinkChannel.write(buffer); // ���������ڵ�����ͨ��д��SinkChannelͨ����pipe�ܵ�
		
		// 3����ȡ�������е�����
		Pipe.SourceChannel sourceChannel = pipe.source(); // ��ȡsource�ܵ�
		buffer.flip(); // ����������ɶ�ģʽ
		int count = sourceChannel.read(buffer); // ��pipe�ܵ��ڵ�����ͨ��SourceChannelͨ����ȡֵ������������ȡ�������ڵ����ݸ���
		System.out.println(new String(buffer.array(), 0, count));
		
		// 4���ر���Դ
		sourceChannel.close();
		sinkChannel.close();
	}
}

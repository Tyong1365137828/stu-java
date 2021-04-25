package edu.hebeu.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.Test;

/**
 * 这个例子用来学习管道Pipe
 * @author 13651
 *
 */
public class StuPipe {
	
	@Test
	public void test1() throws IOException {

		// 1、获取管道
		Pipe pipe = Pipe.open();
		
		// 2、将缓冲区中的数据写入管道
		Pipe.SinkChannel sinkChannel = pipe.sink(); // 获取sink管道
		ByteBuffer buffer = ByteBuffer.allocate(1024); // 创建指定大小的缓冲区
		buffer.put("管道内的数据...".getBytes()); // 向管道内添加数据
		buffer.flip(); // 将管道变成读模式
		sinkChannel.write(buffer); // 将缓冲区内的数据通过写入SinkChannel通道至pipe管道
		
		// 3、读取缓冲区中的数据
		Pipe.SourceChannel sourceChannel = pipe.source(); // 获取source管道
		buffer.flip(); // 将缓冲区变成读模式
		int count = sourceChannel.read(buffer); // 将pipe管道内的数据通过SourceChannel通道读取值缓冲区，并获取缓冲区内的数据个数
		System.out.println(new String(buffer.array(), 0, count));
		
		// 4、关闭资源
		sourceChannel.close();
		sinkChannel.close();
	}
}

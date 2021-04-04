package edu.hebeu.bufferedwriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * BufferedWriter:
 * 	带有缓冲区的字符输出流；
 * @author 13651
 *
 */
public class BufferedWriterStu {
	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		try {
			/**创建BufferedWriter对象*/
//			bw = new BufferedWriter(new FileWriter("data\\bufferedData\\写入数据", true)); // 创建BufferedWriter对象(当节点流是字符流时)，并且不会清空原文件的数据
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data\\bufferedData\\写入数据", true))); // 创建BufferedWriter对象(当节点流是字节流时，要将字节流通过OutputStreamWriter转换成字符流)，并且不会清空原文件的数据
			
			/**
			 * 写操作，write()方法的使用同FileOutStream的write()方法一样
			 */
			char[] chars = {'c', 'h', 'a', 'r', 'a', 'r', 'r', 'a', 'y'};
			bw.write(chars); // 写入一个完整的char数组
			bw.write("\n"); // 写入一个换行
			bw.write(chars, 1, 5); // 写入一个部分的char数组，从下标为1开始，5个长度结束
			bw.write("\n"); // 写入一个换行
			bw.write(97); // 写入一个byte值为97对应的数据(即a)
			bw.write("\n"); // 写入一个换行
			bw.write("你好!Java的流；"); // 写入一个字符串
			bw.write("你好!Java的流；", 0, 2); // 写入一个字符串的一部分从下标0开始，2个长度为止
			bw.write("\n"); // 写入一个换行
			
			bw.flush(); // 写完之后，刷新一下，清空管道
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	}
}

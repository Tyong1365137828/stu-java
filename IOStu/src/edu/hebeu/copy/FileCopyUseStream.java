package edu.hebeu.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 这个例子展示如何通过FiltInputStream和FileOutputStream拷贝文件
 * 	这个例子使用的是Stream流，什么样的文件都能拷贝
 * @author 13651
 *
 */
public class FileCopyUseStream {
	public static void main(String[] args) {
		FileInputStream fis = null; // 声明一个输入流对象
		FileOutputStream fos = null; // 声明一个输出流对象
		
		try {
			
			fis = new FileInputStream("F:\\学习\\javaEE\\第二次课\\第6周（第2次课）.mp4"); // 创建一个输入流对象
			fos = new FileOutputStream("D:\\programme\\code\\java\\neon\\IOStu\\data\\streamData\\拷贝视频.mp4"); // 创建一个输出流对象
			
			/**
			 * 进行读写操作(边读边写)
			 */
			byte[] bytes = new byte[1024 * 1024]; // 一次最多读取 1MB 字节
			int readBytesCount = 0; // 用来存放每次读取入byte数组的字节数量
			while((readBytesCount = fis.read(bytes)) != - 1) {
				fos.write(bytes, 0, readBytesCount); // 将每次读取到的字节写入
			}
			
			fos.flush(); // 输出流对象使用完后要进行刷新
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

package edu.hebeu.copy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 这个例子展示如何使用FileReader和FileWriter拷贝普通文本文件
 * 	这两个流只能操作普通的文本文件
 * @author 13651
 *
 */
public class FileCopyUseReaderWriter {
	public static void main(String[] args) {
		FileReader fr = null; // 声明字符输入流
		FileWriter fw = null; // 声明字符输出流
		
		try {
			fr = new FileReader("F:\\学习\\javaEE\\第十一次课\\backup"); // 创建字符输入流对象
			fw = new FileWriter("D:\\programme\\code\\java\\neon\\IOStu\\data\\read_writerData\\拷贝文件"); // 创建字符输出流对象
			
			/**
			 * 进行拷贝操作
			 */
			char[] chars = new char[1024 * 512]; // 创建字符数组，存储每次读取的字符，表示一次最多读取1MB
			int readCharsCount = 0; // 用来存放每次读取入字符数组的字符数
			while((readCharsCount = fr.read(chars)) != -1) {
				fw.write(chars, 0, readCharsCount); // 将每次读取到的字符写入
			}
			
			fw.flush(); // 字符输出流对象使用完之后要进行刷新，以清空管道
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
	}
}

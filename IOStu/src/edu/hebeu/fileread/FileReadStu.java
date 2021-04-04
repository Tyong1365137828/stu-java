package edu.hebeu.fileread;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileRead：
 * 	文件字符输入流，只能读取普通文本文件；
 * 	读取文件内容时，比较方便快捷
 * @author 13651
 *
 */
public class FileReadStu {
	public static void main(String[] args) {
		FileReader fr = null; // 声明字符文件输入流
		
		try {
			fr = new FileReader("D:\\programme\\code\\java\\neon\\IOStu\\data\\read_writerData\\数据1"); // 创建字符输入流
			
			char[] chars = new char[4]; // 创建一个字节数组，用来存放每次读取的数据，每次最多读取4个字符
			int readCharsCount = 0; // 用来记录每次读取到的字符数
			while((readCharsCount = fr.read(chars)) != -1) {
				System.out.print(new String(chars, 0, readCharsCount)); // 将每次读取入字符数组的字符转换为String类型输出
			}System.out.println();
			
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
		}
		
	}
}

package edu.hebeu.filewriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter:
 * 	字符输出流，只能输出普通文本文件；
 * @author 13651
 *
 */
public class FileWriterStu {
	public static void main(String[] args) {
		FileWriter fw = null; // 声明一个字符输出流
		
		try {
			fw = new FileWriter("data\\read_writerData\\写入数据", true); // 创建字符输出流对象，这个对象写入文件不会清空原文件，而是追加至原文件内容后面；
			
			/**
			 * 写入操作
			 */
			char[] chars = {'你', '好', 'J', 'a', 'v', 'a', '!', '!', '!'};
//			fw.write(chars); // 写入字符数组的全部内容
			fw.write(chars, 1, 2); // 写入字符数组从下标 1 开始，长度为2的内容	
			
			fw.write("\n"); // 写入换行
			
			String s = "通过String类型数据随便写点";
//			fw.write(s); // 直接传入字符串
			fw.write(s, 0, 5); // 写入String类型数据的部分内容		
			
			
			fw.flush(); // 输出流用完之后记得要刷新，以清空管道
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

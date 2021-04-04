package edu.hebeu.fileoutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 通过这个例子学习FileOutputStream类
 * 	
 * @author 13651
 *
 */
public class FileOutputStreamStu {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			/**这种构造方法创建的对象在写入文件时，会先将原文件清空掉，在将新数据写入文件**/
//			fos = new FileOutputStream("data/写入数据"); // 写入文件时如果不存在此文件会自动创建
			
			/**这种构造方法创建的对象在写入文件时，会讲所写的内容追加到原文件末尾，不会清空原文件内容**/
			fos = new FileOutputStream("data/streamData/写入数据", true); // 
			
			/**写入操作**/
			// 1.1、通过int类型的数据(即byte的值)写入文件
			/*fos.write(98);*/
			
			// 1.2、创建byte数组写入文件(将byte数组全部写入)
			/*byte[] bytes = {97, 98, 99, 100, 101, 102, 103, 104};
			fos.write(bytes); // 将此数组写入文件
			*/
			
			// 1.3、将byte数组部分写入文件
			/*byte[] bytes = {97, 98, 99, 100, 101, 102, 103, 104};
			fos.write(bytes, 0, 3); // 表示将byte数组从下标为0的位置，写入长度是3，写入文件
			*/
			
			String s = "你好！我要成果了！！！";
			byte[] bytes = s.getBytes(); // 讲String字符串转换为byte数组
			fos.write(bytes); // 将字符串转换成的byte数组写入到文件中
			
			
			
			// 写完之后一定要刷新一下，以清空管道
			fos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

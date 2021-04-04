package edu.hebeu.printstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 本例子学习标准字节输出流	java.io.PrintStream
 * 	默认输出到控制台；
 * 	标准字节输出流不用手动关闭；
 * @author 13651
 *
 */
public class PrintStreamStu {
	public static void main(String[] args) {
		System.out.println("Hello"); // 这就是使用的标准字节输出流
		
		// 另一种写法
		PrintStream pStream = System.out;
		pStream.println("你好！");
		pStream.println("Java");
		
		
		/**
		 * 以上都是输出至控制台，也可以改变标准字节输出流的输出方向
		 */
		PrintStream ps = null;
		
		try {
			ps = new PrintStream(new FileOutputStream("data\\printData\\log", true)); // 将此输出流的方向改变至 data\\printData\\log 文件，不在指向控制台
			
			System.setOut(ps); // 通过上面的对象修改输出方向，将此输出流的方向改变至 data\\printData\\log 文件，不在指向控制台
			
			/**
			 * 写操作，再输出
			 */
			Date now = new Date(); // 获取系统当前时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"); // 创建时间格式化对象
			String nowStr = sdf.format(now); // 将时间格式化为一个字符串
			System.out.println("当前时间：" + nowStr);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

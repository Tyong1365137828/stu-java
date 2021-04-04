package edu.hebeu.bufferedreader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * BufferedReader:
 * 	带有缓冲区的输入流；
 * 	使用这个流不用自定义char/byte数组，自带缓冲；
 * 	构造方法只能传入Reader，即只能使用字符流，对于字节流，要先转换成字符流才能使用BufferedReader
 * 
 * 构造方法：
 * 	new BufferedReader(Reader r); // 创建BufferedReader对象需要Reader对象(字符流)，但是Reader是抽象的，因此Reader可以借助其子类创建对象
 * 
 * 特有方法：
 * 	String readLine(); // 读取一行文本行，但是不会读到最后的换行(不带换行符)
 * 	
 * 
 * 概念：当一个流的构造方法需要一个流时，被传进来的流叫做"节点流"；
 * 外部负责包装的流叫做"包装流"；
 * 
 * @author 13651
 *
 */
public class BufferedReaderStu {
	public static void main(String[] args) {
		BufferedReader br = null; // 声明一个包装流对象
		try {
			/**对于字符流*/
//			Reader reader = new FileReader("data\\bufferedData\\数据1"); // 创建Reader对象
//			FileReader reader = new FileReader("data\\bufferedData\\数据1"); // 也可以创建Reader的子类的对象
//			br = new BufferedReader(reader); // 通过Reader对象创建BufferedReader对象
			// 可以合并为
//			br = new BufferedReader(new FileReader("data\\bufferedData\\数据1"));
			
			/**对于字节流*/
//			FileInputStream fis = new FileInputStream("data\\bufferedData\\数据1"); // 创建字节流对象
//			InputStreamReader isr = new InputStreamReader(fis); // 将字节流对象(InputStream)转换成字符流对象(Reader)
//			br = new BufferedReader(isr); // 将字节流FileInputStream转换成的Reader字符流对象传入BufferedReader对象，创建BufferedReader对象
			// 可以合并为
			br = new BufferedReader(new InputStreamReader(new FileInputStream("data\\bufferedData\\数据1")));
			
			/**
			 * 		上述中，相对于BufferedReader，Reader或者Reader的子类FileReader等的叫做节点流；
			 *	BufferedReader叫做包装流或者处理流；
			 *		相对于InputStreamReader，FileInputStream是节点流；FileInputStream叫做包装流或
			 *	者处理流；
			 *
			 *		但是在关闭流时，只需要关闭最外面的包装流即可，因为观察源代码结点流会在包装流内部
			 *	被处理关闭关闭；
			 */
			
			
			/**
			 * 读操作
			 */			
//			String textLine = br.readLine(); // 读取第一行数据，但是不会读到最后的换行
//			System.out.println(textLine);
			
			String textLine = null; // 存储读出的每一行文本数据
			while((textLine = br.readLine()) != null) {
				System.out.println(textLine);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/**关闭这种流时，只需要关闭包装流/处理流即可，节点流不用关，因为节点流在包装流内部已经处理关闭了*/
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
} 

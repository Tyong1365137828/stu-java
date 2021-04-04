package edu.hebeu.fileinputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 本例学习java.io.FileInputStream类；
 * 特点：
 * 	1、这是文件字节输入流，是万能的，任何类型的文件都可以采用这个类型的流来读；
 * 	2、以字节的方式完成输入操作，即完成读的操作(硬盘 ---> 内存)；
 * 
 * 常用方法：
 * 	close(); // 关闭流
 * 	int available(); // 返回流当中剩余的未读到的字节数量
 * 	long skip[(long n); // 跳过几个字节不读
 * 	int read(); // 读一个字节，将栈帧后移1位，并将当前栈帧指向的字节读取，返回该字节的值，如果流读取完了就返回 -1；
 * 	int read(byte[] b); // 一次最多读取b.length个字节至byte数组b，如果流读取完了就返回 -1；
 * 	
 * @author 13651
 *
 */
public class FileInputStreamStu {
	public static void main(String[] args) {
		// 声明文件字节输入流对象
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		FileInputStream fis3 = null;
		try {
			// 创建文件字节输入流对象
			// 路径为：D:\programme\code\java\neon\IOStu\data\streamData\数据1 ，但是在Java中一个 \ 表示转义，因此要用两个 \ ，即 \\ 
//			fis = new FileInputStream("D:\\programme\\code\\java\\neon\\IOStu\\data\\streamData\\数据1");
			// 或者写成
//			fis = new FileInputStream("D:/programme/code/java/neon/IOStu/data/streamData/数据1");
			
			/***
			 * 以上几种方式都是通过绝对路径方式创建对象，也可以通过相对位置(相对于此工程的路径位置，即工程的"根")创建对象
			 */
			fis = new FileInputStream("data/streamData/数据1");
			fis2 = new FileInputStream("data/streamData/数据1");
			fis3 = new FileInputStream("data/streamData/数据1");
			
			/***
			 * 通过一个一个是字节完成读操作，
			 * 	FileInputStream字节流的读方式：
					步骤一、将文件内的数据变成字节形式，再使用栈帧初始指向内容字节的的头一个字节处；
					步骤二、调用read()方法就会将栈帧后移1个字节，指向当前字节所在的字符处，并将指向的字符的byte值返回；如果后面没有内容了，read()方法会返回-1；
					步骤三、重复步骤二直至-1，结束读操作；
			 */
			// 开始读
			/*
			// 1.1方式
			int readData = fis.read(); // 当前帧指向第一个字节对应的字符为a
			System.out.println(readData); // 第一个字节对应的字符是a，其字节值(ASII码)是97
			
			readData = fis.read(); // 当前帧指向第二个字节对应的字符为b
			System.out.println(readData); // 第二个字节对应的字符是b，其字节值(ASII码)是98
			
			readData = fis.read(); // 当前帧指向第三个字节对应的字符为c
			System.out.println(readData); // 第三个字节对应的字符是c，其字节值(ASII码)是99
			
			readData = fis.read(); // 当前帧指向第四个字节对应的字符为d
			System.out.println(readData); // 第四个字节对应的字符是d，其字节值(ASII码)是100
			
			readData = fis.read(); // 当前帧指向第五个字节对应的字符为e
			System.out.println(readData); // 第五个字节对应的字符是b，其字节值(ASII码)是101
			
			readData = fis.read(); // 当前帧指向第六个字节对应的字符为f
			System.out.println(readData); // 第六个字节对应的字符是f，其字节值(ASII码)是102
			
			readData = fis.read(); // 此时已经读取到文件的末尾了，此时没有内容了，会返回 -1
			System.out.println(readData);
			
			readData = fis.read(); // 此时已经读取到文件的末尾了，此时没有内容了，会返回 -1
			System.out.println(readData);
			
			readData = fis.read(); // 此时已经读取到文件的末尾了，此时没有内容了，会返回 -1
			System.out.println(readData);
			
			readData = fis.read(); // 此时已经读取到文件的末尾了，此时没有内容了，会返回 -1
			System.out.println(readData);*/
			
			// 1.2方式，对上述读取文件方式的改进，使用while(true)循环方式开始读
			/*System.out.print("[");
			while(true) {
				int readData = fis.read();
				if(readData == -1) {
					System.out.println("]");
					break;
				}
				System.out.print(readData + ", ");
			}*/
			
			// 1.3方式，对上述while(true)方式循环的改进
			/*int readData = 0;
			while((readData=fis.read()) != -1) {
				System.out.print(readData + ", ");
			}*/
			
			/**
			 * 但是上述的方法都存在一个问题：
			 * 	一次读取一个字节byte，这样内存和硬盘交互太频繁，基本上时间和资源都浪费在交互上面了；
			 * 
			 * 为了解决上述的问题，可以想办法一次读取多个字节，这里可以使用byte[]数组完成这种设想，通过方法 int read(byte[] b);
			 * 		一次最多读取b.length个字节，往byte[]数组b内读；减少硬盘和内存的交互，提高程序执行效率；
			 */
			// 2.1方式读取文件
			byte[] b = new byte[4]; // 创建一个长度为4的byte数组，即read()方法使用此数组，每次最多会读取4个字节
			
			/*int readBytesCount = fis.read(b); // 此时read()方法的返回值就变成读到的字节数量！！！此时会返回的4(a、b、c、d)
			System.out.println(readBytesCount);
			System.out.println(new String(b)); // 此时会输出字符串 abcd
			
			readBytesCount = fis.read(b); // 此时会返回2(e、f)
			System.out.println(readBytesCount);
			System.out.println(new String(b)); // 此时会输出字符串 efcd(e和f将ab替换掉了，但是cd没有变)*/
			/***
			 * 通过以上将byte数组转换为String的方法是行不通的，我们要保证每次传入几个byte就转换几个byte为String
			 */
			/*int readBytesCount = fis.read(b);
			System.out.println(readBytesCount);
			System.out.println(new String(b, 0, readBytesCount)); // 表示转换bbyte数组，从下标为0的位置开始，转换readBytesCount长度个字节
			
			readBytesCount = fis.read(b);
			System.out.println(readBytesCount);
			System.out.println(new String(b, 0, readBytesCount)); // 表示转换bbyte数组，从下标为0的位置开始，转换readBytesCount长度个字节
			
			
			readBytesCount = fis.read(b); // 此时会返回-1(即一个字节都没有读到)
			System.out.println(readBytesCount);*/
			
			/**
			 * 总结上述的各种方式，最终读文件方式为：
			 */
			/*byte[] bytes = new byte[10]; // 准备一个长度为6的byte数组，表示每次读取6个字节的内容
			while(true) {
				int readBytesCount = fis.read(bytes); // 进行读操作，每次读取6个字节的内容
				if(readBytesCount == -1) { // 如果readBytesCount是 -1 表示已经读取完毕
					System.out.println();
					break; // 终止while()方法，即结束读文件操作
				}
				System.out.print(new String(bytes, 0, readBytesCount)); // 将字节数组内读取到的字节转换为String类型的数据
			}*/
			/**再次改进，最终方式*/
			/*byte[] bytes = new byte[10]; // 准备一个长度为6的byte数组，表示每次读取6个字节的内容
			int readBytesCount = 0; // 声明一个读取字节的数量，默认为0
			while((readBytesCount = fis.read(bytes)) != -1) {
				System.out.print(new String(bytes, 0, readBytesCount));
			}System.out.println();*/
			/**配合方法使用读文件(这种方式不适合大文件！！！因为byte数组不能太大)*/
			byte[] bytes = new byte[fis.available()]; // 准备一个长度为总文件字节数的byte数组，表示一次读完文件内容
			fis.read(bytes); // 将字节读入byte数组bytes
			System.out.println(new String(bytes)); // 将byte数组bytes转换成String
			
			
			
			/**
			 * 常用方法int available();返回当前流中剩余的未读取到的字节数量
			 */
			byte[] bytes2 = new byte[10]; // 准备一个长度为6的byte数组，表示每次读取6个字节的内容
			int readBytesCount2 = 0; // 声明一个读取字节的数量，默认为0
			while((readBytesCount2 = fis2.read(bytes2)) != -1) {
				System.err.println("fis2本次读了" + readBytesCount2 + "个字节；还剩" + fis2.available() + "个字节未读");
			}System.out.println();
			
			/**
			 * 常用方法long skip(long n);跳过n个字节不读，进行之后的读取
			 */
			fis3.skip(5); // 跳过5个字节不读
			byte[] bytes3 = new byte[10]; // 准备一个长度为6的byte数组，表示每次读取6个字节的内容
			int readBytesCount3 = 0; // 声明一个读取字节的数量，默认为0
			while((readBytesCount3 = fis3.read(bytes3)) != -1) {
				System.out.print(new String(bytes3, 0, readBytesCount3));
			}System.out.println();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) { // 当流不为空时，进行下面的关闭流操作，避免出现空指针异常
				try {
					fis.close(); // 关闭流
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis2 != null) {
				try {
					fis2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis3 != null) {
				try {
					fis3.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

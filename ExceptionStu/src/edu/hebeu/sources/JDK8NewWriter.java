package edu.hebeu.sources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JDK8NewWriter {
	public static void main(String[] args) {
		FileInputStream fls = null;
		try {
			fls = new FileInputStream("D:\\programme\\code\\python\\pc-space\\1test.py");
			
			int a = 10 / 0;
		} catch (FileNotFoundException | ArithmeticException | NullPointerException e) { // JDK8之后(包括JDK8)支持的catch()新写法
			System.err.println("文件找不到？除0？空指针 异常");
		} finally {
			/** 	finally语句在try {}catch() {}语句块最后执行，并且一定会执行(无论try {}内的语句是否出现异常都会执行)，
			 * finally和try必须一起出现，不能单独编写；finally语句通常用于释放(关闭)资源;
			 * 
			 * 		try内不论是什么情况(就算是有 return)，都会执行finally内的代码，仅仅是执行顺序改变，
			 * 即此时finally内的代码执行在return语句执行之前(非try {}之前); return语句只要执行，方法必然结束；
			 * 
			 * 		try内有return时，其块内的 try {}catch() {}finally {} 之后的代码就不能被执行了！！！
			 * 
			 * 		try内有System.exit(0) /**退出Java虚拟机 JVM//时，finally内的语句就不能执行了！！！其块内的 try {}catch() {}finally {} 之后的代码也就不能被执行了！！！
			 * 
			 * 		try不可单独使用；
			 * 
			 * 		finally和try{}语句也可以连用，类似于 try {}finally {}，
			 * 
			 * 		
			*/
			if(fls != null) {
				try {
					fls.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
	}
}

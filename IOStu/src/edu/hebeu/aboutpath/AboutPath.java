package edu.hebeu.aboutpath;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 这个例子用来讲解之前路径获取的问题和解决方案
 * 
 * 先知：
 * 	新建的 "Source Folder" 文件夹，在这个新建的文件夹内创建文件就相当于在src下创建文件！！！
 * @author 13651
 *
 */
public class AboutPath {
	public static void main(String[] args) {
		FileReader fr = null; // 声明一个文件字符读取流对象
		InputStream is = null; // 声明一个字节读取流对象
		try {
			/**
			 * 这种方式直接填写路径的缺点是：移植性差，如果程序的位置发生改变甚至是操作系统发生了改变，这个填入的路径将面临失效的问题，
			 * 此时还要修改源代码来保证程序的正常执行！
			 */
//			fr = new FileReader("db.properties");
			
			/**
			 * 使用一种比较通用的方式获取路径，即使是代码位置改变甚至操作系统改变，也不会出现路径失效的问题；
			 * 但是注意：使用这种方式的前提是要读取的这个文件必须是在类路径下！
			 * 	类路径下：凡是在src下的路径都是类路径下，即src是类的根路径；
			 */
			String absPath = Thread.currentThread().getContextClassLoader().getResource("db.properties").getPath(); // 获取在类路径下(src下)的 config\\db.properties 文件的绝对路径
			/**
			 * 上面一行代码的解读：
			 * 		Thread.currentThread(); // 获取当前线程
			 * 		getContextClassLoader(); // 线程对象的方法，获取当前线程的类加载器对象
			 * 		getResource(String classPath); // 这是类加载器对象的方法，通过当前线程的类加载器对象获取 classPath 文件对象(注意：当前线程的类加载器默认从类的根路径下(src下)加载资源！)
			 * 		getPath(); // 文件对象的方法，获取这个文件对象的绝对路径
			 */
			
			System.out.println("绝对路径：" + absPath);
			fr = new FileReader(absPath); // 通过流读取这个绝对路径的资源
			
//			Properties p = new Properties();
//			p.load(fr);
//			System.out.println("Properties集合(Map类型集合)加载后读取：");
//			System.out.println("用户名：" + p.getProperty("username"));
//			System.out.println("用户名：" + p.getProperty("password"));
//			System.out.println("用户名：" + p.getProperty("driver"));
//			System.out.println("用户名：" + p.getProperty("url"));
			
			int readCharsCount = 0;
			char[] chars = new char[10];
			System.out.println("字符流读取：");
			while((readCharsCount = fr.read(chars)) != -1) {
				System.out.print(new String(chars, 0, readCharsCount));
			}System.out.println();
			
			// 或者以这种方式读取类路径下(src下)的文件内容
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"); // 直接以字节流的形式返回文件的内容
			/**
			 * 上面一行代码的解读：
			 * 		Thread.currentThread(); // 获取当前线程
			 * 		getContextClassLoader(); // 线程对象的方法，获取当前线程的类加载器对象
			 * 		getResourceAsStream(String classPath); // 类加载器对象的方法，通过当前线程的类加载器对象获取 classPath 文件对象内容的字节流(注意：当前线程的类加载器默认从类的根路径下(src下)加载资源！)
			 */
			
//			Properties p = new Properties();
//			p.load(is);
//			System.out.println("Properties集合(Map类型集合)加载后读取：");
//			System.out.println("用户名：" + p.getProperty("username"));
//			System.out.println("用户名：" + p.getProperty("password"));
//			System.out.println("用户名：" + p.getProperty("driver"));
//			System.out.println("用户名：" + p.getProperty("url"));
			
			int readBytesCount = 0;
			byte[] bytes = new byte[60];
			System.out.println("字节流读取：");
			while((readBytesCount = is.read(bytes)) != -1) {
				System.out.print(new String(bytes, 0, readBytesCount));
			}System.out.println();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

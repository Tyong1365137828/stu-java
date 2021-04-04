package edu.hebeu.fileclass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类和流的四大家族没有关系，所以其不能完成文件的读写，
 * 	
 * 	File对象表示什么：
 * 		File是一个文件或目录路径名的抽象表示形式；
 * 		D:\programme 是一个File对象
 * 		C:\index.txt 也是一个对象
 * 		File对象有可能是目录，也可能是文件，File只是一个路径的抽象表示形式
 * 
 * 	File类常用的方法:
 * 		boolean exists(); // 判断是否存在File对象
 * 		void createNewFile(); // 以文件的形式创建此File对象(即在File对象的指定路径下创建文件)
 * 		void mkdir(); // 以目录的形式创建此File对象(即在File对象的指定路径下创建文件)
 * 		void mkdirs(); // 以多重目录的形式创建此File对象(即在File对象的指定路径下创建文件)
 * 		String getParent(); // 获取当前File对象的父路径
 * 		File getParentFlie(); // 获取当前File对象的父File对象
 * 		String getAbsolutePath(); // 获取当前File对象的绝对路径
 * 		boolean delete(); // 删除当前File对象(由File对象指定的文件或目录)
 * 		String getName(); // 获取当前File对象的文件名
 * 		boolean isDirectory(); // 判断当前File对象是否为目录
 * 		boolean isFile(); // 判断当前File对象是否为文件
 * 		boolean isHidden(); // 判断当前File对象是否为隐藏文件
 * 		long lastModified(); // 获取当前File对象最后一次的修改时间(毫秒：1970-1-1 0:0:0 000开始到现在的毫秒数)
 * 		long length(); // 获取当前File对象的大小(字节)
 *		boolean renameTo(File dest); // 充命名当前File对象的路径 成 dest路径
 *		File[] listFiles(); // 获取当前File对象下的所有子文件对象
 *		
 *		
 * @author 13651
 *
 */
public class FileStu {
	public static void main(String[] args) {
		File file = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\file\\数据1"); // 路径可以是目录，也可以是文件
		
		/**判断是否存在此File对象(即判断是否存在此路径)*/
		boolean existsFlag = file.exists();
		System.out.println("存在此File对象(路径)吗?" + existsFlag);
		
		
			if(!existsFlag) { // 如果没有此File对象指定的路径
					try {
						/**根据File对象的路径以文件的形式创建*/
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				/**根据File对象的路径以目录的形式创建*/
//				file.mkdir();				
			}
			
			
			File file2 = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\file\\a\\b\\c\\d");
			if(!file2.exists()) {
				/**根据File对象的路径以多重目录的形式创建*/
				file2.mkdirs();
			}
			
			
			File file3 = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\file\\数据1");
			String parentPath = file3.getParent(); /**获取当前File对象的父路径*/
			System.out.println("获取到当前File对象的父路径：" + parentPath + "; 当前File对象的绝对路径：" + file3.getAbsolutePath());
			File parentFile = file3.getParentFile(); /**获取当前File对象的父File对象*/
			System.out.println("获取到当前File对象,由父对象获取绝对路径：" + parentFile.getAbsolutePath());
			
			System.out.println("当前File对象的文件名：" + file3.getName() + "; 当前File对象最好一次修改的时间：" + new Date(file3.lastModified()));
			System.out.println("当前File对象是否为目录？" + file3.isDirectory() + "; 当前File对象是否为文件？" + file3.isFile() + "; 当前File对象是否是隐藏的？" + file3.isHidden());
			System.out.println("当前File对象的文件大小：" + file3.length() + "byte");
			
			/**获取当前File对象下的所有子文件*/
			File file4 = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\file");
			File[] files = file4.listFiles();
			System.out.println("当前File对象的所有子文件的绝对路径：");
			for(File f : files) {
				System.out.println(f.getAbsolutePath());
			}
	}
}

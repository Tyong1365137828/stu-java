package edu.hebeu.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MkdirCopy {
	public static void main(String[] args) {
		File srcFile = new File("F:\\学习\\C++"); // 创建拷贝源对象
		File destFile = new File("D:\\programme\\code\\java\\neon\\IOStu\\data\\mkdir\\dest"); // 创建拷贝目标
		
		copyMkdir(srcFile, destFile); // 调用拷贝目录静态方法
	}
	
	/**
	 * 拷贝目录方法
	 * @param srcFile 拷贝源
	 * @param destFile 拷贝目标
	 */
	public static void copyMkdir(File srcFile, File destFile) {
		if(srcFile.isFile()) { /**如果拷贝源文件是文件*/
			/**进行拷贝文件*/
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			try {
				fis = new FileInputStream(srcFile); // 通过拷贝源的File对象创建FileInputStream字节输入流对象
				String destFilePath = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsoluteFile() + "\\") + srcFile.getAbsolutePath().substring(3);// 获取拷贝的目标文件路径，substring(3)表示将拷贝源文件对象的路径从第3位开始截取(即不包含转义符，截取盘符，如截取：" D:/ ")
				fos = new FileOutputStream(destFilePath); // 通过拷贝目标的File对象创建FileOutputStream字节输出流对象
				byte[] bytes = new byte[1024 * 1024]; // 一次最多读取1MB字节
				int readBytesCount = 0; // 存储每次读取到字节数组的字节数
				while((readBytesCount = fis.read(bytes)) != -1) {
					fos.write(bytes, 0, readBytesCount); // 进行写操作
				}
				
				fos.flush(); // 输出流用完之后进行刷新，清空管道
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return; // 结束递归
		}

		System.out.println("长度============：");
		/**程序执行到此说明拷贝源是目录*/
		File[] childFiles = srcFile.listFiles();
		System.out.println("长度：" + childFiles.length);
		for(File childFile : childFiles) { // 获取拷贝源目录的子文件对象

//			System.out.println(childFile.getAbsolutePath());
			if(childFile.isDirectory()) { // 如果拷贝源文件的这个子文件是目录
				// 新建对应目录
				String srcMkdir = childFile.getAbsolutePath(); // 获取拷贝的源目录
				String destMkdir = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsoluteFile() + "\\") + srcMkdir.substring(3); // 获取拷贝的目标目录，substring(3)表示将拷贝源文件对象的路径从第3位开始截取(即不包含转义符，截取盘符，如截取：" D:/ ")
				File newFile = new File(destMkdir); // 通过目标目录创建File对象
				if(!newFile.exists()) { // 如果这个File对象不存在
					newFile.mkdirs(); // 通过这个File对象创建目录
				}
			}
			
			copyMkdir(childFile, destFile); // 进行递归
		}
	}
}

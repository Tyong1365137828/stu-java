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
		} catch (FileNotFoundException | ArithmeticException | NullPointerException e) { // JDK8֮��(����JDK8)֧�ֵ�catch()��д��
			System.err.println("�ļ��Ҳ�������0����ָ�� �쳣");
		} finally {
			/** 	finally�����try {}catch() {}�������ִ�У�����һ����ִ��(����try {}�ڵ�����Ƿ�����쳣����ִ��)��
			 * finally��try����һ����֣����ܵ�����д��finally���ͨ�������ͷ�(�ر�)��Դ;
			 * 
			 * 		try�ڲ�����ʲô���(�������� return)������ִ��finally�ڵĴ��룬������ִ��˳��ı䣬
			 * ����ʱfinally�ڵĴ���ִ����return���ִ��֮ǰ(��try {}֮ǰ); return���ֻҪִ�У�������Ȼ������
			 * 
			 * 		try����returnʱ������ڵ� try {}catch() {}finally {} ֮��Ĵ���Ͳ��ܱ�ִ���ˣ�����
			 * 
			 * 		try����System.exit(0) /**�˳�Java����� JVM//ʱ��finally�ڵ����Ͳ���ִ���ˣ���������ڵ� try {}catch() {}finally {} ֮��Ĵ���Ҳ�Ͳ��ܱ�ִ���ˣ�����
			 * 
			 * 		try���ɵ���ʹ�ã�
			 * 
			 * 		finally��try{}���Ҳ�������ã������� try {}finally {}��
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

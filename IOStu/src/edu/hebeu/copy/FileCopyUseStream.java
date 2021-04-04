package edu.hebeu.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �������չʾ���ͨ��FiltInputStream��FileOutputStream�����ļ�
 * 	�������ʹ�õ���Stream����ʲô�����ļ����ܿ���
 * @author 13651
 *
 */
public class FileCopyUseStream {
	public static void main(String[] args) {
		FileInputStream fis = null; // ����һ������������
		FileOutputStream fos = null; // ����һ�����������
		
		try {
			
			fis = new FileInputStream("F:\\ѧϰ\\javaEE\\�ڶ��ο�\\��6�ܣ���2�οΣ�.mp4"); // ����һ������������
			fos = new FileOutputStream("D:\\programme\\code\\java\\neon\\IOStu\\data\\streamData\\������Ƶ.mp4"); // ����һ�����������
			
			/**
			 * ���ж�д����(�߶���д)
			 */
			byte[] bytes = new byte[1024 * 1024]; // һ������ȡ 1MB �ֽ�
			int readBytesCount = 0; // �������ÿ�ζ�ȡ��byte������ֽ�����
			while((readBytesCount = fis.read(bytes)) != - 1) {
				fos.write(bytes, 0, readBytesCount); // ��ÿ�ζ�ȡ�����ֽ�д��
			}
			
			fos.flush(); // ���������ʹ�����Ҫ����ˢ��
			
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
	}
}

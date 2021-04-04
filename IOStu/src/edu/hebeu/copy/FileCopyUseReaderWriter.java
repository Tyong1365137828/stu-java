package edu.hebeu.copy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �������չʾ���ʹ��FileReader��FileWriter������ͨ�ı��ļ�
 * 	��������ֻ�ܲ�����ͨ���ı��ļ�
 * @author 13651
 *
 */
public class FileCopyUseReaderWriter {
	public static void main(String[] args) {
		FileReader fr = null; // �����ַ�������
		FileWriter fw = null; // �����ַ������
		
		try {
			fr = new FileReader("F:\\ѧϰ\\javaEE\\��ʮһ�ο�\\backup"); // �����ַ�����������
			fw = new FileWriter("D:\\programme\\code\\java\\neon\\IOStu\\data\\read_writerData\\�����ļ�"); // �����ַ����������
			
			/**
			 * ���п�������
			 */
			char[] chars = new char[1024 * 512]; // �����ַ����飬�洢ÿ�ζ�ȡ���ַ�����ʾһ������ȡ1MB
			int readCharsCount = 0; // �������ÿ�ζ�ȡ���ַ�������ַ���
			while((readCharsCount = fr.read(chars)) != -1) {
				fw.write(chars, 0, readCharsCount); // ��ÿ�ζ�ȡ�����ַ�д��
			}
			
			fw.flush(); // �ַ����������ʹ����֮��Ҫ����ˢ�£�����չܵ�
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
	}
}

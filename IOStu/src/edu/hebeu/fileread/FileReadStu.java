package edu.hebeu.fileread;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileRead��
 * 	�ļ��ַ���������ֻ�ܶ�ȡ��ͨ�ı��ļ���
 * 	��ȡ�ļ�����ʱ���ȽϷ�����
 * @author 13651
 *
 */
public class FileReadStu {
	public static void main(String[] args) {
		FileReader fr = null; // �����ַ��ļ�������
		
		try {
			fr = new FileReader("D:\\programme\\code\\java\\neon\\IOStu\\data\\read_writerData\\����1"); // �����ַ�������
			
			char[] chars = new char[4]; // ����һ���ֽ����飬�������ÿ�ζ�ȡ�����ݣ�ÿ������ȡ4���ַ�
			int readCharsCount = 0; // ������¼ÿ�ζ�ȡ�����ַ���
			while((readCharsCount = fr.read(chars)) != -1) {
				System.out.print(new String(chars, 0, readCharsCount)); // ��ÿ�ζ�ȡ���ַ�������ַ�ת��ΪString�������
			}System.out.println();
			
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
		}
		
	}
}

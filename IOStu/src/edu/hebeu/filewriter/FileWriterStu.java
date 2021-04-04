package edu.hebeu.filewriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter:
 * 	�ַ��������ֻ�������ͨ�ı��ļ���
 * @author 13651
 *
 */
public class FileWriterStu {
	public static void main(String[] args) {
		FileWriter fw = null; // ����һ���ַ������
		
		try {
			fw = new FileWriter("data\\read_writerData\\д������", true); // �����ַ�����������������д���ļ��������ԭ�ļ�������׷����ԭ�ļ����ݺ��棻
			
			/**
			 * д�����
			 */
			char[] chars = {'��', '��', 'J', 'a', 'v', 'a', '!', '!', '!'};
//			fw.write(chars); // д���ַ������ȫ������
			fw.write(chars, 1, 2); // д���ַ�������±� 1 ��ʼ������Ϊ2������	
			
			fw.write("\n"); // д�뻻��
			
			String s = "ͨ��String�����������д��";
//			fw.write(s); // ֱ�Ӵ����ַ���
			fw.write(s, 0, 5); // д��String�������ݵĲ�������		
			
			
			fw.flush(); // ���������֮��ǵ�Ҫˢ�£�����չܵ�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

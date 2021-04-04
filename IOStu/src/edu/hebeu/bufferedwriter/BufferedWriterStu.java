package edu.hebeu.bufferedwriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * BufferedWriter:
 * 	���л��������ַ��������
 * @author 13651
 *
 */
public class BufferedWriterStu {
	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		try {
			/**����BufferedWriter����*/
//			bw = new BufferedWriter(new FileWriter("data\\bufferedData\\д������", true)); // ����BufferedWriter����(���ڵ������ַ���ʱ)�����Ҳ������ԭ�ļ�������
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data\\bufferedData\\д������", true))); // ����BufferedWriter����(���ڵ������ֽ���ʱ��Ҫ���ֽ���ͨ��OutputStreamWriterת�����ַ���)�����Ҳ������ԭ�ļ�������
			
			/**
			 * д������write()������ʹ��ͬFileOutStream��write()����һ��
			 */
			char[] chars = {'c', 'h', 'a', 'r', 'a', 'r', 'r', 'a', 'y'};
			bw.write(chars); // д��һ��������char����
			bw.write("\n"); // д��һ������
			bw.write(chars, 1, 5); // д��һ�����ֵ�char���飬���±�Ϊ1��ʼ��5�����Ƚ���
			bw.write("\n"); // д��һ������
			bw.write(97); // д��һ��byteֵΪ97��Ӧ������(��a)
			bw.write("\n"); // д��һ������
			bw.write("���!Java������"); // д��һ���ַ���
			bw.write("���!Java������", 0, 2); // д��һ���ַ�����һ���ִ��±�0��ʼ��2������Ϊֹ
			bw.write("\n"); // д��һ������
			
			bw.flush(); // д��֮��ˢ��һ�£���չܵ�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	}
}

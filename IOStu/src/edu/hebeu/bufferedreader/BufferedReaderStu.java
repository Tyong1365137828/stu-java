package edu.hebeu.bufferedreader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * BufferedReader:
 * 	���л���������������
 * 	ʹ������������Զ���char/byte���飬�Դ����壻
 * 	���췽��ֻ�ܴ���Reader����ֻ��ʹ���ַ����������ֽ�����Ҫ��ת�����ַ�������ʹ��BufferedReader
 * 
 * ���췽����
 * 	new BufferedReader(Reader r); // ����BufferedReader������ҪReader����(�ַ���)������Reader�ǳ���ģ����Reader���Խ��������ഴ������
 * 
 * ���з�����
 * 	String readLine(); // ��ȡһ���ı��У����ǲ���������Ļ���(�������з�)
 * 	
 * 
 * �����һ�����Ĺ��췽����Ҫһ����ʱ������������������"�ڵ���"��
 * �ⲿ�����װ��������"��װ��"��
 * 
 * @author 13651
 *
 */
public class BufferedReaderStu {
	public static void main(String[] args) {
		BufferedReader br = null; // ����һ����װ������
		try {
			/**�����ַ���*/
//			Reader reader = new FileReader("data\\bufferedData\\����1"); // ����Reader����
//			FileReader reader = new FileReader("data\\bufferedData\\����1"); // Ҳ���Դ���Reader������Ķ���
//			br = new BufferedReader(reader); // ͨ��Reader���󴴽�BufferedReader����
			// ���Ժϲ�Ϊ
//			br = new BufferedReader(new FileReader("data\\bufferedData\\����1"));
			
			/**�����ֽ���*/
//			FileInputStream fis = new FileInputStream("data\\bufferedData\\����1"); // �����ֽ�������
//			InputStreamReader isr = new InputStreamReader(fis); // ���ֽ�������(InputStream)ת�����ַ�������(Reader)
//			br = new BufferedReader(isr); // ���ֽ���FileInputStreamת���ɵ�Reader�ַ���������BufferedReader���󣬴���BufferedReader����
			// ���Ժϲ�Ϊ
			br = new BufferedReader(new InputStreamReader(new FileInputStream("data\\bufferedData\\����1")));
			
			/**
			 * 		�����У������BufferedReader��Reader����Reader������FileReader�ȵĽ����ڵ�����
			 *	BufferedReader������װ�����ߴ�������
			 *		�����InputStreamReader��FileInputStream�ǽڵ�����FileInputStream������װ����
			 *	�ߴ�������
			 *
			 *		�����ڹر���ʱ��ֻ��Ҫ�ر�������İ�װ�����ɣ���Ϊ�۲�Դ�����������ڰ�װ���ڲ�
			 *	������رչرգ�
			 */
			
			
			/**
			 * ������
			 */			
//			String textLine = br.readLine(); // ��ȡ��һ�����ݣ����ǲ���������Ļ���
//			System.out.println(textLine);
			
			String textLine = null; // �洢������ÿһ���ı�����
			while((textLine = br.readLine()) != null) {
				System.out.println(textLine);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/**�ر�������ʱ��ֻ��Ҫ�رհ�װ��/���������ɣ��ڵ������ùأ���Ϊ�ڵ����ڰ�װ���ڲ��Ѿ�����ر���*/
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
} 

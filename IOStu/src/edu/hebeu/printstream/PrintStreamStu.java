package edu.hebeu.printstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������ѧϰ��׼�ֽ������	java.io.PrintStream
 * 	Ĭ�����������̨��
 * 	��׼�ֽ�����������ֶ��رգ�
 * @author 13651
 *
 */
public class PrintStreamStu {
	public static void main(String[] args) {
		System.out.println("Hello"); // �����ʹ�õı�׼�ֽ������
		
		// ��һ��д��
		PrintStream pStream = System.out;
		pStream.println("��ã�");
		pStream.println("Java");
		
		
		/**
		 * ���϶������������̨��Ҳ���Ըı��׼�ֽ���������������
		 */
		PrintStream ps = null;
		
		try {
			ps = new PrintStream(new FileOutputStream("data\\printData\\log", true)); // ����������ķ���ı��� data\\printData\\log �ļ�������ָ�����̨
			
			System.setOut(ps); // ͨ������Ķ����޸�������򣬽���������ķ���ı��� data\\printData\\log �ļ�������ָ�����̨
			
			/**
			 * д�����������
			 */
			Date now = new Date(); // ��ȡϵͳ��ǰʱ��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"); // ����ʱ���ʽ������
			String nowStr = sdf.format(now); // ��ʱ���ʽ��Ϊһ���ַ���
			System.out.println("��ǰʱ�䣺" + nowStr);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

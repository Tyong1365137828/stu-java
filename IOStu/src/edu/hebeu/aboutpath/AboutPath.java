package edu.hebeu.aboutpath;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ���������������֮ǰ·����ȡ������ͽ������
 * 
 * ��֪��
 * 	�½��� "Source Folder" �ļ��У�������½����ļ����ڴ����ļ����൱����src�´����ļ�������
 * @author 13651
 *
 */
public class AboutPath {
	public static void main(String[] args) {
		FileReader fr = null; // ����һ���ļ��ַ���ȡ������
		InputStream is = null; // ����һ���ֽڶ�ȡ������
		try {
			/**
			 * ���ַ�ʽֱ����д·����ȱ���ǣ���ֲ�Բ��������λ�÷����ı������ǲ���ϵͳ�����˸ı䣬��������·��������ʧЧ�����⣬
			 * ��ʱ��Ҫ�޸�Դ��������֤���������ִ�У�
			 */
//			fr = new FileReader("db.properties");
			
			/**
			 * ʹ��һ�ֱȽ�ͨ�õķ�ʽ��ȡ·������ʹ�Ǵ���λ�øı���������ϵͳ�ı䣬Ҳ�������·��ʧЧ�����⣻
			 * ����ע�⣺ʹ�����ַ�ʽ��ǰ����Ҫ��ȡ������ļ�����������·���£�
			 * 	��·���£�������src�µ�·��������·���£���src����ĸ�·����
			 */
			String absPath = Thread.currentThread().getContextClassLoader().getResource("db.properties").getPath(); // ��ȡ����·����(src��)�� config\\db.properties �ļ��ľ���·��
			/**
			 * ����һ�д���Ľ����
			 * 		Thread.currentThread(); // ��ȡ��ǰ�߳�
			 * 		getContextClassLoader(); // �̶߳���ķ�������ȡ��ǰ�̵߳������������
			 * 		getResource(String classPath); // ���������������ķ�����ͨ����ǰ�̵߳�������������ȡ classPath �ļ�����(ע�⣺��ǰ�̵߳��������Ĭ�ϴ���ĸ�·����(src��)������Դ��)
			 * 		getPath(); // �ļ�����ķ�������ȡ����ļ�����ľ���·��
			 */
			
			System.out.println("����·����" + absPath);
			fr = new FileReader(absPath); // ͨ������ȡ�������·������Դ
			
//			Properties p = new Properties();
//			p.load(fr);
//			System.out.println("Properties����(Map���ͼ���)���غ��ȡ��");
//			System.out.println("�û�����" + p.getProperty("username"));
//			System.out.println("�û�����" + p.getProperty("password"));
//			System.out.println("�û�����" + p.getProperty("driver"));
//			System.out.println("�û�����" + p.getProperty("url"));
			
			int readCharsCount = 0;
			char[] chars = new char[10];
			System.out.println("�ַ�����ȡ��");
			while((readCharsCount = fr.read(chars)) != -1) {
				System.out.print(new String(chars, 0, readCharsCount));
			}System.out.println();
			
			// ���������ַ�ʽ��ȡ��·����(src��)���ļ�����
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"); // ֱ�����ֽ�������ʽ�����ļ�������
			/**
			 * ����һ�д���Ľ����
			 * 		Thread.currentThread(); // ��ȡ��ǰ�߳�
			 * 		getContextClassLoader(); // �̶߳���ķ�������ȡ��ǰ�̵߳������������
			 * 		getResourceAsStream(String classPath); // �����������ķ�����ͨ����ǰ�̵߳�������������ȡ classPath �ļ��������ݵ��ֽ���(ע�⣺��ǰ�̵߳��������Ĭ�ϴ���ĸ�·����(src��)������Դ��)
			 */
			
//			Properties p = new Properties();
//			p.load(is);
//			System.out.println("Properties����(Map���ͼ���)���غ��ȡ��");
//			System.out.println("�û�����" + p.getProperty("username"));
//			System.out.println("�û�����" + p.getProperty("password"));
//			System.out.println("�û�����" + p.getProperty("driver"));
//			System.out.println("�û�����" + p.getProperty("url"));
			
			int readBytesCount = 0;
			byte[] bytes = new byte[60];
			System.out.println("�ֽ�����ȡ��");
			while((readBytesCount = is.read(bytes)) != -1) {
				System.out.print(new String(bytes, 0, readBytesCount));
			}System.out.println();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

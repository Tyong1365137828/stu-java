package edu.hebeu.fileinputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ����ѧϰjava.io.FileInputStream�ࣻ
 * �ص㣺
 * 	1�������ļ��ֽ��������������ܵģ��κ����͵��ļ������Բ���������͵���������
 * 	2�����ֽڵķ�ʽ����������������ɶ��Ĳ���(Ӳ�� ---> �ڴ�)��
 * 
 * ���÷�����
 * 	close(); // �ر���
 * 	int available(); // ����������ʣ���δ�������ֽ�����
 * 	long skip[(long n); // ���������ֽڲ���
 * 	int read(); // ��һ���ֽڣ���ջ֡����1λ��������ǰջָ֡����ֽڶ�ȡ�����ظ��ֽڵ�ֵ���������ȡ���˾ͷ��� -1��
 * 	int read(byte[] b); // һ������ȡb.length���ֽ���byte����b���������ȡ���˾ͷ��� -1��
 * 	
 * @author 13651
 *
 */
public class FileInputStreamStu {
	public static void main(String[] args) {
		// �����ļ��ֽ�����������
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		FileInputStream fis3 = null;
		try {
			// �����ļ��ֽ�����������
			// ·��Ϊ��D:\programme\code\java\neon\IOStu\data\streamData\����1 ��������Java��һ�� \ ��ʾת�壬���Ҫ������ \ ���� \\ 
//			fis = new FileInputStream("D:\\programme\\code\\java\\neon\\IOStu\\data\\streamData\\����1");
			// ����д��
//			fis = new FileInputStream("D:/programme/code/java/neon/IOStu/data/streamData/����1");
			
			/***
			 * ���ϼ��ַ�ʽ����ͨ������·����ʽ��������Ҳ����ͨ�����λ��(����ڴ˹��̵�·��λ�ã������̵�"��")��������
			 */
			fis = new FileInputStream("data/streamData/����1");
			fis2 = new FileInputStream("data/streamData/����1");
			fis3 = new FileInputStream("data/streamData/����1");
			
			/***
			 * ͨ��һ��һ�����ֽ���ɶ�������
			 * 	FileInputStream�ֽ����Ķ���ʽ��
					����һ�����ļ��ڵ����ݱ���ֽ���ʽ����ʹ��ջ֡��ʼָ�������ֽڵĵ�ͷһ���ֽڴ���
					�����������read()�����ͻὫջ֡����1���ֽڣ�ָ��ǰ�ֽ����ڵ��ַ���������ָ����ַ���byteֵ���أ��������û�������ˣ�read()�����᷵��-1��
					���������ظ������ֱ��-1��������������
			 */
			// ��ʼ��
			/*
			// 1.1��ʽ
			int readData = fis.read(); // ��ǰָ֡���һ���ֽڶ�Ӧ���ַ�Ϊa
			System.out.println(readData); // ��һ���ֽڶ�Ӧ���ַ���a�����ֽ�ֵ(ASII��)��97
			
			readData = fis.read(); // ��ǰָ֡��ڶ����ֽڶ�Ӧ���ַ�Ϊb
			System.out.println(readData); // �ڶ����ֽڶ�Ӧ���ַ���b�����ֽ�ֵ(ASII��)��98
			
			readData = fis.read(); // ��ǰָ֡��������ֽڶ�Ӧ���ַ�Ϊc
			System.out.println(readData); // �������ֽڶ�Ӧ���ַ���c�����ֽ�ֵ(ASII��)��99
			
			readData = fis.read(); // ��ǰָ֡����ĸ��ֽڶ�Ӧ���ַ�Ϊd
			System.out.println(readData); // ���ĸ��ֽڶ�Ӧ���ַ���d�����ֽ�ֵ(ASII��)��100
			
			readData = fis.read(); // ��ǰָ֡�������ֽڶ�Ӧ���ַ�Ϊe
			System.out.println(readData); // ������ֽڶ�Ӧ���ַ���b�����ֽ�ֵ(ASII��)��101
			
			readData = fis.read(); // ��ǰָ֡��������ֽڶ�Ӧ���ַ�Ϊf
			System.out.println(readData); // �������ֽڶ�Ӧ���ַ���f�����ֽ�ֵ(ASII��)��102
			
			readData = fis.read(); // ��ʱ�Ѿ���ȡ���ļ���ĩβ�ˣ���ʱû�������ˣ��᷵�� -1
			System.out.println(readData);
			
			readData = fis.read(); // ��ʱ�Ѿ���ȡ���ļ���ĩβ�ˣ���ʱû�������ˣ��᷵�� -1
			System.out.println(readData);
			
			readData = fis.read(); // ��ʱ�Ѿ���ȡ���ļ���ĩβ�ˣ���ʱû�������ˣ��᷵�� -1
			System.out.println(readData);
			
			readData = fis.read(); // ��ʱ�Ѿ���ȡ���ļ���ĩβ�ˣ���ʱû�������ˣ��᷵�� -1
			System.out.println(readData);*/
			
			// 1.2��ʽ����������ȡ�ļ���ʽ�ĸĽ���ʹ��while(true)ѭ����ʽ��ʼ��
			/*System.out.print("[");
			while(true) {
				int readData = fis.read();
				if(readData == -1) {
					System.out.println("]");
					break;
				}
				System.out.print(readData + ", ");
			}*/
			
			// 1.3��ʽ��������while(true)��ʽѭ���ĸĽ�
			/*int readData = 0;
			while((readData=fis.read()) != -1) {
				System.out.print(readData + ", ");
			}*/
			
			/**
			 * ���������ķ���������һ�����⣺
			 * 	һ�ζ�ȡһ���ֽ�byte�������ڴ��Ӳ�̽���̫Ƶ����������ʱ�����Դ���˷��ڽ��������ˣ�
			 * 
			 * Ϊ�˽�����������⣬������취һ�ζ�ȡ����ֽڣ��������ʹ��byte[]��������������룬ͨ������ int read(byte[] b);
			 * 		һ������ȡb.length���ֽڣ���byte[]����b�ڶ�������Ӳ�̺��ڴ�Ľ�������߳���ִ��Ч�ʣ�
			 */
			// 2.1��ʽ��ȡ�ļ�
			byte[] b = new byte[4]; // ����һ������Ϊ4��byte���飬��read()����ʹ�ô����飬ÿ�������ȡ4���ֽ�
			
			/*int readBytesCount = fis.read(b); // ��ʱread()�����ķ���ֵ�ͱ�ɶ������ֽ�������������ʱ�᷵�ص�4(a��b��c��d)
			System.out.println(readBytesCount);
			System.out.println(new String(b)); // ��ʱ������ַ��� abcd
			
			readBytesCount = fis.read(b); // ��ʱ�᷵��2(e��f)
			System.out.println(readBytesCount);
			System.out.println(new String(b)); // ��ʱ������ַ��� efcd(e��f��ab�滻���ˣ�����cdû�б�)*/
			/***
			 * ͨ�����Ͻ�byte����ת��ΪString�ķ������в�ͨ�ģ�����Ҫ��֤ÿ�δ��뼸��byte��ת������byteΪString
			 */
			/*int readBytesCount = fis.read(b);
			System.out.println(readBytesCount);
			System.out.println(new String(b, 0, readBytesCount)); // ��ʾת��bbyte���飬���±�Ϊ0��λ�ÿ�ʼ��ת��readBytesCount���ȸ��ֽ�
			
			readBytesCount = fis.read(b);
			System.out.println(readBytesCount);
			System.out.println(new String(b, 0, readBytesCount)); // ��ʾת��bbyte���飬���±�Ϊ0��λ�ÿ�ʼ��ת��readBytesCount���ȸ��ֽ�
			
			
			readBytesCount = fis.read(b); // ��ʱ�᷵��-1(��һ���ֽڶ�û�ж���)
			System.out.println(readBytesCount);*/
			
			/**
			 * �ܽ������ĸ��ַ�ʽ�����ն��ļ���ʽΪ��
			 */
			/*byte[] bytes = new byte[10]; // ׼��һ������Ϊ6��byte���飬��ʾÿ�ζ�ȡ6���ֽڵ�����
			while(true) {
				int readBytesCount = fis.read(bytes); // ���ж�������ÿ�ζ�ȡ6���ֽڵ�����
				if(readBytesCount == -1) { // ���readBytesCount�� -1 ��ʾ�Ѿ���ȡ���
					System.out.println();
					break; // ��ֹwhile()���������������ļ�����
				}
				System.out.print(new String(bytes, 0, readBytesCount)); // ���ֽ������ڶ�ȡ�����ֽ�ת��ΪString���͵�����
			}*/
			/**�ٴθĽ������շ�ʽ*/
			/*byte[] bytes = new byte[10]; // ׼��һ������Ϊ6��byte���飬��ʾÿ�ζ�ȡ6���ֽڵ�����
			int readBytesCount = 0; // ����һ����ȡ�ֽڵ�������Ĭ��Ϊ0
			while((readBytesCount = fis.read(bytes)) != -1) {
				System.out.print(new String(bytes, 0, readBytesCount));
			}System.out.println();*/
			/**��Ϸ���ʹ�ö��ļ�(���ַ�ʽ���ʺϴ��ļ���������Ϊbyte���鲻��̫��)*/
			byte[] bytes = new byte[fis.available()]; // ׼��һ������Ϊ���ļ��ֽ�����byte���飬��ʾһ�ζ����ļ�����
			fis.read(bytes); // ���ֽڶ���byte����bytes
			System.out.println(new String(bytes)); // ��byte����bytesת����String
			
			
			
			/**
			 * ���÷���int available();���ص�ǰ����ʣ���δ��ȡ�����ֽ�����
			 */
			byte[] bytes2 = new byte[10]; // ׼��һ������Ϊ6��byte���飬��ʾÿ�ζ�ȡ6���ֽڵ�����
			int readBytesCount2 = 0; // ����һ����ȡ�ֽڵ�������Ĭ��Ϊ0
			while((readBytesCount2 = fis2.read(bytes2)) != -1) {
				System.err.println("fis2���ζ���" + readBytesCount2 + "���ֽڣ���ʣ" + fis2.available() + "���ֽ�δ��");
			}System.out.println();
			
			/**
			 * ���÷���long skip(long n);����n���ֽڲ���������֮��Ķ�ȡ
			 */
			fis3.skip(5); // ����5���ֽڲ���
			byte[] bytes3 = new byte[10]; // ׼��һ������Ϊ6��byte���飬��ʾÿ�ζ�ȡ6���ֽڵ�����
			int readBytesCount3 = 0; // ����һ����ȡ�ֽڵ�������Ĭ��Ϊ0
			while((readBytesCount3 = fis3.read(bytes3)) != -1) {
				System.out.print(new String(bytes3, 0, readBytesCount3));
			}System.out.println();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) { // ������Ϊ��ʱ����������Ĺر���������������ֿ�ָ���쳣
				try {
					fis.close(); // �ر���
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis2 != null) {
				try {
					fis2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis3 != null) {
				try {
					fis3.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

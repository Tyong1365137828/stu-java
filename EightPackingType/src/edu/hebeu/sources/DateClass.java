package edu.hebeu.sources;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ѧϰJava�е�Date��װ��
 * @author 13651
 * 
 */
public class DateClass {
	public static void main(String[] args) throws Exception {
		
		/**
		 * ��ȡϵͳ��ǰʱ��
		 */
		Date nowDate = new Date(); // ��ȡϵͳ��ǰʱ�䣬��ȷ������
		System.out.println(nowDate); // ͨ����ӡ���Կ���Dtae���toString()�����Ѿ�����д��
		
		/**
		 * ��ʽ������
		 * yyyy ��
		 * MM ��
		 * dd ��
		 * HH ʱ
		 * mm ��
		 * ss ��
		 * SSS ����
		 * ע�⣺�ڸ�ʽ������ʱ������y M d H m s S�������д���⣬�����ķ�������ʽ������֯
		 */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"); // �����������ڸ�ʽ���ĸ�ʽ����
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String nowDateS = simpleDateFormat1.format(nowDate); // ͨ����ʽ���Ķ������format()��������ʱ��������÷����᷵��һ��ͬ�����ʽ��ͬ��ʱ���ַ���
		System.out.println(nowDateS);
//		int code = Integer.valueOf(nowDateS);
		Long codeLong = Long.valueOf(nowDateS);
		String code = Long.toHexString(codeLong + 1999999999);
		System.out.println(code);
		
		
		/**
		 * ͨ�������ַ�������������
		 */
		String dateTime = "2000=10=02 21=59=56 555";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy=MM=dd HH=mm=ss SSS"); // ע�⣬������󹹽�ʱ����Ĳ���Ҫ�������String���͵����ڸ�ʽһ�£�����
		Date date = simpleDateFormat2.parse(dateTime); // ͨ�� �����ĸ�ʽ���������parse()��������String���͵����ڣ��÷����᷵��һ��Date���͵�ֵ
		System.out.println(date); // Mon Oct 02 21:59:56 CST 2000
		
		/**
		 * ��ȡ��1970��1��1�� 00:00:00 000����ǰϵͳʱ����ܺ�����
		 */
		long nowTimeMills = System.currentTimeMillis();
		System.out.println(nowTimeMills);
		
		/**
		 * ͳ�Ʒ���ִ��ʱ��
		 */
		long doMethodFrontTime = System.currentTimeMillis();
		method();
		long doMethodEndTime = System.currentTimeMillis();
		System.out.println("method()������ִ��" + (doMethodEndTime - doMethodFrontTime) + "ms");
		
		/**
		 * �в����Ĺ��캯��
		 * �����Ǵ�1970��1��1�� 0:0:0 000��ʼ��ϵͳ��ǰʱ��ĺ���������λ�Ǻ���
		 */
		
		Date dateTime2 = new Date(1); // ����������Ϊ1970��1��1�� 0:0:0 001��Date����
		String time1 = simpleDateFormat.format(dateTime2);
		System.out.println("time1=" + time1); // ���8��Сʱ��û�����⣬��Ϊ�����Ƕ�8��
		
		/**
		 * ��ȡ���������
		 */
		Date dateTime3 = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
		String time2 = simpleDateFormat.format(dateTime3);
		System.out.println("time2=" + time2);
	}
	
	// ģ��ִ��ʱ��
	public static void method() {
		for(int i = 0; i < 1000000000; i++) {
//			System.out.println("i=" + i);
		}
	}
}

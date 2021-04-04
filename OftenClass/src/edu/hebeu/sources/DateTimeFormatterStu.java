package edu.hebeu.sources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;

/**
 * �����������ʾDateTimeFormatter�ĳ���API
 * ������SimpleDateFormate
 * 	
 * @author 13651
 *
 */
public class DateTimeFormatterStu {

	/**
	 * ʵ�����ķ�ʽ��
	 * 	��ʽһ��Ԥ�����׼��ʽ���磺DateTimeFormatter.��ʽ
	 * 		��ʽ�Ĳ����У�ISO_LOCAL_DATE_TIME��ISO_LOCAL_DATE��ISO_LOCAL_TIME��
	 * 
	 * 	��ʽ�������ػ���صĸ�ʽ���磺ofLocalizedDateTime(FormatStyle f)��������LocalDateTime
	 * 		��Ҫע�⣺����Ĳ����У�FormatStyle.SHORT��FormatStyle.MEDIUM��FormatStyle.LONG
	 * 	���ػ���ظ�ʽ���磺ofLocalizedDate(FormatStyle f)��������LocalDate
	 * 		��Ҫע�⣺����Ĳ����У�FormatStyle.SHORT��FormatStyle.MEDIUM��FormatStyle.LONG��FomatStyle.FULL
	 * 	......
	 * 	...
	 * 
	 * 	��ʽ�����Զ����ʽ���磺ofPattern("yyyy-MM-dd hh:mm:ss E")
	 * 
	 */
	@Test
	public void test1() {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		
		/*ʹ�÷�ʽһʵ����*/
		// ��ʽ������
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String s1 = dateTimeFormatter.format(localDateTime);
		System.out.println(s1);
		// ...
		
		// ���������ַ���
		TemporalAccessor parse = dateTimeFormatter.parse("2021-03-30T09:44:49.356");
		System.out.println(parse);
		// ...
		
		
		/*ʹ�÷�ʽ��ʵ����*/
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		String s2 = dateTimeFormatter2.format(localDateTime);
		System.out.println(s2);
		// ......
		
		/*ʹ�÷�ʽ��ʵ����*/
		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E");
		String s3 = dateTimeFormatter3.format(LocalDateTime.now());
		System.out.println(s3);
		// ����
		TemporalAccessor parse2 = dateTimeFormatter3.parse("2000-10-02 17:54:26 ����һ");
		System.out.println(parse2);
		
	}
}

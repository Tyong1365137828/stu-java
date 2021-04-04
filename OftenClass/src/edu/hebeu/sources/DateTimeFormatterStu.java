package edu.hebeu.sources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;

/**
 * 这个类用来演示DateTimeFormatter的常用API
 * 类似于SimpleDateFormate
 * 	
 * @author 13651
 *
 */
public class DateTimeFormatterStu {

	/**
	 * 实例化的方式：
	 * 	方式一：预定义标准格式。如：DateTimeFormatter.格式
	 * 		格式的参数有：ISO_LOCAL_DATE_TIME、ISO_LOCAL_DATE、ISO_LOCAL_TIME等
	 * 
	 * 	方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle f)，适用于LocalDateTime
	 * 		需要注意：上面的参数有：FormatStyle.SHORT、FormatStyle.MEDIUM、FormatStyle.LONG
	 * 	本地化相关格式，如：ofLocalizedDate(FormatStyle f)，适用于LocalDate
	 * 		需要注意：上面的参数有：FormatStyle.SHORT、FormatStyle.MEDIUM、FormatStyle.LONG、FomatStyle.FULL
	 * 	......
	 * 	...
	 * 
	 * 	方式三：自定义格式，如：ofPattern("yyyy-MM-dd hh:mm:ss E")
	 * 
	 */
	@Test
	public void test1() {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		
		/*使用方式一实例化*/
		// 格式化日期
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String s1 = dateTimeFormatter.format(localDateTime);
		System.out.println(s1);
		// ...
		
		// 解析日期字符串
		TemporalAccessor parse = dateTimeFormatter.parse("2021-03-30T09:44:49.356");
		System.out.println(parse);
		// ...
		
		
		/*使用方式二实例化*/
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		String s2 = dateTimeFormatter2.format(localDateTime);
		System.out.println(s2);
		// ......
		
		/*使用方式三实例化*/
		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E");
		String s3 = dateTimeFormatter3.format(LocalDateTime.now());
		System.out.println(s3);
		// 解析
		TemporalAccessor parse2 = dateTimeFormatter3.parse("2000-10-02 17:54:26 星期一");
		System.out.println(parse2);
		
	}
}

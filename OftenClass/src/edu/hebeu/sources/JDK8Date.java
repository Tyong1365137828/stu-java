package edu.hebeu.sources;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.junit.Test;

/**
 * JDK8中新的日期时间API(解决了以前Date等API的缺陷)测试
 * 
 * LocalDate代表IOS格式(公历，yyyy-MM-dd)的日期，可以存储生日，纪念日等日期
 * 
 * LocalTime表示一个时间，而不是日期
 * 
 * LocalDateTime用来表示日期和时间的，这是最常用的类之一
 * @author 13651
 *
 */
public class JDK8Date {

	/**
	 * 这个方法测试JDK8之前的Date
	 */
	@Test
	public void test1() {
		// 有偏移量，需要进行处理
		Date date = new Date(2020 - 1900, 3 - 1, 30);
		System.out.println(date);
	}
	
	/**
	 * LocalDate、LocalTime、LocalDateTime的使用
	 * 
	 * 常用API：
	 * 	now() / now(ZoneId zone) 静态方法，根据当前时间创建对象 / 指定时区的对象
	 * 	of() 静态方法，根据指定日期/时间创建对象
	 * 	getDayOfMonth() / getDayOfYear() 获取月份天数(1~31) / 获取年份天数(1~366)
	 * 	getDayOfWeek() 获取星期几(返回一个DayOfWeek枚举值)
	 * 	getMonth() 获取月份，返回一个Month枚举值
	 * 	getMonthValue() / getYear() 获取月份(1~12) / 获取年份
	 * 	getHour() / getMinute() / getSecond() 获取当前对象对应的小时、分钟、秒
	 * 	withDayOfMonth() / withDayOfYear() / withMonth() / withYear() 将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象
	 * 	plusDays(), plusWeeks(), plusMonths(), plusYears(), plusHours() 向当前对象添加几天、几周、几月、几年、几小时
	 * 	minusDays(), minusWeeks(), minusMonths(), minusYears(), minusHours() 从当前对象减去几天、几周、几月、几年、几小时
	 * 
	 * 
	 */
	@Test
	public void test2() {
		// 获取当前的日期、时间、日期 + 时间
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
		
		// of()方法：设置指定的年、月、日、时、分、秒是没有偏移量的
		LocalDateTime localDateTime1 = LocalDateTime.of(2020, 3, 29, 12, 51, 24);
		System.out.println(localDateTime1);
		// ...
		
		// getXxx()：获取指定对象相关的属性
		System.out.println(localDateTime.getDayOfMonth()); // 获取当前是这个月的第几天
		System.out.println(localDateTime.getMonthValue()); // 获取当前月份
		System.out.println(localDateTime.getMinute());
		// ...
		
		//withXxx()：修改相关属性，并且修改之后，原对象的属性是不变的！体现了不可变性！！！
		LocalDate localDate2 = localDate.withDayOfMonth(24); // 设置这个月的24号对应的LocalDate对象并接收
		System.out.println(localDate2);
		LocalDateTime localDateTime2 = localDateTime.withMinute(50); // 设置当前小时内为50分钟对应的LocalDateTime对象并接收
		System.out.println(localDateTime2);
		// ...
		
		// plusXxx()：将相关属性添加以实现修改，并且修改之后，原对象的属性是不变的！体现了不可变性！！！
		LocalDate localDate3 = localDate.plusWeeks(2); // 加两周，并将得到的对象返回接收
		System.out.println(localDate3);
		// ...
		
		// minusXxx()：将相关属性减少以实现修改，原对象的属性是不变的！体现了不可变性！！！
		LocalDateTime localDateTime3 = localDateTime.minusMinutes(600); // 减600分钟，并将得到的对象返回接收
		System.out.println(localDateTime3);
		// ...
		
	}
	
}



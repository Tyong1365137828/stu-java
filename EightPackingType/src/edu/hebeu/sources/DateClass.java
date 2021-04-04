package edu.hebeu.sources;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 学习Java中的Date包装类
 * @author 13651
 * 
 */
public class DateClass {
	public static void main(String[] args) throws Exception {
		
		/**
		 * 获取系统当前时间
		 */
		Date nowDate = new Date(); // 获取系统当前时间，精确到毫秒
		System.out.println(nowDate); // 通过打印可以看出Dtae类的toString()方法已经被重写了
		
		/**
		 * 格式化日期
		 * yyyy 年
		 * MM 月
		 * dd 日
		 * HH 时
		 * mm 分
		 * ss 秒
		 * SSS 毫秒
		 * 注意：在格式化日期时，除了y M d H m s S不能随便写以外，其他的符号填充格式随意组织
		 */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"); // 创建进行日期格式化的格式对象
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String nowDateS = simpleDateFormat1.format(nowDate); // 通过格式化的对象调用format()方法传入时间参数，该方法会返回一个同对象格式相同的时间字符串
		System.out.println(nowDateS);
//		int code = Integer.valueOf(nowDateS);
		Long codeLong = Long.valueOf(nowDateS);
		String code = Long.toHexString(codeLong + 1999999999);
		System.out.println(code);
		
		
		/**
		 * 通过日期字符串解析出日期
		 */
		String dateTime = "2000=10=02 21=59=56 555";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy=MM=dd HH=mm=ss SSS"); // 注意，这个对象构建时传入的参数要与解析的String类型的日期格式一致！！！
		Date date = simpleDateFormat2.parse(dateTime); // 通过 创建的格式化对象调用parse()方法传入String类型的日期，该方法会返回一个Date类型的值
		System.out.println(date); // Mon Oct 02 21:59:56 CST 2000
		
		/**
		 * 获取自1970年1月1日 00:00:00 000到当前系统时间的总毫秒数
		 */
		long nowTimeMills = System.currentTimeMillis();
		System.out.println(nowTimeMills);
		
		/**
		 * 统计方法执行时间
		 */
		long doMethodFrontTime = System.currentTimeMillis();
		method();
		long doMethodEndTime = System.currentTimeMillis();
		System.out.println("method()方法共执行" + (doMethodEndTime - doMethodFrontTime) + "ms");
		
		/**
		 * 有参数的构造函数
		 * 参数是从1970年1月1日 0:0:0 000开始到系统当前时间的毫秒数，单位是毫秒
		 */
		
		Date dateTime2 = new Date(1); // 即构造日期为1970年1月1日 0:0:0 001的Date对象
		String time1 = simpleDateFormat.format(dateTime2);
		System.out.println("time1=" + time1); // 会多8个小时，没有问题，因为北京是东8区
		
		/**
		 * 获取昨天的日期
		 */
		Date dateTime3 = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
		String time2 = simpleDateFormat.format(dateTime3);
		System.out.println("time2=" + time2);
	}
	
	// 模仿执行时间
	public static void method() {
		for(int i = 0; i < 1000000000; i++) {
//			System.out.println("i=" + i);
		}
	}
}

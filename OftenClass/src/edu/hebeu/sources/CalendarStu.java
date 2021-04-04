package edu.hebeu.sources;

import java.util.Calendar;
import java.util.Date;

public class CalendarStu {
	public static void main(String[] args) {
		/*实例化*/
		// 方式一，通过其子类的GregorianCalendar的对象
		// 方式二，通过调用其静态方法getInstance()
		Calendar calendar = Calendar.getInstance();
		
		/*常用方法*/
		int days = calendar.get(Calendar.DAY_OF_MONTH); // 获取当前是这个月的第几天
		System.out.println(days);
		
		days = calendar.get(Calendar.DAY_OF_YEAR); // 获取当前是这一年的第几天
		System.out.println(days);
		
		// ...
		
		calendar.set(Calendar.DAY_OF_MONTH, 5); // 算出5是这个月的第几天
		days = calendar.get(Calendar.DAY_OF_MONTH); // 求出上面赋值计算之后数据
		System.out.println(days);
		
		// ...
		
		calendar.add(Calendar.DAY_OF_YEAR, 5); // 将上面计算好的DAY_OF_YEAR加上5天对应的是这个月的第几天
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		
		// ...
		
		Date date = calendar.getTime(); // 获取calendar对应的Date
		System.out.println(date);
		
		Date nowDate = new Date();
		calendar.setTime(nowDate); // 将的Date对象转为calendar对象
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
	}
}

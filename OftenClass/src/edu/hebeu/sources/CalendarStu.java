package edu.hebeu.sources;

import java.util.Calendar;
import java.util.Date;

public class CalendarStu {
	public static void main(String[] args) {
		/*ʵ����*/
		// ��ʽһ��ͨ���������GregorianCalendar�Ķ���
		// ��ʽ����ͨ�������侲̬����getInstance()
		Calendar calendar = Calendar.getInstance();
		
		/*���÷���*/
		int days = calendar.get(Calendar.DAY_OF_MONTH); // ��ȡ��ǰ������µĵڼ���
		System.out.println(days);
		
		days = calendar.get(Calendar.DAY_OF_YEAR); // ��ȡ��ǰ����һ��ĵڼ���
		System.out.println(days);
		
		// ...
		
		calendar.set(Calendar.DAY_OF_MONTH, 5); // ���5������µĵڼ���
		days = calendar.get(Calendar.DAY_OF_MONTH); // ������渳ֵ����֮������
		System.out.println(days);
		
		// ...
		
		calendar.add(Calendar.DAY_OF_YEAR, 5); // ���������õ�DAY_OF_YEAR����5���Ӧ��������µĵڼ���
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		
		// ...
		
		Date date = calendar.getTime(); // ��ȡcalendar��Ӧ��Date
		System.out.println(date);
		
		Date nowDate = new Date();
		calendar.setTime(nowDate); // ����Date����תΪcalendar����
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
	}
}

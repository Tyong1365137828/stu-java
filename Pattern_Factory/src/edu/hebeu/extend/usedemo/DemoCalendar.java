package edu.hebeu.extend.usedemo;

import java.util.Calendar;

/**
 * JDKԴ���Calendar���о�ʹ���˼򵥹���ģʽ
 * @author 13651
 *
 */
public class DemoCalendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		// ע���·��±�� 0 ��ʼ������ȡ�·�Ҫ+1
		System.out.println("��:" + cal.get(Calendar.YEAR));
		System.out.println(" �� :" + (cal.get(Calendar.MONTH) + 1)); System.out.println("��:" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("ʱ:" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("��:" + cal.get(Calendar.MINUTE));
		System.out.println("��:" + cal.get(Calendar.SECOND));
		
	}
}

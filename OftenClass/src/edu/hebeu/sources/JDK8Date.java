package edu.hebeu.sources;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.junit.Test;

/**
 * JDK8���µ�����ʱ��API(�������ǰDate��API��ȱ��)����
 * 
 * LocalDate����IOS��ʽ(������yyyy-MM-dd)�����ڣ����Դ洢���գ������յ�����
 * 
 * LocalTime��ʾһ��ʱ�䣬����������
 * 
 * LocalDateTime������ʾ���ں�ʱ��ģ�������õ���֮һ
 * @author 13651
 *
 */
public class JDK8Date {

	/**
	 * �����������JDK8֮ǰ��Date
	 */
	@Test
	public void test1() {
		// ��ƫ��������Ҫ���д���
		Date date = new Date(2020 - 1900, 3 - 1, 30);
		System.out.println(date);
	}
	
	/**
	 * LocalDate��LocalTime��LocalDateTime��ʹ��
	 * 
	 * ����API��
	 * 	now() / now(ZoneId zone) ��̬���������ݵ�ǰʱ�䴴������ / ָ��ʱ���Ķ���
	 * 	of() ��̬����������ָ������/ʱ�䴴������
	 * 	getDayOfMonth() / getDayOfYear() ��ȡ�·�����(1~31) / ��ȡ�������(1~366)
	 * 	getDayOfWeek() ��ȡ���ڼ�(����һ��DayOfWeekö��ֵ)
	 * 	getMonth() ��ȡ�·ݣ�����һ��Monthö��ֵ
	 * 	getMonthValue() / getYear() ��ȡ�·�(1~12) / ��ȡ���
	 * 	getHour() / getMinute() / getSecond() ��ȡ��ǰ�����Ӧ��Сʱ�����ӡ���
	 * 	withDayOfMonth() / withDayOfYear() / withMonth() / withYear() ���·�����������������·ݡ�����޸�Ϊָ����ֵ�������µĶ���
	 * 	plusDays(), plusWeeks(), plusMonths(), plusYears(), plusHours() ��ǰ������Ӽ��졢���ܡ����¡����ꡢ��Сʱ
	 * 	minusDays(), minusWeeks(), minusMonths(), minusYears(), minusHours() �ӵ�ǰ�����ȥ���졢���ܡ����¡����ꡢ��Сʱ
	 * 
	 * 
	 */
	@Test
	public void test2() {
		// ��ȡ��ǰ�����ڡ�ʱ�䡢���� + ʱ��
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
		
		// of()����������ָ�����ꡢ�¡��ա�ʱ���֡�����û��ƫ������
		LocalDateTime localDateTime1 = LocalDateTime.of(2020, 3, 29, 12, 51, 24);
		System.out.println(localDateTime1);
		// ...
		
		// getXxx()����ȡָ��������ص�����
		System.out.println(localDateTime.getDayOfMonth()); // ��ȡ��ǰ������µĵڼ���
		System.out.println(localDateTime.getMonthValue()); // ��ȡ��ǰ�·�
		System.out.println(localDateTime.getMinute());
		// ...
		
		//withXxx()���޸�������ԣ������޸�֮��ԭ����������ǲ���ģ������˲��ɱ��ԣ�����
		LocalDate localDate2 = localDate.withDayOfMonth(24); // ��������µ�24�Ŷ�Ӧ��LocalDate���󲢽���
		System.out.println(localDate2);
		LocalDateTime localDateTime2 = localDateTime.withMinute(50); // ���õ�ǰСʱ��Ϊ50���Ӷ�Ӧ��LocalDateTime���󲢽���
		System.out.println(localDateTime2);
		// ...
		
		// plusXxx()����������������ʵ���޸ģ������޸�֮��ԭ����������ǲ���ģ������˲��ɱ��ԣ�����
		LocalDate localDate3 = localDate.plusWeeks(2); // �����ܣ������õ��Ķ��󷵻ؽ���
		System.out.println(localDate3);
		// ...
		
		// minusXxx()����������Լ�����ʵ���޸ģ�ԭ����������ǲ���ģ������˲��ɱ��ԣ�����
		LocalDateTime localDateTime3 = localDateTime.minusMinutes(600); // ��600���ӣ������õ��Ķ��󷵻ؽ���
		System.out.println(localDateTime3);
		// ...
		
	}
	
}



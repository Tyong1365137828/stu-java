package edu.hebeu.sources;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.Test;

/**
 * Instant��
 * @author 13651
 *
 */
public class InstantStu {

	/**
	 * ���������ʾInstant��ĳ���API
	 * 	now() ��̬����������Ĭ��UTCʱ����Instant��Ķ���
	 * 	ofEpochMill(long epochMill) ��̬������������1970-01-01 00:00:00�����ϼ���ָ��������֮���Instant��Ķ���
	 * 	atOffset(ZoneOffset offset) ��ϼ�ʱ��ƫ��������һ��OffsetDateTime
	 * 	toEpochMill() ����1970-01-01 00:00:00����ǰ�ĺ���������ʱ���
	 */
	@Test
	public void test1() {
		Instant instant = Instant.now();
		System.out.println(instant); // ע�ⱱ��λ�ڶ������������8Сʱ
		
		// ������ƫ��8Сʱ�Ķ��󷵻ؽ��գ�ע��Instant��������Բ���ı䣡�����˲��ɱ��ԣ�����
		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
		System.out.println(offsetDateTime);
		
		// ����Instant�����ʱ���
		long l = instant.toEpochMilli();
		System.out.println(l);
		
		// ͨ��������(ʱ���)����Instantʵ������
		Instant instant2 = Instant.ofEpochMilli(l);
		System.out.println(instant2);
		
	}
}

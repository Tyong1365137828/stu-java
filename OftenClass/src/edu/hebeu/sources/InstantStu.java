package edu.hebeu.sources;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.Test;

/**
 * Instant的
 * @author 13651
 *
 */
public class InstantStu {

	/**
	 * 这个例子演示Instant类的常用API
	 * 	now() 静态方法，返回默认UTC时区的Instant类的对象
	 * 	ofEpochMill(long epochMill) 静态方法，返回再1970-01-01 00:00:00基础上加上指定毫秒数之后的Instant类的对象
	 * 	atOffset(ZoneOffset offset) 结合即时的偏移来创建一个OffsetDateTime
	 * 	toEpochMill() 返回1970-01-01 00:00:00到当前的毫秒数，即时间戳
	 */
	@Test
	public void test1() {
		Instant instant = Instant.now();
		System.out.println(instant); // 注意北京位于东八区，会相差8小时
		
		// 将对象偏移8小时的对象返回接收，注意Instant对象的属性不会改变！体现了不可变性！！！
		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
		System.out.println(offsetDateTime);
		
		// 计算Instant对象的时间戳
		long l = instant.toEpochMilli();
		System.out.println(l);
		
		// 通过毫秒数(时间戳)创建Instant实例对象
		Instant instant2 = Instant.ofEpochMilli(l);
		System.out.println(instant2);
		
	}
}

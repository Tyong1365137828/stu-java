package edu.hebeu.entity;

import java.util.Date;

/**
 * 这个类供反射属性测试使用
 * @author 13651
 *
 */
public class FieldEntity {
	
	/**
	 * 共4个Field，分别采用public、private、protected、和默认
	 */
	Date birthday; // 整行表示一个Field对象
	public Integer sex; // 整行表示一个Field对象
	protected Integer age; // 整行表示一个Field对象
	public String name; // 整行表示一个Field对象
	public static final String Country = "中国"; // 整行表示一个Field对象
}

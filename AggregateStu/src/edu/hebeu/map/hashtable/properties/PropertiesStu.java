package edu.hebeu.map.hashtable.properties;

import java.util.Properties;

/**
 * 演示Properties集合的学习：
 * 	Properties是Map集合，继承Hashtable集合，Properties集合的key和value都是String类型；
 * 	Properties被称为属性类对象，Properties是线程安全的；
 * 
 * 常用方法：
 * 	void setProperty(String key, String value); // 会调用Hashtable的put()方法，存入一个元素
 * 	String value = getProperty(String key); // 通过key获取value
 * @author 13651
 *
 */
public class PropertiesStu {
	public static void main(String[] args) {
		// 创建一个Properties对象
		Properties p = new Properties();
		
		// Properties存元素，注意存入的key和value都只能是String类型的
		p.setProperty("url", "jdbc:mysql://127.0.0.1:3306/test");
		p.setProperty("driver", "com.mysql.jdbc.Driver");
		p.setProperty("username", "root");
		p.setProperty("password", "0727316052");
		
		// Properties取元素
		String s1 = p.getProperty("url");
		String s2 = p.getProperty("driver");
		String s3 = p.getProperty("username");
		String s4 = p.getProperty("password");
		
		System.out.println("URL：" + s1 + "; 驱动：" + s2 + "; 用户名：" + s3 + "; 密码：" + s4);
	}
}

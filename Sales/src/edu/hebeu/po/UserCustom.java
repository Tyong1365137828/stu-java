package edu.hebeu.po;

import java.util.List;

/**
 * @author Tyong(汤勇)
 * UserCustom.java
 * Jul 6, 2020
 * 用户扩展类
 */
public class UserCustom extends User {

	private Integer age; // 用户年龄，注意，这个在用户表中没有，是用来在接受参数传入数据库进行分析的

	private List<Order> order_list;	//一个user对应多个order
	
	public List<Order> getOrder_list() {
		return order_list;
	}

	public void setOrder_list(List<Order> order_list) {
		this.order_list = order_list;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return super.toString()+"UserCustom [age=" + age + "]";
	}
	
	
	

}

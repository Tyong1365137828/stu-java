package edu.hebeu.po;

import java.util.List;

/**
 * @author Tyong(����)
 * UserCustom.java
 * Jul 6, 2020
 * �û���չ��
 */
public class UserCustom extends User {

	private Integer age; // �û����䣬ע�⣬������û�����û�У��������ڽ��ܲ����������ݿ���з�����

	private List<Order> order_list;	//һ��user��Ӧ���order
	
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

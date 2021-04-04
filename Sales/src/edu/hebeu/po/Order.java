package edu.hebeu.po;

import java.util.Date;
import java.util.List;

/**
 * @author Tyong(����)
 * Order.java
 * Jul 6, 2020
 * �˵���
 */
public class Order {
	private String num;	//������
	private String user_account;	//�û��˺�
	private Date createtime;	//��������
	private Double total_price;	//�õ��ܼ�
	private String note;	//״̬

	private List<Orderdetail> orderdetail_list;	//һ��order��Ӧ���orderdetail
	
	public List<Orderdetail> getOrderdetail_list() {
		return orderdetail_list;
	}

	public void setOrderdetail_list(List<Orderdetail> orderdetail_list) {
		this.orderdetail_list = orderdetail_list;
	}

	private User user;	//����user���࣬1��1��ϵ
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Order(String num, String user_account, Date createtime, Double total_price, String note) {
		super();
		this.num = num;
		this.user_account = user_account;
		this.createtime = createtime;
		this.total_price = total_price;
		this.note = note;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [num=" + num + ", user_account=" + user_account + ", createtime=" + createtime + ", total_price="
				+ total_price + ", note=" + note + "]"+user.toString();
	}

}

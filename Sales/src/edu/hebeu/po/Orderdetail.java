package edu.hebeu.po;


/**
 * @author Tyong(����)
 * Orderdetail.java
 * Jul 6, 2020
 * ��ϸ�˵���
 */
public class Orderdetail {
	private int id;	//id��ʶ
	private String order_num;	//������
	private String items_code;	//������Ʒ���
	private Integer items_num;	//������Ʒ����
	private Double prices;	//����Ʒ�Ĺ����ܼ�
	private String appraise;	//����

	private Items items;	//һ��items��Ӧһ��items
	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_num() {
		return order_num;
	}

	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}

	public String getItems_code() {
		return items_code;
	}

	public void setItems_code(String items_code) {
		this.items_code = items_code;
	}

	public Integer getItems_num() {
		return items_num;
	}

	public void setItems_num(Integer items_num) {
		this.items_num = items_num;
	}

	public Double getPrices() {
		return prices;
	}

	public void setPrices(Double prices) {
		this.prices = prices;
	}

	public String getAppraise() {
		return appraise;
	}

	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}

	public Orderdetail(int id, String order_num, String items_code, Integer items_num, Double prices, String appraise) {
		super();
		this.id = id;
		this.order_num = order_num;
		this.items_code = items_code;
		this.items_num = items_num;
		this.prices = prices;
		this.appraise = appraise;
	}

	public Orderdetail() {
		super();
	}

	@Override
	public String toString() {
		return "Orderdetail [id=" + id + ", order_num=" + order_num + ", items_code=" + items_code + ", items_num="
				+ items_num + ", prices=" + prices + ", appraise=" + appraise + "]";
	}

}

package edu.hebeu.po;

/**
 * @author Tyong(����)
 * Items.java
 * Jul 6, 2020
 * ��Ʒ��Ϣ��
 */
public class Items {
	private String code;	//��Ʒ����
	private String name;	//��Ʒ��
	private String user_account;	//�����˺�
	private Double price;	//����
	private Integer quantity;	//ʣ����Ʒ����
	private String evaluate;	//��Ʒ����
	private String src;	//��ƷͼƬ��ַ
	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Items() {
		super();
	}
	public Items(String code, String name, String user_account, Double price, Integer quantity, String evaluate,
			String src) {
		super();
		this.code = code;
		this.name = name;
		this.user_account = user_account;
		this.price = price;
		this.quantity = quantity;
		this.evaluate = evaluate;
		this.src = src;
	}
	@Override
	public String toString() {
		return "Items [code=" + code + ", name=" + name + ", user_account=" + user_account + ", price=" + price
				+ ", quantity=" + quantity + ", evaluate=" + evaluate + ", src=" + src + "]";
	}

}

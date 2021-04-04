package edu.hebeu;

/**
 * 请求类
 * @author 13651
 *
 */
public class PurchaseRequest {

	private int type; // 请求类型
	private String id; // 请求id
	private float price; // 金额
	
	public PurchaseRequest(int type, String id, float price) {
		super();
		this.type = type;
		this.id = id;
		this.price = price;
	}

	public int getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public float getPrice() {
		return price;
	}
	
}

package edu.hebeu;

/**
 * ������
 * @author 13651
 *
 */
public class PurchaseRequest {

	private int type; // ��������
	private String id; // ����id
	private float price; // ���
	
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

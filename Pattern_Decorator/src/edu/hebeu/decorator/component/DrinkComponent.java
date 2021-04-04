package edu.hebeu.decorator.component;

public abstract class DrinkComponent { // ���������������������
	
	protected String desc; // ��Ʒ����

	private Float price = 0.0f; // ��Ʒ�۸�
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getPrice() {
		return price;
	}
	
	public abstract Float coast(); // �����������������ã��÷����� ��Ʒ�͵��ϵķ����ܺͣ�
	
}

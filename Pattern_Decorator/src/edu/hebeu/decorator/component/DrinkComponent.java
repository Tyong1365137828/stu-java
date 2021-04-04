package edu.hebeu.decorator.component;

public abstract class DrinkComponent { // 这个类用来做抽象主体类
	
	protected String desc; // 饮品描述

	private Float price = 0.0f; // 饮品价格
	
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
	
	public abstract Float coast(); // 这个方法用来计算费用，该费用是 饮品和调料的费用总和；
	
}

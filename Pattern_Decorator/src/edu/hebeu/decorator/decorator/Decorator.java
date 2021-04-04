package edu.hebeu.decorator.decorator;

import edu.hebeu.decorator.component.DrinkComponent;

public class Decorator extends DrinkComponent { // 这个类用来做装饰者类

	private DrinkComponent drink; // 饮品
	
	public Decorator(DrinkComponent drink) {
		this.drink = drink;	
	}
	
	@Override
	public Float coast() { // 这个方法是用来计算总金额，即包括饮品和调料的费用总和
		return super.getPrice() + drink.coast(); // super.getPrice()就是获取 调味品(当前装饰者)的自己的价格
	}

	@Override
	public String getDesc() { // 这个方法用来输出总描述，即包括饮品和调料的全部描述，递归调用思想
		return super.desc + " " + super.getPrice() + "; " + drink.getDesc();
	}
	
	
	
}

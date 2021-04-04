package edu.hebeu.decorator.component;

public class Coffee extends DrinkComponent{
	
	protected Coffee() {} // 将构造器对外界私有化，对子类开放

	@Override
	public Float coast() { // 获取饮品的费用
		// TODO Auto-generated method stub
		return super.getPrice(); // 调用父类的饮品价格，该价格只包含饮品费用，没有包括调料费用
	}

}

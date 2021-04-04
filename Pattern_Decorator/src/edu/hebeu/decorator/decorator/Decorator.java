package edu.hebeu.decorator.decorator;

import edu.hebeu.decorator.component.DrinkComponent;

public class Decorator extends DrinkComponent { // �����������װ������

	private DrinkComponent drink; // ��Ʒ
	
	public Decorator(DrinkComponent drink) {
		this.drink = drink;	
	}
	
	@Override
	public Float coast() { // ������������������ܽ���������Ʒ�͵��ϵķ����ܺ�
		return super.getPrice() + drink.coast(); // super.getPrice()���ǻ�ȡ ��ζƷ(��ǰװ����)���Լ��ļ۸�
	}

	@Override
	public String getDesc() { // ������������������������������Ʒ�͵��ϵ�ȫ���������ݹ����˼��
		return super.desc + " " + super.getPrice() + "; " + drink.getDesc();
	}
	
	
	
}

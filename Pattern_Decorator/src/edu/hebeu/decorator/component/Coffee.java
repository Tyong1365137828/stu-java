package edu.hebeu.decorator.component;

public class Coffee extends DrinkComponent{
	
	protected Coffee() {} // �������������˽�л��������࿪��

	@Override
	public Float coast() { // ��ȡ��Ʒ�ķ���
		// TODO Auto-generated method stub
		return super.getPrice(); // ���ø������Ʒ�۸񣬸ü۸�ֻ������Ʒ���ã�û�а������Ϸ���
	}

}

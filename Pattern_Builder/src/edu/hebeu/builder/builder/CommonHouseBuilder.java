package edu.hebeu.builder.builder;

public class CommonHouseBuilder extends HouseBuilder{

	@Override
	public void piling() {
		System.out.println("��ͨ���Ӵ�ػ�...");
	}

	@Override
	public void buildWall() {
		System.out.println("��ͨ������ǽ...");
	}

	@Override
	public void capping() {
		System.out.println("��ͨ���ӷⶥ...");
	}

}

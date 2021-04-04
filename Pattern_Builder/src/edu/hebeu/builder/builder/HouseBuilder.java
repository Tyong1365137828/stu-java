package edu.hebeu.builder.builder;

import edu.hebeu.builder.product.House;

public abstract class HouseBuilder {
	
	protected House house = new House();
	
	public abstract void piling(); // ����������������д�׮��
	
	public abstract void buildWall(); // �������������ǽ
	
	public abstract void capping(); // ������������ⶥ
	
	public House buildHouse() {
		return house;
	}
	
}

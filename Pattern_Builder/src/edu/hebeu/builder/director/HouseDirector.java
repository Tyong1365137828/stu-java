package edu.hebeu.builder.director;

import edu.hebeu.builder.builder.HouseBuilder;
import edu.hebeu.builder.product.House;

public class HouseDirector { // ָ����
	
	private HouseBuilder builder;
	
	public HouseDirector(HouseBuilder builder) { // ����ͨ������������
		this.builder = builder;
	}

	public void setBuilder(HouseBuilder builder) { // Ҳ����ͨ��setter����
		this.builder = builder;
	}
	
	public House startBuild() {
		
		builder.piling();
		builder.buildWall();
		builder.capping();
		System.out.println("����ɹ���");
		
		return builder.buildHouse();
	}
	
}

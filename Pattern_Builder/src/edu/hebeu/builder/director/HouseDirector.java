package edu.hebeu.builder.director;

import edu.hebeu.builder.builder.HouseBuilder;
import edu.hebeu.builder.product.House;

public class HouseDirector { // 指挥者
	
	private HouseBuilder builder;
	
	public HouseDirector(HouseBuilder builder) { // 可以通过构造器传入
		this.builder = builder;
	}

	public void setBuilder(HouseBuilder builder) { // 也可以通过setter传入
		this.builder = builder;
	}
	
	public House startBuild() {
		
		builder.piling();
		builder.buildWall();
		builder.capping();
		System.out.println("建造成功！");
		
		return builder.buildHouse();
	}
	
}

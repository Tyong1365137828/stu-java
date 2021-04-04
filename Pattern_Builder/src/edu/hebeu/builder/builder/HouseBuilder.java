package edu.hebeu.builder.builder;

import edu.hebeu.builder.product.House;

public abstract class HouseBuilder {
	
	protected House house = new House();
	
	public abstract void piling(); // 这个方法是用来进行打桩的
	
	public abstract void buildWall(); // 这个方法用来砌墙
	
	public abstract void capping(); // 这个方法用来封顶
	
	public House buildHouse() {
		return house;
	}
	
}

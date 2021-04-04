package edu.hebeu.original.house;

public abstract class House {
	
	public abstract void piling(); // 这个方法是用来进行打桩的
	
	public abstract void buildWall(); // 这个方法用来砌墙
	
	public abstract void capping(); // 这个方法用来封顶
	
	public void build() { // 这个方法用来建造房子
		piling();
		buildWall();
		capping();
		System.out.println("建造完毕！");
	}
	
}

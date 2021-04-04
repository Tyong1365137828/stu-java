package edu.hebeu.builder.product;

public class House { // 房子类，相当于建造者模式的产品
	
	private String baise;
	private String wall;
	private String roofed;
	
	public String getBaise() {
		return baise;
	}
	
	public void setBaise(String baise) {
		this.baise = baise;
	}
	
	public String getWall() {
		return wall;
	}
	
	public void setWall(String wall) {
		this.wall = wall;
	}
	
	public String getRoofed() {
		return roofed;
	}
	
	public void setRoofed(String roofed) {
		this.roofed = roofed;
	}
	
}

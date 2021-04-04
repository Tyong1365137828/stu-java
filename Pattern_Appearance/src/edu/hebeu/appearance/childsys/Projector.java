package edu.hebeu.appearance.childsys;

public class Projector {
	
	private static Projector instance = new Projector();
	
	private Projector() {}
	
	public static Projector getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("投影仪打开...");
	}
	
	public void off() {
		System.out.println("投影仪关闭");
	}
	
	public void fox() {
		System.out.println("投影仪正在聚焦...");
	}
	
}

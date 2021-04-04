package edu.hebeu.appearance.childsys;

public class Projector {
	
	private static Projector instance = new Projector();
	
	private Projector() {}
	
	public static Projector getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("ͶӰ�Ǵ�...");
	}
	
	public void off() {
		System.out.println("ͶӰ�ǹر�");
	}
	
	public void fox() {
		System.out.println("ͶӰ�����ھ۽�...");
	}
	
}

package edu.hebeu.appearance.childsys;

public class Light {

	private static Light instance = new Light();
	
	private Light() {}
	
	public static Light getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("灯光打开...");
	}
	
	public void off() {
		System.out.println("灯光关闭");
	}
	
	public void dim() {
		System.out.println("灯光调暗...");
	}
	
	public void bright() {
		System.out.println("灯光调亮...");
	}
	
}

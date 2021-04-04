package edu.hebeu.appearance.childsys;

public class Screen {
	
	private static Screen instance = new Screen();
	
	private Screen() {}
	
	public static Screen getInstance() {
		return instance;
	}
	
	public void up() {
		System.out.println("屏幕收起");
	}
	
	public void down() {
		System.out.println("屏幕放下");
	}
}

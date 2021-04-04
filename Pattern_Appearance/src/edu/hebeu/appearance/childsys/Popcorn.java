package edu.hebeu.appearance.childsys;

public class Popcorn {
	
	private static Popcorn instance = new Popcorn();
	
	private Popcorn() {}
	
	public static Popcorn getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("爆米花机打开...");
	}
	
	public void off() {
		System.out.println("爆米花机关闭");
	}
	
	public void pop() {
		System.out.println("爆米花机正在出爆米花...");
	}
}

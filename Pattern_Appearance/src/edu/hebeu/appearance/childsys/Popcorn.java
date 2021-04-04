package edu.hebeu.appearance.childsys;

public class Popcorn {
	
	private static Popcorn instance = new Popcorn();
	
	private Popcorn() {}
	
	public static Popcorn getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("���׻�����...");
	}
	
	public void off() {
		System.out.println("���׻����ر�");
	}
	
	public void pop() {
		System.out.println("���׻������ڳ����׻�...");
	}
}

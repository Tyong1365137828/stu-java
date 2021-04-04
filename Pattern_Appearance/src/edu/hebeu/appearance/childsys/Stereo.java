package edu.hebeu.appearance.childsys;

public class Stereo {

	private static Stereo instance = new Stereo();
	
	private Stereo() {}
	
	public static Stereo getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("��������...");
	}
	
	public void off() {
		System.out.println("�������ر�");
	}
	
	public void up() {
		System.out.println("����������...");
	}
	
	public void down() {
		System.out.println("��������С...");
	}
	
}

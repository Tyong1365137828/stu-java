package edu.hebeu.appearance.childsys;

public class DVDPlayer {
	
	private static DVDPlayer instance = new DVDPlayer();
	
	private DVDPlayer() {}
	
	public static DVDPlayer getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("DVD����...");
	}
	
	public void off() {
		System.out.println("DVD�ر�");
	}
	
	public void play() {
		System.out.println("DVD���ڲ���...");
	}
	
	public void pause() {
		System.out.println("DVD��ͣ");
	}
	
	public void set() {
		System.out.println("DVDѡ���Ŀ...");
	}
	
}

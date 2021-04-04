package edu.hebeu.appearance.childsys;

public class DVDPlayer {
	
	private static DVDPlayer instance = new DVDPlayer();
	
	private DVDPlayer() {}
	
	public static DVDPlayer getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("DVD开启...");
	}
	
	public void off() {
		System.out.println("DVD关闭");
	}
	
	public void play() {
		System.out.println("DVD正在播放...");
	}
	
	public void pause() {
		System.out.println("DVD暂停");
	}
	
	public void set() {
		System.out.println("DVD选择节目...");
	}
	
}

package edu.hebeu.appearance.childsys;

public class Light {

	private static Light instance = new Light();
	
	private Light() {}
	
	public static Light getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println("�ƹ��...");
	}
	
	public void off() {
		System.out.println("�ƹ�ر�");
	}
	
	public void dim() {
		System.out.println("�ƹ����...");
	}
	
	public void bright() {
		System.out.println("�ƹ����...");
	}
	
}

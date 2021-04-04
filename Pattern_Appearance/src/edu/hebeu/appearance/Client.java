package edu.hebeu.appearance;

public class Client {
	public static void main(String[] args) {
		HomeAppearance homeAppearance = new HomeAppearance();
		homeAppearance.ready();
		homeAppearance.pause();
		homeAppearance.play();
		homeAppearance.off();
	}
}

package edu.hebeu.appearance;

import edu.hebeu.appearance.childsys.DVDPlayer;
import edu.hebeu.appearance.childsys.Light;
import edu.hebeu.appearance.childsys.Popcorn;
import edu.hebeu.appearance.childsys.Projector;
import edu.hebeu.appearance.childsys.Screen;
import edu.hebeu.appearance.childsys.Stereo;

public class HomeAppearance {
	
	private DVDPlayer dvdPlayer;
	private Popcorn popcorn;
	private Projector projector;
	private Screen screen;
	private Stereo stereo;
	private Light light;
	
	public HomeAppearance() {
		dvdPlayer = DVDPlayer.getInstance();
		popcorn = Popcorn.getInstance();
		projector = Projector.getInstance();
		screen = Screen.getInstance();
		stereo = Stereo.getInstance();
		light = Light.getInstance();
	}
	
	public void ready() {
		popcorn.on();
		screen.down();
		projector.on();
		stereo.on();
		dvdPlayer.on();
		dvdPlayer.set();
	}
	
	public void off() {
		dvdPlayer.off();
		popcorn.off();
		projector.off();
		screen.up();
		stereo.off();
		light.off();
	}
	
	public void play() {
		popcorn.pop();
		light.on();
		light.dim();
		dvdPlayer.play();
	}
	
	public void pause() {
		dvdPlayer.pause();
	}
	
}

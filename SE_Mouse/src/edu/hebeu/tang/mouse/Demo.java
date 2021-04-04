package edu.hebeu.tang.mouse;

public class Demo {

	public static void main(String[] args) {
			
		WhiteMouse wMouse=new WhiteMouse();
		GrayMouse gMouse=new GrayMouse();
		MottleMouse mMouse=new MottleMouse();
		Master master=new Master();
		System.out.println("ÊÔ¾Æ¿ªÊ¼---------");
		master.feedingVino(gMouse);
		master.feedingVino(wMouse);
		master.feedingVino(mMouse);

	}

}

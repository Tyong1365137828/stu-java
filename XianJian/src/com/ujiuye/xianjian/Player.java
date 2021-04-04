package com.ujiuye.xianjian;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	String Arrdir[] = { "up", "down", "left", "right" };
	String dir = Arrdir[0];
	int X = 0, Y = 0;// 玩家默认角色坐标
	int frame = 0;// 玩家角色当前帧
	int frames = 0;// 玩家角色总帧数
	int speed = 0;// 角色移动速度
	
	Image upImg[] = null;// 向上状态角色图片数组
	Image downImg[] = null;// 向下状态角色图片数组
	Image leftImg[] = null;// 向左状态角色图片数组
	Image rightImg[] = null;// 向右状态角色图片数组

	public Player(String dir, int x, int y, int frames, int speed) {
		this.X = x;
		this.Y = y;
		this.frames = frames;
		this.speed = speed;
		upImg = new Image[frames];
		downImg = new Image[frames];
		leftImg = new Image[frames];
		rightImg = new Image[frames];
		for (int i = 0; i < frames; i++) {
			upImg[i] = new ImageIcon(dir + "上/" + i + ".png").getImage();
			downImg[i] = new ImageIcon(dir + "下/" + i + ".png").getImage();
			leftImg[i] = new ImageIcon(dir + "左/" + i + ".png").getImage();
			rightImg[i] = new ImageIcon(dir + "右/" + i + ".png").getImage();
		}
	}

	public String[] getArrdir() {
		return Arrdir;
	}

	public void setArrdir(String[] arrdir) {
		Arrdir = arrdir;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	void setFrame() {
		frame = frame + 1;
		if (frame == frames) {
			frame = 0;
		}
	}
	
	public int getFrames() {
		return frames;
	}

	public void setFrames(int frames) {
		this.frames = frames;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	Image getImage() {
		Image i = null;
		switch (dir) {
		case "up":
			i = upImg[frame];
			break;
		case "down":
			i = downImg[frame];
			break;
		case "left":
			i = leftImg[frame];
			break;
		case "right":
			i = rightImg[frame];
			break;
		default:
			i = downImg[frame];
			break;
		}
		return i;
	}

}

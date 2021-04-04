package com.ujiuye.xianjian;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	String Arrdir[] = { "up", "down", "left", "right" };
	String dir = Arrdir[0];
	int X = 0, Y = 0;// ���Ĭ�Ͻ�ɫ����
	int frame = 0;// ��ҽ�ɫ��ǰ֡
	int frames = 0;// ��ҽ�ɫ��֡��
	int speed = 0;// ��ɫ�ƶ��ٶ�
	
	Image upImg[] = null;// ����״̬��ɫͼƬ����
	Image downImg[] = null;// ����״̬��ɫͼƬ����
	Image leftImg[] = null;// ����״̬��ɫͼƬ����
	Image rightImg[] = null;// ����״̬��ɫͼƬ����

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
			upImg[i] = new ImageIcon(dir + "��/" + i + ".png").getImage();
			downImg[i] = new ImageIcon(dir + "��/" + i + ".png").getImage();
			leftImg[i] = new ImageIcon(dir + "��/" + i + ".png").getImage();
			rightImg[i] = new ImageIcon(dir + "��/" + i + ".png").getImage();
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

package com.ujiuye.xianjian;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;

public class NPC implements Runnable {
	int X, Y;// NPC默认角色坐标
	int index = 0;// NPC角色当前帧
	int frame = 0;// NPC角色帧数
	int frameRate = 6;// NPC帧率
	int frameRelease = 1000 / frameRate;// NPC刷新间隔（毫秒）
	Image image[] = null;// NPC角色帧数组
	InputStream npcIs = null;// 读取地图组件配置文件
	Properties npcProp = new Properties();// 申明配置文件对象

	NPC(String dir) {
		try {// 读取地图组件配置文件
			npcIs = new FileInputStream(dir + "npc.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("没有找到对应NPC文件");
		}
		try {// 加载地图组件配置文件
			npcProp.load(npcIs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		initNPC(npcProp, dir);// 根据配置文件加载地图组件
		new Thread(this).start();
	}

	private void initNPC(Properties npcProp, String dir) {
		this.X = Integer.parseInt(npcProp.getProperty("x"));// 设置默认X坐标
		this.Y = Integer.parseInt(npcProp.getProperty("y"));// 设置默认Y坐标
		this.frame = Integer.parseInt(npcProp.getProperty("frame"));// 设置帧数
		image = new Image[frame];// 初始化帧数组
		for (int i = 0; i < frame; i++) {// 加载角色帧数组内容
			image[i] = new ImageIcon(dir + i + ".png").getImage();
		}
	}

	int getIndex() {// 获取当前显示的帧数
		return index;
	}

	void setIndex() {// 设置当前显示的帧数（默认自增1）
		index = index + 1;
		if (index == frame) {
			index = 0;
		}
	}

	void setIndex(int index) {
		this.index = index;
	}

	int getFrame() {// 获取
		return frame;
	}

	int getX() {
		return X;
	}

	int getY() {
		return Y;
	}

	Image getImg() {
		return image[index];
	}

	public void run() {
		while (true) {
			setIndex();
			try {
				Thread.sleep(frameRelease);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
package com.ujiuye.xianjian;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;

public class NPC implements Runnable {
	int X, Y;// NPCĬ�Ͻ�ɫ����
	int index = 0;// NPC��ɫ��ǰ֡
	int frame = 0;// NPC��ɫ֡��
	int frameRate = 6;// NPC֡��
	int frameRelease = 1000 / frameRate;// NPCˢ�¼�������룩
	Image image[] = null;// NPC��ɫ֡����
	InputStream npcIs = null;// ��ȡ��ͼ��������ļ�
	Properties npcProp = new Properties();// ���������ļ�����

	NPC(String dir) {
		try {// ��ȡ��ͼ��������ļ�
			npcIs = new FileInputStream(dir + "npc.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("û���ҵ���ӦNPC�ļ�");
		}
		try {// ���ص�ͼ��������ļ�
			npcProp.load(npcIs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		initNPC(npcProp, dir);// ���������ļ����ص�ͼ���
		new Thread(this).start();
	}

	private void initNPC(Properties npcProp, String dir) {
		this.X = Integer.parseInt(npcProp.getProperty("x"));// ����Ĭ��X����
		this.Y = Integer.parseInt(npcProp.getProperty("y"));// ����Ĭ��Y����
		this.frame = Integer.parseInt(npcProp.getProperty("frame"));// ����֡��
		image = new Image[frame];// ��ʼ��֡����
		for (int i = 0; i < frame; i++) {// ���ؽ�ɫ֡��������
			image[i] = new ImageIcon(dir + i + ".png").getImage();
		}
	}

	int getIndex() {// ��ȡ��ǰ��ʾ��֡��
		return index;
	}

	void setIndex() {// ���õ�ǰ��ʾ��֡����Ĭ������1��
		index = index + 1;
		if (index == frame) {
			index = 0;
		}
	}

	void setIndex(int index) {
		this.index = index;
	}

	int getFrame() {// ��ȡ
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
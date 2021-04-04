package com.ujiuye.xianjian;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class XianJianMap {

	private int x = 0, y = 0;// ��ʼ����ͼ����
	private Image mapImg = null;// ����ͼ

	BufferedImage mapData = null;// ��ͼ�ϰ���ʶ����
	int extra = 0;// ��ͼ��ˮ�������ݵ��ڸ���ͼ���������
	MapExtra mapExtraImg[] = null;// ������ͼ�������
	private int npcCounter = 0;// npc����
	protected NPC npc[] = null;// npc����
	InputStream mapDataIs = null;// ��ȡ��ͼ�����ļ�
	Properties mapDataProp = new Properties();// ���ص�ͼ�����ļ�

	XianJianMap(String mapDir) {

		try {// ��ȡ��ͼ��������ļ�
			this.mapDataIs = new FileInputStream(mapDir + "mapData.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {// ���ص�ͼ��������ļ�
			mapDataProp.load(mapDataIs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		this.extra = Integer.parseInt(mapDataProp.getProperty("extra"));
		// ���������ļ��е��������
		this.npcCounter = Integer.parseInt(mapDataProp.getProperty("npcCounter"));

		if (extra != 0) {
			mapExtraImg = new MapExtra[extra];
			initExtra(mapDataProp, mapDir);
		}

		if (npcCounter > 0) {
			npc = new NPC[npcCounter];// ��ȡNPC���鳤��
			initNpc(mapDir);
		}

		mapImg = new ImageIcon(mapDir + "map.png").getImage();// ���ص�ͼ
		try {
			mapData = ImageIO.read(new File(mapDir + "mapData.png"));// ���ص�ͼ��ʶ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void initNpc(String mapDir) {
		for (int i = 0; i < getNpcCounter(); i++) {
			npc[i] = new NPC(mapDir + "NPC_" + i + "/");
		}
	}

	void initExtra(Properties extraProp, String dir) {
		for (int i = 0; i < extra; i++) {
			mapExtraImg[i] = new MapExtra();
			mapExtraImg[i].setImage(new ImageIcon(dir + (i + 1) + ".png").getImage());
			mapExtraImg[i].setX(Integer.parseInt(extraProp.getProperty((i + 1) + "x")));
			mapExtraImg[i].setY(Integer.parseInt(extraProp.getProperty((i + 1) + "y")));
			if (mapExtraImg[i] == null) {
				System.out.println("11111111");
				System.exit(1);
			}
		}
	}

	public BufferedImage getMapData() {
		return mapData;
	}

	public void setMapData(BufferedImage mapData) {
		this.mapData = mapData;
	}

	public int getExtra() {
		return extra;
	}

	public void setExtra(int extra) {
		this.extra = extra;
	}

	public MapExtra[] getMapExtraImg() {
		return mapExtraImg;
	}

	public void setMapExtraImg(MapExtra[] mapExtraImg) {
		this.mapExtraImg = mapExtraImg;
	}

	public int getNpcCounter() {
		return npcCounter;
	}

	public void setNpcCounter(int npcCounter) {
		this.npcCounter = npcCounter;
	}

	public NPC[] getNpc() {
		return npc;
	}

	public void setNpc(NPC[] npc) {
		this.npc = npc;
	}

	public InputStream getMapDataIs() {
		return mapDataIs;
	}

	public void setMapDataIs(InputStream mapDataIs) {
		this.mapDataIs = mapDataIs;
	}

	public Properties getMapDataProp() {
		return mapDataProp;
	}

	public void setMapDataProp(Properties mapDataProp) {
		this.mapDataProp = mapDataProp;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getMapImg() {
		return mapImg;
	}

	public void setMapImg(Image mapImg) {
		this.mapImg = mapImg;
	}

	class MapExtra {
		Image image = null;
		int x = 0, y = 0;

		Image getImgae() {
			return image;
		}

		void setImage(Image image) {
			this.image = image;
		}

		int getX() {
			return x;
		}

		void setX(int x) {
			this.x = x;
		}

		int getY() {
			return y;
		}

		void setY(int y) {
			this.y = y;
		}
	}
}

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

	private int x = 0, y = 0;// 初始化地图坐标
	private Image mapImg = null;// 主地图

	BufferedImage mapData = null;// 地图障碍标识数据
	int extra = 0;// 地图（水井，房屋等遮盖贴图）组件数量
	MapExtra mapExtraImg[] = null;// 声明地图组件数组
	private int npcCounter = 0;// npc数量
	protected NPC npc[] = null;// npc数组
	InputStream mapDataIs = null;// 读取地图配置文件
	Properties mapDataProp = new Properties();// 加载地图配置文件

	XianJianMap(String mapDir) {

		try {// 读取地图组件配置文件
			this.mapDataIs = new FileInputStream(mapDir + "mapData.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {// 加载地图组件配置文件
			mapDataProp.load(mapDataIs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		this.extra = Integer.parseInt(mapDataProp.getProperty("extra"));
		// 加载配置文件中的组件数量
		this.npcCounter = Integer.parseInt(mapDataProp.getProperty("npcCounter"));

		if (extra != 0) {
			mapExtraImg = new MapExtra[extra];
			initExtra(mapDataProp, mapDir);
		}

		if (npcCounter > 0) {
			npc = new NPC[npcCounter];// 获取NPC数组长度
			initNpc(mapDir);
		}

		mapImg = new ImageIcon(mapDir + "map.png").getImage();// 加载地图
		try {
			mapData = ImageIO.read(new File(mapDir + "mapData.png"));// 加载地图标识数据
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

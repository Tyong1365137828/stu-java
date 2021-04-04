package com.ujiuye.xianjian;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class XianJianFrame extends JFrame implements Runnable{
	private Image cacheImg;// 定义缓冲图层
	private Graphics cacheGph;// 定义缓冲图层绘制器
	
	private boolean mapFlag=true;
	private XianJianMap map_LiJiaCun = null;// 李家村地图
	private XianJianMap map_ShiChang = null;// 市场地图
	
	private XianJianMap currentMap;// 当前地图
	
	// 参数说明:Player(String 素材路径,int 默认x,int 默认y,int 帧数,int 移动速度)
	Player lxy = new Player("src/pic/李逍遥/李逍遥", 900, 500, 8, 5);// 加载李逍遥角色
	Player lyr = new Player("src/pic/林月如/林月如", 900, 500, 8, 5);// 加载林月如角色
	Player player = lxy;// 设置玩家
	
	public XianJianFrame(){
		setMap_LiJiaCun(new XianJianMap("src/pic/李家村/"));// 加载李家村地图
		setMap_ShiChang(new XianJianMap("src/pic/市场/"));// 加载市场地图
		new Thread(this).start();
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void paint(Graphics g) {
		if (mapFlag) {
			currentMap=map_LiJiaCun;
		}else {
			currentMap=map_ShiChang;
		}
		if (cacheImg == null) {// 初始化缓存
			cacheImg = createImage(this.getSize().width, this.getSize().height);
			cacheGph = cacheImg.getGraphics();
		}
		cacheGph.drawImage(currentMap.getMapImg(), currentMap.getX(),
				currentMap.getY(), null);// 绘制地图缓存
		System.out.println("地图绘制完成");
		
		for (int i = 0; i < currentMap.getNpcCounter(); i++) {
			cacheGph.drawImage(currentMap.getNpc()[i].getImg(),
					currentMap.getNpc()[i].getX(), currentMap.getNpc()[i].getY(),
					null);// 绘制NPC缓存
		}
		System.out.println("NPC绘制完成");
		
		cacheGph.drawImage(player.getImage(), player.getX(), player.getY(),
				null);// 绘制玩家缓存
		if (currentMap.getMapData().getRGB(player.getX()+60, player.getY()+108) != -1) {

			for (int i = 0; i < currentMap.getExtra(); i++) {
				cacheGph.drawImage(currentMap.getMapExtraImg()[i].getImgae(),
						currentMap.getMapExtraImg()[i].getX(),
						currentMap.getMapExtraImg()[i].getY(), null);
			}
		}
		g.drawImage(cacheImg, 0, 0, null);// 更新缓存界面
		
	}
	public boolean moveAble(BufferedImage img, int x, int y) {
		if (img.getRGB(x, y) == -16777216) {
			return true;
		}
		return false;
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		super.processKeyEvent(e);
		
		switch (e.getKeyCode()) {
		case 38:// 上
			if (mapFlag) {
				if (player.getY() - player.getSpeed()<=0) {
					player.setY(0);
					mapFlag=!mapFlag;
				}else if (moveAble(currentMap.getMapData(),
						player.getX() + 60, player.getY() + 108 - player.getSpeed())) {
					setPlayIndex();
					repaint();
				}
				else {
					player.setY(player.getY() - player.getSpeed());
				}
			}
			else {
				if (player.getY() - player.getSpeed()<=0) {
					player.setY(0);
				}else if (moveAble(currentMap.getMapData(),
						player.getX() + 60 - player.getSpeed(), player.getY() + 108)) {
					setPlayIndex();
					repaint();
				}
				else {
					player.setY(player.getY() - player.getSpeed());
				}
			}
			player.setDir(player.getArrdir()[0]);
			repaint();
			setPlayIndex();
			System.out.println(player.getY()+"---------");
			break;
		case 40:// 下
			double height=Toolkit.getDefaultToolkit().getScreenSize().height;
			if (mapFlag) {
				if (player.getY() + player.getSpeed()>=height-108) {
					player.setY(Toolkit.getDefaultToolkit().getScreenSize().height-108);
				}else if (moveAble(currentMap.getMapData(), player.getX() + 60,
						player.getY() + 108 + player.getSpeed())) {
					setPlayIndex();
					repaint();
				}
				else {
					player.setY(player.getY() + player.getSpeed());
				}
			}else {
				if (player.getY() + player.getSpeed()>=height-108) {
					player.setY(Toolkit.getDefaultToolkit().getScreenSize().height-108);
					mapFlag=!mapFlag;
				}else {
					player.setY(player.getY() + player.getSpeed());
				}
			}
			player.setDir(player.getArrdir()[1]);
			repaint();
			setPlayIndex();
			System.out.println(player.getY()+"---------");
			break;
		case 37:// 左
			player.setX(player.getX() - player.getSpeed());
			player.setDir(player.getArrdir()[2]);
			repaint();
			setPlayIndex();
			break;
		case 39:// 右
			player.setX(player.getX() + player.getSpeed());
			player.setDir(player.getArrdir()[3]);
			repaint();
			setPlayIndex();
			break;
		case KeyEvent.VK_1:
			player = lxy;
			lxy.setX(lyr.getX());
			lxy.setY(lyr.getY());
			repaint();
			break;
		case KeyEvent.VK_2:
			player = lyr;
			lyr.setX(lxy.getX());
			lyr.setY(lxy.getY());
			repaint();
			break;
		}
		//esc 退出
		if (e.getKeyCode() == 27) {
			System.exit(1);
		}
		
	}
	
	
	void setPlayIndex() {
		player.setFrame();
	}
	
	public Image getCacheImg() {
		return cacheImg;
	}
	public void setCacheImg(Image cacheImg) {
		this.cacheImg = cacheImg;
	}
	public Graphics getCacheGph() {
		return cacheGph;
	}
	public void setCacheGph(Graphics cacheGph) {
		this.cacheGph = cacheGph;
	}
	public XianJianMap getMap_LiJiaCun() {
		return map_LiJiaCun;
	}
	public void setMap_LiJiaCun(XianJianMap map_LiJiaCun) {
		this.map_LiJiaCun = map_LiJiaCun;
	}
	public XianJianMap getMap_ShiChang() {
		return map_ShiChang;
	}
	public void setMap_ShiChang(XianJianMap map_ShiChang) {
		this.map_ShiChang = map_ShiChang;
	}
	
}

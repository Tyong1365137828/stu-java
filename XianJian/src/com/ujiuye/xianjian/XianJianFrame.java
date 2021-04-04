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
	private Image cacheImg;// ���建��ͼ��
	private Graphics cacheGph;// ���建��ͼ�������
	
	private boolean mapFlag=true;
	private XianJianMap map_LiJiaCun = null;// ��Ҵ��ͼ
	private XianJianMap map_ShiChang = null;// �г���ͼ
	
	private XianJianMap currentMap;// ��ǰ��ͼ
	
	// ����˵��:Player(String �ز�·��,int Ĭ��x,int Ĭ��y,int ֡��,int �ƶ��ٶ�)
	Player lxy = new Player("src/pic/����ң/����ң", 900, 500, 8, 5);// ��������ң��ɫ
	Player lyr = new Player("src/pic/������/������", 900, 500, 8, 5);// �����������ɫ
	Player player = lxy;// �������
	
	public XianJianFrame(){
		setMap_LiJiaCun(new XianJianMap("src/pic/��Ҵ�/"));// ������Ҵ��ͼ
		setMap_ShiChang(new XianJianMap("src/pic/�г�/"));// �����г���ͼ
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
		if (cacheImg == null) {// ��ʼ������
			cacheImg = createImage(this.getSize().width, this.getSize().height);
			cacheGph = cacheImg.getGraphics();
		}
		cacheGph.drawImage(currentMap.getMapImg(), currentMap.getX(),
				currentMap.getY(), null);// ���Ƶ�ͼ����
		System.out.println("��ͼ�������");
		
		for (int i = 0; i < currentMap.getNpcCounter(); i++) {
			cacheGph.drawImage(currentMap.getNpc()[i].getImg(),
					currentMap.getNpc()[i].getX(), currentMap.getNpc()[i].getY(),
					null);// ����NPC����
		}
		System.out.println("NPC�������");
		
		cacheGph.drawImage(player.getImage(), player.getX(), player.getY(),
				null);// ������һ���
		if (currentMap.getMapData().getRGB(player.getX()+60, player.getY()+108) != -1) {

			for (int i = 0; i < currentMap.getExtra(); i++) {
				cacheGph.drawImage(currentMap.getMapExtraImg()[i].getImgae(),
						currentMap.getMapExtraImg()[i].getX(),
						currentMap.getMapExtraImg()[i].getY(), null);
			}
		}
		g.drawImage(cacheImg, 0, 0, null);// ���»������
		
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
		case 38:// ��
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
		case 40:// ��
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
		case 37:// ��
			player.setX(player.getX() - player.getSpeed());
			player.setDir(player.getArrdir()[2]);
			repaint();
			setPlayIndex();
			break;
		case 39:// ��
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
		//esc �˳�
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

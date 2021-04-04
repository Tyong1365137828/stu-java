package edu.hebeu.tang5;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Work5Test {

	public static void main(String[] args) {
		Work5 w = new Work5();
		w.Work5();
	}

}

@SuppressWarnings("serial")
class Work5 extends Frame {

	Image i = HuoQuTu.getImage("image/1.jpg");

	public void Work5() {
		setTitle("图片移动");
		setSize(1000, 270);
		setLocation(100, 100);
		setVisible(true);
		new PaintThread().start();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}

	private double x = 0, y = 0;

	public void paint(Graphics g) {		//图片平移
		g.drawImage(i, (int) x, (int) y, null);
		x += 2;
	}

	class PaintThread extends Thread {			//画图
		
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

//获取图片的类
class HuoQuTu{
	public static Image getImage(String s) {		//获取图片的方法
		URL u = Work5Test.class.getClassLoader().getResource(s);  // 获取图片的url
		BufferedImage b = null;
		try {
			b = ImageIO.read(u);	// 通过之前获取的url读取图片
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

}
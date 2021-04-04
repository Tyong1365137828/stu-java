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
		setTitle("ͼƬ�ƶ�");
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

	public void paint(Graphics g) {		//ͼƬƽ��
		g.drawImage(i, (int) x, (int) y, null);
		x += 2;
	}

	class PaintThread extends Thread {			//��ͼ
		
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

//��ȡͼƬ����
class HuoQuTu{
	public static Image getImage(String s) {		//��ȡͼƬ�ķ���
		URL u = Work5Test.class.getClassLoader().getResource(s);  // ��ȡͼƬ��url
		BufferedImage b = null;
		try {
			b = ImageIO.read(u);	// ͨ��֮ǰ��ȡ��url��ȡͼƬ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

}
package com.ujiuye.xianjian;

public class Game {

	public static void main(String[] args) {
		XianJianFrame gameFrame = new XianJianFrame();// ���������д���һ����Ϸ����
		gameFrame.setUndecorated(true);//������Ϸ�����ޱ߿�
		gameFrame.getGraphicsConfiguration().getDevice().setFullScreenWindow(gameFrame);//���ô���������Ļ
		System.out.println(gameFrame.getWidth());
		gameFrame.setVisible(true);// ���ô���Ϊ�ɼ�
		gameFrame.setTitle("�ɽ�������");// ���ñ���
	}
	
}

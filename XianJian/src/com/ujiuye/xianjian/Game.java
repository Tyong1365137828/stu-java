package com.ujiuye.xianjian;

public class Game {

	public static void main(String[] args) {
		XianJianFrame gameFrame = new XianJianFrame();// 在主函数中创建一个游戏界面
		gameFrame.setUndecorated(true);//设置游戏窗体无边框
		gameFrame.getGraphicsConfiguration().getDevice().setFullScreenWindow(gameFrame);//设置窗体铺满屏幕
		System.out.println(gameFrame.getWidth());
		gameFrame.setVisible(true);// 设置窗口为可见
		gameFrame.setTitle("仙剑奇侠传");// 设置标题
	}
	
}

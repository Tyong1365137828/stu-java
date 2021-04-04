package edu.hebeu.tang2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JieMianTest2 {

	public static void main(String[] args) {
		//new DeLongFrame();
		//JFrame f1=new JFrame();
         //f1.setVisible(true);
         //f1.setSize(width, height);
		//DeLongFrame d1=new DeLongFrame();
		//d1.setMYframe();
		//MyPanelframe f2=new MyPanelframe();
		new Mygridframe();
	}

}

class DeLongFrame extends JFrame{
	public DeLongFrame() {
		//自动布局管理(4种，3种)
		//采用的1、边界布局BorderLayout
		//(1)这是框架的基本布局（2）策略：把界面分成五块，五个区域：东西南北中
		//(3)结合panel嵌套布局，解决数量不足问题
		//（4）不让自动布局（大小、位置等不用管），用手工定制。都是通过方法解决。
		setSize(200, 200);
		setVisible(true);
		//setLayout(null);//取消布局，人工方式
		
		//2、流式布局 FlowLayout  策略：从左到右排列，排完一排，排第二排。。。。居中，左对齐，右对齐，间距可以调整
		JButton b1=new JButton("中间");		//生成对象
		b1.setBounds(100, 100, 200, 100);
		JButton b2=new JButton("北部1");
		JButton b3=new JButton("南部");		//生成对象
		JButton b4=new JButton("西部");
		JButton b5=new JButton("东部");
		JButton b6=new JButton("北部2");
		JLabel j1=new JLabel("aaaaaa");
		b1.setSize(50, 30);         		//设置一些参数
		b1.setBackground(Color.red);	
		add(b1);                    		 //放到框架容器中
		
		//add(BorderLayout.NORTH,b2);
		add(BorderLayout.SOUTH,b3);
		add(BorderLayout.WEST,b4);
		add(BorderLayout.EAST,b5);
		JPanel p1=new JPanel();//面板  白板   平板----中间件  三层（基本组件---面板---框架）
		p1.setLayout(new FlowLayout(FlowLayout.LEFT,30,60));
		add(BorderLayout.NORTH,p1);
		p1.add(b2);
		p1.add(b6);
	}
	void setMYframe(){
		setSize(200, 200);
		setVisible(true);
		
		JButton b1=new JButton("确定");
		JButton b2=new JButton("取消");
		b1.setSize(50, 30);
		add(b1);
		add(BorderLayout.NORTH,b2);
	}
}

class MyPanelframe extends JFrame{
	public MyPanelframe() {
		setSize(200,200);
		//setLayout(new FlowLayout(FlowLayout.LEFT,30,60));
		setLayout(new FlowLayout());

		JButton b1=new JButton("确定");
		JButton b2=new JButton("取消");
		add(b1);
		add(b2);
		setVisible(true);
	}
}

class Mygridframe extends JFrame{
	public Mygridframe() {
		setSize(200,200);
		Container a=getContentPane();
		//setResizable(false);
		setLayout(new GridLayout(3, 2));
		JButton b1=new JButton("确定");
		JButton b2=new JButton("取消");
		JButton b3=new JButton("重置");
		//JButton b4=new JButton("重置11");
		add(b1);
		add(b2);
		add(b3);
		//add(b4);
		setVisible(true);
	}
}
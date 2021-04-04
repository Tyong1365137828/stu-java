package edu.hebeu.entry;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StuMangerment implements ActionListener{
	JFrame stuFrame = new JFrame("学生界面");
	
	JButton checkcreditdButton , informationButton;
	
	JMenuBar jMenuBar;
	JMenu jMenu,couMenu;
	JMenuItem exitAccountJMenuItem,changeInfromationJMenuItem,changepasswordItem,addcouItem,deletecouItem;
	
	public StuMangerment() {
		
		checkcreditdButton = new JButton("查询学分");
		informationButton = new JButton("个人信息");
		
		jMenuBar = new JMenuBar();
		jMenu = new JMenu("我的");
		couMenu = new JMenu("课程管理");
		exitAccountJMenuItem = new JMenuItem("退出当前账号");
		changeInfromationJMenuItem = new JMenuItem("修改个人信息");
		changepasswordItem = new JMenuItem("修改个人密码");
		addcouItem = new JMenuItem("添加课程");
		deletecouItem = new JMenuItem("删除课程");
		
		stuFrame.setLayout(null);
		
		checkcreditdButton.setBounds(200, 230, 450, 400);
		informationButton.setBounds(850, 230, 450, 400);
		stuFrame.setJMenuBar(jMenuBar);
		jMenuBar.add(jMenu);
		jMenuBar.add(couMenu);
		jMenu.add(exitAccountJMenuItem);
		jMenu.add(changeInfromationJMenuItem);
		jMenu.add(changepasswordItem);
		couMenu.add(addcouItem);
		couMenu.add(deletecouItem);
		
		stuFrame.add(checkcreditdButton);
		stuFrame.add(informationButton);
		
		
		Toolkit toolkit =stuFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		System.out.println("widt="+width);
		System.out.println("height="+height);
		stuFrame.setSize(width, height);
		stuFrame.setVisible(true);
		
		checkcreditdButton.addActionListener(this);
		informationButton.addActionListener(this);
		exitAccountJMenuItem.addActionListener(this);
		changepasswordItem.addActionListener(this);
		changeInfromationJMenuItem.addActionListener(this);
		addcouItem.addActionListener(this);
		deletecouItem.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(checkcreditdButton)) {
			new StuCheckCredit();
		}
		if(e.getSource().equals(informationButton)) {
			new StuInformation();
		}
		if(e.getSource().equals(changepasswordItem)) {
			new StuChangePass();
		}
		if(e.getSource().equals(exitAccountJMenuItem)) {
			stuFrame.dispose();
			new Login();
		}
		if(e.getSource().equals(changeInfromationJMenuItem)) {
			new StuPerfect();
		}
		if(e.getSource().equals(addcouItem)) {
			new StuAddCou();
		}
		if(e.getSource().equals(deletecouItem)) {
			new StuDeleteCou();
		}
		
		
	}
	
}

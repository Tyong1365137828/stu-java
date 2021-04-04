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

public class AdministratorMangerment implements ActionListener{
	
	JFrame admFrame = new JFrame("管理员界面");
	
	JButton showButton ,delectButton , addButton;
	
	JMenuBar jMenuBar;
	JMenu jMenu,creditMenu;
	JMenuItem exitAccountJMenuItem,changepasswordItem,creditItem;
	
	public static void main(String[] args) {
		new AdministratorMangerment();
	}
	
	public AdministratorMangerment(){
		
		showButton = new JButton("显示学生");
		delectButton = new JButton("删除学生");
		addButton = new JButton("添加学生");
		
		jMenuBar = new JMenuBar();
		jMenu = new JMenu("我的");
		creditMenu = new JMenu("学分管理");
		exitAccountJMenuItem = new JMenuItem("退出当前账号");
		changepasswordItem = new JMenuItem("修改个人密码");
		creditItem = new JMenuItem("录入学分");
		
		
		admFrame.setLayout(null);//使用自定义布局
		
		showButton.setBounds(300, 30, 400, 300);
		delectButton.setBounds(900, 30, 400, 300);
		addButton.setBounds(600, 360, 400, 300);
		admFrame.setJMenuBar(jMenuBar);
		jMenuBar.add(jMenu);
		jMenuBar.add(creditMenu);
		jMenu.add(exitAccountJMenuItem);
		jMenu.add(changepasswordItem);
		creditMenu.add(creditItem);
		
		admFrame.add(showButton);
		admFrame.add(delectButton);
		admFrame.add(addButton);
		
		Toolkit toolkit =admFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		System.out.println("widt="+width);
		System.out.println("height="+height);
		admFrame.setSize(width, height);
		admFrame.setVisible(true);
		
		delectButton.addActionListener(this);
		showButton.addActionListener(this);
		addButton.addActionListener(this);
		exitAccountJMenuItem.addActionListener(this);
		changepasswordItem.addActionListener(this);
		creditItem.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(delectButton)) {
			new AdmDeleteStu();
		}
		
		if(e.getSource().equals(showButton)) {
			new AdmShowStu();
		}
		if(e.getSource().equals(addButton)) {
			new AdmAddStu();
		}

		if(e.getSource().equals(exitAccountJMenuItem)) {
			admFrame.dispose();
			new Login();
		}
		if(e.getSource().equals(changepasswordItem)) {
			new AdmChangePass();
		}
		if(e.getSource() == creditItem) {
			new AdmCreditForStu();
		}
		
	}
	
}

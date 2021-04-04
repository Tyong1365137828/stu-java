package edu.hebeu.entry;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.hebeu.jdbc.GetConn;

public class StudentMangement implements ActionListener{
	
	JFrame stuMangeFrame = new JFrame("学生窗口");
	
	JButton chekinforButton,alterButton,checkrewardButton,checkclassButton;
	
	JLabel helloLabel;
	
	JMenuBar jMenuBar;
	JMenu myJMenu,classJMenu;
	JMenuItem exitAccountJMenuItem,changepassItem,changeInfromationJMenuItem,deleteclassItem,addclassItem;
	
	JLabel l1= null;
	
//	@SuppressWarnings("deprecation")
	public StudentMangement() {
		
		chekinforButton = new JButton("个人信息查看");
		alterButton = new JButton("个人学分查询");
		checkrewardButton =new JButton("个人奖励查看");
		checkclassButton = new JButton("个人课程查看");
		
		helloLabel = new JLabel("");
		String name = name();
		helloLabel.setText(name+"同学，你好！！！");
		helloLabel.setForeground(Color.RED);
		
		jMenuBar = new JMenuBar();

		myJMenu = new JMenu("我的");
		exitAccountJMenuItem = new JMenuItem("退出当前账号");
		changeInfromationJMenuItem = new JMenuItem("修改个人信息");
		changepassItem = new JMenuItem("修改个人密码");
		
		classJMenu = new JMenu("课程管理");
		deleteclassItem = new JMenuItem("删除课程");
		addclassItem = new JMenuItem("添加课程");
		
		ImageIcon imageIcon = new ImageIcon("src/images/stu.jpg");
		l1 = new JLabel(imageIcon);
		stuMangeFrame.getLayeredPane().add(l1,new Integer(Integer.MIN_VALUE));
		l1.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());	
		
		Container cp = stuMangeFrame.getContentPane();
		cp.setLayout(null);
		
		stuMangeFrame.setLayout(null);
		
		chekinforButton.setBounds(400, 100, 300, 250);
		alterButton.setBounds(900, 100, 300, 250);
		checkrewardButton.setBounds(400, 400, 300, 250);
		checkclassButton.setBounds(900, 400, 300, 250);
		
		helloLabel.setBounds(280, 20, 300, 25);
		
		stuMangeFrame.setJMenuBar(jMenuBar);
		jMenuBar.add(myJMenu);
		myJMenu.add(exitAccountJMenuItem);
		myJMenu.add(changeInfromationJMenuItem);
		myJMenu.add(changepassItem);
		
		jMenuBar.add(classJMenu);
		classJMenu.add(deleteclassItem);
		classJMenu.add(addclassItem);

		cp.add(chekinforButton);
		cp.add(alterButton);
		cp.add(checkrewardButton);
		cp.add(checkclassButton);

		cp.add(helloLabel);
		
		((JPanel) cp).setOpaque(false);
		
		Toolkit toolkit = stuMangeFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;

		exitAccountJMenuItem.addActionListener(this);
		changeInfromationJMenuItem.addActionListener(this);
		changepassItem.addActionListener(this);
		deleteclassItem.addActionListener(this);
		addclassItem.addActionListener(this);
		chekinforButton.addActionListener(this);
		checkrewardButton.addActionListener(this);
		checkclassButton.addActionListener(this);
		alterButton.addActionListener(this);
		
		
		stuMangeFrame.setSize(width, height);
		stuMangeFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == changeInfromationJMenuItem) {
			new StuPerfect();
		}
		
		if(e.getSource() == exitAccountJMenuItem) {
			new Login();
			stuMangeFrame.dispose();
		}

		if(e.getSource() == chekinforButton) {
			new StudentInformationAll();
		}
		
		if(e.getSource() == checkclassButton) {
			new StuCheckCou();
		}
		
		if(e.getSource() == deleteclassItem) {
			new StuDeleteCou();
		}
		
		if(e.getSource() == changepassItem) {
			new StuChangePass();
		}
		
		if(e.getSource() == alterButton) {
			new StuCredit();
		}
		
		if(e.getSource() == addclassItem){
			new StuAddCou();
		}
		
		if(e.getSource() == checkrewardButton) {
			new StuCheckAward();
		}
	}
	
	String name() {
		String number = findAccountStudent();
		
		String name = "";
		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select stu_name from student where stu_number = '"+number+"'";
		
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				name = resultSet.getString("stu_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
		
	}
	
	String findAccountStudent() {

		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select * from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				account = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	public static void main(String[] args) {
		new StudentMangement();
	}
}

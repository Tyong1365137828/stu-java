package edu.hebeu.entry;

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

public class TeacherMangement implements ActionListener{
	
	JFrame teaFrame = new JFrame("教师窗口");
	
	JButton checkStuByCouButton,checkinforButton,checkawardButton;
	
	JMenuBar jMenuBar;
	JMenu myJMenu,classJMenu;
	JMenuItem exitItem,changepasswordItem,changeinformItem,addcreditItem,deleItem;
	
	JLabel l1= null;
	
//	@SuppressWarnings("deprecation")
	public TeacherMangement() {
		
		checkawardButton = new JButton("所获荣誉");
		checkinforButton = new JButton("个人信息");
		checkStuByCouButton = new JButton("我的学生");
		
		jMenuBar = new JMenuBar();
		
		myJMenu = new JMenu("我的");
		exitItem = new JMenuItem("退出账号");
		changeinformItem = new JMenuItem("修改信息");
		changepasswordItem = new JMenuItem("修改密码");
		
		classJMenu = new JMenu("代课");
		addcreditItem = new JMenuItem("录入学分");
		deleItem = new JMenuItem("删除学生");
		
		ImageIcon imageIcon = new ImageIcon("src/images/tea.jpg");
		l1 = new JLabel(imageIcon);
		teaFrame.getLayeredPane().add(l1,new Integer(Integer.MIN_VALUE));
		l1.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		
		Container cp = teaFrame.getContentPane();
		cp.setLayout(null);
		
		teaFrame.setJMenuBar(jMenuBar);
		
		jMenuBar.add(myJMenu);
		myJMenu.add(changeinformItem);
		myJMenu.add(changepasswordItem);
		myJMenu.add(exitItem);
		
		jMenuBar.add(classJMenu);
		classJMenu.add(addcreditItem);
		classJMenu.add(deleItem);
		
		cp.add(checkinforButton);
		cp.add(checkStuByCouButton);
		cp.add(checkawardButton);
		
		teaFrame.setLayout(null);
		
		((JPanel) cp).setOpaque(false);
		
		checkinforButton.setBounds(400,100,300,250);
		checkStuByCouButton.setBounds(900,100,300,250);
		checkawardButton.setBounds(650,400,300,250);
		
		Toolkit toolkit =teaFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		
		teaFrame.setSize(width, height);
		teaFrame.setVisible(true);
		
		changeinformItem.addActionListener(this);
		changepasswordItem.addActionListener(this);
		exitItem.addActionListener(this);
		addcreditItem.addActionListener(this);
		checkawardButton.addActionListener(this);
		checkinforButton.addActionListener(this);
		checkStuByCouButton.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new TeacherMangement();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == checkinforButton) {
			new TeaInformationAll();
		}
		if(e.getSource() == changeinformItem) {
			new TeaPerfect();
		}
		
		if(e.getSource() == changepasswordItem) {
			new TeaChangePass();
		}
		if(e.getSource() == exitItem) {
			teaFrame.dispose();
			new Login();
		}
		if(e.getSource() == addcreditItem) {
			new TeaAddCredit();
		}
		if(e.getSource() == checkawardButton) {
			new TeaCheckAward();
		}
		if(e.getSource()==checkStuByCouButton) {
			new TeaSelectStu();
		}
		
	}
	
	
	String Memory() {

		String accountField = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				accountField = resultSet.getString(1);// 将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountField;

	}
}

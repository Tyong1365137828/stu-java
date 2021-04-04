package edu.hebeu.entry;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AdministratorManagement implements ActionListener{
	
	JFrame AdminMangeframe = new JFrame("管理员窗口");
	
	JButton checkteabutton,checkstubutton,checkcoubutton;
	
	JMenuBar jMenuBar;//生成菜单框对象
	JMenu myJenu,teacherJMenu,studentjJMenu,couresJMenu,awardJMenu;
	JMenuItem exitJMenuItem,changepassItem,
			addstuItem,deletestuItem,alterStuItem,addteaItem,alterTeaItem,deleteteaItem,
			addcouItem,deletecouItem,stuawardItem,teaawardItem;
	
	JLabel l1 = null;
	
//	@SuppressWarnings("deprecation")
	public AdministratorManagement() {
		Toolkit toolkit = AdminMangeframe.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		System.out.println("你的电脑width"+width+"，你的电脑height"+height);
		
		jMenuBar = new JMenuBar();
		myJenu = new JMenu("我的");
		changepassItem = new JMenuItem("修改密码");
		exitJMenuItem = new JMenuItem("退出");
		
		studentjJMenu = new JMenu("学生管理");
		addstuItem = new JMenuItem("添加学生");
		alterStuItem = new JMenuItem("修改学生信息");
		deletestuItem = new JMenuItem("删除学生");
		
		teacherJMenu = new JMenu("教师管理");
		addteaItem = new JMenuItem("添加教师");
		alterTeaItem = new JMenuItem("修改教师信息");
		deleteteaItem = new JMenuItem("删除教师");
		
		couresJMenu = new JMenu("课程管理");
		addcouItem = new JMenuItem("教师任课");
		deletecouItem = new JMenuItem("删除任课");
		
		awardJMenu = new JMenu("奖励管理");
		stuawardItem = new JMenuItem("学生奖励");
		teaawardItem = new JMenuItem("教师奖励");
		
		checkcoubutton = new JButton("课程查看");
		checkstubutton = new JButton("学生查看");
		checkteabutton = new JButton("教师查看");
		
		ImageIcon imageIcon = new ImageIcon("src/images/admin.jpg");
		l1 = new JLabel(imageIcon);
		AdminMangeframe.getLayeredPane().add(l1,new Integer(Integer.MIN_VALUE));
		l1.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		
		Container cp = AdminMangeframe.getContentPane();
		cp.setLayout(null);
		
		AdminMangeframe.setLayout(null);//使用自定义布局
		
		checkcoubutton.setBounds(400, 100, 300, 250);
		checkstubutton.setBounds(900, 100, 300, 250);
		checkteabutton.setBounds(650, 400, 300, 250);
		
		cp.add(checkcoubutton);
		cp.add(checkstubutton);
		cp.add(checkteabutton);
		
		AdminMangeframe.setJMenuBar(jMenuBar);
		
		((JPanel) cp).setOpaque(false);
		
		//我的菜单
		jMenuBar.add(myJenu);
		
		myJenu.add(changepassItem);
		myJenu.add(exitJMenuItem);
		
		//学生管理菜单
		jMenuBar.add(studentjJMenu);
		
		studentjJMenu.add(addstuItem);
		studentjJMenu.add(alterStuItem);
		studentjJMenu.add(deletestuItem);
		
		//教师管理菜单
		jMenuBar.add(teacherJMenu);
		
		teacherJMenu.add(addteaItem);
		teacherJMenu.add(alterTeaItem);
		teacherJMenu.add(deleteteaItem);
		
		//课程管理
		jMenuBar.add(couresJMenu);
		
		couresJMenu.add(addcouItem);
		couresJMenu.add(deletecouItem);
		
		//奖励管理
		jMenuBar.add(awardJMenu);
		
		awardJMenu.add(stuawardItem);
		awardJMenu.add(teaawardItem);
		
		AdminMangeframe.setSize(width, height);
		
		checkteabutton.addActionListener(this);
		checkstubutton.addActionListener(this);
		checkcoubutton.addActionListener(this);
		
		exitJMenuItem.addActionListener(this);
		changepassItem.addActionListener(this);
		addstuItem.addActionListener(this);
		addteaItem.addActionListener(this);
		deletestuItem.addActionListener(this);
		deleteteaItem.addActionListener(this);
		stuawardItem.addActionListener(this);
		teaawardItem.addActionListener(this);
		alterStuItem.addActionListener(this);
		alterTeaItem.addActionListener(this);
		addcouItem.addActionListener(this);
		deletecouItem.addActionListener(this);
		
		AdminMangeframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AdministratorManagement();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//如果选中课程查看按钮
		if(e.getSource() == checkcoubutton) {
			new AdminSelectCou();
		}
		
		//如果选中学生查看按钮
		if(e.getSource() == checkstubutton) {
			new AdminSelectStu();
		}
		
		//如果选中教师查看按钮
		if(e.getSource() == checkteabutton) {
			new AdminSelectTea();
		}
		
		//如果选中退出
		if(e.getSource() == exitJMenuItem) {
			new Login();
			AdminMangeframe.dispose();
		}
		
		if(e.getSource() == changepassItem) {
			new AdminChangePass();
		}
		
		if(e.getSource() == addstuItem) {
			new AdminAddStu();
		}
		if(e.getSource() == deletestuItem) {
			new AdminDeleteStu();
		}
		if(e.getSource() == addteaItem) {
			new AdminAddTea();
		}
		if(e.getSource() == deleteteaItem) {
			new AdminDeleteTea();
		}
		if(e.getSource() == stuawardItem) {
			new AdminAddStuAward();
		}
		if(e.getSource() == teaawardItem) {
			new AdminAddTeaAward();
		}
		if(e.getSource() == addcouItem) {
			new AdminAddCou();
		}
		if(e.getSource() == deletecouItem) {
			new AdminDeleteCou();
		}
		if(e.getSource()==alterStuItem) {
			new AdminChangeStu();
		}
		if(e.getSource() == alterTeaItem) {
			new AdminChangeTea();
		}
	}
}

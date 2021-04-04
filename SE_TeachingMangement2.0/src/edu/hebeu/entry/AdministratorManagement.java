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
	
	JFrame AdminMangeframe = new JFrame("����Ա����");
	
	JButton checkteabutton,checkstubutton,checkcoubutton;
	
	JMenuBar jMenuBar;//���ɲ˵������
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
		System.out.println("��ĵ���width"+width+"����ĵ���height"+height);
		
		jMenuBar = new JMenuBar();
		myJenu = new JMenu("�ҵ�");
		changepassItem = new JMenuItem("�޸�����");
		exitJMenuItem = new JMenuItem("�˳�");
		
		studentjJMenu = new JMenu("ѧ������");
		addstuItem = new JMenuItem("���ѧ��");
		alterStuItem = new JMenuItem("�޸�ѧ����Ϣ");
		deletestuItem = new JMenuItem("ɾ��ѧ��");
		
		teacherJMenu = new JMenu("��ʦ����");
		addteaItem = new JMenuItem("��ӽ�ʦ");
		alterTeaItem = new JMenuItem("�޸Ľ�ʦ��Ϣ");
		deleteteaItem = new JMenuItem("ɾ����ʦ");
		
		couresJMenu = new JMenu("�γ̹���");
		addcouItem = new JMenuItem("��ʦ�ο�");
		deletecouItem = new JMenuItem("ɾ���ο�");
		
		awardJMenu = new JMenu("��������");
		stuawardItem = new JMenuItem("ѧ������");
		teaawardItem = new JMenuItem("��ʦ����");
		
		checkcoubutton = new JButton("�γ̲鿴");
		checkstubutton = new JButton("ѧ���鿴");
		checkteabutton = new JButton("��ʦ�鿴");
		
		ImageIcon imageIcon = new ImageIcon("src/images/admin.jpg");
		l1 = new JLabel(imageIcon);
		AdminMangeframe.getLayeredPane().add(l1,new Integer(Integer.MIN_VALUE));
		l1.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		
		Container cp = AdminMangeframe.getContentPane();
		cp.setLayout(null);
		
		AdminMangeframe.setLayout(null);//ʹ���Զ��岼��
		
		checkcoubutton.setBounds(400, 100, 300, 250);
		checkstubutton.setBounds(900, 100, 300, 250);
		checkteabutton.setBounds(650, 400, 300, 250);
		
		cp.add(checkcoubutton);
		cp.add(checkstubutton);
		cp.add(checkteabutton);
		
		AdminMangeframe.setJMenuBar(jMenuBar);
		
		((JPanel) cp).setOpaque(false);
		
		//�ҵĲ˵�
		jMenuBar.add(myJenu);
		
		myJenu.add(changepassItem);
		myJenu.add(exitJMenuItem);
		
		//ѧ������˵�
		jMenuBar.add(studentjJMenu);
		
		studentjJMenu.add(addstuItem);
		studentjJMenu.add(alterStuItem);
		studentjJMenu.add(deletestuItem);
		
		//��ʦ����˵�
		jMenuBar.add(teacherJMenu);
		
		teacherJMenu.add(addteaItem);
		teacherJMenu.add(alterTeaItem);
		teacherJMenu.add(deleteteaItem);
		
		//�γ̹���
		jMenuBar.add(couresJMenu);
		
		couresJMenu.add(addcouItem);
		couresJMenu.add(deletecouItem);
		
		//��������
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
		
		//���ѡ�пγ̲鿴��ť
		if(e.getSource() == checkcoubutton) {
			new AdminSelectCou();
		}
		
		//���ѡ��ѧ���鿴��ť
		if(e.getSource() == checkstubutton) {
			new AdminSelectStu();
		}
		
		//���ѡ�н�ʦ�鿴��ť
		if(e.getSource() == checkteabutton) {
			new AdminSelectTea();
		}
		
		//���ѡ���˳�
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

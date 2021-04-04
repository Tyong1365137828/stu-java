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
	JFrame stuFrame = new JFrame("ѧ������");
	
	JButton checkcreditdButton , informationButton;
	
	JMenuBar jMenuBar;
	JMenu jMenu,couMenu;
	JMenuItem exitAccountJMenuItem,changeInfromationJMenuItem,changepasswordItem,addcouItem,deletecouItem;
	
	public StuMangerment() {
		
		checkcreditdButton = new JButton("��ѯѧ��");
		informationButton = new JButton("������Ϣ");
		
		jMenuBar = new JMenuBar();
		jMenu = new JMenu("�ҵ�");
		couMenu = new JMenu("�γ̹���");
		exitAccountJMenuItem = new JMenuItem("�˳���ǰ�˺�");
		changeInfromationJMenuItem = new JMenuItem("�޸ĸ�����Ϣ");
		changepasswordItem = new JMenuItem("�޸ĸ�������");
		addcouItem = new JMenuItem("��ӿγ�");
		deletecouItem = new JMenuItem("ɾ���γ�");
		
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

package edu.hebeu.tang1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class JieMianTest {

	public static void main(String[] args) {
		new JieMian();
	}

}


class JieMian extends JFrame{	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	
	JPasswordField pa1;
	JButton b1,b2;
	
	public JieMian() {
		setSize(500, 600);
		setTitle("µÇÂ½´°¿Ú");
		setLayout(new GridLayout(4,3));
		
		Toolkit tk=getToolkit();
		Dimension d=tk.getScreenSize();
		
		int pingkuan=d.width;
		int pinggao=d.height;
		
		setLocation((pingkuan-500)/2, (pinggao-600)/2);
		
		b1=new JButton("µÇÂ¼");
		b2=new JButton("È¡Ïû");
		JLabel l1=new JLabel("ÕËºÅ");
		JLabel l2=new JLabel("ÃÜÂë");
		JTextField t1=new JTextField(18);
		JPasswordField pa1=new JPasswordField(18);
		
		p2.add(l1);
		p2.add(t1);
		p3.add(l2);
		p3.add(pa1);
		p4.add(b2);
		p4.add(b1);
		
		MyAct m1=new MyAct();
		b1.addActionListener(m1);
		b2.addActionListener(m1);
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		
		setVisible(true);
	}
	
	class MyAct implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			b1.setBackground(new Color(200, 10, 20));
			b2.setBackground(new Color(200, 10, 20));
		}
	}
	
}
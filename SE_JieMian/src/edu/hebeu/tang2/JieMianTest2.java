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
		//�Զ����ֹ���(4�֣�3��)
		//���õ�1���߽粼��BorderLayout
		//(1)���ǿ�ܵĻ������֣�2�����ԣ��ѽ���ֳ���飬������򣺶����ϱ���
		//(3)���panelǶ�ײ��֣����������������
		//��4�������Զ����֣���С��λ�õȲ��ùܣ������ֹ����ơ�����ͨ�����������
		setSize(200, 200);
		setVisible(true);
		//setLayout(null);//ȡ�����֣��˹���ʽ
		
		//2����ʽ���� FlowLayout  ���ԣ����������У�����һ�ţ��ŵڶ��š����������У�����룬�Ҷ��룬�����Ե���
		JButton b1=new JButton("�м�");		//���ɶ���
		b1.setBounds(100, 100, 200, 100);
		JButton b2=new JButton("����1");
		JButton b3=new JButton("�ϲ�");		//���ɶ���
		JButton b4=new JButton("����");
		JButton b5=new JButton("����");
		JButton b6=new JButton("����2");
		JLabel j1=new JLabel("aaaaaa");
		b1.setSize(50, 30);         		//����һЩ����
		b1.setBackground(Color.red);	
		add(b1);                    		 //�ŵ����������
		
		//add(BorderLayout.NORTH,b2);
		add(BorderLayout.SOUTH,b3);
		add(BorderLayout.WEST,b4);
		add(BorderLayout.EAST,b5);
		JPanel p1=new JPanel();//���  �װ�   ƽ��----�м��  ���㣨�������---���---��ܣ�
		p1.setLayout(new FlowLayout(FlowLayout.LEFT,30,60));
		add(BorderLayout.NORTH,p1);
		p1.add(b2);
		p1.add(b6);
	}
	void setMYframe(){
		setSize(200, 200);
		setVisible(true);
		
		JButton b1=new JButton("ȷ��");
		JButton b2=new JButton("ȡ��");
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

		JButton b1=new JButton("ȷ��");
		JButton b2=new JButton("ȡ��");
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
		JButton b1=new JButton("ȷ��");
		JButton b2=new JButton("ȡ��");
		JButton b3=new JButton("����");
		//JButton b4=new JButton("����11");
		add(b1);
		add(b2);
		add(b3);
		//add(b4);
		setVisible(true);
	}
}
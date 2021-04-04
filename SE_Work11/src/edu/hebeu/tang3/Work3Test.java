package edu.hebeu.tang3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Work3Test {

	public static void main(String[] args) {
		new Work3();
	}

}

class Work3 extends JFrame {

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	JLabel l1;
	JLabel l2;
	JLabel l3;

	JTextField f1;
	JTextField f2;
	JTextField f3;

	JButton b1;

	public Work3() {

		setSize(600, 600);
		l1 = new JLabel("��һ������");
		l2 = new JLabel("�ڶ�������");
		l3 = new JLabel("����ƽ����");

		setLayout(new GridLayout(4, 1));
//		setLayout(null);	������״��ʽΪ�Զ���
		
		f1 = new JTextField(10);
		f2 = new JTextField(10);
		f3 = new JTextField(10);

		b1 = new JButton("����");
		b1.setPreferredSize(new Dimension(600,150)); //��Ϊ��״���ֲ���ʹ��һ�㷽�����������С��������״�����ô�С��Ȼ���������Զ�������ѡ��Ӧ
		
		p1.add(l1);
		p1.add(f1);
		p2.add(l2);
		p2.add(f2);
		p3.add(l3);
		p3.add(f3);
		p4.add(b1);

		add(p1);
		add(p2);
		add(p3);
		add(p4);

		setVisible(true);
		
		MyMouse m1=new MyMouse();		//ע�������
		b1.addMouseListener(m1);		//��ťb1���ô˼�����
		
	}

	class MyMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {		//����������ʱ�ļ�����

			int a = Integer.parseInt(f1.getText());		//���ı����л�ȡ����
			int b = Integer.parseInt(f2.getText());		//���ı����л�ȡ����
			double c = (a + b) / 2;

			f3.setText(String.valueOf(c));	//Ϊ�ı����ȡ������

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}

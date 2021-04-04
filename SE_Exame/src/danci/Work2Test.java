package danci;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Work2Test {

	public static void main(String[] args) {
		new Work2();
	}

}


class Work2 extends JFrame{

	String [] danci=new String[] {"Hello","Good","What","How","Why"};

	JLabel l1=new JLabel("Hello");
	JLabel l2=new JLabel("Good");
	JLabel l3=new JLabel("What");
	JLabel l4=new JLabel("How");
	JLabel l5=new JLabel("Why");
	
	Font f=new Font(null, Font.BOLD, 100);		//�½������С��ǩ�Ķ���
	
	JButton b1;
	JButton b2;
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	CardLayout c=new CardLayout();		//Ϊ��Ƭ����CardLayout����һ��������ʹ����p1������
	
	public Work2() {
		
		setTitle("�������");
		setSize(600, 600);
		
		b1=new JButton("��һ��");
		b2=new JButton("��һ��");
		
		l1.setFont(f);		//l1,2,3,4,5��������Ĵ�С
		l2.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		
		l1.setForeground(Color.BLACK);		//�����lable����������ɫ
		l2.setForeground(Color.RED);
		l3.setForeground(Color.YELLOW);
		l4.setForeground(Color.BLUE);
		l5.setForeground(Color.GREEN);
		
		l1.setHorizontalAlignment(0);		//��l1��2��3��4��5���ı�����
		l2.setHorizontalAlignment(0);
		l3.setHorizontalAlignment(0);
		l4.setHorizontalAlignment(0);
		l5.setHorizontalAlignment(0);
		
		p1.setLayout(c);			//����p1ͨ������c��������뿨Ƭ����
//		p1.setLayout(new CardLayout());
		
		p1.add(l1);					//l1��2��3��4��5����p1
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);					//��Ϊp1�ڿ�Ƭ�����У���l1��2��3��4��5��������˳��ģ�ֻ�����Ƿִ���ʾ
		p2.add(b1);
		p2.add(b2);
			
		add(BorderLayout.CENTER,p1);
		add(BorderLayout.SOUTH,p2);
		
		MyAction m=new MyAction();		//ע�������
		b1.addActionListener(m);		//b1���ü�����
		b2.addActionListener(m);		//b2���ü�����
		
		setVisible(true);
		
	}
	
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {			//�����b1������
				c.previous(p1);				//��ʾ��һ��
			}
			if(e.getSource()==b2) {			//�����b2������
				c.next(p1);					//��ʾ��һ��
			}			
		}
	}
}
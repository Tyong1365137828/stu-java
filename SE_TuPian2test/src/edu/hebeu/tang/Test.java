package edu.hebeu.tang;

import java.awt.Graphics;
import java.awt.Image;
/*�б���ͼ��ͼ�������*/
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Test extends JFrame {

	ImageIcon img = new ImageIcon("src/images/1.jpg"); // ���ͼƬ
	Image image = img.getImage();

	JButton button1 = new JButton("��¼");
	JButton button2 = new JButton("ȡ��");
	
	JTextField field1=new JTextField(20);
	JTextField field2=new JTextField(20);
	
	JLabel jLabel1=new JLabel("�˺�");
	JLabel jLabel2=new JLabel("����");

	JPanel jp1 = new JPanel(); // ������JPanel
	JPanel jp2 = new JPanel(); // ������JPanel
	JPanel jp3 = new JPanel(); // ������JPanel
	JPanel jp4 = new JPanel(); // ������JPanel
	JPanel jp5 = new JPanel(); // ������JPanel
	
	@SuppressWarnings("deprecation")
	public void setBak() {//����

		((JPanel) this.getContentPane()).setOpaque(false);
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		background.setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	
	@SuppressWarnings("deprecation")
	public Test() {
		
//		Container c = getContentPane(); // ��ȡJFrame���    container��һ��������������Jpanel
		
		JLabel background=new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(800, 400);
		
//		setLayout(new GridLayout(5,1));//�ֲ���������ʹ�����񲼾�

//		c.add(jp1);//��������add
//		c.add(jp2);//��������add
//		c.add(jp3);//��������add
//		c.add(jp4);//��������add
//		c.add(jp5);//��������add

		
		JLayeredPane jLayeredPane=new JLayeredPane();//ʹ�÷ֲ���������������ʾ���
		add(jLayeredPane);//ʹ��jLayeredPane����ֲ�
		
		jLayeredPane.add(jp1, new Integer(200));
		jLayeredPane.add(jp2, new Integer(200));
		jLayeredPane.add(jp3, new Integer(200));
		jLayeredPane.add(jp4, new Integer(200));
		jLayeredPane.add(jp5, new Integer(200));
		
		jp1.setBounds(0, 0, 800, 80);
		jp2.setBounds(0, 80, 800, 80);
		jp3.setBounds(0, 160, 800, 80);
		jp4.setBounds(0, 240, 800, 80);
		jp5.setBounds(0, 320, 800, 80);
		
		jp2.add(jLabel1);
		jp2.add(field1);
		jp3.add(jLabel2);
		jp3.add(field2);
		jp4.add(button1);
		jp4.add(button2);
		
//		jLayeredPane.setOpaque(false);
		jp1.setOpaque(false); // ��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		jp2.setOpaque(false); // ��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		jp3.setOpaque(false); // ��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		jp4.setOpaque(false); // ��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		jp5.setOpaque(false); // ��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		
		
		setVisible(true);
		setBak(); // ���ñ�������
	}

	public static void main(String[] args) {
//		Test s = new Test();
//		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Test();
	}
}

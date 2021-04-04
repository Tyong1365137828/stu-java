package edu.hebeu.tang;

import java.awt.Graphics;
import java.awt.Image;
/*有背景图，图上有组件*/
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Test extends JFrame {

	ImageIcon img = new ImageIcon("src/images/1.jpg"); // 添加图片
	Image image = img.getImage();

	JButton button1 = new JButton("登录");
	JButton button2 = new JButton("取消");
	
	JTextField field1=new JTextField(20);
	JTextField field2=new JTextField(20);
	
	JLabel jLabel1=new JLabel("账号");
	JLabel jLabel2=new JLabel("密码");

	JPanel jp1 = new JPanel(); // 创建个JPanel
	JPanel jp2 = new JPanel(); // 创建个JPanel
	JPanel jp3 = new JPanel(); // 创建个JPanel
	JPanel jp4 = new JPanel(); // 创建个JPanel
	JPanel jp5 = new JPanel(); // 创建个JPanel
	
	@SuppressWarnings("deprecation")
	public void setBak() {//背景

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
		
//		Container c = getContentPane(); // 获取JFrame面板    container是一个容器，用来放Jpanel
		
		JLabel background=new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(800, 400);
		
//		setLayout(new GridLayout(5,1));//分层容器不能使用网格布局

//		c.add(jp1);//容器不可add
//		c.add(jp2);//容器不可add
//		c.add(jp3);//容器不可add
//		c.add(jp4);//容器不可add
//		c.add(jp5);//容器不可add

		
		JLayeredPane jLayeredPane=new JLayeredPane();//使用分层容器，以正常显示组件
		add(jLayeredPane);//使用jLayeredPane对象分层
		
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
		jp1.setOpaque(false); // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		jp2.setOpaque(false); // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		jp3.setOpaque(false); // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		jp4.setOpaque(false); // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		jp5.setOpaque(false); // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		
		
		setVisible(true);
		setBak(); // 调用背景方法
	}

	public static void main(String[] args) {
//		Test s = new Test();
//		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Test();
	}
}

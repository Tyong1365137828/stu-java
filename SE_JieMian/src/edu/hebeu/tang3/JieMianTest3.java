package edu.hebeu.tang3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JieMianTest3 {

	public static void main(String[] args) {
		Login lo = new Login();
		lo.LaunchFrame();
		lo.setVisible(true);

	}

}

@SuppressWarnings("serial")
class Login extends JFrame {
	JButton b1 = new JButton("登录");
	JButton b2 = new JButton("取消");

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
//	JPanel p6 = new JPanel();

	JLabel l1 = new JLabel("帐号");
	JLabel l2 = new JLabel("密码");

	JTextField t1 = new JTextField(15);
	JTextField t2 = new JTextField(15);

	public Login() {

	}

	public void LaunchFrame() {
		setTitle("登陆界面");
		setSize(500, 600);

		Toolkit tk = getToolkit();				//使用工具对象获取此电脑的大小尺寸
		Dimension d = tk.getScreenSize();		//使用工具对象获取此电脑的大小尺寸
		int screen_width = d.width;				//将上述对象的宽由对象d的weight赋给screen_width
		int screen_height = d.height;			//将上述对象的高由对象d的height赋给screen_height
		setLocation((screen_width - 500) / 2, (screen_height - 600) / 2);		//将此frame界面显示在屏幕中间

		Image img = tk.getImage("Imangs/336.png");
		setIconImage(img);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

//		p1.setBackground(Color.gray);
//		p2.setBackground(Color.blue);
//		p3.setBackground(Color.CYAN);
//		p4.setBackground(Color.green);
//		p5.setBackground(Color.lightGray);

		p2.add(l1);
		p2.add(t1);
		p3.add(l2);
		p3.add(t2);
		p4.add(b1);
		p4.add(b2);

		add(p1);
		add(p2);
		add(p3);
		add(p4);
//		add(p5);
//		add(p6);
		setLayout(new GridLayout(5, 1));

		ButtonActionEvent a1 = new ButtonActionEvent();
		b1.addActionListener(a1);
		b2.addActionListener(a1);

	}

	class ButtonActionEvent implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				b1.setBackground(Color.red);
				if ((t1.getText().equals("1365137828")) && (t2.getText().equals("0727316052"))) {
					JOptionPane.showMessageDialog(getContentPane(), "你已经通过验证！");
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "请重新输入你的用户名或密码！");
				}
			}
			if (e.getSource() == b2) {
				b2.setBackground(Color.green);
				t1.setText("uy");
				t2.setText("pl");
			}
		}

	}
}
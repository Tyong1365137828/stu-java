package edu.hebeu.entry;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.hebeu.dao.UserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.User;

public class System_Login {

	public static void main(String[] args) {
		Login lo = new Login();
	}

}

class Login extends JFrame {
	JButton b1 = new JButton("登录");
	JButton b2 = new JButton("重置");
	JButton b3 = new JButton("注册");
			
	JLabel l1 = new JLabel("帐号:");
	JLabel l2 = new JLabel("密码:");
	JLabel l3 =null;
	
	JTextField t1 = new JTextField(15);
	JTextField t2 = new JTextField(15);
	
	JFrame frame = new JFrame("登录界面");
	
	public Login() {
		if(t1.getText().equals("")){
		t1.setText(userMemory_xianshi());//在用户名框中显示最后一次和注册的用户名
		}
		
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize();
		int screen_width = d.width;
		int screen_height = d.height;
		
		frame.setLocation((screen_width-Constant.Frame_width)/2, (screen_height-Constant.Frame_height)/2);
		frame.setSize(Constant.Frame_width, Constant.Frame_height);
		
		Image img = tk.getImage("Imangs/336.png");
		setIconImage(img);
		
		
		ImageIcon img1 = new ImageIcon("Imangs/bjtp.jpg");// 这是背景图片
		l3 = new JLabel(img1);
		frame.getLayeredPane().add(l3, new Integer(Integer.MIN_VALUE));
		l3.setSize(img1.getIconWidth(), img1.getIconHeight());
			
		Container cp = frame.getContentPane();
		
		cp.setLayout(null);
		
		l1.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 25));
		l1.setBounds(150, 100, 1000, 50);
		l2.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 25));
		l2.setBounds(150, 200, 1000, 50);
		t1.setBounds(270, 100, 300, 50);
		t2.setBounds(270, 200, 300, 50);
		b1.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 25));
		b1.setBounds(160, 380, 100, 50);
		b2.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 25));
		b2.setBounds(300, 380, 100, 50);
		b3.setFont(new Font("楷体", Font.PLAIN + Font.BOLD, 25));
		b3.setBounds(440, 380, 100, 50);
		
		cp.add(l1);
		cp.add(l2);
		cp.add(t1);
		cp.add(t2);
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		
		((JPanel) cp).setOpaque(false);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enterjButtonActionPerformed(e);
				userMemory_Login_ok(t1.getText());
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetjButtonActionPerformed(e);
				
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserGegister();
			}
		});
		/*
		t1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				t1.setText(User_Memory.userName);
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
							
				//t1.setText(User_Memory.userName);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				t1.setText(User_Memory.userName);
			}
		});
		frame.setVisible(true);
	}
	
	private void enterjButtonActionPerformed(java.awt.event.ActionEvent evt) {
			//FindUsers findUsers = new FindUsers(); // 创建包含有按用户名与密码检索用户类对象
			// 如果用户是否输入"用户名"与"密码"
			if (t1.getText().equals("") || (String.valueOf(t2.getText()).equals(""))) {
				JOptionPane.showMessageDialog(this, "请输入正确的用户名和密码", "警告提示框",
						JOptionPane.WARNING_MESSAGE); // 给出提示信息
				return; // 退出程序
			} else {
				User user1 = new User(); // 创建与数据表对应的Java Bean类User对象
				user1.setUsename(String.valueOf(t1.getText())); // 设置该对象的用户名属性
				user1.setPassword(String.valueOf(t2.getText())); // 创建该对象的密码属性
				//User users = findUsers.finUsers(user); // 调用检索用户方法
				UserDaoImpl userdaoimpl=new UserDaoImpl();// 创建包含有按用户名与密码检索用户类对象
				User user2 =userdaoimpl.findUserByNameAndPassword(user1);
				if ((user2 != null)) { // 如果检索出的用户不为null并且编号不为0
					JOptionPane.showMessageDialog(this, "系统登录成功", "信息提示框",
							JOptionPane.WARNING_MESSAGE); // 给出提示信息
					new System_MainFrame();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "用户名或密码错误", "警告提示框",
							JOptionPane.WARNING_MESSAGE); // 给出提示信息
				}
			}

		}

	private void resetjButtonActionPerformed(java.awt.event.ActionEvent evt) {
		t1.setText("");	// 将用户文本框清空
		t2.setText(""); // 将密码文本框清空
	}
	
	//记录登录名的方法
	void userMemory_Login_ok(String userName){
		try {
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();
		Statement stmt = conn.createStatement();
		Date date=new Date();
		//String sql2="insert into user_memory value('"+userName+"')";
		String sql2="insert into user_memory value('"+userName+"','"+date.toString()+"')";
		stmt.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//显示用户名的方法
	String userMemory_xianshi(){
		String t1_text="";
		try {
			GetConn getConn=new GetConn();
			Connection conn=getConn.getConnection();
			String sql1="select * from user_memory";
			Statement stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next()){
				t1_text=rs.getString(1);//将是数据库表中的最后一条记录
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return t1_text;
	}
}
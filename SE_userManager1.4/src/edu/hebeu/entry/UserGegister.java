package edu.hebeu.entry;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.User;
/**
 * 用户注册
 * @author gong
 *
 */
public class UserGegister extends JFrame implements ActionListener {
	// 注册界面
	JLabel l1, l2, l3, l4;
	JButton an1, an2;
	JTextField tf;
	JPasswordField pf1, pf2;
	JFrame frame = new JFrame("注册界面");
	UserGegister() {
		l1 = new JLabel("用户账号：");
		l1.setFont(new Font("楷体", Font.PLAIN+Font.BOLD, 25));
		l1.setBounds(200, 100, 1000, 50);
		l2 = new JLabel("用户密码：");
		l2.setFont(new Font("楷体", Font.PLAIN+Font.BOLD, 25));
		l2.setBounds(200, 200, 1000, 50);
		l3 = new JLabel("确认密码：");
		l3.setFont(new Font("楷体", Font.PLAIN+Font.BOLD, 25));
		l3.setBounds(200, 300, 1000, 50);
		l4 = new JLabel();
		an1 = new JButton("确认");
		an1.setFont(new Font("楷体", Font.PLAIN+Font.BOLD, 25));
		an1.setBounds(200, 500, 100, 50);
		an1.addActionListener(this);
		an2 = new JButton("取消");
		an2.setFont(new Font("楷体", Font.PLAIN+Font.BOLD, 25));
		an2.setBounds(400, 500, 100, 50);
		an2.addActionListener(this);
		tf = new JTextField(100);
		tf.setBounds(500, 100, 300, 50);
		pf1 = new JPasswordField();
		pf1.setBounds(500, 200, 300, 50);
		pf2 = new JPasswordField();
		pf2.setBounds(500, 300, 300, 50);
		
		ImageIcon img = new ImageIcon("image/bjtp.jpg");// 这是背景图片
		l4 = new JLabel(img);
		frame.getLayeredPane().add(l4, new Integer(Integer.MIN_VALUE));
		l4.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		Container cp = frame.getContentPane();
		cp.setLayout(null);
		cp.add(l1);
		cp.add(l2);
		cp.add(l3);
		cp.add(an1);
		cp.add(an2);
		cp.add(pf1);
		cp.add(pf2);
		cp.add(tf);
		((JPanel) cp).setOpaque(false);
		frame.setBounds(20, 10, 1024, 683);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.an1)) {
			String s_tf=tf.getText();
			String s_pf1=String.valueOf((pf1.getPassword()));
			String s_pf2=String.valueOf((pf2.getPassword()));
			
			if( s_pf1.equals(s_pf2)){
				try{
					User user=new User(s_tf,s_pf1);
					UserDaoImpl userDao=new UserDaoImpl();
					userDao.insertUser(user);
				}catch(Exception s){}
			JOptionPane.showMessageDialog(this, "注册成功！", "",JOptionPane.ERROR_MESSAGE );
				
			User_Memory.userName=s_tf;
		    frame.dispose();
		    
			}else JOptionPane.showMessageDialog(this, "两次密码不一样！", "",JOptionPane.ERROR_MESSAGE );	
		}
		if(e.getSource().equals(an2)){
			frame.dispose();
		}

	}
	
	void userMemory(String userName){
		try {
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();
		String sql1="delete from user_memory";
		Statement stmt = conn.createStatement();
		stmt.execute(sql1);
		String sql2="insert into user_memory value('"+userName+"')";
		stmt.execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

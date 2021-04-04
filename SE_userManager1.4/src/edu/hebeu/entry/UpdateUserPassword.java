package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class UpdateUserPassword {
	JFrame frame=new JFrame("更改用户密码");
	TextField userNameField =new TextField(15);
	TextField userPasswordField =new TextField(15);
	JLabel userNameLable=new JLabel("用户名：");
	JLabel userPasswordLable=new JLabel("密  码：");
	JButton okButton=new JButton("确定");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();	
	String userName,passWord;
	UserDaoImpl userDaoImpl;
	
	public static void main(String[] args) {
		new UpdateUserPassword();
	}
	
	public UpdateUserPassword() {
		frame.setLayout(new GridLayout(3, 1));
		frame.setBounds(500, 300, 350, 200);
		frame.setResizable(false);
		userNameField.setEnabled(false);
		userName=getUserName();
		
		userNameField.setText(getUserName());
		p1.add(userNameLable);
		p1.add(userNameField);
		p2.add(userPasswordLable);
		p2.add(userPasswordField);
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				passWord=userPasswordField.getText();
				//System.out.println(passWord);
				userDaoImpl=new UserDaoImpl();
				userDaoImpl.updateUser(userName,passWord);
				userDaoImpl.close();
				JOptionPane.showMessageDialog(frame, "密码修改成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
				frame.dispose();
			}
		});
		p3.add(okButton);
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.setVisible(true);
	}
	
	/*public static void main(String[] args) {
		new UpdateUserPassword();
	}
	*/
	
	private String getUserName(){
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

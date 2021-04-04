package edu.hebeu.entry;

import java.awt.GridLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class AdmChangePass implements ActionListener{

	JFrame changepassFrame = new JFrame("修改密码界面");
	JLabel idLabel, passwordLabel, repasswordLabel1, repasswordLabel2;
	JTextField idField, passwordField, repasswordField1, repasswordField2;
	JButton confirmButton;
	JPanel p1, p2, p3, p4, p5, p6, p7;
	
	
	public AdmChangePass() {
		
		idLabel = new JLabel("你的id");
		passwordLabel = new JLabel("当前密码");
		repasswordLabel1 = new JLabel("修改密码");
		repasswordLabel2 = new JLabel("确认密码");

		idField = new JTextField(15);
		passwordField = new JPasswordField(15);
		repasswordField1 = new JPasswordField(15);
		repasswordField2 = new JPasswordField(15);

		confirmButton = new JButton("确认");

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();

		changepassFrame.setLayout(new GridLayout(7, 1));

		changepassFrame.add(p1);
		changepassFrame.add(p2);
		changepassFrame.add(p3);
		changepassFrame.add(p4);
		changepassFrame.add(p5);
		changepassFrame.add(p6);
		changepassFrame.add(p7);

		p2.add(idLabel);
		p2.add(idField);
		p2.add(passwordLabel);
		p2.add(passwordField);
		p3.add(repasswordLabel1);
		p3.add(repasswordField1);
		p4.add(repasswordLabel2);
		p4.add(repasswordField2);
		p5.add(confirmButton);

		changepassFrame.setBounds(800, 100, 500, 600);
		idField.setEnabled(false);
		String id = null;
		id = MemoryXianShi();
		idField.setText(id);
		changepassFrame.setVisible(true);
		confirmButton.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String id = null;
		id = MemoryXianShi();
		
		if (e.getSource().equals(confirmButton)) {
			ResultSet resultSet;
			
			String password = null;
			String repassword = null;
			
			password = passwordField.getText();
			repassword = repasswordField2.getText();
			
		

			if (passwordField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "初始密码不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (repasswordField1.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "修改密码不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (repasswordField2.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "确认密码不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (!repasswordField1.getText().equals(repasswordField2.getText())) {
				JOptionPane.showMessageDialog(p2, "两次密码一样！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else {

				try {
					GetConn getConn = new GetConn();
					Connection connection = getConn.getConnection();
					String sql = "select * from administrator where adm_id = '" + id + "'" + "and adm_password = '"
							+ password + "'";

					Statement statement = connection.createStatement();
					
					resultSet = statement.executeQuery(sql);
					int count = 0;
					while(resultSet.next()) {
						count++;
					}
					System.out.println("count="+count);
					if(count != 0) {
						AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
						administratorDaoImpl.UpDateStu(id, repassword);

						JOptionPane.showMessageDialog(p2, "'"+id+"'管理员将初始的密码'"+password+"'更改为'" + repassword + "'", "信息提示",
								JOptionPane.WARNING_MESSAGE);
					}else if(count == 0){
						JOptionPane.showMessageDialog(p2, "初始密码不正确,无法确定是否为本人,所以无法进行密码重设", "错误提示", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
		
	}
	
	
	
	String MemoryXianShi() {// 将记忆数据表的最后一条记录，即上次的一次放在accountFiled
		String id = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getString(1);// 将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
}

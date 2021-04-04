package edu.hebeu.entry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Administrator;
import edu.hebeu.po.Stu_Id_Key;

public class Login implements ActionListener {

	JFrame loginFrame = new JFrame("登陆界面");

	JPanel p1, p2, p3, p4, p5, p6;

	JLabel idLabel, passwordLabel;

	JTextField idField, passwordField;

	JButton loginButton, registerButton;

	JRadioButton stu, adm;

	ButtonGroup group;

	public Login() {

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();

		idLabel = new JLabel("账号");
		passwordLabel = new JLabel("密码");

		idField = new JTextField(18);
		passwordField = new JPasswordField(18);

		loginButton = new JButton("登录");
		registerButton = new JButton("注册");

		stu = new JRadioButton("学生");
		adm = new JRadioButton("管理员");

		group = new ButtonGroup();
		group.add(adm);
		group.add(stu);
		adm.setSelected(true);

		loginFrame.setLayout(new GridLayout(6, 1));

		loginFrame.add(p1);
		loginFrame.add(p2);
		loginFrame.add(p3);
		loginFrame.add(p4);
		loginFrame.add(p5);
		loginFrame.add(p6);

		p2.add(idLabel);
		p2.add(idField);
		p3.add(passwordLabel);
		p3.add(passwordField);
		p4.add(adm);
		p4.add(stu);
		p5.add(loginButton);
		p5.add(registerButton);
		
		if(idField.getText().equals("")) {
			idField.setText(MemoryXianShi());
		}
		
		Toolkit toolkit = loginFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;

		loginFrame.setLocation((width - 600) / 2, (height - 700) / 2);
		loginFrame.setSize(600, 700);

		loginButton.addActionListener(this);
		registerButton.addActionListener(this);

		loginFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == registerButton) {
			new Register();
			loginFrame.dispose();
		}
		
		if (e.getSource() == loginButton) {
			
			Memory(idField.getText());
			
			if (adm.isSelected()) {
				Administrator administrator = new Administrator();
				administrator.setAdm_id(String.valueOf(idField.getText()));
				administrator.setAdm_password(String.valueOf(passwordField.getText()));

				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				Administrator administrator2 = administratorDaoImpl.FindAdmByIdAndPassword(administrator);
				if (administrator2 != null) {
					JOptionPane.showMessageDialog(p3, "'" + idField.getText() + "'管理员登录成功", "消息提示",
							JOptionPane.WARNING_MESSAGE);
					loginFrame.dispose();
					new AdministratorMangerment();
				} else {
					JOptionPane.showMessageDialog(p3, "请输入正确的账号或密码", "错误警告", JOptionPane.WARNING_MESSAGE);
					loginButton.setBackground(Color.RED);
				}

			}

			if (stu.isSelected()) {
				Stu_Id_Key stu_Id_Key = new Stu_Id_Key();
				stu_Id_Key.setStu_id(String.valueOf(idField.getText()));
				stu_Id_Key.setStu_password(String.valueOf(passwordField.getText()));

				StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
				Stu_Id_Key stu_Id_Key2 = studentDaoImpl.FindStudentByIdAndPassword(stu_Id_Key);
				if (stu_Id_Key2 != null) {
					JOptionPane.showMessageDialog(p3, "'" + idField.getText() + "'学生登录成功", "消息提示",
							JOptionPane.WARNING_MESSAGE);
					loginFrame.dispose();
					new StuMangerment();
				} else {
					JOptionPane.showMessageDialog(p3, "请输入正确的账号或密码", "错误警告", JOptionPane.WARNING_MESSAGE);
					loginButton.setBackground(Color.RED);
				}
			}
		}
	}

	void Memory(String id) {// 把所有的登录记录放入一个表中

		GetConn getConn = new GetConn();
		Connection connection = getConn.getConnection();
		try {
			Statement statement = connection.createStatement();
			Date date = new Date();
			
			String sql = "insert into memory value ('"+id+"','"+date.toString()+"')";
			statement.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	String MemoryXianShi() {//将记忆数据表的最后一条记录，即上次的一次放在accountFiled
		String idField = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				idField = resultSet.getString(1);//将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idField;
	}

}

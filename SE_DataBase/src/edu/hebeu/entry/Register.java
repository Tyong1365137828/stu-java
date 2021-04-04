package edu.hebeu.entry;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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

public class Register implements ActionListener {

	JFrame rejisterFrame = new JFrame("注册界面");

	JLabel idLabel, passwordLabel, repasswordLabel;

	JTextField idField, passwordField, repasswordField;

	JButton registerButton;

	JRadioButton stu, adm;

	ButtonGroup group;

	JPanel p1, p2, p3, p4, p5;

	public Register() {

		idLabel = new JLabel("账号");
		passwordLabel = new JLabel("密码");
		repasswordLabel = new JLabel("确认密码");

		idField = new JTextField(18);
		passwordField = new JPasswordField(18);
		repasswordField = new JPasswordField(18);

		registerButton = new JButton("注册");

		stu = new JRadioButton("学生");
		adm = new JRadioButton("管理员");

		group = new ButtonGroup();
		group.add(adm);
		group.add(stu);
		adm.setSelected(true);

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();

		rejisterFrame.setLayout(new GridLayout(5, 1));

		rejisterFrame.add(p1);
		rejisterFrame.add(p2);
		rejisterFrame.add(p3);
		rejisterFrame.add(p4);
		rejisterFrame.add(p5);

		p1.add(adm);
		p1.add(stu);
		p2.add(idLabel);
		p2.add(idField);
		p3.add(passwordLabel);
		p3.add(passwordField);
		p4.add(repasswordLabel);
		p4.add(repasswordField);
		p5.add(registerButton);

		Toolkit toolkit = rejisterFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;

		rejisterFrame.setLocation((width - 600) / 2, (height - 700) / 2);
		rejisterFrame.setSize(600, 700);
		rejisterFrame.setVisible(true);
		registerButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerButton) {
			
			if (idField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "账号不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (passwordField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "密码框不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (repasswordField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "确认密码框不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (!passwordField.getText().equals(repasswordField.getText())) {
				JOptionPane.showMessageDialog(p2, "两次密码的值不一样！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (stu.isSelected()) {

				String stu_id = idField.getText();
				String stu_password = passwordField.getText();
				String stu_name = null;
				String stu_depid = null;

				Stu_Id_Key stu_Id_Key = new Stu_Id_Key(stu_id, stu_name, stu_depid, stu_password);

				StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
				studentDaoImpl.registrStudent(stu_Id_Key);
				
				Memory(idField.getText());
				
				JOptionPane.showMessageDialog(p2, "'"+stu_id+"'学生，注册成功！","消息提示",JOptionPane.WARNING_MESSAGE);
				
				rejisterFrame.dispose();
				new StuPerfect();
				new Login();
				
			}else if (adm.isSelected()) {
				String adm_id = idField.getText();
				String adm_password = passwordField.getText();
				
				Administrator administrator = new Administrator(adm_id,adm_password);
				
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				administratorDaoImpl.registerAdministrator(administrator);
				
				JOptionPane.showMessageDialog(null, "'"+adm_id+"'管理员，注册成功！","消息提示",JOptionPane.WARNING_MESSAGE);
			}
		}

	}
	
	
	void Memory(String id) {// 把所有的注册记录放入一个表中

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

}

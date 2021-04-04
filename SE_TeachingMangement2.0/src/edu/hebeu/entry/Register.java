package edu.hebeu.entry;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.po.Student;
import edu.hebeu.po.Teacher;

public class Register implements ActionListener {

	JFrame registerJframe = new JFrame("注册界面");
	JLabel registerJLabel, accountJLabel, passwordJLabel, repasswordJLabel, quanxianJLabel;
	JTextField accountField, passwordField, repasswordField;
	JButton cancelButton, registerButton;
	Font font1, font2;
	String[] quanxianlist;// 用于生成数组并放入下拉框
	JComboBox<String> quanxiancomboBox = null;// 用于生成下拉框
	String quanxian;

	public Register() {

		registerJLabel = new JLabel("用户注册");
		accountJLabel = new JLabel("用户账号");
		passwordJLabel = new JLabel("用户密码");
		repasswordJLabel = new JLabel("确认密码");
		quanxianJLabel = new JLabel("权限选择");

		accountField = new JTextField();
		passwordField = new JPasswordField();
		repasswordField = new JPasswordField();

		registerButton = new JButton("注册");
		cancelButton = new JButton("取消");

		font1 = new Font("黑体", Font.BOLD, 15);
		font2 = new Font("宋体", Font.PLAIN, 60);

		accountJLabel.setFont(font1);
		passwordJLabel.setFont(font1);
		repasswordJLabel.setFont(font1);
		quanxianJLabel.setFont(font1);
		registerJLabel.setFont(font2);

		quanxianlist = new String[] { "请选择", "教师", "学生" };// 从0开始索引
		quanxiancomboBox = new JComboBox<String>(quanxianlist);// 生成下拉框并放入数组
		quanxiancomboBox.setSelectedIndex(0);// 默认选择索引为0的数组元素

		registerJframe.setLayout(null);// 使用自定义布局

		cancelButton.setBounds(530, 0, 60, 20);
		registerJLabel.setBounds(170, 30, 480, 120);
		accountJLabel.setBounds(100, 180, 70, 25);
		accountField.setBounds(170, 180, 320, 25);
		passwordJLabel.setBounds(100, 230, 70, 25);
		passwordField.setBounds(170, 230, 320, 25);
		repasswordJLabel.setBounds(100, 280, 70, 25);
		repasswordField.setBounds(170, 280, 320, 25);
		quanxianJLabel.setBounds(100, 330, 70, 30);
		quanxiancomboBox.setBounds(170, 330, 320, 25);
		registerButton.setBounds(170, 380, 320, 25);

		registerJframe.add(cancelButton);
		registerJframe.add(registerJLabel);
		registerJframe.add(accountJLabel);
		registerJframe.add(accountField);
		registerJframe.add(passwordJLabel);
		registerJframe.add(passwordField);
		registerJframe.add(repasswordJLabel);
		registerJframe.add(repasswordField);
		registerJframe.add(quanxianJLabel);
		registerJframe.add(quanxiancomboBox);
		registerJframe.add(registerButton);

		Toolkit toolkit = registerJframe.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;

		registerJframe.setLocation((width - 600) / 2, (height - 700) / 2);
		registerJframe.setSize(600, 700);

		cancelButton.addActionListener(this);
		registerButton.addActionListener(this);
		registerJframe.setVisible(true);

		quanxiancomboBox.addItemListener(new ItemListener() {// 是给comboBox设置监听函数

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (passwordField.getText().equals(repasswordField.getText())) {// 注:此不可用==,而是用equals()
					if (e.getStateChange() == ItemEvent.SELECTED) {// 只处理选中的状态

						if (e.getItem().equals(quanxianlist[0])) {
							quanxian = "请选择权限";
						}

						else if (e.getItem().equals(quanxianlist[1])) {// 如果选择了索引2，即教师
							quanxian = "教师";
						}

						else if (e.getItem().equals(quanxianlist[2])) {// 如果选择了索引3，即学生
							quanxian = "学生";
						}

						else if (repasswordField.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "确认密码框不为0", "asd", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}

				}

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			registerJframe.dispose();
			new Login();
		}

		if (e.getSource() == registerButton) {// 如果选择了索引3，即学生
			if (accountField.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "账号框不为0", "asd", JOptionPane.INFORMATION_MESSAGE);
			} else if (passwordField.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "密码框不为0", "asd", JOptionPane.INFORMATION_MESSAGE);
			} else if (repasswordField.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "确认密码框不为0", "asd", JOptionPane.INFORMATION_MESSAGE);
			} else if (!passwordField.getText().equals(repasswordField.getText())) {// 当两次密码不同时
				JOptionPane.showMessageDialog(null, "请检查你是否输入完两次密码是否对应!", "asd", JOptionPane.INFORMATION_MESSAGE);
			} else if (quanxian == "学生") {
				String stu_number = String.valueOf(accountField.getText());
				String stu_repassword = String.valueOf(repasswordField.getText());
				int count = 0;

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					ResultSet resultSet = administratorDaoImpl.JSelectStudentByNum(stu_number);
					while (resultSet.next()) {
						count++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (count != 0) {
					JOptionPane.showMessageDialog(null, "已存在id为" + stu_number + "的学生账号,请更换别的账号", "消息提示",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Student student = new Student(stu_number, stu_repassword);
					StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
					studentDaoImpl.registerStudent(student);
					JOptionPane.showMessageDialog(null, "学生'" + stu_number + "'注册成功", "消息提示",
							JOptionPane.INFORMATION_MESSAGE);
					registerJframe.dispose();
				}

			} else if (quanxian == "教师") {
				String tea_id = String.valueOf(accountField.getText());
				String tea_password = String.valueOf(passwordField.getText());
				int count = 0;

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					ResultSet resultSet = administratorDaoImpl.JSelectTeaByNum(tea_id);
					while (resultSet.next()) {
						count++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(count != 0) {
					JOptionPane.showMessageDialog(null, "已存在id为"+tea_id+"的教师账号,请更换别的账号", "消息提示", JOptionPane.WARNING_MESSAGE);
				}else {
					Teacher teacher = new Teacher(tea_id, tea_password);
					TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
					teacherDaoImpl.registerTeacher(teacher);
					JOptionPane.showMessageDialog(null, "教师'" + tea_id + "'注册成功", "asd", JOptionPane.INFORMATION_MESSAGE);
					registerJframe.dispose();
				}
				
			} else if (quanxian == "请选择权限") {
				JOptionPane.showMessageDialog(null, "请选择权限", "消息提示", JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}

}
package edu.hebeu.entry;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Administrator;
import edu.hebeu.po.Student;
import edu.hebeu.po.Teacher;

/**
 * @author 汤勇
 *
 *         2019年12月13日
 */
public class Login implements ActionListener {

	JFrame loginFrame = new JFrame("登录界面");

	JPanel p1, p2, p3, p4, p5;

	JLabel accountLabel, passwordLabel, chooseLabel,loginJLabel;
	JTextField accountField, passwordField;
	JButton loginButton, cancelButton,registerButton,forgetButton;
	JRadioButton stu, tea, adm; // 单选按钮
	ButtonGroup group;

	Font font1,font2;
	
	JLabel l1= null;
//	@SuppressWarnings("deprecation")
	public Login() {

		accountLabel = new JLabel("账号");
		passwordLabel = new JLabel("密码");
		chooseLabel = new JLabel("登录权限");
		loginJLabel = new JLabel("用户登录");
		
		accountField = new JTextField();
		passwordField = new JPasswordField();

		loginButton = new JButton("登录");
		cancelButton = new JButton("取消");
		registerButton = new JButton("注册用户");
		forgetButton = new JButton("忘记密码？");
		
		stu = new JRadioButton("学生");
		tea = new JRadioButton("教师");
		adm = new JRadioButton("管理员");
		
		font1= new Font("黑体", Font.BOLD, 15);
		font2 = new Font("宋体", Font.PLAIN, 60);
		
		Toolkit toolkit =loginFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		
		loginFrame.setLocation((width-600)/2, (height-700)/2);
		loginFrame.setSize(600, 700);
		
		ImageIcon imageIcon = new ImageIcon("src/images/login.jpg");
		l1 = new JLabel(imageIcon);
		loginFrame.getLayeredPane().add(l1, new Integer(Integer.MIN_VALUE));
		l1.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		
		Container cp = loginFrame.getContentPane();
		cp.setLayout(null);//使用自定义布局
		
		accountLabel.setFont(font1);
		passwordLabel.setFont(font1);
		loginJLabel.setFont(font2);		
		loginJLabel.setForeground(Color.green);
		
		
		group = new ButtonGroup();//将stu,tea,adm放入ButtonGroup的对象group中,并使这3个JRadioButton只能选一个
		group.add(stu);
		group.add(tea);
		group.add(adm);
		adm.setSelected( true );//默认选择adm
//		stu.setSelected(true);//默认选择stu
//		tea.setSelected(true);//默认选择tea

//		loginFrame.setLayout(null);//使用自定义布局

		loginJLabel.setBounds(170, 30, 480, 120);
		chooseLabel.setBounds(155, 170, 60, 25);
		adm.setBounds(230, 170, 65, 25);
		tea.setBounds(310, 170, 60, 25);
		stu.setBounds(385, 170, 60, 25);
		accountLabel.setBounds(120, 220, 30, 25);
		accountField.setBounds(160, 220, 320, 25);
		passwordLabel.setBounds(120, 270, 30, 25);
		passwordField.setBounds(160, 270, 320, 25);
		loginButton.setBounds(125, 320, 355, 30);
		registerButton.setBounds(175, 380, 95, 20);
		forgetButton.setBounds(340, 380, 95, 20);
		
		cp.add(loginJLabel);
		cp.add(chooseLabel);
		cp.add(adm);
		cp.add(tea);
		cp.add(stu);
		cp.add(accountLabel);
		cp.add(accountField);
		cp.add(passwordLabel);
		cp.add(passwordField);
		cp.add(loginButton);
		cp.add(registerButton);
		cp.add(forgetButton);
		
		if(accountField.getText().equals("")) {//如果accountField的值为空，则将方法MemoryXianShi的值（即上一次登录的账号）放入accountField
			accountField.setText(MemoryXianShi());
		}
		
		((JPanel) cp).setOpaque(false);
		
		loginFrame.setResizable(false);
		loginFrame.setVisible(true);
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		forgetButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == forgetButton) {
			new ForgetPassword();
		}
		
		if(e.getSource() == registerButton) {//注册
			new Register();
		}

		if (e.getSource() == loginButton) {// 如果点击了登录按钮
			Memory(accountField.getText());//利用监听按钮loginButton将账号框的内容获得并进行事件Memory
			// 如果管理员身份被选中
			if (adm.isSelected()) {
				Administrator administrator = new Administrator();// 生成Administrator的对象administrator以获得以下set，get方法
				administrator.setAdm_account(String.valueOf(accountField.getText()));// 将accountfield的值给administrator
				administrator.setAdm_password(String.valueOf(passwordField.getText()));// 将passwordfield的值给administrator

				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();// 生成AdministratorDaoImpl的对象administratorDaoImpl以调用其方法
				Administrator administrator2 = administratorDaoImpl
						.FindadministratorByAccountAndPassword(administrator);// 以administrator做参数给此方法并将返回值给Administrator的对象administrator2
				if (administrator2 != null) {
//					JOptionPane.showInputDialog给出提示信息
					JOptionPane.showMessageDialog(p3, "管理员登录成功", "消息提示", JOptionPane.WARNING_MESSAGE);
					new AdministratorManagement();
					loginFrame.dispose();
					
				} else {
					JOptionPane.showMessageDialog(p3, "请输入正确的账号或密码", "错误警告", JOptionPane.WARNING_MESSAGE);
					loginButton.setBackground(Color.RED);
				}
			}
		}

		// 如果学生选中
		if (stu.isSelected()) {
			Student student = new Student();
			student.setStu_number(String.valueOf(accountField.getText()));
			student.setStu_password(String.valueOf(passwordField.getText()));
			
			StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
			Student student2 = studentDaoImpl.FindStudentBynumberAndPassword(student);
			if (student2 != null) {
				JOptionPane.showMessageDialog(p3, "学生登录成功", "消息提示", JOptionPane.WARNING_MESSAGE);
				new StudentMangement();
				loginFrame.dispose();
			} else {
				JOptionPane.showMessageDialog(p3, "请输入正确的账号或密码", "错误警告", JOptionPane.WARNING_MESSAGE);
				loginButton.setBackground(Color.RED);
			}
		}

		// 如果老师选中
		if (tea.isSelected()) {
			Teacher teacher = new Teacher();
			teacher.setTea_id(String.valueOf(accountField.getText()));
			teacher.setTea_password(String.valueOf(passwordField.getText()));

			TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
			Teacher teacher2 = teacherDaoImpl.FindTeacherByIdAndPassword(teacher);
			if (teacher2 != null) {
				JOptionPane.showMessageDialog(p3, "教师登录成功", "消息提示", JOptionPane.WARNING_MESSAGE);
				new TeacherMangement();
			} else {
				JOptionPane.showMessageDialog(p3, "请输入正确的账号或密码", "错误警告", JOptionPane.WARNING_MESSAGE);
				loginButton.setBackground(Color.RED);
			}
		}
	}
	
	void Memory (String number) {//把所有的登录记录放入一个表中
		
		GetConn getConn = new GetConn();
		Connection connection=getConn.getConnection();
		try {
			Statement statement = connection.createStatement();
			Date date = new Date();
			
			String sql = "insert into memory value ('"+number+"','"+date.toString()+"')";
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	String MemoryXianShi() {//将记忆数据表的最后一条记录，即上次的一次放在accountFiled
		String accountField = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				accountField = resultSet.getString(1);//将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountField;
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
}

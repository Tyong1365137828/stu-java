package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.jdbc.GetConn;

public class ForgetPassword implements ActionListener {

	ResultSet resultSet;

	JFrame forgetFrame = new JFrame("忘记密码界面");

	JLabel nameLabel, accountLabel, chooseLabel,idcardLabel;

	JTextField nameField, accountField, idcardField;

	JButton confirmButton;

	JRadioButton stu, tea, adm; // 单选按钮
	ButtonGroup group;

	JPanel p1, p2, p3, p4, p5, p6, p7, p8;

	public ForgetPassword() {

		nameLabel = new JLabel("你的姓名");
		accountLabel = new JLabel("你的账号");
		idcardLabel = new JLabel("你的身份证号");
		chooseLabel = new JLabel("你的权限");

		nameField = new JTextField(18);
		accountField = new JTextField(18);
		idcardField = new JTextField(18);

		confirmButton = new JButton("确认提交");

		stu = new JRadioButton("学生");
		tea = new JRadioButton("教师");
		adm = new JRadioButton("管理员");

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		
		group = new ButtonGroup();// 将stu,tea,adm放入ButtonGroup的对象group中,并使这3个JRadioButton只能选一个
		group.add(stu);
		group.add(tea);
		group.add(adm);
		adm.setSelected(true);// 默认选择adm
//		stu.setSelected(true);//默认选择stu
//		tea.setSelected(true);//默认选择tea

		forgetFrame.setLayout(new GridLayout(8, 1));

		forgetFrame.add(p1);
		forgetFrame.add(p2);
		forgetFrame.add(p3);
		forgetFrame.add(p4);
		forgetFrame.add(p5);
		forgetFrame.add(p6);
		forgetFrame.add(p7);
		forgetFrame.add(p8);

		p2.add(nameLabel);
		p2.add(nameField);
		p3.add(accountLabel);
		p3.add(accountField);
		p4.add(idcardLabel);
		p4.add(idcardField);
		p7.add(chooseLabel);
		p7.add(adm);
		p7.add(tea);
		p7.add(stu);
		p8.add(confirmButton);

		forgetFrame.setSize(500, 600);
		forgetFrame.setVisible(true);

		confirmButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//
		if (e.getSource() == confirmButton) {

			if (nameField.getText().length() == 0) {// 不论选哪个如果名字为空
				JOptionPane.showMessageDialog(p2, "名字输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (accountField.getText().length() == 0) {// 不论选哪个如果账号为空
				JOptionPane.showMessageDialog(p2, "账号输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			}else if (idcardField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "身份证输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			else if (stu.isSelected() ) {// 如果选择了学生且密码框不为空
				
					String name = nameField.getText();
					String account = accountField.getText();
					String idcard = idcardField.getText();
					String password = null;
					try {
						GetConn getConn = new GetConn();
						Connection connection = getConn.getConnection();
						String sql = "select * from student where stu_name='" + name + "'"// 此语句用于判断名字和账号和身份证号是否合法来决定是否让用户重设密码
								+ " and stu_number = '" + account + "'"
								+"and stu_idcard = '"+idcard+"'";
						Statement statement = connection.createStatement();
						
						resultSet = statement.executeQuery(sql);
						int count = 0;// 此count用于判断名字和账号是否合法来决定是否让用户重设密码
						while (resultSet.next()) {
							password = resultSet.getString("stu_password");
							count++;
						}
						System.out.println("忘记密码里的账号与名字符合的记录count=" + count);
						
						if (count != 0) {// 如果count不等于0，即名字和账号合法，则可以重设密码

							JOptionPane.showMessageDialog(p2, "'"+account+"'学生,你的密码为''" + password + "'", "信息提示",
									JOptionPane.WARNING_MESSAGE);
							System.out.println("最后一条了");
							forgetFrame.dispose();
						}
						else if (count == 0) {// 否则，即名字与账号不合法，发生以下反应
							JOptionPane.showMessageDialog(p2, "信息不符，所以无法进行密码找回", "错误提示", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
				
				
			} else if (tea.isSelected()) {// 如果选择了教师且密码框不为空
				
					String name = nameField.getText();
					String account = accountField.getText();
					String password = null;
					String idcard = idcardField.getText();
					try {
						GetConn getConn = new GetConn();
						Connection connection = getConn.getConnection();
						String sql = "select * from teacher where tea_name='" + name + "'"// 此语句用于判断名字和账号是否合法来决定是否让用户重设密码
								+ " and tea_id = '" + account + "'"
								+" and tea_idcard = '"+idcard+"'";
						Statement statement = connection.createStatement();
						
						resultSet = statement.executeQuery(sql);
						int count = 0;// 此count用于判断名字和账号是否合法来决定是否让用户重设密码
						while (resultSet.next()) {
							password =resultSet.getString("tea_password");
							count++;
						}
						System.out.println("忘记密码里的账号与名字符合的记录count=" + count);

						if (count != 0) {// 如果count不等于0，即名字和账号合法，则可以重设密码

							JOptionPane.showMessageDialog(p2, "'"+account+"'教师,你的密码为' " + password + "'", "信息提示",
									JOptionPane.WARNING_MESSAGE);
							forgetFrame.dispose();
						} else if (count == 0) {// 否则，即名字与账号不合法，发生以下反应
							JOptionPane.showMessageDialog(p2, "信息不符，所以无法进行密码找回", "错误提示", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					

			}	
			else if (adm.isSelected()) {// 如果选择了管理员且密码框不为空
				
					String name = nameField.getText();
					String account = accountField.getText();
					String password = null;
					String idcard = idcardField.getText();
					
					try {
						GetConn getConn = new GetConn();
						Connection connection = getConn.getConnection();
						String sql = "select * from administrator where adm_name='" + name + "'"// 此语句用于判断名字和账号是否合法来决定是否让用户重设密码
								+ " and adm_account = '" + account + "'"
								+"and adm_idcard = '" + idcard + "'";
						Statement statement = connection.createStatement();
						System.out.println("adm_name=" + name);
						
						resultSet = statement.executeQuery(sql);
						int count = 0;// 此count用于判断名字和账号是否合法来决定是否让用户重设密码
						while (resultSet.next()) {
							password = resultSet.getString("adm_password");
							count++;
						}
						System.out.println("忘记密码里的账号与名字符合的记录count=" + count);

						if (count != 0) {// 如果count不等于0，即名字和账号合法，则可以重设密码
							
							
							JOptionPane.showMessageDialog(p2, "'"+account+"'管理员,你的的密码为' " + password + "'", "信息提示",
									JOptionPane.WARNING_MESSAGE);
							System.out.println("最后一条了");
							forgetFrame.dispose();
						} else if (count == 0) {// 否则，即名字与账号不合法，发生以下反应
							JOptionPane.showMessageDialog(p2, "信息不符，所以无法进行密码找回", "错误提示", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
			
			
			
		}

	}
	
	public static void main(String[] args) {
		new ForgetPassword();
	}

}

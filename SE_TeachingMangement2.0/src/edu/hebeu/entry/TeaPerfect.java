package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Teacher;

public class TeaPerfect implements ActionListener{
	JFrame perFrame = new JFrame("教师信息修改与完善");

	JButton returnButton, confirmButton;

	JLabel nameLabel, genderLabel, ageLabel, teLabel, depnumLabel, idcardLabel;

	JTextField nameField, ageField, telField, depnamField, idcardField;

	JRadioButton manRadioButton, womanRadioButton;

	ButtonGroup group;

	String[] depnumlist;
	JComboBox<String> depnumcomboBox = null;// 用于生成下拉框

	String account;

	JPanel p1, p2, p3, p4, p5, p6, p7, p8;

	public TeaPerfect() {

		returnButton = new JButton("返回");
		confirmButton = new JButton("确认");

		nameLabel = new JLabel("姓名");
		ageLabel = new JLabel("年龄");
		genderLabel = new JLabel("性别");
		teLabel = new JLabel("手机号");
//		depnumLabel = new JLabel("系号");
		idcardLabel = new JLabel("身份证号");

		nameField = new JTextField(5);
		ageField = new JTextField(5);
		idcardField = new JTextField(15);
		telField = new JTextField(15);
//		depnamField = new JTextField(5);
//		depnamField = new JTextField("请选择", 10);
//		depnamField.setEditable(false);

		manRadioButton = new JRadioButton("男");
		womanRadioButton = new JRadioButton("女");

		group = new ButtonGroup();
		group.add(manRadioButton);
		group.add(womanRadioButton);
		manRadioButton.setSelected(true);// 默认选择男

//		depnumlist = new String[] { "请选择", "001", "002", "003", "004", "005", "006", "007", };
//		depnumcomboBox = new JComboBox<String>(depnumlist);
//		depnumcomboBox.setSelectedIndex(0);

		account = Memory();

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();

		perFrame.setLayout(new GridLayout(8, 1));

		perFrame.add(p1);
		perFrame.add(p2);
		perFrame.add(p3);
		perFrame.add(p4);
		perFrame.add(p5);
		perFrame.add(p6);
		perFrame.add(p7);
		perFrame.add(p8);

		p1.add(returnButton);
		p2.add(nameLabel);
		p2.add(nameField);
		p2.add(idcardLabel);
		p2.add(idcardField);
		p3.add(genderLabel);
		p3.add(manRadioButton);
		p3.add(womanRadioButton);
		p3.add(ageLabel);
		p3.add(ageField);
		p4.add(teLabel);
		p4.add(telField);
//		p5.add(depnumLabel);
//		p5.add(depnumcomboBox);
//		p5.add(depnamField);
		p7.add(confirmButton);
		
//		Toolkit toolkit =perFrame.getToolkit();
//		Dimension dimension = toolkit.getScreenSize();
//		int width = dimension.width;
//		int height = dimension.height;
		
		perFrame.setSize(600, 700);
		perFrame.setVisible(true);
		
		confirmButton.addActionListener(this);
		
//		depnumcomboBox.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				
//				if(e.getStateChange() == ItemEvent.SELECTED) {
//					if(e.getItem().equals(depnumlist[0])) {
//						depnamField.setText("请选择");
//					}
//					if(e.getItem().equals(depnumlist[1])) {
//						depnamField.setText("软件工程");
//					}
//					if(e.getItem().equals(depnumlist[2])) {
//						depnamField.setText("计算机科学与技术");
//					}
//					if(e.getItem().equals(depnumlist[3])) {
//						depnamField.setText("物联网");
//					}
//					if(e.getItem().equals(depnumlist[4])) {
//						depnamField.setText("电气工程");
//					}
//					if(e.getItem().equals(depnumlist[5])) {
//						depnamField.setText("机械工程自动化");
//					}
//					if(e.getItem().equals(depnumlist[6])) {
//						depnamField.setText("冶金工程");
//					}
//					if(e.getItem().equals(depnumlist[7])) {
//						depnamField.setText("农学");
//					}
//				}
//			}
//		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==confirmButton) {
			if(nameField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "请输入名字", "错误警告", JOptionPane.ERROR_MESSAGE);
			}else if(idcardField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "请输入身份证号", "错误警告", JOptionPane.ERROR_MESSAGE);
			}else if(ageField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "请输入年龄", "错误警告", JOptionPane.ERROR_MESSAGE);
			}else if(telField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "请输入手机号", "错误警告", JOptionPane.ERROR_MESSAGE);
			}else {
				Teacher teacher = new Teacher();
				teacher.setTea_id(account);
				DefaultButtonModel model = (DefaultButtonModel) manRadioButton.getModel();//选择男并生成model对象
				if(model.getGroup().isSelected(model)) {//当选择含有男的model对象时
					teacher.setTea_gender(String.valueOf(manRadioButton.getText()));
				}else {//否则
					teacher.setTea_gender(String.valueOf(womanRadioButton.getText()));
				}
				teacher.setTea_idcard(String.valueOf(idcardField.getText()));
//				teacher.setTea_depnum(String.valueOf(depnumcomboBox.getSelectedItem()));//获取下拉框的值
				teacher.setTea_age(String.valueOf(ageField.getText()));
				teacher.setTea_name(String.valueOf(nameField.getText()));
				teacher.setTea_tel(String.valueOf(telField.getText()));
				
				TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
				
				teacherDaoImpl.perfectinformation(teacher);
				
				JOptionPane.showMessageDialog(perFrame, "教师信息修改成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);	
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new TeaPerfect();
	}

	String Memory() {

		String accountField = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				accountField = resultSet.getString(1);// 将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountField;

	}

}

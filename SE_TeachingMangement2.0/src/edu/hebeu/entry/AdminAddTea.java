package edu.hebeu.entry;

import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;

public class AdminAddTea implements ActionListener {

	JFrame addFrame = new JFrame("添加教师界面");

	JLabel idLabel, passwordLabel, depnumLabel;

	JTextField idField, passwordField, depnamField;

	JButton addButton;

	JPanel p1, p2, p3;

	JPanel p11, p12, p21, p22;

	String[] depnumlist;
	JComboBox<String> depnumcomboBox = null;// 用于生成下拉框

	String depnum = "";

	public AdminAddTea() {

		idLabel = new JLabel("添加账号");
		passwordLabel = new JLabel("添加密码");
		depnumLabel = new JLabel("添加系号");

		idField = new JTextField(10);
		passwordField = new JPasswordField(10);
		depnamField = new JTextField("请选择", 10);
		depnamField.setEnabled(false);

		addButton = new JButton("确认添加");

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		p11 = new JPanel();
		p12 = new JPanel();
		p21 = new JPanel();
		p22 = new JPanel();

		depnumlist = new String[] { "请选择", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010" };
		depnumcomboBox = new JComboBox<String>(depnumlist);
		depnumcomboBox.setSelectedIndex(0);

		p1.setLayout(new GridLayout(2, 1));
		p1.add(p11);
		p1.add(p12);

		p2.setLayout(new GridLayout(2, 1));
		p2.add(p21);
		p2.add(p22);

		addFrame.setLayout(new GridLayout(3, 1));

		addFrame.add(p1);
		addFrame.add(p2);
		addFrame.add(p3);

		p12.add(idLabel);
		p12.add(idField);
		p21.add(passwordLabel);
		p21.add(passwordField);
		p22.add(depnumLabel);
		p22.add(depnumcomboBox);
		p22.add(depnamField);
		p3.add(addButton);

		addFrame.setVisible(true);
		addFrame.setSize(500, 400);

		depnumcomboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(depnumlist[0])) {
						depnamField.setText("请选择");
					}
					if (e.getItem().equals(depnumlist[1])) {
						depnamField.setText("软件工程");
						depnum = "001";
					}
					if (e.getItem().equals(depnumlist[2])) {
						depnamField.setText("计算机科学与技术");
						depnum = "002";
					}
					if (e.getItem().equals(depnumlist[3])) {
						depnamField.setText("物联网");
						depnum = "003";
					}
					if (e.getItem().equals(depnumlist[4])) {
						depnamField.setText("电气工程");
						depnum = "004";
					}
					if (e.getItem().equals(depnumlist[5])) {
						depnamField.setText("机械工程自动化");
						depnum = "005";
					}
					if (e.getItem().equals(depnumlist[6])) {
						depnamField.setText("冶金工程");
						depnum = "006";
					}
					if (e.getItem().equals(depnumlist[7])) {
						depnamField.setText("农学");
						depnum = "007";
					}
					if (e.getItem().equals(depnumlist[8])) {
						depnamField.setText("应用化学");
						depnum = "008";
					}
					if (e.getItem().equals(depnumlist[9])) {
						depnamField.setText("土木工程");
						depnum = "009";
					}
					if (e.getItem().equals(depnumlist[10])) {
						depnamField.setText("水利水电工程");
						depnum = "010";
					}
				}

			}
		});

		addButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (idField.getText().length() == 0) {
			JOptionPane.showMessageDialog(p3, "请输入添加账号", "错误警告", JOptionPane.ERROR_MESSAGE);
		} else if (passwordField.getText().length() == 0) {
			JOptionPane.showMessageDialog(p3, "请输入添加账号的密码", "错误警告", JOptionPane.ERROR_MESSAGE);
		} else if (depnamField.getText().equals("请选择")) {
			JOptionPane.showMessageDialog(p3, "请选择添加账号的系号", "错误警告", JOptionPane.ERROR_MESSAGE);
		} else {

			String id = idField.getText();
			String password = passwordField.getText();
			int count = 0;
			
			try {
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				ResultSet resultSet = administratorDaoImpl.JSelectTeaByNum(id);
				while (resultSet.next()) {
					count++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(count != 0) {
				JOptionPane.showMessageDialog(p2, "已存在id为"+id+"的教师账号,请更换别的账号", "消息提示", JOptionPane.WARNING_MESSAGE);
			}else {
				AdministratorDaoImpl administratorDaoImpl2 = new AdministratorDaoImpl();
				administratorDaoImpl2.AddTea(id, password, depnum);
				
				JOptionPane.showMessageDialog(p2, "id为'" + id + "'的教师，添加成功！", "消息提示", JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	public static void main(String[] args) {
		new AdminAddTea();
	}

}

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
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.po.Department;

public class AdminChangeTea implements ActionListener {

	JFrame changeTeaFrame = new JFrame("修改教师信息");
	JPanel p1, p2, p3, p4, p5, p6, p7;

	JLabel teaIdLabel, teaNamLabel, depnumLabel, depnamLabel, passLabel, alterdepnumLabel;

	JTextField teaIdField, teanameField, depnumField, depnamField, passField;

	JButton checkButton, alterButton;

	String[] depnumlist;
	JComboBox<String> depnumcomboBox = null;// 用于生成下拉框

	public AdminChangeTea() {

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();

		teaIdLabel = new JLabel("教师id：");
		teaNamLabel = new JLabel("教师姓名：");
		teaNamLabel.setVisible(false);
		depnumLabel = new JLabel("所在系号：");
		depnumLabel.setVisible(false);
		depnamLabel = new JLabel("所在系名：");
		depnamLabel.setVisible(false);
		passLabel = new JLabel("密码：");
		passLabel.setVisible(false);
		alterdepnumLabel = new JLabel("修改系号为：");
		alterdepnumLabel.setVisible(false);

		teaIdField = new JTextField(10);
		teanameField = new JTextField(10);
		teanameField.setVisible(false);
		teanameField.setEnabled(false);
		depnumField = new JTextField(10);
		depnumField.setVisible(false);
		depnumField.setEnabled(false);
		depnamField = new JTextField(10);
		depnamField.setVisible(false);
		depnamField.setEnabled(false);
		passField = new JTextField(10);
		passField.setVisible(false);

		checkButton = new JButton("查询");
		alterButton = new JButton("修改");
		alterButton.setVisible(false);

		depnumlist = new String[] { "请选择", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010" };
		depnumcomboBox = new JComboBox<String>(depnumlist);
//		depnumcomboBox.setSelectedIndex(0);
		depnumcomboBox.setVisible(false);

		changeTeaFrame.setLayout(new GridLayout(7, 1));

		changeTeaFrame.add(p1);
		changeTeaFrame.add(p2);
		changeTeaFrame.add(p3);
		changeTeaFrame.add(p4);
		changeTeaFrame.add(p5);
		changeTeaFrame.add(p6);
		changeTeaFrame.add(p7);

		p1.add(teaIdLabel);
		p1.add(teaIdField);
		p1.add(checkButton);
		p2.add(teaNamLabel);
		p2.add(teanameField);
		p3.add(depnumLabel);
		p3.add(depnumField);
		p4.add(alterdepnumLabel);
		p4.add(depnumcomboBox);
		p5.add(depnamLabel);
		p5.add(depnamField);
		p6.add(passLabel);
		p6.add(passField);
		p7.add(alterButton);

		changeTeaFrame.setSize(500, 400);
		changeTeaFrame.setVisible(true);

		depnumcomboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(depnumlist[0])) {
						depnamField.setText("请选择");
					}
					if (e.getItem().equals(depnumlist[1])) {
						depnamField.setText("软件工程");
						depnumField.setText("001");
					}
					if (e.getItem().equals(depnumlist[2])) {
						depnamField.setText("计算机科学与技术");
						depnumField.setText("002");
					}
					if (e.getItem().equals(depnumlist[3])) {
						depnamField.setText("物联网");
						depnumField.setText("003");
					}
					if (e.getItem().equals(depnumlist[4])) {
						depnamField.setText("电气工程");
						depnumField.setText("004");
					}
					if (e.getItem().equals(depnumlist[5])) {
						depnamField.setText("机械工程自动化");
						depnumField.setText("005");
					}
					if (e.getItem().equals(depnumlist[6])) {
						depnamField.setText("冶金工程");
						depnumField.setText("006");
					}
					if (e.getItem().equals(depnumlist[7])) {
						depnamField.setText("农学");
						depnumField.setText("007");
					}
					if (e.getItem().equals(depnumlist[8])) {
						depnamField.setText("应用化学");
						depnumField.setText("008");
					}
					if (e.getItem().equals(depnumlist[9])) {
						depnamField.setText("土木工程");
						depnumField.setText("009");
					}
					if (e.getItem().equals(depnumlist[10])) {
						depnamField.setText("水利水电工程");
						depnumField.setText("010");
					}
				}

			}
		});

		checkButton.addActionListener(this);
		alterButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == checkButton) {
			if (teaIdField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "请输入id", "错误警告", JOptionPane.ERROR_MESSAGE);
			} else {

				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				String id = teaIdField.getText();

				try {
					ResultSet resultSet = administratorDaoImpl.JSelectTeaByNum(id);
					int count = 0;
					while (resultSet.next()) {
						count++;
					}
					if (count == 0) {
						JOptionPane.showMessageDialog(p3, "查无此人", "信息提示", JOptionPane.WARNING_MESSAGE);
					} else {

						resultSet.beforeFirst();
						resultSet.next();
						String Nam = resultSet.getString(2);
						String depnum = resultSet.getString(5);
						String password = resultSet.getString(6);
						System.out.println("wrfddwwr");

						CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
						Department department = new Department();
						department.setDepnum(depnum);
						String depnam = courseDaoImpl.FindDepNam(department);

						teanameField.setText(Nam);
						depnumField.setText(depnum);
						depnamField.setText(depnam);
						passField.setText(password);

						teaNamLabel.setVisible(true);
						depnumLabel.setVisible(true);
						depnamLabel.setVisible(true);
						passLabel.setVisible(true);

						teanameField.setVisible(true);
						depnumField.setVisible(true);
						depnamField.setVisible(true);
						passField.setVisible(true);
						alterButton.setVisible(true);
						depnumcomboBox.setVisible(true);
						alterdepnumLabel.setVisible(true);

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		
		if(e.getSource() == alterButton) {
			if (depnamField.getText().equals("请选择")) {
				JOptionPane.showMessageDialog(p3, "请选择所在系", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (passField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "密码不为空", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else {
				String password = passField.getText();
				String depnum = depnumField.getText();
				String id = teaIdField.getText();
				
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				administratorDaoImpl.AlterTeaByteaId(depnum, password, id);
				
				JOptionPane.showMessageDialog(p3, "修改成功", "消息提示", JOptionPane.WARNING_MESSAGE);
				
			}
		}

	}
	
}

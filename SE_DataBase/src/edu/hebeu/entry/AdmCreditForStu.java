package edu.hebeu.entry;

import java.awt.BorderLayout;
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
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.po.Stu_Name_Cou_Key;

public class AdmCreditForStu implements ActionListener {

	JFrame addcreditframe = new JFrame("录入学生分数");

	JLabel selCouLabel, stuIdLabel, stuIddataLabel, credLabel, creddataLabel, nameLabel, namedataLabel, creditLabel;

	JTextField couField, creditField;

	JButton selectButton, yesButton, upButton, downButton;

	int row = 1;// 代表指针，用于获取所查表的第一条记录
	int count, count1;// 用于获取表的最大记录数

	String[] counumlist;
	JComboBox<String> counumcomboBox = null;// 用于生成下拉框

	JPanel p1, p2, p3;

	public AdmCreditForStu() {
		selCouLabel = new JLabel("选择查询的课程号");
		stuIdLabel = new JLabel("学号");
		stuIdLabel.setVisible(false);
		stuIddataLabel = new JLabel("", 10);
		stuIddataLabel.setVisible(false);
		credLabel = new JLabel("以得学分");
		credLabel.setVisible(false);
		creddataLabel = new JLabel("", 10);
		creddataLabel.setVisible(false);
		nameLabel = new JLabel("名字");
		nameLabel.setVisible(false);
		namedataLabel = new JLabel("", 10);
		namedataLabel.setVisible(false);
		creditLabel = new JLabel("学分");
		creditLabel.setVisible(false);

		couField = new JTextField("数据库", 10);
		couField.setEditable(false);
		creditField = new JTextField(10);
		creditField.setVisible(false);

		selectButton = new JButton("查询");
		yesButton = new JButton("确认");
		yesButton.setVisible(false);
		upButton = new JButton("上一个");
		upButton.setVisible(false);
		downButton = new JButton("下一个");
		downButton.setVisible(false);

		counumlist = new String[] { "01<数据库>", "02<C语言>", "03<操作系统>", "04<java>", "05<概率论>", "06<英语>", "07<计算机系统基础>",
				"08<大学物理>", "09<高数上册>", "10<高数下册>", "11<军事理论>" };
		counumcomboBox = new JComboBox<String>(counumlist);
		counumcomboBox.setSelectedIndex(0);

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		addcreditframe.setLayout(new GridLayout(3, 1));

		addcreditframe.add(p1);
		addcreditframe.add(p2);
		addcreditframe.add(p3);

		p1.add(selCouLabel, BorderLayout.CENTER);
		p1.add(counumcomboBox, BorderLayout.CENTER);
		p1.add(couField, BorderLayout.CENTER);
		p1.add(selectButton, BorderLayout.CENTER);
		p2.add(stuIdLabel, BorderLayout.NORTH);
		p2.add(stuIddataLabel, BorderLayout.NORTH);
		p2.add(nameLabel, BorderLayout.CENTER);
		p2.add(namedataLabel, BorderLayout.CENTER);
		p2.add(creditLabel, BorderLayout.SOUTH);
		p2.add(creditField, BorderLayout.SOUTH);
		p3.add(upButton, BorderLayout.CENTER);
		p3.add(downButton, BorderLayout.CENTER);
		p3.add(yesButton, BorderLayout.CENTER);

		addcreditframe.setSize(600, 700);
		addcreditframe.setVisible(true);

		selectButton.addActionListener(this);
		upButton.addActionListener(this);
		downButton.addActionListener(this);
		yesButton.addActionListener(this);

		counumcomboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(counumlist[0])) {
						couField.setText("数据库");
					}
					if (e.getItem().equals(counumlist[1])) {
						couField.setText("C语言");
					}
					if (e.getItem().equals(counumlist[2])) {
						couField.setText("操作系统");
					}
					if (e.getItem().equals(counumlist[3])) {
						couField.setText("java");
					}
					if (e.getItem().equals(counumlist[4])) {
						couField.setText("概率论");
					}
					if (e.getItem().equals(counumlist[5])) {
						couField.setText("英语");
					}
					if (e.getItem().equals(counumlist[6])) {
						couField.setText("计算机系统基础");
					}
					if (e.getItem().equals(counumlist[7])) {
						couField.setText("大学物理");
					}
					if (e.getItem().equals(counumlist[8])) {
						couField.setText("高数上册");
					}
					if (e.getItem().equals(counumlist[9])) {
						couField.setText("高数下册");
					}
					if (e.getItem().equals(counumlist[10])) {
						couField.setText("军事理论");
					}
				}

			}
		});

	}

	private void diaoYong() {
		ResultSet result1 = null;
		ResultSet result2 = null;

		try {
			String cou = couField.getText();
			AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
			result1 = administratorDaoImpl.SelectStuBycou(cou);
//			int count = 0;
//			while (result1.next()) {
//				count++;
//			}
//			System.out.println("count="+count);
////			result1.beforeFirst();
//			if (count == 0) {
//				JOptionPane.showMessageDialog(p3, "该课程没有学生选择", "错误警告", JOptionPane.ERROR_MESSAGE);
//			} else {
			result1.last();
			count = result1.getRow();

			if (result1.absolute(row)) {
				String stuId = result1.getString(1);
				String credit = result1.getString(3);
				System.out.println("id=" + stuId);

				StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
				result2 = studentDaoImpl.FindStuById(stuId);

				result2.next();
				String name = result2.getString(2);

				stuIddataLabel.setText(stuId);
				namedataLabel.setText(name);
				creddataLabel.setText(credit);

				stuIdLabel.setVisible(true);
				stuIddataLabel.setVisible(true);
				nameLabel.setVisible(true);
				namedataLabel.setVisible(true);
				credLabel.setVisible(true);
				creddataLabel.setVisible(true);
				creditLabel.setVisible(true);
				creditField.setVisible(true);
				yesButton.setVisible(true);
				upButton.setVisible(true);
				downButton.setVisible(true);

//				}
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectButton) {
			ResultSet result = null;
			int count1 = 0;
			String cou = couField.getText();
			try {
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				result = administratorDaoImpl.SelectStuBycou(cou);
				
				while (result.next()) {
					count1++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("count1=" + count1);
//				result1.beforeFirst();
			if (count1 == 0) {
				JOptionPane.showMessageDialog(p1, "该课程没有学生选择！", "信息提示", JOptionPane.WARNING_MESSAGE);
			} else {
				diaoYong();
			}

		}
		if (e.getSource() == yesButton) {
			if (creditField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "请输入该生的学分", "错误警告", JOptionPane.ERROR_MESSAGE);
			} else {
				String cou = couField.getText();
				String id = stuIddataLabel.getText();
				String credit = creditField.getText();
				
				Stu_Name_Cou_Key stu_Name_Cou_Key = new Stu_Name_Cou_Key();
				
				stu_Name_Cou_Key.setStu_cou(cou);
				stu_Name_Cou_Key.setStu_id(id);
				stu_Name_Cou_Key.setStu_credit(credit);
				
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				administratorDaoImpl.AddCredit(stu_Name_Cou_Key);
				JOptionPane.showMessageDialog(p1, "录入该学生的分数", "信息提示", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource().equals(upButton)) {// 如果点击"上一个"按钮
			row--;// 指针值减一
			diaoYong();// 调用自定义的查询方法，以将row值引用
			downButton.setEnabled(true);
			if (row <= 1) {// 当指针值小于一时，即比所查询表的最小指针还小
				upButton.setEnabled(false);// 此时"上一个"按钮不可选中
				row = 1;// 此时指针值始终为一
			}
		}

		if (e.getSource().equals(downButton)) {// 如果点击"下一个"按钮
			row++;// 指针值加一
			diaoYong();// 调用自定义的查询方法，以将row值引用
			upButton.setEnabled(true);
			if (row >= count) {// 当指针值大于count值时，即比所查询表的最大指针还大
				row = count;// 此时指针值始终为所查询表的最大指针值count
				downButton.setEnabled(false);// 此时"上一个"按钮不可选中
			}
		}

	}
	
	public static void main(String[] args) {
		new AdmCreditForStu();
	}
	
}

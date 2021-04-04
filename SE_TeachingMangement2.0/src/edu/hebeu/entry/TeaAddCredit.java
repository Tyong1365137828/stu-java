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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class TeaAddCredit implements ActionListener {

	JFrame teaaddCreditFrame = new JFrame("教师录分");
	JTabbedPane showPanel;// 分页总面板
	JPanel p1, p2;// 用于分页
	/*
	 * 
	 * 第一页
	 * 
	 */

	JLabel classLabel;

	JLabel stuIdLabel, stuIddataLabel, creditLabel, stunameLabel, stunamedataLabel;

	JButton yesButton, upButton, downButton;

	JTextField creditField;

	JPanel p11, p12, p13, p14, p15, p16;

	String account;

	int row = 1;// 代表指针，用于获取所查表的第一条记录
	int count, count1;// 用于获取表的最大记录数

	/*
	 * 
	 * 第二页
	 * 
	 */

	JLabel classLabel2, checkLabel2;

	JLabel stuIdLabel2, stuIddataLabel2, creditLabel2, stunameLabel2, stunamedataLabel2;

	JButton yesButton2, checkButton2;

	JTextField creditField2, checkField2;

	JPanel p21, p22, p23, p24, p25, p26;

	String account2;

	public TeaAddCredit() {

		showPanel = new JTabbedPane();

		/*
		 * 第一页
		 * 
		 */

		p1 = new JPanel();

		classLabel = new JLabel("" + "课程", 10);

		stuIdLabel = new JLabel("学生学号");
		stuIddataLabel = new JLabel("", 10);
		stunameLabel = new JLabel("学生名字");
		stunamedataLabel = new JLabel("", 10);
		creditLabel = new JLabel("获得学分");

		creditField = new JTextField(10);

		yesButton = new JButton("确认");
		upButton = new JButton("上一个");
		downButton = new JButton("下一个");

		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p14 = new JPanel();
		p15 = new JPanel();
		p16 = new JPanel();

		teaaddCreditFrame.add(p1);

		p1.setLayout(new GridLayout(6, 1));

		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		p1.add(p14);
		p1.add(p15);
		p1.add(p16);

		p12.add(classLabel);
		p13.add(stuIdLabel);
		p13.add(stuIddataLabel);
		p14.add(stunameLabel);
		p14.add(stunamedataLabel);
		p15.add(creditLabel);
		p15.add(creditField);
		p15.add(yesButton);
		p16.add(upButton);
		p16.add(downButton);

		selectStu();

		showPanel.addTab("全部学生", p1);

		upButton.addActionListener(this);
		downButton.addActionListener(this);
		yesButton.addActionListener(this);

		/*
		 * 
		 * 第二页
		 * 
		 */

		p2 = new JPanel();

		classLabel2 = new JLabel("", 10);

		stuIdLabel2 = new JLabel("学生学号");
		stuIdLabel2.setVisible(false);
		stuIddataLabel2 = new JLabel("", 10);
		stunameLabel2 = new JLabel("学生名字");
		stunameLabel2.setVisible(false);
		stunamedataLabel2 = new JLabel("", 10);
		creditLabel2 = new JLabel("获得学分");
		creditLabel2.setVisible(false);
		checkLabel2 = new JLabel("输入查询的学生学号");

		creditField2 = new JTextField(10);
		creditField2.setVisible(false);
		checkField2 = new JTextField(10);

		yesButton2 = new JButton("确认");
		yesButton2.setVisible(false);
		checkButton2 = new JButton("查找");

		p21 = new JPanel();
		p22 = new JPanel();
		p23 = new JPanel();
		p24 = new JPanel();
		p25 = new JPanel();
		p26 = new JPanel();

		teaaddCreditFrame.add(p2);

		p2.setLayout(new GridLayout(6, 1));
		p2.add(p21);
		p2.add(p22);
		p2.add(p23);
		p2.add(p24);
		p2.add(p25);
		p2.add(p26);

		System.out.println("aebtbetetstrb");

		p21.add(classLabel2);
		p22.add(checkLabel2);
		p22.add(checkField2);
		p22.add(checkButton2);
		p23.add(stuIdLabel2);
		p23.add(stuIddataLabel2);
		p24.add(stunameLabel2);
		p24.add(stunamedataLabel2);
		p25.add(creditLabel2);
		p25.add(creditField2);
		p25.add(yesButton2);
		
		String teaId = "";
		ResultSet result2 = null;
		
		CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
		teaId = MemoryXianShi();
		result2 = courseDaoImpl.FindCreditByTeanumber(teaId);
		
		try {
			result2.next();
			String classes = result2.getString(2);
			
			classLabel2.setText(classes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		showPanel.addTab("查询学生", p2);
		
		checkButton2.addActionListener(this);
		yesButton2.addActionListener(this);

		/*
		 * 分页完成
		 * 
		 */

		teaaddCreditFrame.add(showPanel);
		teaaddCreditFrame.setSize(600, 700);
		teaaddCreditFrame.setVisible(true);

	}

	/*
	 * 
	 * 第一页
	 * 
	 */
	private void selectStu() {
		ResultSet result1 = null;
		ResultSet result2 = null;

		try {
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			account = MemoryXianShi();
			result1 = courseDaoImpl.FindCreditByTeanumber(account);

			result1.last();
			count = result1.getRow();

			if (result1.absolute(row)) {

				String stuId = result1.getString(1);
				String classes = result1.getString(2);

				StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
				result2 = studentDaoImpl.FindAllStudentByNumber(stuId);

				result2.next();
				String stuName = result2.getString(2);

				classLabel.setText(classes);
				stuIddataLabel.setText(stuId);
				stunamedataLabel.setText(stuName);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * 
		 * 第一页
		 * 
		 */
		if (e.getSource().equals(upButton)) {// 如果点击"上一个"按钮
			row--;// 指针值减一
			selectStu();// 调用自定义的查询方法，以将row值引用
			downButton.setEnabled(true);
			if (row <= 1) {// 当指针值小于一时，即比所查询表的最小指针还小
				upButton.setEnabled(false);// 此时"上一个"按钮不可选中
				row = 1;// 此时指针值始终为一
			}
		}

		if (e.getSource().equals(downButton)) {// 如果点击"下一个"按钮
			row++;// 指针值加一
			selectStu();// 调用自定义的查询方法，以将row值引用
			upButton.setEnabled(true);
			if (row >= count) {// 当指针值大于count值时，即比所查询表的最大指针还大
				row = count;// 此时指针值始终为所查询表的最大指针值count
				downButton.setEnabled(false);// 此时"上一个"按钮不可选中
			}
		}

		if (e.getSource() == yesButton) {
			if (creditField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p13, "请输入该生的学分", "错误警告", JOptionPane.ERROR_MESSAGE);
			} else {

				String stuId = stuIddataLabel.getText();
				String credit = creditField.getText();

				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
				courseDaoImpl.addCredit(stuId, account, credit);

				JOptionPane.showMessageDialog(p13, "成功录入该学生的分数", "信息提示", JOptionPane.WARNING_MESSAGE);
			}
		}

		/*
		 * 
		 * 第二页
		 * 
		 */

		if (e.getSource() == checkButton2) {

			String stuId = checkField2.getText();
			
			try {
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();

				ResultSet resultSet = administratorDaoImpl.JSelectStudentByNum(stuId);
				
				int count = 0;
				while(resultSet.next()) {
					count++;
				}
				if(count==0) {
					JOptionPane.showMessageDialog(p23, "查无此人", "信息提示", JOptionPane.WARNING_MESSAGE);
				}
				else {
					resultSet.beforeFirst();
					
					resultSet.next();
					String stuNam = resultSet.getString(2);
					
					stuIddataLabel2.setText(stuId);
					stunamedataLabel2.setText(stuNam);
					
					stuIdLabel2.setVisible(true);
					stunameLabel2.setVisible(true);
					creditLabel2.setVisible(true);
					creditField2.setVisible(true);
					yesButton2.setVisible(true);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		

		if (e.getSource() == yesButton2) {
			if (creditField2.getText().length() == 0) {
				JOptionPane.showMessageDialog(p23, "请输入该生的学分", "错误警告", JOptionPane.ERROR_MESSAGE);
			} else {

				String stuId = stuIddataLabel2.getText();
				String credit = creditField2.getText();
				String teaId = MemoryXianShi();
				
				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
				courseDaoImpl.addCredit(stuId, teaId, credit);

				JOptionPane.showMessageDialog(p13, "成功录入该学生的分数", "信息提示", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	String MemoryXianShi() {// 将记忆数据表的最后一条记录，即上次的一次放在accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				account = resultSet.getString(1);// 将是数据库表中的最后一条记录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

	public static void main(String[] args) {
		new TeaAddCredit();
	}

}

package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.TeacherDaoImpl;

public class AdminSelectCou implements ActionListener {

	JFrame selectFrame = new JFrame("查询学生界面");
	JTabbedPane showPanel;// 分页总面板
	JPanel p1, p2, p3;// 用于分页

	/*
	 * 
	 * 
	 * 第一页
	 * 
	 */

	String title1[] = { "课程号", "课程名", "学时", "上课地点", "考试时间", "任课教师", "任课教师id" };

	JScrollPane tableScrollPane1;// 声明一个滚动杠对象

	JTable jTable1;// 声明Jtable对象

	/*
	 * 
	 * 第二页
	 * 
	 * 
	 */

	JButton returnButton, exactButton, dimButton;

	JRadioButton nameRadioButton, numRadioButton;
	ButtonGroup group;

	JLabel accountOrNameLabel;

	JTextField textField;

	JScrollPane tableScrollPane2;// 声明一个滚动杠对象

	JTable jTable2;// 声明Jtable对象

	String title2[] = { "课程号", "课程名", "学时", "上课地点", "考试时间", "任课教师", "任课教师id" };

	JPanel p21, p22;

	JPanel p211, p212, p213, p214, p215;

	/*
	 * 
	 * 第三页
	 * 
	 */
	JLabel classLabel3;

	JTextField textField3;

	JButton checkButton3;

	JScrollPane tableScrollPane3;// 声明一个滚动杠对象

	JTable jTable3;// 声明Jtable对象

	String[] counumlist;
	JComboBox<String> counumcomboBox = null;//

	String title3[] = { "课程号", "课程名", "学时", "上课地点", "考试时间", "任课教师", "任课教师id" };

	JPanel p31, p32;

	JPanel p311, p312, p313;

	public AdminSelectCou() {
		showPanel = new JTabbedPane();
		/*
		 * 
		 * 第一页
		 * 
		 */

		p2 = new JPanel();

		p21 = new JPanel();
		p22 = new JPanel();

		p211 = new JPanel();
		p212 = new JPanel();
		p213 = new JPanel();
		p214 = new JPanel();
		p215 = new JPanel();

		returnButton = new JButton("返回");
		exactButton = new JButton("精确查找");
		dimButton = new JButton("类似查找");

		nameRadioButton = new JRadioButton("教师名查找课程");
		numRadioButton = new JRadioButton("教师id查找课程");

		group = new ButtonGroup();// 将stu,tea,adm放入ButtonGroup的对象group中,并使这3个JRadioButton只能选一个
		group.add(nameRadioButton);
		group.add(numRadioButton);
		nameRadioButton.setSelected(true);

		accountOrNameLabel = new JLabel("输入教师名字或id");

		textField = new JTextField(18);

		selectFrame.add(p2);

		p2.setLayout(new GridLayout(2, 1));
		p2.add(p21);
		p2.add(p22);

		p21.setLayout(new GridLayout(5, 1));
		p21.add(p211);
		p21.add(p212);
		p21.add(p213);
		p21.add(p214);
		p21.add(p215);

		p211.add(returnButton);
		p212.add(nameRadioButton);
		p212.add(numRadioButton);
		p213.add(accountOrNameLabel);
		p213.add(textField);
		p214.add(dimButton);
		p214.add(exactButton);

		showPanel.addTab("由教师查课", p2);

		returnButton.addActionListener(this);
		dimButton.addActionListener(this);
		exactButton.addActionListener(this);

		/*
		 * 
		 * 第二页
		 * 
		 */
		p1 = new JPanel();

		tableScrollPane1 = new JScrollPane();
		jTable1 = new JTable();

		selectFrame.add(p1);

		p1.setLayout(new GridLayout(1, 1));

		pagetwo();

		showPanel.addTab("全部课程", p1);

		/*
		 * 
		 * 第三页
		 * 
		 */

		p3 = new JPanel();
		
		p31 = new JPanel();
		p32 = new JPanel();
		
		p311 = new JPanel();
		p312 = new JPanel();
		p313 = new JPanel();
		
		classLabel3 = new JLabel("课程名");

		checkButton3 = new JButton("查询");

		textField3 = new JTextField("请选择", 8);
		textField3.setEnabled(false);

		counumlist = new String[] { "请选择", "01<Java>", "02<C语言>", "03<操作系统>", "04<数据库>", "05<概率论>", "06<英语>",
				"07<计算机系统基础>", "08<大学物理>", "09<高数上册>", "10<高数下册>", "11<军事理论>", "12<离散数学>", "13<大学体育>" };
		counumcomboBox = new JComboBox<String>(counumlist);
		counumcomboBox.setSelectedIndex(0);

		p3.setLayout(new GridLayout(2, 1));
		p3.add(p31);
		p3.add(p32);

		p31.setLayout(new GridLayout(3, 1));
		p31.add(p311);
		p31.add(p312);
		p31.add(p313);

		p312.add(classLabel3);
		p312.add(counumcomboBox);
		p312.add(textField3);
		p312.add(checkButton3);

		selectFrame.add(p3);

		showPanel.addTab("课程查找", p3);

		counumcomboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(counumlist[0])) {
						textField3.setText("请选择");
					}
					if (e.getItem().equals(counumlist[1])) {
						textField3.setText("Java");
					}
					if (e.getItem().equals(counumlist[2])) {
						textField3.setText("C语言");
					}
					if (e.getItem().equals(counumlist[3])) {
						textField3.setText("操作系统");
					}
					if (e.getItem().equals(counumlist[4])) {
						textField3.setText("数据库");
					}
					if (e.getItem().equals(counumlist[5])) {
						textField3.setText("概率论");
					}
					if (e.getItem().equals(counumlist[6])) {
						textField3.setText("英语");
					}
					if (e.getItem().equals(counumlist[7])) {
						textField3.setText("计算机系统基础");
					}
					if (e.getItem().equals(counumlist[8])) {
						textField3.setText("大学物理");
					}
					if (e.getItem().equals(counumlist[9])) {
						textField3.setText("高数上册");
					}
					if (e.getItem().equals(counumlist[10])) {
						textField3.setText("高数下册");
					}
					if (e.getItem().equals(counumlist[11])) {
						textField3.setText("军事理论");
					}
					if (e.getItem().equals(counumlist[12])) {
						textField3.setText("离散数学");
					}
					if (e.getItem().equals(counumlist[13])) {
						textField3.setText("大学体育");
					}

				}
			}
		});
		
		checkButton3.addActionListener(this);

		/*
		 * 
		 * 分页完成
		 * 
		 */
		selectFrame.add(showPanel);
		selectFrame.setSize(900, 800);
		selectFrame.setVisible(true);

		System.out.println("wdwgrdsrszdfb");

	}

	// 第二页
	private void pagetwo() {

		ResultSet resultSet = null;

		try {
			AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
			resultSet = administratorDaoImpl.SelectAllCou();

			int count = 0;
			while (resultSet.next()) {
				count++;
			}
			resultSet.beforeFirst();

			Object[][] info = new Object[count][7];
			System.out.println("count=" + count);
			count = 0;// count归0
			while (resultSet.next()) {
				info[count][0] = resultSet.getString(1);
				info[count][1] = resultSet.getString(2);
				info[count][2] = resultSet.getString(3);
				info[count][3] = resultSet.getString(4);
				info[count][4] = resultSet.getString(5);
				info[count][6] = resultSet.getString(6);

				String teaId = resultSet.getString(6);
				TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();

				ResultSet resultSet2 = teacherDaoImpl.SelectTea(teaId);
				resultSet2.next();
				info[count][5] = resultSet2.getString(2);

				count++;
			}
			jTable1 = new JTable(info, title1);
			jTable1.getTableHeader();

			// 将JTable加入到带滚动条的面板中
			tableScrollPane1.getViewport().add(jTable1);
			p1.add(tableScrollPane1);
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
		if (e.getSource() == returnButton) {
			selectFrame.dispose();
		}

		if (e.getSource() == exactButton) {// 如果选择了精确查询

			if (textField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p21, "输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (numRadioButton.isSelected() && textField.getText().length() != 0) {// 用教师id查询
				tableScrollPane2 = new JScrollPane();
				tableScrollPane2.setBounds(0, 0, 900, 1000);

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					String number = textField.getText();

					ResultSet resultSet = administratorDaoImpl.JSelectCouByTeaNum(number);

					int count = 0;
					while (resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();

					Object[][] info = new Object[count][7];
					System.out.println("count=" + count);
					count = 0;// count归0
					while (resultSet.next()) {
						info[count][0] = resultSet.getString(1);
						info[count][1] = resultSet.getString(2);
						info[count][2] = resultSet.getString(3);
						info[count][3] = resultSet.getString(4);
						info[count][4] = resultSet.getString(5);
						info[count][6] = resultSet.getString(6);

						String stuId = resultSet.getString(6);
						TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
						ResultSet resultSet2 = teacherDaoImpl.SelectTea(stuId);

						resultSet2.next();
						info[count][5] = resultSet2.getString(2);
						count++;
					}
					jTable2 = new JTable(info, title2);
					jTable2.getTableHeader();

					// 将JTable加入到带滚动条的面板中
					tableScrollPane2.getViewport().add(jTable2);
					p22.add(tableScrollPane2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			else if (nameRadioButton.isSelected() && textField.getText().length() != 0) {// 用教师id查询
				tableScrollPane2 = new JScrollPane();
				tableScrollPane2.setBounds(0, 0, 900, 1000);

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					String name = textField.getText();

					ResultSet resultSet = administratorDaoImpl.JSelectTeaByNam(name);

					int count = 0;
					while (resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();

					Object[][] info = new Object[count][7];
					count = 0;// count归0
					while (resultSet.next()) {

						String teaId = resultSet.getString(1);
						System.out.println("teaId=" + teaId);

						AdministratorDaoImpl administratorDaoImpl2 = new AdministratorDaoImpl();
						ResultSet resultSet2 = administratorDaoImpl2.JSelectCouByTeaNum(teaId);

						resultSet2.next();
						info[count][0] = resultSet2.getString(1);
						info[count][1] = resultSet2.getString(2);
						info[count][2] = resultSet2.getString(3);
						info[count][3] = resultSet2.getString(4);
						info[count][4] = resultSet2.getString(5);
						info[count][5] = resultSet.getString(2);
						info[count][6] = resultSet2.getString(6);

						count++;
					}
					jTable2 = new JTable(info, title2);
					jTable2.getTableHeader();

					// 将JTable加入到带滚动条的面板中
					tableScrollPane2.getViewport().add(jTable2);
					p22.add(tableScrollPane2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		if (e.getSource() == dimButton) {// 如果点击了模糊查询按钮

			if (textField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p21, "输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (numRadioButton.isSelected() && textField.getText().length() != 0) {// 用教师id查询
				tableScrollPane2 = new JScrollPane();
				tableScrollPane2.setBounds(0, 0, 900, 1000);

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					String number = textField.getText();

					ResultSet resultSet = administratorDaoImpl.SelectCouByTeaNum(number);

					int count = 0;
					while (resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();

					Object[][] info = new Object[count][7];
					System.out.println("count=" + count);
					count = 0;// count归0
					while (resultSet.next()) {
						info[count][0] = resultSet.getString(1);
						info[count][1] = resultSet.getString(2);
						info[count][2] = resultSet.getString(3);
						info[count][3] = resultSet.getString(4);
						info[count][4] = resultSet.getString(5);
						info[count][6] = resultSet.getString(6);

						String stuId = resultSet.getString(6);
						TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
						ResultSet resultSet2 = teacherDaoImpl.SelectTea(stuId);

						resultSet2.next();
						info[count][5] = resultSet2.getString(2);
						count++;
					}
					jTable2 = new JTable(info, title2);
					jTable2.getTableHeader();

					// 将JTable加入到带滚动条的面板中
					tableScrollPane2.getViewport().add(jTable2);
					p22.add(tableScrollPane2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			else if (nameRadioButton.isSelected() && textField.getText().length() != 0) {// 用教师id查询
				tableScrollPane2 = new JScrollPane();
				tableScrollPane2.setBounds(0, 0, 900, 1000);

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					String name = textField.getText();

					ResultSet resultSet = administratorDaoImpl.SelectTeaByNam(name);

					int count = 0;
					while (resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();

					Object[][] info = new Object[count][7];
					count = 0;// count归0
					while (resultSet.next()) {

						String teaId = resultSet.getString(1);
						System.out.println("teaId=" + teaId);

						AdministratorDaoImpl administratorDaoImpl2 = new AdministratorDaoImpl();
						ResultSet resultSet2 = administratorDaoImpl2.JSelectCouByTeaNum(teaId);

						resultSet2.next();
						info[count][0] = resultSet2.getString(1);
						info[count][1] = resultSet2.getString(2);
						info[count][2] = resultSet2.getString(3);
						info[count][3] = resultSet2.getString(4);
						info[count][4] = resultSet2.getString(5);
						info[count][5] = resultSet.getString(2);
						info[count][6] = resultSet2.getString(6);
						
						count++;
					}
					jTable2 = new JTable(info, title2);
					jTable2.getTableHeader();

					// 将JTable加入到带滚动条的面板中
					tableScrollPane2.getViewport().add(jTable2);
					p22.add(tableScrollPane2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		/*
		 * 
		 * 第三页
		 * 
		 */
		if (e.getSource() == checkButton3) {
			if (textField3.getText().equals("请选择")) {
				JOptionPane.showMessageDialog(p3, "请选择所查课", "错误警告", JOptionPane.ERROR_MESSAGE);
			} else {
				
				tableScrollPane3 = new JScrollPane();
				tableScrollPane3.setBounds(0, 0, 900, 1000);
				
				String cou = textField3.getText();

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					ResultSet resultSet = administratorDaoImpl.SelectByCou(cou);
					
					int count =0;
					while (resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();
					System.out.println("counttt="+count);
					
					Object[][] info = new Object[count][7];
					count = 0;// count归0
					while(resultSet.next()) {
						info[count][0] = resultSet.getString(1);
						info[count][1] = resultSet.getString(2);
						info[count][2] = resultSet.getString(3);
						info[count][3] = resultSet.getString(4);
						info[count][4] = resultSet.getString(5);
						info[count][6] = resultSet.getString(6);
						
						String stuId = resultSet.getString(6);
						TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
						ResultSet resultSet2 = teacherDaoImpl.SelectTea(stuId);
						resultSet2.next();
						info[count][5] = resultSet2.getString(2);
						System.out.println("stuId="+stuId);
						
						count++;
					}
					jTable3 = new JTable(info, title3);
					jTable3.getTableHeader();
					
					// 将JTable加入到带滚动条的面板中
					System.out.println("aswdsfdffqwerg");
					tableScrollPane3.getViewport().add(jTable3);
					p32.add(tableScrollPane3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

	public static void main(String[] args) {
		new AdminSelectCou();
	}

}

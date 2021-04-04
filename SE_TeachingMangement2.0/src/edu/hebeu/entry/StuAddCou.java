package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class StuAddCou implements ActionListener {

	JFrame addcouFrame = new JFrame("添加课程界面");

	JTabbedPane showPanel;// 分页总面板

	JPanel p1, p2, p3;// 用于分页

	/*
	 * 
	 * 第一页
	 * 
	 */
	JPanel p11, p12, p13, p14, p15, p16, p17;

	JLabel couLabel, coudataLabel, teaidLabel, teaiddataLabel, teaLabel, teadataLabel, placeLabel, placedataLabel,
			periodLabel, perioddataLabel;

	JButton addButton, upButton, downButton;

	/*
	 * 
	 * 第二页
	 * 
	 */

	JPanel p21, p22, p23, p24, p25, p26, p27, p28;

	JLabel checkLabel2, couLabel2, coudataLabel2, teaidLabel2, teaiddataLabel2, teaLabel2, teadataLabel2, placeLabel2,
			placedataLabel2, periodLabel2, perioddataLabel2;

	JTextField checkField2;
	
	JButton addButton2, upButton2, downButton2, check2Button;
	
	JRadioButton nameRadioButton, idRadioButton;
	ButtonGroup group;
	
	/*
	 * 
	 * 第三页
	 * 
	 */
	JPanel p31, p32, p33, p34, p35, p36, p37, p38;

	JLabel checkLabel3, couLabel3, coudataLabel3, teaidLabel3, teaiddataLabel3, teaLabel3, teadataLabel3, placeLabel3,
			placedataLabel3, periodLabel3, perioddataLabel3;

	JButton addButton3, upButton3, downButton3, check3Button;

	JTextField checkField3;

	String[] coulist;
	JComboBox<String> coucomboBox = null;// 用于生成下拉框

	int count;
	int row = 1;

	int count2;
	int row2 = 1;

	int count3;
	int row3 = 1;

	/**
	 * 
	 */
	public StuAddCou() {

		showPanel = new JTabbedPane();

		/*
		 * 第一页
		 * 
		 */

		p1 = new JPanel();
		
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p14 = new JPanel();
		p15 = new JPanel();
		p16 = new JPanel();
		p17 = new JPanel();

		couLabel = new JLabel("课程");
		coudataLabel = new JLabel("", 10);
		teaLabel = new JLabel("教师");
		teadataLabel = new JLabel("", 10);
		teaidLabel = new JLabel("教师id号");
		teaiddataLabel = new JLabel("", 10);
		placeLabel = new JLabel("地点");
		placedataLabel = new JLabel("", 10);
		periodLabel = new JLabel("课时");
		perioddataLabel = new JLabel("", 10);

		addButton = new JButton("添加课程");
		upButton = new JButton("上一个");
		downButton = new JButton("下一个");

		addcouFrame.add(p1);

		p1.setLayout(new GridLayout(7, 1));
		
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		p1.add(p14);
		p1.add(p15);
		p1.add(p16);
		p1.add(p17);
		
		p12.add(couLabel);
		p12.add(coudataLabel);
		p13.add(teaLabel);
		p13.add(teadataLabel);
		p14.add(teaidLabel);
		p14.add(teaiddataLabel);
		p15.add(placeLabel);
		p15.add(placedataLabel);
		p16.add(periodLabel);
		p16.add(perioddataLabel);
		p17.add(upButton);
		p17.add(downButton);
		p17.add(addButton);

		chaXun1();// p1的

		showPanel.addTab("全部课程", p1);// 以p1，p2进行分页

		upButton.addActionListener(this);
		downButton.addActionListener(this);
		addButton.addActionListener(this);

		/*
		 * 第二页
		 * 
		 */

		p2 = new JPanel();

		p21 = new JPanel();
		p22 = new JPanel();
		p23 = new JPanel();
		p24 = new JPanel();
		p25 = new JPanel();
		p26 = new JPanel();
		p27 = new JPanel();
		p28 = new JPanel();

		checkLabel2 = new JLabel("查询的教师");
		couLabel2 = new JLabel("课程");
		couLabel2.setVisible(false);
		coudataLabel2 = new JLabel("", 10);
		coudataLabel2.setVisible(false);
		teaidLabel2 = new JLabel("教师id号");
		teaidLabel2.setVisible(false);
		teaiddataLabel2 = new JLabel("", 10);
		teaiddataLabel2.setVisible(false);
		teaLabel2 = new JLabel("教师");
		teaLabel2.setVisible(false);
		teadataLabel2 = new JLabel("", 10);
		teadataLabel2.setVisible(false);
		placeLabel2 = new JLabel("地点");
		placeLabel2.setVisible(false);
		placedataLabel2 = new JLabel("", 10);
		placedataLabel2.setVisible(false);
		periodLabel2 = new JLabel("课时");
		periodLabel2.setVisible(false);
		perioddataLabel2 = new JLabel("", 10);
		perioddataLabel2.setVisible(false);

		addButton2 = new JButton("添加课程");
		addButton2.setVisible(false);
		upButton2 = new JButton("上一个");
		upButton2.setVisible(false);
		downButton2 = new JButton("下一个");
		downButton2.setVisible(false);
		check2Button = new JButton("查询");

		checkField2 = new JTextField(15);

		nameRadioButton = new JRadioButton("教师名");
		idRadioButton = new JRadioButton("教师id");

		group = new ButtonGroup();// 将stu,tea,adm放入ButtonGroup的对象group中,并使这3个JRadioButton只能选一个
		group.add(nameRadioButton);
		group.add(idRadioButton);
		nameRadioButton.setSelected(true);

		addcouFrame.add(p2);

		p2.setLayout(new GridLayout(8, 1));

		p2.add(p21);
		p2.add(p22);
		p2.add(p23);
		p2.add(p24);
		p2.add(p25);
		p2.add(p26);
		p2.add(p27);
		p2.add(p28);

		p21.add(nameRadioButton);
		p21.add(idRadioButton);
		p22.add(checkLabel2);
		p22.add(checkField2);
		p22.add(check2Button);
		p23.add(couLabel2);
		p23.add(coudataLabel2);
		p24.add(teaLabel2);
		p24.add(teadataLabel2);
		p25.add(placeLabel2);
		p25.add(placedataLabel2);
		p26.add(periodLabel2);
		p26.add(perioddataLabel2);
		p27.add(upButton2);
		p27.add(downButton2);
		p27.add(addButton2);

//		chaXun2();// p2的

		showPanel.addTab("查询课程", p2);// p2分页

		upButton2.addActionListener(this);
		downButton2.addActionListener(this);
		addButton2.addActionListener(this);
		check2Button.addActionListener(this);

		/*
		 * 
		 * 第三页
		 * 
		 */
		p3 = new JPanel();

		p31 = new JPanel();
		p32 = new JPanel();
		p33 = new JPanel();
		p34 = new JPanel();
		p35 = new JPanel();
		p36 = new JPanel();
		p37 = new JPanel();
		p38 = new JPanel();

		checkLabel3 = new JLabel("查询的课程");
		couLabel3 = new JLabel("课程");
		couLabel3.setVisible(false);
		coudataLabel3 = new JLabel("", 10);
		coudataLabel3.setVisible(false);
		teaidLabel3 = new JLabel("教师id号");
		teaidLabel3.setVisible(false);
		teaiddataLabel3 = new JLabel("", 10);
		teaiddataLabel3.setVisible(false);
		teaLabel3 = new JLabel("教师");
		teaLabel3.setVisible(false);
		teadataLabel3 = new JLabel("", 10);
		teadataLabel3.setVisible(false);
		placeLabel3 = new JLabel("地点");
		placeLabel3.setVisible(false);
		placedataLabel3 = new JLabel("", 10);
		placedataLabel3.setVisible(false);
		periodLabel3 = new JLabel("课时");
		periodLabel3.setVisible(false);
		perioddataLabel3 = new JLabel("", 10);
		perioddataLabel3.setVisible(false);

		addButton3 = new JButton("添加课程");
		addButton3.setVisible(false);
		upButton3 = new JButton("上一个");
		upButton3.setVisible(false);
		downButton3 = new JButton("下一个");
		downButton3.setVisible(false);
		check3Button = new JButton("查询");

		checkField3 = new JTextField("", 10);
		checkField3.setEnabled(false);

		coulist = new String[] { "请选择", "C语言", "Java", "操作系统", "数据库", "概率论", "英语", "计算机系统基础", "大学物理", "高数上册", "高数下册",
				"军事理论" ,"离散数学" ,"大学体育"};
		coucomboBox = new JComboBox<String>(coulist);
		coucomboBox.setSelectedIndex(0);

		addcouFrame.add(p3);

		p3.setLayout(new GridLayout(8, 1));

		p3.add(p31);
		p3.add(p32);
		p3.add(p33);
		p3.add(p34);
		p3.add(p35);
		p3.add(p36);
		p3.add(p37);
		p3.add(p38);

		p32.add(checkLabel3);
		p32.add(coucomboBox);
		p32.add(checkField3);
		p32.add(check3Button);
		p33.add(couLabel3);
		p33.add(coudataLabel3);
		p34.add(teaLabel3);
		p34.add(teadataLabel3);
		p35.add(placeLabel3);
		p35.add(placedataLabel3);
		p36.add(periodLabel3);
		p36.add(perioddataLabel3);
		p37.add(upButton3);
		p37.add(downButton3);
		p37.add(addButton3);

		showPanel.addTab("搜索课程", p3);

		coucomboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(coulist[0])) {
						checkField3.setText("请选择");
					}
					if (e.getItem().equals(coulist[1])) {
						checkField3.setText("C语言");
					}
					if (e.getItem().equals(coulist[2])) {
						checkField3.setText("Java");
					}
					if (e.getItem().equals(coulist[3])) {
						checkField3.setText("操作系统");
					}
					if (e.getItem().equals(coulist[4])) {
						checkField3.setText("数据库");
					}
					if (e.getItem().equals(coulist[5])) {
						checkField3.setText("概率论");
					}
					if (e.getItem().equals(coulist[6])) {
						checkField3.setText("英语");
					}
					if (e.getItem().equals(coulist[7])) {
						checkField3.setText("计算机系统基础");
					}
					if (e.getItem().equals(coulist[8])) {
						checkField3.setText("大学物理");
					}
					if (e.getItem().equals(coulist[9])) {
						checkField3.setText("高数上册");
					}
					if (e.getItem().equals(coulist[10])) {
						checkField3.setText("高数下册");
					}
					if (e.getItem().equals(coulist[11])) {
						checkField3.setText("军事理论");
					}
					if (e.getItem().equals(coulist[12])) {
						checkField3.setText("离散数学");
					}
					if (e.getItem().equals(coulist[13])) {
						checkField3.setText("大学体育");
					}
				}
			}
		});

		upButton3.addActionListener(this);
		downButton3.addActionListener(this);
		addButton3.addActionListener(this);
		check3Button.addActionListener(this);

		/*
		 * 
		 * 分页完成
		 * 
		 */

		addcouFrame.add(showPanel);
		addcouFrame.setSize(600, 700);

		addcouFrame.setVisible(true);

	}

	// 第一页使用的方法
	private void chaXun1() {
		ResultSet resultSet = null;

		try {
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			
			resultSet = courseDaoImpl.SelectCou();
			resultSet.last();
			count = resultSet.getRow();

			if (resultSet.absolute(row)) {
				String coures = resultSet.getString(2);
				String period = resultSet.getString(3);
				String place = resultSet.getString(4);
				String teaId = resultSet.getString(6);

				ResultSet resultSet2 = null;
				String sql = "select * from teacher where tea_id='" + teaId + "'";
				GetConn getConn = new GetConn();
				Connection connection = getConn.getConnection();
				Statement statement = connection.createStatement();
				resultSet2 = statement.executeQuery(sql);

				resultSet2.next();
				String teacher = resultSet2.getString(2);

				coudataLabel.setText(coures);
				perioddataLabel.setText(period);
				placedataLabel.setText(place);
				teadataLabel.setText(teacher);
				teaiddataLabel.setText(teaId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 第二页使用的方法
	private void chaXun2() {
		String teanam = "";
		String teaId = "";

		if (idRadioButton.isSelected()) {
			ResultSet resultSet = null;

			try {
				teaId = checkField2.getText();

				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
				resultSet = courseDaoImpl.FindCouInformationByTea(teaId);

				resultSet.last();
				count2 = resultSet.getRow();
				System.out.println("count2=" + count2);
				if (count2 == 0) {
					JOptionPane.showMessageDialog(p23, "该教师没有课程", "信息提示", JOptionPane.WARNING_MESSAGE);
				} else {
					if (resultSet.absolute(row2)) {
						String coures = resultSet.getString(2);
						String period = resultSet.getString(3);
						String place = resultSet.getString(4);

						ResultSet resultSet12 = null;
						System.out.println("cfyfyghvg");
						String sql = "select * from teacher where tea_id='" + teaId + "'";
						GetConn getConn = new GetConn();
						Connection connection = getConn.getConnection();
						Statement statement = connection.createStatement();
						resultSet12 = statement.executeQuery(sql);

						resultSet12.next();
						String teacher = resultSet12.getString(2);

						System.out.println("ctrfgfhygh" + teacher);

						coudataLabel2.setText(coures);
						perioddataLabel2.setText(period);
						placedataLabel2.setText(place);
						teadataLabel2.setText(teacher);
						teaiddataLabel2.setText(teaId);

						couLabel2.setVisible(true);
						coudataLabel2.setVisible(true);
						periodLabel2.setVisible(true);
						perioddataLabel2.setVisible(true);
						placeLabel2.setVisible(true);
						placedataLabel2.setVisible(true);
						teaLabel2.setVisible(true);
						teadataLabel2.setVisible(true);
						teaidLabel2.setVisible(true);
						teaiddataLabel2.setVisible(true);
						upButton2.setVisible(true);
						downButton2.setVisible(true);
						addButton2.setVisible(true);

					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (nameRadioButton.isSelected()) {
			ResultSet resultSet21 = null;
			ResultSet resultSet22 = null;

			try {
				teanam = checkField2.getText();

				GetConn getConn21 = new GetConn();
				Connection connection21 = getConn21.getConnection();
				Statement statement21 = connection21.createStatement();

				String sql = "select * from teacher where tea_name='" + teanam + "'";
				resultSet21 = statement21.executeQuery(sql);
				int count21 = 0;
				resultSet21.next();
				count21 = resultSet21.getRow();
				if (count21 != 0) {

					String teaId21 = resultSet21.getString(1);

					CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
					resultSet22 = courseDaoImpl.FindCouInformationByTea(teaId21);
					System.out.println("wdaebrfbgs");
					
					resultSet22.last();
					count2 = resultSet22.getRow();
					System.out.println("count2=" + count2);
					if (resultSet22.absolute(row2)) {
						String coures2 = resultSet22.getString(2);
						String period2 = resultSet22.getString(3);
						String place2 = resultSet22.getString(4);

						coudataLabel2.setText(coures2);
						perioddataLabel2.setText(period2);
						placedataLabel2.setText(place2);
						teadataLabel2.setText(teanam);
						teaiddataLabel2.setText(teaId21);

						couLabel2.setVisible(true);
						coudataLabel2.setVisible(true);
						periodLabel2.setVisible(true);
						perioddataLabel2.setVisible(true);
						placeLabel2.setVisible(true);
						placedataLabel2.setVisible(true);
						teaLabel2.setVisible(true);
						teadataLabel2.setVisible(true);
						teaidLabel2.setVisible(true);
						teaiddataLabel2.setVisible(true);
						upButton2.setVisible(true);
						downButton2.setVisible(true);
						addButton2.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "没有该教师", "信息提示", JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	//
	private void chaXun3() {

		ResultSet resultSet = null;

		String coures = checkField3.getText();

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();

			String sql = "select * from courseinfromation where couin_name ='" + coures + "'";
			Statement statement;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			resultSet.last();
			count3 = resultSet.getRow();
			if (resultSet.absolute(row3)) {
				String period = resultSet.getString(3);
				String place = resultSet.getString(4);
				String teaId = resultSet.getString(6);
				
				ResultSet resultSet2 = null;
				String sql2 = "select * from teacher where tea_id='" + teaId + "'";
				GetConn getConn2 = new GetConn();
				Connection connection2 = getConn2.getConnection();
				Statement statement2 = connection2.createStatement();
				
				resultSet2 = statement2.executeQuery(sql2);
				
				resultSet2.next();
				String teacher = resultSet2.getString(2);
				
				coudataLabel3.setText(coures);
				perioddataLabel3.setText(period);
				placedataLabel3.setText(place);
				teadataLabel3.setText(teacher);
				teaiddataLabel3.setText(teaId);

				couLabel3.setVisible(true);
				coudataLabel3.setVisible(true);
				periodLabel3.setVisible(true);
				perioddataLabel3.setVisible(true);
				placeLabel3.setVisible(true);
				placedataLabel3.setVisible(true);
				teaLabel3.setVisible(true);
				teadataLabel3.setVisible(true);
				teaidLabel3.setVisible(true);
				teaiddataLabel3.setVisible(true);
				upButton3.setVisible(true);
				downButton3.setVisible(true);
				addButton3.setVisible(true);
				
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
		 * 第一页的监听
		 * 
		 */
		if (e.getSource() == upButton) {
			row--;
			chaXun1();
			downButton.setEnabled(true);
			if (row <= 1) {
				upButton.setEnabled(false);
				row = 1;
			}
		}

		if (e.getSource() == downButton) {
			row++;
			chaXun1();
			upButton.setEnabled(true);
			if (row >= count) {
				row = count;
				downButton.setEnabled(false);
			}
		}
		if (e.getSource() == addButton) {
			String coures = coudataLabel.getText();
			String account = MemoryXianShi();
			String teaId = teaiddataLabel.getText();
			int count = 0;

			try {
				GetConn getConn = new GetConn();
				Connection connection = getConn.getConnection();
				String sql = "select * from credit where stu_id ='" + account + "'" + "and cou ='" + coures + "'";
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					count++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;

			if (count == 0) {
				CourseDaoImpl courseDaoImpl2 = new CourseDaoImpl();
				courseDaoImpl2.InsertCou(account, coures, teaId);
				JOptionPane.showMessageDialog(p13, "'" + account + "'同学,你的课程' " + coures + "'添加成功！！！", "信息提示",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(p13, "你已选择了这门课，不可重复选择", "错误警告", JOptionPane.ERROR_MESSAGE);
			}

		}

		/*
		 * 
		 * 第二页的监听
		 * 
		 */
		if (e.getSource() == check2Button) {
			if (checkField2.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else {
				chaXun2();
			}
		}

		if (e.getSource() == upButton2) {
			row2--;
			chaXun2();
			downButton2.setEnabled(true);
			if (row2 <= 1) {
				upButton2.setEnabled(false);
				row2 = 1;
			}
		}

		if (e.getSource() == downButton2) {
			row2++;
			chaXun2();
			upButton2.setEnabled(true);
			if (row2 >= count2) {
				row2 = count2;
				downButton2.setEnabled(false);
			}
		}
		if (e.getSource() == addButton2) {
			String coures = coudataLabel2.getText();
			String account = MemoryXianShi();
			String teaId = teaiddataLabel2.getText();

			int count = 0;

			try {
				GetConn getConn = new GetConn();
				Connection connection = getConn.getConnection();
				String sql = "select * from credit where stu_id ='" + account + "'" + "and cou ='" + coures + "'";
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					count++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;

			if (count == 0) {
				CourseDaoImpl courseDaoImpl2 = new CourseDaoImpl();
				courseDaoImpl2.InsertCou(account, coures, teaId);
				JOptionPane.showMessageDialog(p23, "'" + account + "'同学,你的课程' " + coures + "'添加成功！！！", "信息提示",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(p23, "你已选择了这门课，不可重复选择", "错误警告", JOptionPane.ERROR_MESSAGE);
			}

		}

		/*
		 * 
		 * 第三页的监听
		 * 
		 */
		if (e.getSource() == check3Button) {
			if (checkField3.getText().equals("请选择")) {
				JOptionPane.showMessageDialog(p3, "请选择课程！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else {
				chaXun3();
			}
		}

		if (e.getSource() == upButton3) {
			row3--;
			chaXun3();
			downButton3.setEnabled(true);
			if (row3 <= 1) {
				upButton3.setEnabled(false);
				row3 = 1;
			}
		}

		if (e.getSource() == downButton3) {
			row3++;
			chaXun3();
			upButton3.setEnabled(true);
			if (row3 >= count3) {
				row3 = count3;
				downButton3.setEnabled(false);
			}
		}
		if (e.getSource() == addButton3) {
			String coures = coudataLabel3.getText();
			String account = MemoryXianShi();
			String teaId = teaiddataLabel3.getText();

			int count = 0;

			try {
				GetConn getConn = new GetConn();
				Connection connection = getConn.getConnection();
				String sql = "select * from credit where stu_id ='" + account + "'" + "and cou ='" + coures + "'";
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					count++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;

			if (count == 0) {
				CourseDaoImpl courseDaoImpl2 = new CourseDaoImpl();
				courseDaoImpl2.InsertCou(account, coures, teaId);
				JOptionPane.showMessageDialog(p23, "'" + account + "'同学,你的课程' " + coures + "'添加成功！！！", "信息提示",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(p23, "你已选择了这门课，不可重复选择", "错误警告", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	public static void main(String[] args) {
		new StuAddCou();
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

}

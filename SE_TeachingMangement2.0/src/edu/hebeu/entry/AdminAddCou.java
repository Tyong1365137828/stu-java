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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.po.CouInformination;

public class AdminAddCou implements ActionListener {

	JFrame adminAddCouFrame = new JFrame("任课界面");
	JTabbedPane showPane;
	JPanel p1, p2;

	/*
	 * 
	 * 
	 * 第一页
	 * 
	 */

	JPanel p11, p12, p13;
//	,p14,p15;

	JPanel p111, p112, p113;

	JPanel p121, p122, p123, p124, p125;

	JPanel p131, p132;

	JLabel teaIdLabel, teaNamLabel, teaIddataLabel, teaNamdataLabel, couLabel, couidLabel, coutestLabel, couperiodLabel,
			couplaceLabel;

	JTextField couField, couidField, couplaceField, couperiodField, coutestField;

	JButton yesButton, upButton, downButton;

	String[] couList;
	JComboBox<String> jComboBox = null;

	int count;
	int row = 1;

	public AdminAddCou() {

		showPane = new JTabbedPane();

		/*
		 * 
		 * 
		 * 第一页
		 * 
		 */
		p1 = new JPanel();

		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
//		p14 = new JPanel();
//		p15 = new JPanel();

		p111 = new JPanel();
		p112 = new JPanel();
		p113 = new JPanel();

		p121 = new JPanel();
		p122 = new JPanel();
		p123 = new JPanel();
		p124 = new JPanel();
		p125 = new JPanel();

		p131 = new JPanel();
		p132 = new JPanel();

		teaIdLabel = new JLabel("任课教师Id");
		teaNamLabel = new JLabel("任课教师姓名");
		couLabel = new JLabel("新建的课程名");
		couidLabel = new JLabel("课程号");
		couperiodLabel = new JLabel("学时");
		couplaceLabel = new JLabel("上课地点");
		coutestLabel = new JLabel("上课时间");

		teaIddataLabel = new JLabel("", 10);
		teaNamdataLabel = new JLabel("", 10);

		couField = new JTextField("请选择");
		couField.setEnabled(false);
		couidField = new JTextField(10);
		couidField.setEnabled(false);
		coutestField = new JTextField(10);
		couplaceField = new JTextField(10);
		couperiodField = new JTextField(10);

		yesButton = new JButton("确认");
		upButton = new JButton("上一个");
		downButton = new JButton("下一个");

		couList = new String[] { "请选择", "Java", "C语言", "操作系统", "数据库", "概率论", "英语", "计算机系统基础", "大学物理", "高数上册", "高数下册",
				"军事理论", "离散数学", "大学体育" };
		jComboBox = new JComboBox<String>(couList);
		jComboBox.setSelectedIndex(0);

		adminAddCouFrame.add(p1);

		p1.setLayout(new GridLayout(3, 1));
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
//		p1.add(p14);
//		p1.add(p15);

		p11.setLayout(new GridLayout(3, 1));
		p11.add(p111);
		p11.add(p112);
		p11.add(p113);

		p12.setLayout(new GridLayout(5, 1));
		p12.add(p121);
		p12.add(p122);
		p12.add(p123);
		p12.add(p124);
		p12.add(p125);

		p13.setLayout(new GridLayout(2, 1));
		p13.add(p131);
		p13.add(p132);

		p111.add(teaIdLabel);
		p111.add(teaIddataLabel);
		p112.add(teaNamLabel);
		p112.add(teaNamdataLabel);
		p113.add(upButton);
		p113.add(downButton);
		p121.add(couLabel);
		p121.add(jComboBox);
		p121.add(couField);
		p122.add(couidLabel);
		p122.add(couidField);
		p123.add(coutestLabel);
		p123.add(coutestField);
		p124.add(couplaceLabel);
		p124.add(couplaceField);
		p125.add(couperiodLabel);
		p125.add(couperiodField);
		p131.add(yesButton);

		chaxun();

		showPane.addTab("全部教师", p1);

		jComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(couList[0])) {
						couField.setText("请选择");
					}
					if (e.getItem().equals(couList[1])) {
						couField.setText("Java");
						couidField.setText("01");
					}
					if (e.getItem().equals(couList[2])) {
						couField.setText("C语言");
						couidField.setText("02");
					}
					if (e.getItem().equals(couList[3])) {
						couField.setText("操作系统");
						couidField.setText("03");
					}
					if (e.getItem().equals(couList[4])) {
						couField.setText("数据库");
						couidField.setText("04");
					}
					if (e.getItem().equals(couList[5])) {
						couField.setText("概率论");
						couidField.setText("05");
					}
					if (e.getItem().equals(couList[6])) {
						couField.setText("英语");
						couidField.setText("06");
					}
					if (e.getItem().equals(couList[7])) {
						couField.setText("计算机系统基础");
						couidField.setText("07");
					}
					if (e.getItem().equals(couList[8])) {
						couField.setText("大学物理");
						couidField.setText("08");
					}
					if (e.getItem().equals(couList[9])) {
						couField.setText("高数上册");
						couidField.setText("09");
					}
					if (e.getItem().equals(couList[10])) {
						couField.setText("高数下册");
						couidField.setText("10");
					}
					if (e.getItem().equals(couList[11])) {
						couField.setText("军事理论");
						couidField.setText("11");
					}
					if (e.getItem().equals(couList[12])) {
						couField.setText("离散数学");
						couidField.setText("12");
					}
					if (e.getItem().equals(couList[13])) {
						couField.setText("大学体育");
						couidField.setText("13");
					}
				}
			}
		});

		upButton.addActionListener(this);
		downButton.addActionListener(this);
		yesButton.addActionListener(this);

		/*
		 * 
		 * 分页完成
		 * 
		 */
		adminAddCouFrame.add(showPane);
		adminAddCouFrame.setSize(600, 800);

		adminAddCouFrame.setVisible(true);

	}

	private void chaxun() {

		ResultSet resultSet = null;

		AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
		resultSet = administratorDaoImpl.SelectAllTea();

		try {
			resultSet.last();
			count = resultSet.getRow();
			if (resultSet.absolute(row)) {
				String id = resultSet.getString(1);
				String name = resultSet.getString(2);

				teaIddataLabel.setText(id);
				teaNamdataLabel.setText(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * 第一页
		 */
		if (e.getSource() == upButton) {
			row--;
			chaxun();
			downButton.setEnabled(true);
			if (row <= 1) {
				upButton.setEnabled(false);
				row = 1;
			}
		}

		if (e.getSource() == downButton) {
			row++;
			chaxun();
			upButton.setEnabled(true);
			if (row >= count) {
				row = count;
				downButton.setEnabled(false);
			}
		}

		if (e.getSource() == yesButton) {
			if (couField.getText().equals("请选择")) {
				JOptionPane.showMessageDialog(p123, "请选择课程", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (coutestField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p123, "考试时间输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (couperiodField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p123, "学时输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else if (couplaceField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p123, "上课地点输入不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
			} else {

				String teaId = teaIddataLabel.getText();
				AdministratorDaoImpl administratorDaoImpl1 = new AdministratorDaoImpl();
				ResultSet resultSet1 = administratorDaoImpl1.selectCou(teaId);
				int count = 0;
				try {
					while (resultSet1.next()) {
						count++;
					}
					
					if (count != 0) {
						JOptionPane.showMessageDialog(p123, "该教师已任课，不能重复任课", "消息提示", JOptionPane.WARNING_MESSAGE);
					} else {
						AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();

						CouInformination couInformination = new CouInformination();
						couInformination.setCouid(couidField.getText());
						couInformination.setCoures(couField.getText());
						couInformination.setPeriod(couperiodField.getText());
						couInformination.setPlace(couplaceField.getText());
						couInformination.setTest(coutestField.getText());
						couInformination.setTea_id(teaIddataLabel.getText());

						administratorDaoImpl.addCou(couInformination);

						JOptionPane.showMessageDialog(p123, "任课成功", "消息提示", JOptionPane.WARNING_MESSAGE);

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new AdminAddCou();
	}

}

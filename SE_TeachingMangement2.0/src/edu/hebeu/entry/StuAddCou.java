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

	JFrame addcouFrame = new JFrame("��ӿγ̽���");

	JTabbedPane showPanel;// ��ҳ�����

	JPanel p1, p2, p3;// ���ڷ�ҳ

	/*
	 * 
	 * ��һҳ
	 * 
	 */
	JPanel p11, p12, p13, p14, p15, p16, p17;

	JLabel couLabel, coudataLabel, teaidLabel, teaiddataLabel, teaLabel, teadataLabel, placeLabel, placedataLabel,
			periodLabel, perioddataLabel;

	JButton addButton, upButton, downButton;

	/*
	 * 
	 * �ڶ�ҳ
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
	 * ����ҳ
	 * 
	 */
	JPanel p31, p32, p33, p34, p35, p36, p37, p38;

	JLabel checkLabel3, couLabel3, coudataLabel3, teaidLabel3, teaiddataLabel3, teaLabel3, teadataLabel3, placeLabel3,
			placedataLabel3, periodLabel3, perioddataLabel3;

	JButton addButton3, upButton3, downButton3, check3Button;

	JTextField checkField3;

	String[] coulist;
	JComboBox<String> coucomboBox = null;// ��������������

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
		 * ��һҳ
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

		couLabel = new JLabel("�γ�");
		coudataLabel = new JLabel("", 10);
		teaLabel = new JLabel("��ʦ");
		teadataLabel = new JLabel("", 10);
		teaidLabel = new JLabel("��ʦid��");
		teaiddataLabel = new JLabel("", 10);
		placeLabel = new JLabel("�ص�");
		placedataLabel = new JLabel("", 10);
		periodLabel = new JLabel("��ʱ");
		perioddataLabel = new JLabel("", 10);

		addButton = new JButton("��ӿγ�");
		upButton = new JButton("��һ��");
		downButton = new JButton("��һ��");

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

		chaXun1();// p1��

		showPanel.addTab("ȫ���γ�", p1);// ��p1��p2���з�ҳ

		upButton.addActionListener(this);
		downButton.addActionListener(this);
		addButton.addActionListener(this);

		/*
		 * �ڶ�ҳ
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

		checkLabel2 = new JLabel("��ѯ�Ľ�ʦ");
		couLabel2 = new JLabel("�γ�");
		couLabel2.setVisible(false);
		coudataLabel2 = new JLabel("", 10);
		coudataLabel2.setVisible(false);
		teaidLabel2 = new JLabel("��ʦid��");
		teaidLabel2.setVisible(false);
		teaiddataLabel2 = new JLabel("", 10);
		teaiddataLabel2.setVisible(false);
		teaLabel2 = new JLabel("��ʦ");
		teaLabel2.setVisible(false);
		teadataLabel2 = new JLabel("", 10);
		teadataLabel2.setVisible(false);
		placeLabel2 = new JLabel("�ص�");
		placeLabel2.setVisible(false);
		placedataLabel2 = new JLabel("", 10);
		placedataLabel2.setVisible(false);
		periodLabel2 = new JLabel("��ʱ");
		periodLabel2.setVisible(false);
		perioddataLabel2 = new JLabel("", 10);
		perioddataLabel2.setVisible(false);

		addButton2 = new JButton("��ӿγ�");
		addButton2.setVisible(false);
		upButton2 = new JButton("��һ��");
		upButton2.setVisible(false);
		downButton2 = new JButton("��һ��");
		downButton2.setVisible(false);
		check2Button = new JButton("��ѯ");

		checkField2 = new JTextField(15);

		nameRadioButton = new JRadioButton("��ʦ��");
		idRadioButton = new JRadioButton("��ʦid");

		group = new ButtonGroup();// ��stu,tea,adm����ButtonGroup�Ķ���group��,��ʹ��3��JRadioButtonֻ��ѡһ��
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

//		chaXun2();// p2��

		showPanel.addTab("��ѯ�γ�", p2);// p2��ҳ

		upButton2.addActionListener(this);
		downButton2.addActionListener(this);
		addButton2.addActionListener(this);
		check2Button.addActionListener(this);

		/*
		 * 
		 * ����ҳ
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

		checkLabel3 = new JLabel("��ѯ�Ŀγ�");
		couLabel3 = new JLabel("�γ�");
		couLabel3.setVisible(false);
		coudataLabel3 = new JLabel("", 10);
		coudataLabel3.setVisible(false);
		teaidLabel3 = new JLabel("��ʦid��");
		teaidLabel3.setVisible(false);
		teaiddataLabel3 = new JLabel("", 10);
		teaiddataLabel3.setVisible(false);
		teaLabel3 = new JLabel("��ʦ");
		teaLabel3.setVisible(false);
		teadataLabel3 = new JLabel("", 10);
		teadataLabel3.setVisible(false);
		placeLabel3 = new JLabel("�ص�");
		placeLabel3.setVisible(false);
		placedataLabel3 = new JLabel("", 10);
		placedataLabel3.setVisible(false);
		periodLabel3 = new JLabel("��ʱ");
		periodLabel3.setVisible(false);
		perioddataLabel3 = new JLabel("", 10);
		perioddataLabel3.setVisible(false);

		addButton3 = new JButton("��ӿγ�");
		addButton3.setVisible(false);
		upButton3 = new JButton("��һ��");
		upButton3.setVisible(false);
		downButton3 = new JButton("��һ��");
		downButton3.setVisible(false);
		check3Button = new JButton("��ѯ");

		checkField3 = new JTextField("", 10);
		checkField3.setEnabled(false);

		coulist = new String[] { "��ѡ��", "C����", "Java", "����ϵͳ", "���ݿ�", "������", "Ӣ��", "�����ϵͳ����", "��ѧ����", "�����ϲ�", "�����²�",
				"��������" ,"��ɢ��ѧ" ,"��ѧ����"};
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

		showPanel.addTab("�����γ�", p3);

		coucomboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(coulist[0])) {
						checkField3.setText("��ѡ��");
					}
					if (e.getItem().equals(coulist[1])) {
						checkField3.setText("C����");
					}
					if (e.getItem().equals(coulist[2])) {
						checkField3.setText("Java");
					}
					if (e.getItem().equals(coulist[3])) {
						checkField3.setText("����ϵͳ");
					}
					if (e.getItem().equals(coulist[4])) {
						checkField3.setText("���ݿ�");
					}
					if (e.getItem().equals(coulist[5])) {
						checkField3.setText("������");
					}
					if (e.getItem().equals(coulist[6])) {
						checkField3.setText("Ӣ��");
					}
					if (e.getItem().equals(coulist[7])) {
						checkField3.setText("�����ϵͳ����");
					}
					if (e.getItem().equals(coulist[8])) {
						checkField3.setText("��ѧ����");
					}
					if (e.getItem().equals(coulist[9])) {
						checkField3.setText("�����ϲ�");
					}
					if (e.getItem().equals(coulist[10])) {
						checkField3.setText("�����²�");
					}
					if (e.getItem().equals(coulist[11])) {
						checkField3.setText("��������");
					}
					if (e.getItem().equals(coulist[12])) {
						checkField3.setText("��ɢ��ѧ");
					}
					if (e.getItem().equals(coulist[13])) {
						checkField3.setText("��ѧ����");
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
		 * ��ҳ���
		 * 
		 */

		addcouFrame.add(showPanel);
		addcouFrame.setSize(600, 700);

		addcouFrame.setVisible(true);

	}

	// ��һҳʹ�õķ���
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

	// �ڶ�ҳʹ�õķ���
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
					JOptionPane.showMessageDialog(p23, "�ý�ʦû�пγ�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "û�иý�ʦ", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
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
		 * ��һҳ�ļ���
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
				JOptionPane.showMessageDialog(p13, "'" + account + "'ͬѧ,��Ŀγ�' " + coures + "'��ӳɹ�������", "��Ϣ��ʾ",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(p13, "����ѡ�������ſΣ������ظ�ѡ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}

		}

		/*
		 * 
		 * �ڶ�ҳ�ļ���
		 * 
		 */
		if (e.getSource() == check2Button) {
			if (checkField2.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "���벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(p23, "'" + account + "'ͬѧ,��Ŀγ�' " + coures + "'��ӳɹ�������", "��Ϣ��ʾ",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(p23, "����ѡ�������ſΣ������ظ�ѡ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}

		}

		/*
		 * 
		 * ����ҳ�ļ���
		 * 
		 */
		if (e.getSource() == check3Button) {
			if (checkField3.getText().equals("��ѡ��")) {
				JOptionPane.showMessageDialog(p3, "��ѡ��γ̣�", "������ʾ", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(p23, "'" + account + "'ͬѧ,��Ŀγ�' " + coures + "'��ӳɹ�������", "��Ϣ��ʾ",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(p23, "����ѡ�������ſΣ������ظ�ѡ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	public static void main(String[] args) {
		new StuAddCou();
	}

	String MemoryXianShi() {// ���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				account = resultSet.getString(1);// �������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

}

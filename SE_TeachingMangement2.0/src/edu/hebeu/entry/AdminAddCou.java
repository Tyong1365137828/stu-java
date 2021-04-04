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

	JFrame adminAddCouFrame = new JFrame("�ον���");
	JTabbedPane showPane;
	JPanel p1, p2;

	/*
	 * 
	 * 
	 * ��һҳ
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
		 * ��һҳ
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

		teaIdLabel = new JLabel("�ον�ʦId");
		teaNamLabel = new JLabel("�ον�ʦ����");
		couLabel = new JLabel("�½��Ŀγ���");
		couidLabel = new JLabel("�γ̺�");
		couperiodLabel = new JLabel("ѧʱ");
		couplaceLabel = new JLabel("�Ͽεص�");
		coutestLabel = new JLabel("�Ͽ�ʱ��");

		teaIddataLabel = new JLabel("", 10);
		teaNamdataLabel = new JLabel("", 10);

		couField = new JTextField("��ѡ��");
		couField.setEnabled(false);
		couidField = new JTextField(10);
		couidField.setEnabled(false);
		coutestField = new JTextField(10);
		couplaceField = new JTextField(10);
		couperiodField = new JTextField(10);

		yesButton = new JButton("ȷ��");
		upButton = new JButton("��һ��");
		downButton = new JButton("��һ��");

		couList = new String[] { "��ѡ��", "Java", "C����", "����ϵͳ", "���ݿ�", "������", "Ӣ��", "�����ϵͳ����", "��ѧ����", "�����ϲ�", "�����²�",
				"��������", "��ɢ��ѧ", "��ѧ����" };
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

		showPane.addTab("ȫ����ʦ", p1);

		jComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(couList[0])) {
						couField.setText("��ѡ��");
					}
					if (e.getItem().equals(couList[1])) {
						couField.setText("Java");
						couidField.setText("01");
					}
					if (e.getItem().equals(couList[2])) {
						couField.setText("C����");
						couidField.setText("02");
					}
					if (e.getItem().equals(couList[3])) {
						couField.setText("����ϵͳ");
						couidField.setText("03");
					}
					if (e.getItem().equals(couList[4])) {
						couField.setText("���ݿ�");
						couidField.setText("04");
					}
					if (e.getItem().equals(couList[5])) {
						couField.setText("������");
						couidField.setText("05");
					}
					if (e.getItem().equals(couList[6])) {
						couField.setText("Ӣ��");
						couidField.setText("06");
					}
					if (e.getItem().equals(couList[7])) {
						couField.setText("�����ϵͳ����");
						couidField.setText("07");
					}
					if (e.getItem().equals(couList[8])) {
						couField.setText("��ѧ����");
						couidField.setText("08");
					}
					if (e.getItem().equals(couList[9])) {
						couField.setText("�����ϲ�");
						couidField.setText("09");
					}
					if (e.getItem().equals(couList[10])) {
						couField.setText("�����²�");
						couidField.setText("10");
					}
					if (e.getItem().equals(couList[11])) {
						couField.setText("��������");
						couidField.setText("11");
					}
					if (e.getItem().equals(couList[12])) {
						couField.setText("��ɢ��ѧ");
						couidField.setText("12");
					}
					if (e.getItem().equals(couList[13])) {
						couField.setText("��ѧ����");
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
		 * ��ҳ���
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
		 * ��һҳ
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
			if (couField.getText().equals("��ѡ��")) {
				JOptionPane.showMessageDialog(p123, "��ѡ��γ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else if (coutestField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p123, "����ʱ�����벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else if (couperiodField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p123, "ѧʱ���벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else if (couplaceField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p123, "�Ͽεص����벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
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
						JOptionPane.showMessageDialog(p123, "�ý�ʦ���οΣ������ظ��ο�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
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

						JOptionPane.showMessageDialog(p123, "�ογɹ�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);

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

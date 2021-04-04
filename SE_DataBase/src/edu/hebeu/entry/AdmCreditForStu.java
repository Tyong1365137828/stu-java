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

	JFrame addcreditframe = new JFrame("¼��ѧ������");

	JLabel selCouLabel, stuIdLabel, stuIddataLabel, credLabel, creddataLabel, nameLabel, namedataLabel, creditLabel;

	JTextField couField, creditField;

	JButton selectButton, yesButton, upButton, downButton;

	int row = 1;// ����ָ�룬���ڻ�ȡ�����ĵ�һ����¼
	int count, count1;// ���ڻ�ȡ�������¼��

	String[] counumlist;
	JComboBox<String> counumcomboBox = null;// ��������������

	JPanel p1, p2, p3;

	public AdmCreditForStu() {
		selCouLabel = new JLabel("ѡ���ѯ�Ŀγ̺�");
		stuIdLabel = new JLabel("ѧ��");
		stuIdLabel.setVisible(false);
		stuIddataLabel = new JLabel("", 10);
		stuIddataLabel.setVisible(false);
		credLabel = new JLabel("�Ե�ѧ��");
		credLabel.setVisible(false);
		creddataLabel = new JLabel("", 10);
		creddataLabel.setVisible(false);
		nameLabel = new JLabel("����");
		nameLabel.setVisible(false);
		namedataLabel = new JLabel("", 10);
		namedataLabel.setVisible(false);
		creditLabel = new JLabel("ѧ��");
		creditLabel.setVisible(false);

		couField = new JTextField("���ݿ�", 10);
		couField.setEditable(false);
		creditField = new JTextField(10);
		creditField.setVisible(false);

		selectButton = new JButton("��ѯ");
		yesButton = new JButton("ȷ��");
		yesButton.setVisible(false);
		upButton = new JButton("��һ��");
		upButton.setVisible(false);
		downButton = new JButton("��һ��");
		downButton.setVisible(false);

		counumlist = new String[] { "01<���ݿ�>", "02<C����>", "03<����ϵͳ>", "04<java>", "05<������>", "06<Ӣ��>", "07<�����ϵͳ����>",
				"08<��ѧ����>", "09<�����ϲ�>", "10<�����²�>", "11<��������>" };
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
						couField.setText("���ݿ�");
					}
					if (e.getItem().equals(counumlist[1])) {
						couField.setText("C����");
					}
					if (e.getItem().equals(counumlist[2])) {
						couField.setText("����ϵͳ");
					}
					if (e.getItem().equals(counumlist[3])) {
						couField.setText("java");
					}
					if (e.getItem().equals(counumlist[4])) {
						couField.setText("������");
					}
					if (e.getItem().equals(counumlist[5])) {
						couField.setText("Ӣ��");
					}
					if (e.getItem().equals(counumlist[6])) {
						couField.setText("�����ϵͳ����");
					}
					if (e.getItem().equals(counumlist[7])) {
						couField.setText("��ѧ����");
					}
					if (e.getItem().equals(counumlist[8])) {
						couField.setText("�����ϲ�");
					}
					if (e.getItem().equals(counumlist[9])) {
						couField.setText("�����²�");
					}
					if (e.getItem().equals(counumlist[10])) {
						couField.setText("��������");
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
//				JOptionPane.showMessageDialog(p3, "�ÿγ�û��ѧ��ѡ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(p1, "�ÿγ�û��ѧ��ѡ��", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
			} else {
				diaoYong();
			}

		}
		if (e.getSource() == yesButton) {
			if (creditField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "�����������ѧ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(p1, "¼���ѧ���ķ���", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource().equals(upButton)) {// ������"��һ��"��ť
			row--;// ָ��ֵ��һ
			diaoYong();// �����Զ���Ĳ�ѯ�������Խ�rowֵ����
			downButton.setEnabled(true);
			if (row <= 1) {// ��ָ��ֵС��һʱ����������ѯ�����Сָ�뻹С
				upButton.setEnabled(false);// ��ʱ"��һ��"��ť����ѡ��
				row = 1;// ��ʱָ��ֵʼ��Ϊһ
			}
		}

		if (e.getSource().equals(downButton)) {// ������"��һ��"��ť
			row++;// ָ��ֵ��һ
			diaoYong();// �����Զ���Ĳ�ѯ�������Խ�rowֵ����
			upButton.setEnabled(true);
			if (row >= count) {// ��ָ��ֵ����countֵʱ����������ѯ������ָ�뻹��
				row = count;// ��ʱָ��ֵʼ��Ϊ����ѯ������ָ��ֵcount
				downButton.setEnabled(false);// ��ʱ"��һ��"��ť����ѡ��
			}
		}

	}
	
	public static void main(String[] args) {
		new AdmCreditForStu();
	}
	
}

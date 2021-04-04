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
import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.po.Department;

public class AdminAddTeaAward implements ActionListener{
	
	JFrame addAwardTeaFrame = new JFrame("��ʦ��������");
	JTabbedPane showPanel;// ��ҳ�����
	JPanel p1, p2;// ���ڷ�ҳ
	
	/*
	 * 
	 * 
	 * ��һҳ
	 * 
	 */
	JPanel p11, p12, p13, p14, p15, p16, p17;

	JLabel numLabel1, namLabel1, depLabel1, awardLabel1;
	JLabel numField1, namField1, depField1, awardField1;
	JButton upButton1, downButton1, addButton1;

	int count;
	int row = 1;
	String[] award1list;
	JComboBox<String> award1comboBox = null;// ��������������

	/*
	 * 
	 * �ڶ�ҳ
	 * 
	 */
	JLabel numLabel2, namLabel2, depLabel2, awardLabel2;

	JLabel numField2, namField2, depField2, awardField2;

	JLabel label2;

	JTextField field2;

	JButton checkButton2, addButton2;

	JPanel p21, p22, p23, p24, p25, p26, p27;

	String[] award2list;
	JComboBox<String> award2comboBox = null;// ��������������
	
	public AdminAddTeaAward() {
		
		showPanel = new JTabbedPane();
		
		/*
		 * 
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

		numField1 = new JLabel("", 10);
		namField1 = new JLabel("", 10);
		depField1 = new JLabel("", 10);
		awardField1 = new JLabel("��ѡ��", 10);

		numLabel1 = new JLabel("ѧ��");
		namLabel1 = new JLabel("����");
		depLabel1 = new JLabel("ϵ��");
		awardLabel1 = new JLabel("����");

		upButton1 = new JButton("��һ��");
		downButton1 = new JButton("��һ��");
		addButton1 = new JButton("ȷ�Ͻ���");
		
		award1list = new String[] { "��ѡ��", "�Ƚ�����", "�����ʦ", "���㵳Ա", };
		award1comboBox = new JComboBox<String>(award1list);
		award1comboBox.setSelectedIndex(0);

		addAwardTeaFrame.add(p1);

		p1.setLayout(new GridLayout(7, 1));
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		p1.add(p14);
		p1.add(p15);
		p1.add(p16);
		p1.add(p17);

		p12.add(numLabel1);
		p12.add(numField1);
		p13.add(namLabel1);
		p13.add(namField1);
		p14.add(depLabel1);
		p14.add(depField1);
		p15.add(awardLabel1);
		p15.add(award1comboBox);
		p15.add(awardField1);
		p16.add(upButton1);
		p16.add(addButton1);
		p16.add(downButton1);

		chaXun1();
		
		showPanel.addTab("ȫ��ѧ��", p1);

		upButton1.addActionListener(this);
		downButton1.addActionListener(this);
		addButton1.addActionListener(this);
		award1comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(award1list[0])) {
						awardField1.setText("��ѡ��");
					}
					if (e.getItem().equals(award1list[1])) {
						awardField1.setText("�Ƚ�����");
					}
					if (e.getItem().equals(award1list[2])) {
						awardField1.setText("�����ʦ");
					}
					if (e.getItem().equals(award1list[3])) {
						awardField1.setText("���㵳Ա");
					}
				}

			}
		});
		
		/*
		 * 
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

		label2 = new JLabel("������ѧ��");
		numLabel2 = new JLabel("ѧ��");
		numLabel2.setVisible(false);
		namLabel2 = new JLabel("����");
		namLabel2.setVisible(false);
		depLabel2 = new JLabel("ϵ��");
		depLabel2.setVisible(false);
		awardLabel2 = new JLabel("����");
		awardLabel2.setVisible(false);
		
		checkButton2 = new JButton("��ѯ");
		addButton2 = new JButton("ȷ�Ͻ���");
		addButton2.setVisible(false);
		field2 = new JTextField(15);
		numField2 = new JLabel("", 10);
		namField2 = new JLabel("", 10);
		depField2 = new JLabel("", 10);
		awardField2 = new JLabel("��ѡ��", 10);
		awardField2.setVisible(false);
		
		award2list = new String[] { "��ѡ��", "�Ƚ�����", "�����ʦ", "���㵳Ա", };
		award2comboBox = new JComboBox<String>(award2list);
		award2comboBox.setSelectedIndex(0);
		award2comboBox.setVisible(false);
		
		p2.setLayout(new GridLayout(7, 1));
		p2.add(p21);
		p2.add(p22);
		p2.add(p23);
		p2.add(p24);
		p2.add(p25);
		p2.add(p26);
		p2.add(p27);

		p21.add(label2);
		p21.add(field2);
		p21.add(checkButton2);
		p22.add(numLabel2);
		p22.add(numField2);
		p23.add(namLabel2);
		p23.add(namField2);
		p24.add(depLabel2);
		p24.add(depField2);
		p25.add(awardLabel2);
		p25.add(award2comboBox);
		p25.add(awardField2);
		p26.add(addButton2);

		showPanel.addTab("��ѯ���", p2);

		checkButton2.addActionListener(this);
		addButton2.addActionListener(this);
		award2comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(award2list[0])) {
						awardField2.setText("��ѡ��");
					}
					if (e.getItem().equals(award2list[1])) {
						awardField2.setText("�Ƚ�����");
					}
					if (e.getItem().equals(award2list[2])) {
						awardField2.setText("�����ɲ�");
					}
					if (e.getItem().equals(award2list[3])) {
						awardField2.setText("�������");
					}
				}

			}
		});
		
		/*
		 * 
		 * ��ҳ���
		 * 
		 */
		addAwardTeaFrame.add(showPanel);
		addAwardTeaFrame.setSize(500, 400);
		addAwardTeaFrame.setVisible(true);
		
		/*
		 * 
		 * �ڶ�ҳ
		 * 
		 */
		
		
	}
	
	//��һҳ
	private void chaXun1() {
		
		ResultSet resultSet = null;

		try {
			AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
			resultSet = administratorDaoImpl.SelectAllTea();
			
			resultSet.last();
			count = resultSet.getRow();

			if (resultSet.absolute(row)) {
				String id = resultSet.getString(1);
				String name = resultSet.getString(2);
				String depId = resultSet.getString(5);

				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();

				Department department = new Department();
				department.setDepnum(depId);

				String depnam = courseDaoImpl.FindDepNam(department);

				namField1.setText(name);
				numField1.setText(id);
				depField1.setText(depnam);

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
		if (e.getSource() == upButton1) {
			row--;
			chaXun1();
			downButton1.setEnabled(true);

			if (row <= 1) {
				upButton1.setEnabled(false);
				row = 1;
			}

		}

		if (e.getSource() == downButton1) {// ������"��һ��"��ť
			row++;// ָ��ֵ��һ
			chaXun1();// �����Զ���Ĳ�ѯ�������Խ�rowֵ����
			upButton1.setEnabled(true);
			if (row >= count) {// ��ָ��ֵ����countֵʱ����������ѯ������ָ�뻹��
				row = count;// ��ʱָ��ֵʼ��Ϊ����ѯ������ָ��ֵcount
				downButton1.setEnabled(false);// ��ʱ"��һ��"��ť����ѡ��
			}
		}

		if (e.getSource() == addButton1) {
			
			if(awardField1.getText().equals("��ѡ��")){
				JOptionPane.showMessageDialog(p13, "��ѡ����", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
			}
			else {
				String id = numField1.getText();
				String award = awardField1.getText();
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				administratorDaoImpl.AddAwardForTea(id, award);

				JOptionPane.showMessageDialog(p13, "��ʦ�����ɹ�", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		/*
		 * 
		 * �ڶ�ҳ
		 * 
		 */
		if (e.getSource() == checkButton2) {
			if (field2.getText().length() == 0) {
				JOptionPane.showMessageDialog(p22, "����Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else {
				String id = field2.getText();
				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					ResultSet resultSet = administratorDaoImpl.JSelectTeaByNum(id);

					int count = 0;
					while (resultSet.next()) {
						count++;
					}

					resultSet.beforeFirst();
					if (count == 0) {
						JOptionPane.showMessageDialog(p22, "û�иý�ʦ", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
					} else {
						while (resultSet.next()) {
							String name = resultSet.getString(2);
							String depnum = resultSet.getString(5);
							
							CourseDaoImpl courseDaoImpl = new CourseDaoImpl();

							Department department = new Department();
							department.setDepnum(depnum);

							String depnam = courseDaoImpl.FindDepNam(department);

							numField2.setText(id);
							namField2.setText(name);
							depField2.setText(depnam);

							numLabel2.setVisible(true);
							namLabel2.setVisible(true);
							depLabel2.setVisible(true);
							award2comboBox.setVisible(true);
							addButton2.setVisible(true);
							awardLabel2.setVisible(true);
							awardField2.setVisible(true);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		
		if (e.getSource() == addButton2) {
			if(awardField2.getText().equals("��ѡ��")) {
				JOptionPane.showMessageDialog(p2, "��ѡ����", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else {
				String id = numField2.getText();
				String award = awardField2.getText();
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				administratorDaoImpl.AddAwardForTea(id, award);
				
				JOptionPane.showMessageDialog(p13, "��ʦ�����ɹ�", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
			}
			
		}

		/*
		 * 
		 * ��ҳ���
		 * 
		 */

		
		
		
	}
	
	public static void main(String[] args) {
		new AdminAddTeaAward();
	}
	
}

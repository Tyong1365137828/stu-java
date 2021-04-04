package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.po.Department;

public class AdminDeleteStu implements ActionListener {

	JFrame deleteFrame = new JFrame("ѧ��ɾ������");

	JTabbedPane showPanel;// ��ҳ�����

	JPanel p1, p2;

	/*
	 * 
	 * ��һҳ
	 * 
	 */
	JPanel p11, p12, p13, p14;

	JLabel numLabel1, namLabel1, depLabel1;
	JLabel numField1, namField1, depField1;
	JButton upButton1, downButton1, deleteButton1;

	/*
	 * 
	 * �ڶ�ҳ
	 * 
	 */
	JLabel selectLabel, label, numLabel, namLabel, depLabel;

	JRadioButton stu_id, stu_name;

	ButtonGroup group;

	JButton checkButton, deleteButton;

	JTextField field;

	JLabel numField, namField, depField;

	JPanel p21, p22, p23, p24, p25, p26, p27;

	int count;
	int row = 1;

	public AdminDeleteStu() {

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

		numField1 = new JLabel("", 10);
		namField1 = new JLabel("", 10);
		depField1 = new JLabel("", 10);

		numLabel1 = new JLabel("ѧ��");
		namLabel1 = new JLabel("����");
		depLabel1 = new JLabel("ϵ��");

		upButton1 = new JButton("��һ��");
		downButton1 = new JButton("��һ��");
		deleteButton1 = new JButton("ɾ��");

		deleteFrame.add(p1);

		p1.setLayout(new GridLayout(4, 1));
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		p1.add(p14);

		p11.add(numLabel1);
		p11.add(numField1);
		p12.add(namLabel1);
		p12.add(namField1);
		p13.add(depLabel1);
		p13.add(depField1);
		p14.add(upButton1);
		p14.add(downButton1);
		p14.add(deleteButton1);

		chaXun1();

		showPanel.addTab("ȫ��ѧ��", p1);

		upButton1.addActionListener(this);
		downButton1.addActionListener(this);
		deleteButton1.addActionListener(this);

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

		selectLabel = new JLabel("ѡ���ѯ��ʽ");
		label = new JLabel("������");
		numLabel = new JLabel("ѧ��");
		numLabel.setVisible(false);
		namLabel = new JLabel("����");
		namLabel.setVisible(false);
		depLabel = new JLabel("ϵ��");
		depLabel.setVisible(false);

		stu_id = new JRadioButton("��id��");
		stu_name = new JRadioButton("������");

		checkButton = new JButton("����");
		deleteButton = new JButton("ɾ��");
		deleteButton.setVisible(false);

		field = new JTextField(15);
		numField = new JLabel("", 10);
		namField = new JLabel("", 10);
		depField = new JLabel("", 10);

		group = new ButtonGroup();
		group.add(stu_id);
		group.add(stu_name);
		stu_id.setSelected(true);

		deleteFrame.add(p2);

		p2.setLayout(new GridLayout(7, 1));
		p2.add(p21);
		p2.add(p22);
		p2.add(p23);
		p2.add(p24);
		p2.add(p25);
		p2.add(p26);
		p2.add(p27);

		p21.add(selectLabel);
		p21.add(stu_id);
		p21.add(stu_name);
		p22.add(label);
		p22.add(field);
		p22.add(checkButton);
		p23.add(numLabel);
		p23.add(numField);
		p24.add(namLabel);
		p24.add(namField);
		p25.add(depLabel);
		p25.add(depField);
		p26.add(deleteButton);
		
		showPanel.addTab("��ѯѧ��", p2);
		
		checkButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		/*
		 * 
		 * ��ҳ���
		 * 
		 */
		deleteFrame.add(showPanel);
		deleteFrame.setSize(400, 500);
		deleteFrame.setVisible(true);


	}

	// ��һҳ
	private void chaXun1() {

		ResultSet resultSet = null;

		try {
			AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
			resultSet = administratorDaoImpl.SelectAllStu();

			resultSet.last();
			count = resultSet.getRow();

			if (resultSet.absolute(row)) {
				String id = resultSet.getString(1);
				String name = resultSet.getString(2);
				String depId = resultSet.getString(4);

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

		if (e.getSource() == deleteButton1) {

			String id = numField1.getText();
			AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
			administratorDaoImpl.DeleteStu(id);

			JOptionPane.showMessageDialog(p13, "ѧ��ɾ���ɹ�", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
		}

		/*
		 * 
		 * �ڶ�ҳ
		 * 
		 */
		if (e.getSource() == checkButton) {
			if (field.getText().length() == 0) {
				JOptionPane.showMessageDialog(p22, "����Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else if (stu_id.isSelected()) {

				String id = field.getText();
				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					ResultSet resultSet = administratorDaoImpl.JSelectStudentByNum(id);
					
					int count = 0;
					while(resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();
					if(count == 0) {
						JOptionPane.showMessageDialog(p22, "û�и�ѧ��ѧ��", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
					}
					else {
						while (resultSet.next()) {
							String name = resultSet.getString(2);
							String depnum = resultSet.getString(4);
							
							CourseDaoImpl courseDaoImpl = new CourseDaoImpl();

							Department department = new Department();
							department.setDepnum(depnum);

							String depnam = courseDaoImpl.FindDepNam(department);
							
							numField.setText(id);
							namField.setText(name);
							depField.setText(depnam);
							
							numLabel.setVisible(true);
							namLabel.setVisible(true);
							depLabel.setVisible(true);
							deleteButton.setVisible(true);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}else if(stu_name.isSelected()) {
				String name = field.getText();
				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					ResultSet resultSet = administratorDaoImpl.JSelectStudentByNam(name);
					
					int count = 0;
					while(resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();
					if(count == 0) {
						JOptionPane.showMessageDialog(p22, "û�и�ѧ��ѧ��", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
					}
					else {
						while (resultSet.next()) {
							String id = resultSet.getString(1);
							String depnum = resultSet.getString(4);
							
							CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
							
							Department department = new Department();
							department.setDepnum(depnum);
							
							String depnam = courseDaoImpl.FindDepNam(department);
							
							numField.setText(id);
							namField.setText(name);
							depField.setText(depnam);
							
							numLabel.setVisible(true);
							namLabel.setVisible(true);
							depLabel.setVisible(true);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		}
		
		if(e.getSource() == deleteButton) {
			String id = numField.getText();
			AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
			administratorDaoImpl.DeleteStu(id);
			
			JOptionPane.showMessageDialog(p22, "ѧ��ɾ���ɹ�", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
		}

	}

	public static void main(String[] args) {
		new AdminDeleteStu();
	}

}

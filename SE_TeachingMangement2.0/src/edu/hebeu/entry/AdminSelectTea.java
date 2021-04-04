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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.po.Department;

public class AdminSelectTea implements ActionListener {

	JFrame selectFrame = new JFrame("��ѯ��ʦ����");
	JTabbedPane showPanel;// ��ҳ�����
	JPanel p1, p2;

	/*
	 * 
	 * 
	 * ��һҳ
	 * 
	 */
	String title1[] = { "�˺�", "����", "����", "�Ա�", "ϵ��", "ϵ��", "����", "���֤��", "�绰", };

	JScrollPane tableScrollPane1;// ����һ�������ܶ���

	JTable jTable1;// ����Jtable����

	/*
	 * 
	 * �ڶ�ҳ
	 * 
	 * 
	 */
	JButton returnButton, exactButton, dimButton;

	JRadioButton nameRadioButton, numRadioButton;
	ButtonGroup group;

	JLabel accountOrNameLabel;

	JTextField textField;

	JScrollPane tableScrollPane2;// ����һ�������ܶ���

	JTable jTable2;// ����Jtable����

	String title2[] = { "�˺�", "����", "����", "�Ա�", "ϵ��", "ϵ��", "����", "���֤��", "�绰", };

	JPanel p21, p22;

	JPanel p211, p212, p213, p214, p215;

	public AdminSelectTea() {

		showPanel = new JTabbedPane();

		/*
		 * 
		 * ��һҳ
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

		returnButton = new JButton("����");
		exactButton = new JButton("��ȷ����");
		dimButton = new JButton("���Ʋ���");

		nameRadioButton = new JRadioButton("��������");
		numRadioButton = new JRadioButton("���Ų���");

		group = new ButtonGroup();// ��stu,tea,adm����ButtonGroup�Ķ���group��,��ʹ��3��JRadioButtonֻ��ѡһ��
		group.add(nameRadioButton);
		group.add(numRadioButton);
		nameRadioButton.setSelected(true);

		accountOrNameLabel = new JLabel("�������ֻ��˺�");

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

		showPanel.addTab("���ҽ�ʦ", p2);

		returnButton.addActionListener(this);
		dimButton.addActionListener(this);
		exactButton.addActionListener(this);

		/*
		 * 
		 * �ڶ�ҳ
		 * 
		 */
		p1 = new JPanel();

		tableScrollPane1 = new JScrollPane();
		jTable1 = new JTable();

		selectFrame.add(p1);

		p1.setLayout(new GridLayout(1, 1));

		pagetwo();
		
		showPanel.addTab("ȫ����ʦ", p1);

		/*
		 * 
		 * ��ҳ���
		 * 
		 */
		selectFrame.add(showPanel);
		selectFrame.setSize(900, 800);
		selectFrame.setVisible(true);

		System.out.println("wdwgrdsrszdfb");

	}

	/*
	 * 
	 * �ڶ�ҳ����
	 * 
	 * 
	 */
	private void pagetwo() {

		ResultSet resultSet = null;

		try {
			AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
			resultSet = administratorDaoImpl.SelectAllTea();

			int count = 0;
			while (resultSet.next()) {
				count++;
			}
			resultSet.beforeFirst();

			Object[][] info = new Object[count][9];
			System.out.println("count=" + count);
			count = 0;// count��0
			while (resultSet.next()) {
				
				String depnum = resultSet.getString(5);
				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();

				Department department = new Department();
				department.setDepnum(depnum);

				String depnam = courseDaoImpl.FindDepNam(department);
				System.out.println("depnam=" + depnam);
				
				info[count][0] = resultSet.getString(1);
				info[count][1] = resultSet.getString(2);
				info[count][2] = resultSet.getString(3);
				info[count][3] = resultSet.getString(4);
				info[count][4] = resultSet.getString(5);
				info[count][5] = depnam;
				info[count][6] = resultSet.getString(6);
				info[count][7] = resultSet.getString(7);
				info[count][8] = resultSet.getString(8);
				count++;
			}
			jTable1 = new JTable(info, title1);
			jTable1.getTableHeader();

			// ��JTable���뵽���������������
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
		 * ��һҳ
		 * 
		 */
		if (e.getSource() == returnButton) {
			selectFrame.dispose();
		}

		if (e.getSource() == exactButton) {//��������ȷ��ѯ
			if (textField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p21, "���벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else if (numRadioButton.isSelected() && textField.getText().length() != 0) {
				tableScrollPane2 = new JScrollPane();
				tableScrollPane2.setBounds(0, 0, 900, 1000);

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					
					String number = textField.getText();
					System.out.println("number=" + number);
					ResultSet resultSet = administratorDaoImpl.JSelectTeaByNum(number);
					
					int count = 0;
					while (resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();// ָ���ÿ�
					
					Object[][] info = new Object[count][9];
					
					count = 0;// count��0
					while (resultSet.next()) {
						
						String depnum = resultSet.getString(5);
						CourseDaoImpl courseDaoImpl = new CourseDaoImpl();

						Department department = new Department();
						department.setDepnum(depnum);

						String depnam = courseDaoImpl.FindDepNam(department);
						
						info[count][0] = resultSet.getString(1);
						info[count][1] = resultSet.getString(2);
						info[count][2] = resultSet.getString(3);
						info[count][3] = resultSet.getString(4);
						info[count][4] = resultSet.getString(5);
						info[count][5] = depnam;
						info[count][6] = resultSet.getString(6);
						info[count][7] = resultSet.getString(7);
						info[count][8] = resultSet.getString(8);
						count++;
					}
					
					jTable2 = new JTable(info, title2);
					jTable2.getTableHeader();

					// ��JTable���뵽���������������
					tableScrollPane2.getViewport().add(jTable2);
					p22.add(tableScrollPane2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (nameRadioButton.isSelected() && textField.getText().length() != 0) {
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
					System.out.println("wevcount="+count);
					resultSet.beforeFirst();// ָ���ÿ�
					
					Object[][] info = new Object[count][9];
					count = 0;// count��0
					while (resultSet.next()) {
						
						String depnum = resultSet.getString(5);
						CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
						
						Department department = new Department();
						department.setDepnum(depnum);
						String depnam = courseDaoImpl.FindDepNam(department);
						
						info[count][0] = resultSet.getString(1);
						info[count][1] = resultSet.getString(2);
						info[count][2] = resultSet.getString(3);
						info[count][3] = resultSet.getString(4);
						info[count][4] = resultSet.getString(5);
						info[count][5] = depnam;
						info[count][6] = resultSet.getString(6);
						info[count][7] = resultSet.getString(7);
						info[count][8] = resultSet.getString(8);
						
						count++;
					}
					
					jTable2 = new JTable(info, title2);
					jTable2.getTableHeader();
					
					// ��JTable���뵽���������������
					tableScrollPane2.getViewport().add(jTable2);
					p22.add(tableScrollPane2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(p22, "��ѡ���ѯ����", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		/*
		 * 
		 * 
		 * 
		 * */
		
		if (e.getSource() == dimButton) {// ��������ģ����ѯ��ť
			if (textField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p21, "���벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else if (numRadioButton.isSelected() && textField.getText().length() != 0) {
				tableScrollPane2 = new JScrollPane();
				tableScrollPane2.setBounds(0, 0, 900, 1000);

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();

					String number = textField.getText();
					System.out.println("number=" + number);
					ResultSet resultSet = administratorDaoImpl.SelectTeaByNum(number);
					
					int count = 0;
					while (resultSet.next()) {
						count++;
					}
					resultSet.beforeFirst();// ָ���ÿ�
					
					Object[][] info = new Object[count][9];
					count = 0;// count��0

					while (resultSet.next()) {
						
						String depnum = resultSet.getString(5);
						CourseDaoImpl courseDaoImpl = new CourseDaoImpl();

						Department department = new Department();
						department.setDepnum(depnum);

						String depnam = courseDaoImpl.FindDepNam(department);
						System.out.println("depnam=" + depnam);
						
						info[count][0] = resultSet.getString(1);
						info[count][1] = resultSet.getString(2);
						info[count][2] = resultSet.getString(3);
						info[count][3] = resultSet.getString(4);
						info[count][4] = resultSet.getString(5);
						info[count][5] = depnam;
						info[count][6] = resultSet.getString(6);
						info[count][7] = resultSet.getString(7);
						info[count][8] = resultSet.getString(8);
						count++;
					}
					
					jTable2 = new JTable(info, title2);
					jTable2.getTableHeader();

					// ��JTable���뵽���������������
					tableScrollPane2.getViewport().add(jTable2);
					p22.add(tableScrollPane2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (nameRadioButton.isSelected() && textField.getText().length() != 0) {
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
					resultSet.beforeFirst();// ָ���ÿ�

					Object[][] info = new Object[count][9];
					count = 0;// count��0

					while (resultSet.next()) {
						
						String depnum = resultSet.getString(5);
						CourseDaoImpl courseDaoImpl = new CourseDaoImpl();

						Department department = new Department();
						department.setDepnum(depnum);

						String depnam = courseDaoImpl.FindDepNam(department);
						System.out.println("depnam=" + depnam);
						
						info[count][0] = resultSet.getString(1);
						info[count][1] = resultSet.getString(2);
						info[count][2] = resultSet.getString(3);
						info[count][3] = resultSet.getString(4);
						info[count][4] = resultSet.getString(5);
						info[count][5] = depnam;
						info[count][6] = resultSet.getString(6);
						info[count][7] = resultSet.getString(7);
						info[count][8] = resultSet.getString(8);
						
						count++;
					}

					jTable2 = new JTable(info, title2);
					jTable2.getTableHeader();

					// ��JTable���뵽���������������
					tableScrollPane2.getViewport().add(jTable2);
					p22.add(tableScrollPane2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(p22, "��ѡ���ѯ����", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}
			
		}

	}
	
	public static void main(String[] args) {
		new AdminSelectTea();
	}

}

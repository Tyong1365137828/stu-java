package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.jdbc.GetConn;

public class ForgetPassword implements ActionListener {

	ResultSet resultSet;

	JFrame forgetFrame = new JFrame("�����������");

	JLabel nameLabel, accountLabel, chooseLabel,idcardLabel;

	JTextField nameField, accountField, idcardField;

	JButton confirmButton;

	JRadioButton stu, tea, adm; // ��ѡ��ť
	ButtonGroup group;

	JPanel p1, p2, p3, p4, p5, p6, p7, p8;

	public ForgetPassword() {

		nameLabel = new JLabel("�������");
		accountLabel = new JLabel("����˺�");
		idcardLabel = new JLabel("������֤��");
		chooseLabel = new JLabel("���Ȩ��");

		nameField = new JTextField(18);
		accountField = new JTextField(18);
		idcardField = new JTextField(18);

		confirmButton = new JButton("ȷ���ύ");

		stu = new JRadioButton("ѧ��");
		tea = new JRadioButton("��ʦ");
		adm = new JRadioButton("����Ա");

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		
		group = new ButtonGroup();// ��stu,tea,adm����ButtonGroup�Ķ���group��,��ʹ��3��JRadioButtonֻ��ѡһ��
		group.add(stu);
		group.add(tea);
		group.add(adm);
		adm.setSelected(true);// Ĭ��ѡ��adm
//		stu.setSelected(true);//Ĭ��ѡ��stu
//		tea.setSelected(true);//Ĭ��ѡ��tea

		forgetFrame.setLayout(new GridLayout(8, 1));

		forgetFrame.add(p1);
		forgetFrame.add(p2);
		forgetFrame.add(p3);
		forgetFrame.add(p4);
		forgetFrame.add(p5);
		forgetFrame.add(p6);
		forgetFrame.add(p7);
		forgetFrame.add(p8);

		p2.add(nameLabel);
		p2.add(nameField);
		p3.add(accountLabel);
		p3.add(accountField);
		p4.add(idcardLabel);
		p4.add(idcardField);
		p7.add(chooseLabel);
		p7.add(adm);
		p7.add(tea);
		p7.add(stu);
		p8.add(confirmButton);

		forgetFrame.setSize(500, 600);
		forgetFrame.setVisible(true);

		confirmButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//
		if (e.getSource() == confirmButton) {

			if (nameField.getText().length() == 0) {// ����ѡ�ĸ��������Ϊ��
				JOptionPane.showMessageDialog(p2, "�������벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else if (accountField.getText().length() == 0) {// ����ѡ�ĸ�����˺�Ϊ��
				JOptionPane.showMessageDialog(p2, "�˺����벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}else if (idcardField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "���֤���벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			else if (stu.isSelected() ) {// ���ѡ����ѧ���������Ϊ��
				
					String name = nameField.getText();
					String account = accountField.getText();
					String idcard = idcardField.getText();
					String password = null;
					try {
						GetConn getConn = new GetConn();
						Connection connection = getConn.getConnection();
						String sql = "select * from student where stu_name='" + name + "'"// ����������ж����ֺ��˺ź����֤���Ƿ�Ϸ��������Ƿ����û���������
								+ " and stu_number = '" + account + "'"
								+"and stu_idcard = '"+idcard+"'";
						Statement statement = connection.createStatement();
						
						resultSet = statement.executeQuery(sql);
						int count = 0;// ��count�����ж����ֺ��˺��Ƿ�Ϸ��������Ƿ����û���������
						while (resultSet.next()) {
							password = resultSet.getString("stu_password");
							count++;
						}
						System.out.println("������������˺������ַ��ϵļ�¼count=" + count);
						
						if (count != 0) {// ���count������0�������ֺ��˺źϷ����������������

							JOptionPane.showMessageDialog(p2, "'"+account+"'ѧ��,�������Ϊ''" + password + "'", "��Ϣ��ʾ",
									JOptionPane.WARNING_MESSAGE);
							System.out.println("���һ����");
							forgetFrame.dispose();
						}
						else if (count == 0) {// ���򣬼��������˺Ų��Ϸ����������·�Ӧ
							JOptionPane.showMessageDialog(p2, "��Ϣ�����������޷����������һ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
				
				
			} else if (tea.isSelected()) {// ���ѡ���˽�ʦ�������Ϊ��
				
					String name = nameField.getText();
					String account = accountField.getText();
					String password = null;
					String idcard = idcardField.getText();
					try {
						GetConn getConn = new GetConn();
						Connection connection = getConn.getConnection();
						String sql = "select * from teacher where tea_name='" + name + "'"// ����������ж����ֺ��˺��Ƿ�Ϸ��������Ƿ����û���������
								+ " and tea_id = '" + account + "'"
								+" and tea_idcard = '"+idcard+"'";
						Statement statement = connection.createStatement();
						
						resultSet = statement.executeQuery(sql);
						int count = 0;// ��count�����ж����ֺ��˺��Ƿ�Ϸ��������Ƿ����û���������
						while (resultSet.next()) {
							password =resultSet.getString("tea_password");
							count++;
						}
						System.out.println("������������˺������ַ��ϵļ�¼count=" + count);

						if (count != 0) {// ���count������0�������ֺ��˺źϷ����������������

							JOptionPane.showMessageDialog(p2, "'"+account+"'��ʦ,�������Ϊ' " + password + "'", "��Ϣ��ʾ",
									JOptionPane.WARNING_MESSAGE);
							forgetFrame.dispose();
						} else if (count == 0) {// ���򣬼��������˺Ų��Ϸ����������·�Ӧ
							JOptionPane.showMessageDialog(p2, "��Ϣ�����������޷����������һ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					

			}	
			else if (adm.isSelected()) {// ���ѡ���˹���Ա�������Ϊ��
				
					String name = nameField.getText();
					String account = accountField.getText();
					String password = null;
					String idcard = idcardField.getText();
					
					try {
						GetConn getConn = new GetConn();
						Connection connection = getConn.getConnection();
						String sql = "select * from administrator where adm_name='" + name + "'"// ����������ж����ֺ��˺��Ƿ�Ϸ��������Ƿ����û���������
								+ " and adm_account = '" + account + "'"
								+"and adm_idcard = '" + idcard + "'";
						Statement statement = connection.createStatement();
						System.out.println("adm_name=" + name);
						
						resultSet = statement.executeQuery(sql);
						int count = 0;// ��count�����ж����ֺ��˺��Ƿ�Ϸ��������Ƿ����û���������
						while (resultSet.next()) {
							password = resultSet.getString("adm_password");
							count++;
						}
						System.out.println("������������˺������ַ��ϵļ�¼count=" + count);

						if (count != 0) {// ���count������0�������ֺ��˺źϷ����������������
							
							
							JOptionPane.showMessageDialog(p2, "'"+account+"'����Ա,��ĵ�����Ϊ' " + password + "'", "��Ϣ��ʾ",
									JOptionPane.WARNING_MESSAGE);
							System.out.println("���һ����");
							forgetFrame.dispose();
						} else if (count == 0) {// ���򣬼��������˺Ų��Ϸ����������·�Ӧ
							JOptionPane.showMessageDialog(p2, "��Ϣ�����������޷����������һ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
			
			
			
		}

	}
	
	public static void main(String[] args) {
		new ForgetPassword();
	}

}

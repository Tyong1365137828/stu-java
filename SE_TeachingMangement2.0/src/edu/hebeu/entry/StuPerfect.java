package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Student;

public class StuPerfect implements ActionListener{
	
	JFrame perFrame = new JFrame("ѧ����Ϣ�޸�������");
	
	JButton returnButton,confirmButton;
	
	JLabel nameLabel,genderLabel,ageLabel,teLabel,addressLabel,idcardLabel;
	
	JTextField nameField,ageField,telField,addressField,idcardField;
	
	JRadioButton manRadioButton,womanRadioButton;
	
	ButtonGroup group;
	
//	String[] depnumlist;
//	JComboBox<String> depnumcomboBox = null;// ��������������
	
	String account;
	
	JPanel p1,p2,p3,p4,p5,p6,p7,p8;
	
	public StuPerfect() {
		
		returnButton = new JButton("����");
		confirmButton = new JButton("ȷ��");
		
		nameLabel = new JLabel("����");
		ageLabel = new JLabel("����");
		genderLabel = new JLabel("�Ա�");
		teLabel = new JLabel("�ֻ���");
		addressLabel = new JLabel("��ַ");
//		depnumLabel = new JLabel("ϵ��");
		idcardLabel = new JLabel("���֤��");
		
		nameField = new JTextField(5);
		ageField = new JTextField(5);
		idcardField = new JTextField(15);
		telField = new JTextField(15);
		addressField = new JTextField(15);
//		depnamField = new JTextField(5);
//		depnamField = new JTextField("��ѡ��",10);
//		depnamField.setEditable(false);
		
		manRadioButton = new JRadioButton("��");
		womanRadioButton = new JRadioButton("Ů");
		
		group = new ButtonGroup();
		group.add(manRadioButton);
		group.add(womanRadioButton);
		manRadioButton.setSelected(true);//Ĭ��ѡ����
		
//		depnumlist = new String[] {"��ѡ��","001","002","003","004","005","006","007",};
//		depnumcomboBox = new JComboBox<String>(depnumlist);
//		depnumcomboBox.setSelectedIndex(0);
		
		account = Memory();
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		
		perFrame.setLayout(new GridLayout(8,1));
		
		perFrame.add(p1);
		perFrame.add(p2);
		perFrame.add(p3);
		perFrame.add(p4);
		perFrame.add(p5);
		perFrame.add(p6);
		perFrame.add(p7);
		perFrame.add(p8);
		
		p1.add(returnButton);
		p2.add(nameLabel);
		p2.add(nameField);
		p2.add(idcardLabel);
		p2.add(idcardField);
		p3.add(genderLabel);
		p3.add(manRadioButton);
		p3.add(womanRadioButton);
		p3.add(ageLabel);
		p3.add(ageField);
		p4.add(teLabel);
		p4.add(telField);
		p5.add(addressLabel);
		p5.add(addressField);
//		p6.add(depnumLabel);
//		p6.add(depnumcomboBox);
//		p6.add(depnamField);
		p7.add(confirmButton);
		
		perFrame.setSize(700, 900);
		perFrame.setVisible(true);
		
//		depnumcomboBox.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				
//				if(e.getStateChange() == ItemEvent.SELECTED) {
//					if(e.getItem().equals(depnumlist[0])) {
//						depnamField.setText("��ѡ��");
//					}
//					if(e.getItem().equals(depnumlist[1])) {
//						depnamField.setText("�������");
//					}
//					if(e.getItem().equals(depnumlist[2])) {
//						depnamField.setText("�������ѧ�뼼��");
//					}
//					if(e.getItem().equals(depnumlist[3])) {
//						depnamField.setText("������");
//					}
//					if(e.getItem().equals(depnumlist[4])) {
//						depnamField.setText("��������");
//					}
//					if(e.getItem().equals(depnumlist[5])) {
//						depnamField.setText("��е�����Զ���");
//					}
//					if(e.getItem().equals(depnumlist[6])) {
//						depnamField.setText("ұ�𹤳�");
//					}
//					if(e.getItem().equals(depnumlist[7])) {
//						depnamField.setText("ũѧ");
//					}
//				}
//				
//			}
//		});
		
		
		returnButton.addActionListener(this);
		confirmButton.addActionListener(this);
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == returnButton) {
			perFrame.dispose();
		}
		
		if(e.getSource() == confirmButton) {
			if(nameField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "����������", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if(idcardField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "���������֤��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if(ageField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "����������", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if(telField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "�������ֻ���", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if(addressField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "�������ַ", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else {
				Student student = new Student();
				student.setStu_number(account);
				DefaultButtonModel model = (DefaultButtonModel) manRadioButton.getModel();//ѡ���в�����model����
				if(model.getGroup().isSelected(model)) {//��ѡ�����е�model����ʱ
					student.setStu_gender(String.valueOf(manRadioButton.getText()));
				}else {//����
					student.setStu_gender(String.valueOf(womanRadioButton.getText()));
				}
				student.setStu_address(String.valueOf(addressField.getText()));
				student.setStu_idcard(String.valueOf(idcardField.getText()));
//				student.setStu_depnum(String.valueOf(depnumcomboBox.getSelectedItem()));//��ȡ�������ֵ
				student.setStu_age(String.valueOf(ageField.getText()));
				student.setStu_name(String.valueOf(nameField.getText()));
				student.setStu_tel(String.valueOf(telField.getText()));
				
				StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
				
				studentDaoImpl.perfectinformation(student);
				
				JOptionPane.showMessageDialog(perFrame, "��Ϣ�޸ĳɹ���", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);	
			}
			
		}	
	}
	
	
	
	
	public static void main(String[] args) {
		new StuPerfect();
	}
	
	
	String Memory() {
		
		String accountField = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				accountField = resultSet.getString(1);//�������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountField;
		
	}
	
}

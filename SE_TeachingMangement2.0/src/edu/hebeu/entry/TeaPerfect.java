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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Teacher;

public class TeaPerfect implements ActionListener{
	JFrame perFrame = new JFrame("��ʦ��Ϣ�޸�������");

	JButton returnButton, confirmButton;

	JLabel nameLabel, genderLabel, ageLabel, teLabel, depnumLabel, idcardLabel;

	JTextField nameField, ageField, telField, depnamField, idcardField;

	JRadioButton manRadioButton, womanRadioButton;

	ButtonGroup group;

	String[] depnumlist;
	JComboBox<String> depnumcomboBox = null;// ��������������

	String account;

	JPanel p1, p2, p3, p4, p5, p6, p7, p8;

	public TeaPerfect() {

		returnButton = new JButton("����");
		confirmButton = new JButton("ȷ��");

		nameLabel = new JLabel("����");
		ageLabel = new JLabel("����");
		genderLabel = new JLabel("�Ա�");
		teLabel = new JLabel("�ֻ���");
//		depnumLabel = new JLabel("ϵ��");
		idcardLabel = new JLabel("���֤��");

		nameField = new JTextField(5);
		ageField = new JTextField(5);
		idcardField = new JTextField(15);
		telField = new JTextField(15);
//		depnamField = new JTextField(5);
//		depnamField = new JTextField("��ѡ��", 10);
//		depnamField.setEditable(false);

		manRadioButton = new JRadioButton("��");
		womanRadioButton = new JRadioButton("Ů");

		group = new ButtonGroup();
		group.add(manRadioButton);
		group.add(womanRadioButton);
		manRadioButton.setSelected(true);// Ĭ��ѡ����

//		depnumlist = new String[] { "��ѡ��", "001", "002", "003", "004", "005", "006", "007", };
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

		perFrame.setLayout(new GridLayout(8, 1));

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
//		p5.add(depnumLabel);
//		p5.add(depnumcomboBox);
//		p5.add(depnamField);
		p7.add(confirmButton);
		
//		Toolkit toolkit =perFrame.getToolkit();
//		Dimension dimension = toolkit.getScreenSize();
//		int width = dimension.width;
//		int height = dimension.height;
		
		perFrame.setSize(600, 700);
		perFrame.setVisible(true);
		
		confirmButton.addActionListener(this);
		
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
//			}
//		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==confirmButton) {
			if(nameField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "����������", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if(idcardField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "���������֤��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if(ageField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "����������", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if(telField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "�������ֻ���", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else {
				Teacher teacher = new Teacher();
				teacher.setTea_id(account);
				DefaultButtonModel model = (DefaultButtonModel) manRadioButton.getModel();//ѡ���в�����model����
				if(model.getGroup().isSelected(model)) {//��ѡ�����е�model����ʱ
					teacher.setTea_gender(String.valueOf(manRadioButton.getText()));
				}else {//����
					teacher.setTea_gender(String.valueOf(womanRadioButton.getText()));
				}
				teacher.setTea_idcard(String.valueOf(idcardField.getText()));
//				teacher.setTea_depnum(String.valueOf(depnumcomboBox.getSelectedItem()));//��ȡ�������ֵ
				teacher.setTea_age(String.valueOf(ageField.getText()));
				teacher.setTea_name(String.valueOf(nameField.getText()));
				teacher.setTea_tel(String.valueOf(telField.getText()));
				
				TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
				
				teacherDaoImpl.perfectinformation(teacher);
				
				JOptionPane.showMessageDialog(perFrame, "��ʦ��Ϣ�޸ĳɹ���", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);	
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new TeaPerfect();
	}

	String Memory() {

		String accountField = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				accountField = resultSet.getString(1);// �������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountField;

	}

}

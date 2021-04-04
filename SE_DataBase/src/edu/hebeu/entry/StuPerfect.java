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
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Stu_Id_Key;
import edu.hebeu.po.Stu_Name_Key;

public class StuPerfect implements ActionListener {
	JFrame perfectFrame = new JFrame("������Ϣ�޸Ľ���");

	JLabel nameLabel, sexLabel, ageLabel, telLabel, addressLabel, depidLabel;

	JTextField nameField, ageField, telField, addressField, depidField;

	JButton returnButton, confirmButton;

	JRadioButton manRadioButton, womanRadioButton;

	ButtonGroup group;
	
	String[] depnumlist;
	JComboBox<String> depnumcomboBox = null;// ��������������

	JPanel p1, p2, p3, p4, p5, p6, p7;

	public StuPerfect() {

		nameLabel = new JLabel("����");
		sexLabel = new JLabel("�Ա�");
		ageLabel = new JLabel("����");
		telLabel = new JLabel("�绰");
		addressLabel = new JLabel("��ַ");
		depidLabel = new JLabel("ϵ��");

		nameField = new JTextField(5);
		ageField = new JTextField(5);
		telField = new JTextField(10);
		addressField = new JTextField(15);
		depidField = new JTextField(10);
		depidField.setEnabled(false);
		
		confirmButton = new JButton("ȷ��");

		manRadioButton = new JRadioButton("��");
		womanRadioButton = new JRadioButton("Ů");

		group = new ButtonGroup();
		group.add(manRadioButton);
		group.add(womanRadioButton);
		manRadioButton.setSelected(true);// Ĭ��ѡ����
		
		depnumlist = new String[] {"001<�������>","002<�������ѧ�뼼��>","003<ұ�𹤳�>"};
		depnumcomboBox = new JComboBox<String>(depnumlist);
		depnumcomboBox.setSelectedIndex(0);
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();

		perfectFrame.setLayout(new GridLayout(7, 1));

		perfectFrame.add(p1);
		perfectFrame.add(p2);
		perfectFrame.add(p3);
		perfectFrame.add(p4);
		perfectFrame.add(p5);
		perfectFrame.add(p6);
		perfectFrame.add(p7);

		p1.add(nameLabel);
		p1.add(nameField);
		p2.add(sexLabel);
		p2.add(manRadioButton);
		p2.add(womanRadioButton);
		p3.add(ageLabel);
		p3.add(ageField);
		p4.add(telLabel);
		p4.add(telField);
		p5.add(addressLabel);
		p5.add(addressField);
		p6.add(depidLabel);
		p6.add(depnumcomboBox);
		p6.add(depidField);
		p7.add(confirmButton);

		confirmButton.addActionListener(this);

		perfectFrame.setSize(500, 800);
		perfectFrame.setVisible(true);
		
		depnumcomboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()== ItemEvent.SELECTED) {
					if(e.getItem().equals(depnumlist[0])) {
						depidField.setText("001");
					}
					if(e.getItem().equals(depnumlist[1])) {
						depidField.setText("002");
					}
					if(e.getItem().equals(depnumlist[2])) {
						depidField.setText("003");
					}
				}
				
				
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == confirmButton) {
			if (nameField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "����������", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if (ageField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "����������", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			} else if (telField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "��������ĵ绰��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else if(addressField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p3, "��������ĵ�ַ", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			}else {
				
				String id = MemoryXianShi();
				String name = null;
				String depid = null;
				String name1 = null;
				
				name = nameField.getText();
				System.out.println("name="+name);
				depid = depidField.getText();
				System.out.println("depid="+depid);
				System.out.println("id="+id);
				
				
				try {
					StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
					ResultSet resultSet = studentDaoImpl.FindStuById(id);
					while(resultSet.next()) {
						name1 = resultSet.getString("stu_name");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				System.out.println("name"+name);
				System.out.println("name1="+name1);
				StudentDaoImpl studentDaoImpl1 = new StudentDaoImpl();
				studentDaoImpl1.DeleteStu(name1);
				
				
				
				Stu_Id_Key stu_Id_Key = new Stu_Id_Key();
				stu_Id_Key.setStu_id(id);
				stu_Id_Key.setStu_name(name);
				stu_Id_Key.setStu_depid(depid);
				
				StudentDaoImpl studentDaoImpl2 = new StudentDaoImpl();
				studentDaoImpl2.perfectinformation(stu_Id_Key);
				
				
				
				
				Stu_Name_Key stu_Name_Key = new Stu_Name_Key();
				stu_Name_Key.setStu_name(name);
				DefaultButtonModel model = (DefaultButtonModel) manRadioButton.getModel();//ѡ���в�����model����
				if(model.getGroup().isSelected(model)) {//��ѡ�����е�model����ʱ
					stu_Name_Key.setStu_sex(String.valueOf(manRadioButton.getText()));
				}else {//����
					stu_Name_Key.setStu_sex(String.valueOf(womanRadioButton.getText()));
				}
				stu_Name_Key.setStu_age(String.valueOf(ageField.getText()));
				stu_Name_Key.setStu_tel(String.valueOf(telField.getText()));
				stu_Name_Key.setStu_address(String.valueOf(addressField.getText()));
				
				StudentDaoImpl studentDaoImpl3 = new StudentDaoImpl();
				studentDaoImpl3.perfectinformation(stu_Name_Key);
				
				
				
				
				JOptionPane.showMessageDialog(p3, "��Ϣ�޸ĳɹ���", "��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);	
				perfectFrame.dispose();
			}
		}

	}

	String MemoryXianShi() {// ���������ݱ�����һ����¼
		String id = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getString(1);// �������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}

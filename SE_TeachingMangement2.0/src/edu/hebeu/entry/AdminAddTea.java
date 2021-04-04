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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;

public class AdminAddTea implements ActionListener {

	JFrame addFrame = new JFrame("��ӽ�ʦ����");

	JLabel idLabel, passwordLabel, depnumLabel;

	JTextField idField, passwordField, depnamField;

	JButton addButton;

	JPanel p1, p2, p3;

	JPanel p11, p12, p21, p22;

	String[] depnumlist;
	JComboBox<String> depnumcomboBox = null;// ��������������

	String depnum = "";

	public AdminAddTea() {

		idLabel = new JLabel("����˺�");
		passwordLabel = new JLabel("�������");
		depnumLabel = new JLabel("���ϵ��");

		idField = new JTextField(10);
		passwordField = new JPasswordField(10);
		depnamField = new JTextField("��ѡ��", 10);
		depnamField.setEnabled(false);

		addButton = new JButton("ȷ�����");

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		p11 = new JPanel();
		p12 = new JPanel();
		p21 = new JPanel();
		p22 = new JPanel();

		depnumlist = new String[] { "��ѡ��", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010" };
		depnumcomboBox = new JComboBox<String>(depnumlist);
		depnumcomboBox.setSelectedIndex(0);

		p1.setLayout(new GridLayout(2, 1));
		p1.add(p11);
		p1.add(p12);

		p2.setLayout(new GridLayout(2, 1));
		p2.add(p21);
		p2.add(p22);

		addFrame.setLayout(new GridLayout(3, 1));

		addFrame.add(p1);
		addFrame.add(p2);
		addFrame.add(p3);

		p12.add(idLabel);
		p12.add(idField);
		p21.add(passwordLabel);
		p21.add(passwordField);
		p22.add(depnumLabel);
		p22.add(depnumcomboBox);
		p22.add(depnamField);
		p3.add(addButton);

		addFrame.setVisible(true);
		addFrame.setSize(500, 400);

		depnumcomboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(depnumlist[0])) {
						depnamField.setText("��ѡ��");
					}
					if (e.getItem().equals(depnumlist[1])) {
						depnamField.setText("�������");
						depnum = "001";
					}
					if (e.getItem().equals(depnumlist[2])) {
						depnamField.setText("�������ѧ�뼼��");
						depnum = "002";
					}
					if (e.getItem().equals(depnumlist[3])) {
						depnamField.setText("������");
						depnum = "003";
					}
					if (e.getItem().equals(depnumlist[4])) {
						depnamField.setText("��������");
						depnum = "004";
					}
					if (e.getItem().equals(depnumlist[5])) {
						depnamField.setText("��е�����Զ���");
						depnum = "005";
					}
					if (e.getItem().equals(depnumlist[6])) {
						depnamField.setText("ұ�𹤳�");
						depnum = "006";
					}
					if (e.getItem().equals(depnumlist[7])) {
						depnamField.setText("ũѧ");
						depnum = "007";
					}
					if (e.getItem().equals(depnumlist[8])) {
						depnamField.setText("Ӧ�û�ѧ");
						depnum = "008";
					}
					if (e.getItem().equals(depnumlist[9])) {
						depnamField.setText("��ľ����");
						depnum = "009";
					}
					if (e.getItem().equals(depnumlist[10])) {
						depnamField.setText("ˮ��ˮ�繤��");
						depnum = "010";
					}
				}

			}
		});

		addButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (idField.getText().length() == 0) {
			JOptionPane.showMessageDialog(p3, "����������˺�", "���󾯸�", JOptionPane.ERROR_MESSAGE);
		} else if (passwordField.getText().length() == 0) {
			JOptionPane.showMessageDialog(p3, "����������˺ŵ�����", "���󾯸�", JOptionPane.ERROR_MESSAGE);
		} else if (depnamField.getText().equals("��ѡ��")) {
			JOptionPane.showMessageDialog(p3, "��ѡ������˺ŵ�ϵ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
		} else {

			String id = idField.getText();
			String password = passwordField.getText();
			int count = 0;
			
			try {
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				ResultSet resultSet = administratorDaoImpl.JSelectTeaByNum(id);
				while (resultSet.next()) {
					count++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(count != 0) {
				JOptionPane.showMessageDialog(p2, "�Ѵ���idΪ"+id+"�Ľ�ʦ�˺�,���������˺�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
			}else {
				AdministratorDaoImpl administratorDaoImpl2 = new AdministratorDaoImpl();
				administratorDaoImpl2.AddTea(id, password, depnum);
				
				JOptionPane.showMessageDialog(p2, "idΪ'" + id + "'�Ľ�ʦ����ӳɹ���", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	public static void main(String[] args) {
		new AdminAddTea();
	}

}

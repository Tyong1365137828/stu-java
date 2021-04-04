package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.po.Dep_Id_Key;
import edu.hebeu.po.Stu_Id_Key;

public class AdmDeleteStu implements ActionListener {

	JFrame deleteFrame = new JFrame("ѧ��ɾ������");

	JLabel selectLabel, label, numLabel, namLabel, depLabel;

	JRadioButton stu_id, stu_name;

	ButtonGroup group;

	JButton checkButton, deleteButton;

	JTextField field;
	
	JLabel  numField, namField, depField;

	JPanel p1, p2, p3, p4, p5, p6, p7;

	public AdmDeleteStu() {

		selectLabel = new JLabel("ѡ���ѯ��ʽ");
		label = new JLabel("������");
		numLabel = new JLabel();
		namLabel = new JLabel();
		depLabel = new JLabel();
		
		stu_id = new JRadioButton("��id��");
		stu_name = new JRadioButton("������");

		checkButton = new JButton("����");
		deleteButton = new JButton("ɾ��");
		deleteButton.setVisible(false);
		
		field = new JTextField(15);
		numField = new JLabel("",10);
		namField = new JLabel("",10);
		depField = new JLabel("",10);

		group = new ButtonGroup();
		group.add(stu_id);
		group.add(stu_name);
		stu_id.setSelected(true);

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();

		deleteFrame.setLayout(new GridLayout(7, 1));

		deleteFrame.add(p1);
		deleteFrame.add(p2);
		deleteFrame.add(p3);
		deleteFrame.add(p4);
		deleteFrame.add(p5);
		deleteFrame.add(p6);
		deleteFrame.add(p7);

		p1.add(selectLabel);
		p1.add(stu_id);
		p1.add(stu_name);
		p2.add(label);
		p2.add(field);
		p2.add(checkButton);
		p3.add(numLabel);
		p3.add(numField);
		p4.add(namLabel);
		p4.add(namField);
		p5.add(depLabel);
		p5.add(depField);
		p6.add(deleteButton);

		deleteFrame.setBounds(850, 20, 500, 400);
		deleteFrame.setResizable(false);
		deleteFrame.setVisible(true);

		checkButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == checkButton) {
			if (field.getText().length() == 0) {
				JOptionPane.showMessageDialog(p2, "����Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			} else if (stu_id.isSelected()) {//��id��ѡ��

				String id = field.getText();
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				Stu_Id_Key stu_Id_Key = administratorDaoImpl.FindStuById(id);

				if (stu_Id_Key.getStu_id() != null) {// ��Ϊ��ֵ
					numLabel.setText("ѧ�ţ�");
					namLabel.setText("����");

					numField.setText(stu_Id_Key.getStu_id());
					namField.setText(stu_Id_Key.getStu_name());

					String depid = stu_Id_Key.getStu_depid();
					AdministratorDaoImpl administratorDaoImpl2 = new AdministratorDaoImpl();
					Dep_Id_Key dep_Id_Key = administratorDaoImpl2.FindDepByDepid(depid);

					if (dep_Id_Key.getDep_id() != null) {
						depLabel.setText("ϵ����");
						depField.setText(dep_Id_Key.getDep_name());
					}
					deleteButton.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(p3, "���޴���", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
				}

			} else if (stu_name.isSelected()) {//�����ֲ�ѡ��

				String name = field.getText();
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				Stu_Id_Key stu_Id_Key = administratorDaoImpl.FindById(name);

				if (stu_Id_Key.getStu_name() != null) {

					numLabel.setText("ѧ�ţ�");
					namLabel.setText("����");

					numField.setText(stu_Id_Key.getStu_id());
					namField.setText(stu_Id_Key.getStu_name());

					String depid = stu_Id_Key.getStu_depid();
					AdministratorDaoImpl administratorDaoImpl2 = new AdministratorDaoImpl();
					Dep_Id_Key dep_Id_Key = administratorDaoImpl2.FindDepByDepid(depid);

					if (dep_Id_Key.getDep_id() != null) {
						depLabel.setText("ϵ����");
						depField.setText(dep_Id_Key.getDep_name());
					}
					deleteButton.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(p3, "���޴���", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
				}

			}

		}

		if (e.getSource() == deleteButton) {
			if (stu_id.isSelected()) {
				String id = numField.getText();
				String name = namField.getText();
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				administratorDaoImpl.DeleteStu(id, name);

				JOptionPane.showMessageDialog(p3, "�ɹ���'" + id + "''" + name + "'ɾ����", "��Ϣ��ʾ",
						JOptionPane.CLOSED_OPTION);

			} else if (stu_name.isSelected()) {
				String name = namField.getText();
				String id = numField.getText();
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				administratorDaoImpl.DeleteStu(id, name);

				JOptionPane.showMessageDialog(p3, "�ɹ���'" + id + "''" + name + "'ɾ����", "��Ϣ��ʾ",
						JOptionPane.CLOSED_OPTION);
			}
		}

	}
	
}

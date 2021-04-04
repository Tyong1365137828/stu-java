package edu.hebeu.entry;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.po.Student;
import edu.hebeu.po.Teacher;

public class Register implements ActionListener {

	JFrame registerJframe = new JFrame("ע�����");
	JLabel registerJLabel, accountJLabel, passwordJLabel, repasswordJLabel, quanxianJLabel;
	JTextField accountField, passwordField, repasswordField;
	JButton cancelButton, registerButton;
	Font font1, font2;
	String[] quanxianlist;// �����������鲢����������
	JComboBox<String> quanxiancomboBox = null;// ��������������
	String quanxian;

	public Register() {

		registerJLabel = new JLabel("�û�ע��");
		accountJLabel = new JLabel("�û��˺�");
		passwordJLabel = new JLabel("�û�����");
		repasswordJLabel = new JLabel("ȷ������");
		quanxianJLabel = new JLabel("Ȩ��ѡ��");

		accountField = new JTextField();
		passwordField = new JPasswordField();
		repasswordField = new JPasswordField();

		registerButton = new JButton("ע��");
		cancelButton = new JButton("ȡ��");

		font1 = new Font("����", Font.BOLD, 15);
		font2 = new Font("����", Font.PLAIN, 60);

		accountJLabel.setFont(font1);
		passwordJLabel.setFont(font1);
		repasswordJLabel.setFont(font1);
		quanxianJLabel.setFont(font1);
		registerJLabel.setFont(font2);

		quanxianlist = new String[] { "��ѡ��", "��ʦ", "ѧ��" };// ��0��ʼ����
		quanxiancomboBox = new JComboBox<String>(quanxianlist);// ���������򲢷�������
		quanxiancomboBox.setSelectedIndex(0);// Ĭ��ѡ������Ϊ0������Ԫ��

		registerJframe.setLayout(null);// ʹ���Զ��岼��

		cancelButton.setBounds(530, 0, 60, 20);
		registerJLabel.setBounds(170, 30, 480, 120);
		accountJLabel.setBounds(100, 180, 70, 25);
		accountField.setBounds(170, 180, 320, 25);
		passwordJLabel.setBounds(100, 230, 70, 25);
		passwordField.setBounds(170, 230, 320, 25);
		repasswordJLabel.setBounds(100, 280, 70, 25);
		repasswordField.setBounds(170, 280, 320, 25);
		quanxianJLabel.setBounds(100, 330, 70, 30);
		quanxiancomboBox.setBounds(170, 330, 320, 25);
		registerButton.setBounds(170, 380, 320, 25);

		registerJframe.add(cancelButton);
		registerJframe.add(registerJLabel);
		registerJframe.add(accountJLabel);
		registerJframe.add(accountField);
		registerJframe.add(passwordJLabel);
		registerJframe.add(passwordField);
		registerJframe.add(repasswordJLabel);
		registerJframe.add(repasswordField);
		registerJframe.add(quanxianJLabel);
		registerJframe.add(quanxiancomboBox);
		registerJframe.add(registerButton);

		Toolkit toolkit = registerJframe.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;

		registerJframe.setLocation((width - 600) / 2, (height - 700) / 2);
		registerJframe.setSize(600, 700);

		cancelButton.addActionListener(this);
		registerButton.addActionListener(this);
		registerJframe.setVisible(true);

		quanxiancomboBox.addItemListener(new ItemListener() {// �Ǹ�comboBox���ü�������

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (passwordField.getText().equals(repasswordField.getText())) {// ע:�˲�����==,������equals()
					if (e.getStateChange() == ItemEvent.SELECTED) {// ֻ����ѡ�е�״̬

						if (e.getItem().equals(quanxianlist[0])) {
							quanxian = "��ѡ��Ȩ��";
						}

						else if (e.getItem().equals(quanxianlist[1])) {// ���ѡ��������2������ʦ
							quanxian = "��ʦ";
						}

						else if (e.getItem().equals(quanxianlist[2])) {// ���ѡ��������3����ѧ��
							quanxian = "ѧ��";
						}

						else if (repasswordField.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "ȷ�������Ϊ0", "asd", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}

				}

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			registerJframe.dispose();
			new Login();
		}

		if (e.getSource() == registerButton) {// ���ѡ��������3����ѧ��
			if (accountField.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "�˺ſ�Ϊ0", "asd", JOptionPane.INFORMATION_MESSAGE);
			} else if (passwordField.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "�����Ϊ0", "asd", JOptionPane.INFORMATION_MESSAGE);
			} else if (repasswordField.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "ȷ�������Ϊ0", "asd", JOptionPane.INFORMATION_MESSAGE);
			} else if (!passwordField.getText().equals(repasswordField.getText())) {// ���������벻ͬʱ
				JOptionPane.showMessageDialog(null, "�������Ƿ����������������Ƿ��Ӧ!", "asd", JOptionPane.INFORMATION_MESSAGE);
			} else if (quanxian == "ѧ��") {
				String stu_number = String.valueOf(accountField.getText());
				String stu_repassword = String.valueOf(repasswordField.getText());
				int count = 0;

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					ResultSet resultSet = administratorDaoImpl.JSelectStudentByNum(stu_number);
					while (resultSet.next()) {
						count++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (count != 0) {
					JOptionPane.showMessageDialog(null, "�Ѵ���idΪ" + stu_number + "��ѧ���˺�,���������˺�", "��Ϣ��ʾ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Student student = new Student(stu_number, stu_repassword);
					StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
					studentDaoImpl.registerStudent(student);
					JOptionPane.showMessageDialog(null, "ѧ��'" + stu_number + "'ע��ɹ�", "��Ϣ��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
					registerJframe.dispose();
				}

			} else if (quanxian == "��ʦ") {
				String tea_id = String.valueOf(accountField.getText());
				String tea_password = String.valueOf(passwordField.getText());
				int count = 0;

				try {
					AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
					ResultSet resultSet = administratorDaoImpl.JSelectTeaByNum(tea_id);
					while (resultSet.next()) {
						count++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(count != 0) {
					JOptionPane.showMessageDialog(null, "�Ѵ���idΪ"+tea_id+"�Ľ�ʦ�˺�,���������˺�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
				}else {
					Teacher teacher = new Teacher(tea_id, tea_password);
					TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
					teacherDaoImpl.registerTeacher(teacher);
					JOptionPane.showMessageDialog(null, "��ʦ'" + tea_id + "'ע��ɹ�", "asd", JOptionPane.INFORMATION_MESSAGE);
					registerJframe.dispose();
				}
				
			} else if (quanxian == "��ѡ��Ȩ��") {
				JOptionPane.showMessageDialog(null, "��ѡ��Ȩ��", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}

}
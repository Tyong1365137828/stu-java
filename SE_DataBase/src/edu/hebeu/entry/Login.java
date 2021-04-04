package edu.hebeu.entry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Administrator;
import edu.hebeu.po.Stu_Id_Key;

public class Login implements ActionListener {

	JFrame loginFrame = new JFrame("��½����");

	JPanel p1, p2, p3, p4, p5, p6;

	JLabel idLabel, passwordLabel;

	JTextField idField, passwordField;

	JButton loginButton, registerButton;

	JRadioButton stu, adm;

	ButtonGroup group;

	public Login() {

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();

		idLabel = new JLabel("�˺�");
		passwordLabel = new JLabel("����");

		idField = new JTextField(18);
		passwordField = new JPasswordField(18);

		loginButton = new JButton("��¼");
		registerButton = new JButton("ע��");

		stu = new JRadioButton("ѧ��");
		adm = new JRadioButton("����Ա");

		group = new ButtonGroup();
		group.add(adm);
		group.add(stu);
		adm.setSelected(true);

		loginFrame.setLayout(new GridLayout(6, 1));

		loginFrame.add(p1);
		loginFrame.add(p2);
		loginFrame.add(p3);
		loginFrame.add(p4);
		loginFrame.add(p5);
		loginFrame.add(p6);

		p2.add(idLabel);
		p2.add(idField);
		p3.add(passwordLabel);
		p3.add(passwordField);
		p4.add(adm);
		p4.add(stu);
		p5.add(loginButton);
		p5.add(registerButton);
		
		if(idField.getText().equals("")) {
			idField.setText(MemoryXianShi());
		}
		
		Toolkit toolkit = loginFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;

		loginFrame.setLocation((width - 600) / 2, (height - 700) / 2);
		loginFrame.setSize(600, 700);

		loginButton.addActionListener(this);
		registerButton.addActionListener(this);

		loginFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == registerButton) {
			new Register();
			loginFrame.dispose();
		}
		
		if (e.getSource() == loginButton) {
			
			Memory(idField.getText());
			
			if (adm.isSelected()) {
				Administrator administrator = new Administrator();
				administrator.setAdm_id(String.valueOf(idField.getText()));
				administrator.setAdm_password(String.valueOf(passwordField.getText()));

				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
				Administrator administrator2 = administratorDaoImpl.FindAdmByIdAndPassword(administrator);
				if (administrator2 != null) {
					JOptionPane.showMessageDialog(p3, "'" + idField.getText() + "'����Ա��¼�ɹ�", "��Ϣ��ʾ",
							JOptionPane.WARNING_MESSAGE);
					loginFrame.dispose();
					new AdministratorMangerment();
				} else {
					JOptionPane.showMessageDialog(p3, "��������ȷ���˺Ż�����", "���󾯸�", JOptionPane.WARNING_MESSAGE);
					loginButton.setBackground(Color.RED);
				}

			}

			if (stu.isSelected()) {
				Stu_Id_Key stu_Id_Key = new Stu_Id_Key();
				stu_Id_Key.setStu_id(String.valueOf(idField.getText()));
				stu_Id_Key.setStu_password(String.valueOf(passwordField.getText()));

				StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
				Stu_Id_Key stu_Id_Key2 = studentDaoImpl.FindStudentByIdAndPassword(stu_Id_Key);
				if (stu_Id_Key2 != null) {
					JOptionPane.showMessageDialog(p3, "'" + idField.getText() + "'ѧ����¼�ɹ�", "��Ϣ��ʾ",
							JOptionPane.WARNING_MESSAGE);
					loginFrame.dispose();
					new StuMangerment();
				} else {
					JOptionPane.showMessageDialog(p3, "��������ȷ���˺Ż�����", "���󾯸�", JOptionPane.WARNING_MESSAGE);
					loginButton.setBackground(Color.RED);
				}
			}
		}
	}

	void Memory(String id) {// �����еĵ�¼��¼����һ������

		GetConn getConn = new GetConn();
		Connection connection = getConn.getConnection();
		try {
			Statement statement = connection.createStatement();
			Date date = new Date();
			
			String sql = "insert into memory value ('"+id+"','"+date.toString()+"')";
			statement.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	String MemoryXianShi() {//���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
		String idField = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				idField = resultSet.getString(1);//�������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idField;
	}

}

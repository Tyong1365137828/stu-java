package edu.hebeu.entry;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import edu.hebeu.daoimpl.TeacherDaoImpl;
import edu.hebeu.jdbc.GetConn;
import edu.hebeu.po.Administrator;
import edu.hebeu.po.Student;
import edu.hebeu.po.Teacher;

/**
 * @author ����
 *
 *         2019��12��13��
 */
public class Login implements ActionListener {

	JFrame loginFrame = new JFrame("��¼����");

	JPanel p1, p2, p3, p4, p5;

	JLabel accountLabel, passwordLabel, chooseLabel,loginJLabel;
	JTextField accountField, passwordField;
	JButton loginButton, cancelButton,registerButton,forgetButton;
	JRadioButton stu, tea, adm; // ��ѡ��ť
	ButtonGroup group;

	Font font1,font2;
	
	JLabel l1= null;
//	@SuppressWarnings("deprecation")
	public Login() {

		accountLabel = new JLabel("�˺�");
		passwordLabel = new JLabel("����");
		chooseLabel = new JLabel("��¼Ȩ��");
		loginJLabel = new JLabel("�û���¼");
		
		accountField = new JTextField();
		passwordField = new JPasswordField();

		loginButton = new JButton("��¼");
		cancelButton = new JButton("ȡ��");
		registerButton = new JButton("ע���û�");
		forgetButton = new JButton("�������룿");
		
		stu = new JRadioButton("ѧ��");
		tea = new JRadioButton("��ʦ");
		adm = new JRadioButton("����Ա");
		
		font1= new Font("����", Font.BOLD, 15);
		font2 = new Font("����", Font.PLAIN, 60);
		
		Toolkit toolkit =loginFrame.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		
		loginFrame.setLocation((width-600)/2, (height-700)/2);
		loginFrame.setSize(600, 700);
		
		ImageIcon imageIcon = new ImageIcon("src/images/login.jpg");
		l1 = new JLabel(imageIcon);
		loginFrame.getLayeredPane().add(l1, new Integer(Integer.MIN_VALUE));
		l1.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		
		Container cp = loginFrame.getContentPane();
		cp.setLayout(null);//ʹ���Զ��岼��
		
		accountLabel.setFont(font1);
		passwordLabel.setFont(font1);
		loginJLabel.setFont(font2);		
		loginJLabel.setForeground(Color.green);
		
		
		group = new ButtonGroup();//��stu,tea,adm����ButtonGroup�Ķ���group��,��ʹ��3��JRadioButtonֻ��ѡһ��
		group.add(stu);
		group.add(tea);
		group.add(adm);
		adm.setSelected( true );//Ĭ��ѡ��adm
//		stu.setSelected(true);//Ĭ��ѡ��stu
//		tea.setSelected(true);//Ĭ��ѡ��tea

//		loginFrame.setLayout(null);//ʹ���Զ��岼��

		loginJLabel.setBounds(170, 30, 480, 120);
		chooseLabel.setBounds(155, 170, 60, 25);
		adm.setBounds(230, 170, 65, 25);
		tea.setBounds(310, 170, 60, 25);
		stu.setBounds(385, 170, 60, 25);
		accountLabel.setBounds(120, 220, 30, 25);
		accountField.setBounds(160, 220, 320, 25);
		passwordLabel.setBounds(120, 270, 30, 25);
		passwordField.setBounds(160, 270, 320, 25);
		loginButton.setBounds(125, 320, 355, 30);
		registerButton.setBounds(175, 380, 95, 20);
		forgetButton.setBounds(340, 380, 95, 20);
		
		cp.add(loginJLabel);
		cp.add(chooseLabel);
		cp.add(adm);
		cp.add(tea);
		cp.add(stu);
		cp.add(accountLabel);
		cp.add(accountField);
		cp.add(passwordLabel);
		cp.add(passwordField);
		cp.add(loginButton);
		cp.add(registerButton);
		cp.add(forgetButton);
		
		if(accountField.getText().equals("")) {//���accountField��ֵΪ�գ��򽫷���MemoryXianShi��ֵ������һ�ε�¼���˺ţ�����accountField
			accountField.setText(MemoryXianShi());
		}
		
		((JPanel) cp).setOpaque(false);
		
		loginFrame.setResizable(false);
		loginFrame.setVisible(true);
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		forgetButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == forgetButton) {
			new ForgetPassword();
		}
		
		if(e.getSource() == registerButton) {//ע��
			new Register();
		}

		if (e.getSource() == loginButton) {// �������˵�¼��ť
			Memory(accountField.getText());//���ü�����ťloginButton���˺ſ�����ݻ�ò������¼�Memory
			// �������Ա��ݱ�ѡ��
			if (adm.isSelected()) {
				Administrator administrator = new Administrator();// ����Administrator�Ķ���administrator�Ի������set��get����
				administrator.setAdm_account(String.valueOf(accountField.getText()));// ��accountfield��ֵ��administrator
				administrator.setAdm_password(String.valueOf(passwordField.getText()));// ��passwordfield��ֵ��administrator

				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();// ����AdministratorDaoImpl�Ķ���administratorDaoImpl�Ե����䷽��
				Administrator administrator2 = administratorDaoImpl
						.FindadministratorByAccountAndPassword(administrator);// ��administrator���������˷�����������ֵ��Administrator�Ķ���administrator2
				if (administrator2 != null) {
//					JOptionPane.showInputDialog������ʾ��Ϣ
					JOptionPane.showMessageDialog(p3, "����Ա��¼�ɹ�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
					new AdministratorManagement();
					loginFrame.dispose();
					
				} else {
					JOptionPane.showMessageDialog(p3, "��������ȷ���˺Ż�����", "���󾯸�", JOptionPane.WARNING_MESSAGE);
					loginButton.setBackground(Color.RED);
				}
			}
		}

		// ���ѧ��ѡ��
		if (stu.isSelected()) {
			Student student = new Student();
			student.setStu_number(String.valueOf(accountField.getText()));
			student.setStu_password(String.valueOf(passwordField.getText()));
			
			StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
			Student student2 = studentDaoImpl.FindStudentBynumberAndPassword(student);
			if (student2 != null) {
				JOptionPane.showMessageDialog(p3, "ѧ����¼�ɹ�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
				new StudentMangement();
				loginFrame.dispose();
			} else {
				JOptionPane.showMessageDialog(p3, "��������ȷ���˺Ż�����", "���󾯸�", JOptionPane.WARNING_MESSAGE);
				loginButton.setBackground(Color.RED);
			}
		}

		// �����ʦѡ��
		if (tea.isSelected()) {
			Teacher teacher = new Teacher();
			teacher.setTea_id(String.valueOf(accountField.getText()));
			teacher.setTea_password(String.valueOf(passwordField.getText()));

			TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
			Teacher teacher2 = teacherDaoImpl.FindTeacherByIdAndPassword(teacher);
			if (teacher2 != null) {
				JOptionPane.showMessageDialog(p3, "��ʦ��¼�ɹ�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
				new TeacherMangement();
			} else {
				JOptionPane.showMessageDialog(p3, "��������ȷ���˺Ż�����", "���󾯸�", JOptionPane.WARNING_MESSAGE);
				loginButton.setBackground(Color.RED);
			}
		}
	}
	
	void Memory (String number) {//�����еĵ�¼��¼����һ������
		
		GetConn getConn = new GetConn();
		Connection connection=getConn.getConnection();
		try {
			Statement statement = connection.createStatement();
			Date date = new Date();
			
			String sql = "insert into memory value ('"+number+"','"+date.toString()+"')";
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	String MemoryXianShi() {//���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
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
	
	public static void main(String[] args) {
		new Login();
	}
	
}

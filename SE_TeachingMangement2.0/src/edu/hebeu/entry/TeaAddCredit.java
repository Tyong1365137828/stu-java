package edu.hebeu.entry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import edu.hebeu.daoimpl.AdministratorDaoImpl;
import edu.hebeu.daoimpl.CourseDaoImpl;
import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.jdbc.GetConn;

public class TeaAddCredit implements ActionListener {

	JFrame teaaddCreditFrame = new JFrame("��ʦ¼��");
	JTabbedPane showPanel;// ��ҳ�����
	JPanel p1, p2;// ���ڷ�ҳ
	/*
	 * 
	 * ��һҳ
	 * 
	 */

	JLabel classLabel;

	JLabel stuIdLabel, stuIddataLabel, creditLabel, stunameLabel, stunamedataLabel;

	JButton yesButton, upButton, downButton;

	JTextField creditField;

	JPanel p11, p12, p13, p14, p15, p16;

	String account;

	int row = 1;// ����ָ�룬���ڻ�ȡ�����ĵ�һ����¼
	int count, count1;// ���ڻ�ȡ�������¼��

	/*
	 * 
	 * �ڶ�ҳ
	 * 
	 */

	JLabel classLabel2, checkLabel2;

	JLabel stuIdLabel2, stuIddataLabel2, creditLabel2, stunameLabel2, stunamedataLabel2;

	JButton yesButton2, checkButton2;

	JTextField creditField2, checkField2;

	JPanel p21, p22, p23, p24, p25, p26;

	String account2;

	public TeaAddCredit() {

		showPanel = new JTabbedPane();

		/*
		 * ��һҳ
		 * 
		 */

		p1 = new JPanel();

		classLabel = new JLabel("" + "�γ�", 10);

		stuIdLabel = new JLabel("ѧ��ѧ��");
		stuIddataLabel = new JLabel("", 10);
		stunameLabel = new JLabel("ѧ������");
		stunamedataLabel = new JLabel("", 10);
		creditLabel = new JLabel("���ѧ��");

		creditField = new JTextField(10);

		yesButton = new JButton("ȷ��");
		upButton = new JButton("��һ��");
		downButton = new JButton("��һ��");

		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p14 = new JPanel();
		p15 = new JPanel();
		p16 = new JPanel();

		teaaddCreditFrame.add(p1);

		p1.setLayout(new GridLayout(6, 1));

		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		p1.add(p14);
		p1.add(p15);
		p1.add(p16);

		p12.add(classLabel);
		p13.add(stuIdLabel);
		p13.add(stuIddataLabel);
		p14.add(stunameLabel);
		p14.add(stunamedataLabel);
		p15.add(creditLabel);
		p15.add(creditField);
		p15.add(yesButton);
		p16.add(upButton);
		p16.add(downButton);

		selectStu();

		showPanel.addTab("ȫ��ѧ��", p1);

		upButton.addActionListener(this);
		downButton.addActionListener(this);
		yesButton.addActionListener(this);

		/*
		 * 
		 * �ڶ�ҳ
		 * 
		 */

		p2 = new JPanel();

		classLabel2 = new JLabel("", 10);

		stuIdLabel2 = new JLabel("ѧ��ѧ��");
		stuIdLabel2.setVisible(false);
		stuIddataLabel2 = new JLabel("", 10);
		stunameLabel2 = new JLabel("ѧ������");
		stunameLabel2.setVisible(false);
		stunamedataLabel2 = new JLabel("", 10);
		creditLabel2 = new JLabel("���ѧ��");
		creditLabel2.setVisible(false);
		checkLabel2 = new JLabel("�����ѯ��ѧ��ѧ��");

		creditField2 = new JTextField(10);
		creditField2.setVisible(false);
		checkField2 = new JTextField(10);

		yesButton2 = new JButton("ȷ��");
		yesButton2.setVisible(false);
		checkButton2 = new JButton("����");

		p21 = new JPanel();
		p22 = new JPanel();
		p23 = new JPanel();
		p24 = new JPanel();
		p25 = new JPanel();
		p26 = new JPanel();

		teaaddCreditFrame.add(p2);

		p2.setLayout(new GridLayout(6, 1));
		p2.add(p21);
		p2.add(p22);
		p2.add(p23);
		p2.add(p24);
		p2.add(p25);
		p2.add(p26);

		System.out.println("aebtbetetstrb");

		p21.add(classLabel2);
		p22.add(checkLabel2);
		p22.add(checkField2);
		p22.add(checkButton2);
		p23.add(stuIdLabel2);
		p23.add(stuIddataLabel2);
		p24.add(stunameLabel2);
		p24.add(stunamedataLabel2);
		p25.add(creditLabel2);
		p25.add(creditField2);
		p25.add(yesButton2);
		
		String teaId = "";
		ResultSet result2 = null;
		
		CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
		teaId = MemoryXianShi();
		result2 = courseDaoImpl.FindCreditByTeanumber(teaId);
		
		try {
			result2.next();
			String classes = result2.getString(2);
			
			classLabel2.setText(classes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		showPanel.addTab("��ѯѧ��", p2);
		
		checkButton2.addActionListener(this);
		yesButton2.addActionListener(this);

		/*
		 * ��ҳ���
		 * 
		 */

		teaaddCreditFrame.add(showPanel);
		teaaddCreditFrame.setSize(600, 700);
		teaaddCreditFrame.setVisible(true);

	}

	/*
	 * 
	 * ��һҳ
	 * 
	 */
	private void selectStu() {
		ResultSet result1 = null;
		ResultSet result2 = null;

		try {
			CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
			account = MemoryXianShi();
			result1 = courseDaoImpl.FindCreditByTeanumber(account);

			result1.last();
			count = result1.getRow();

			if (result1.absolute(row)) {

				String stuId = result1.getString(1);
				String classes = result1.getString(2);

				StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
				result2 = studentDaoImpl.FindAllStudentByNumber(stuId);

				result2.next();
				String stuName = result2.getString(2);

				classLabel.setText(classes);
				stuIddataLabel.setText(stuId);
				stunamedataLabel.setText(stuName);

			}
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
		if (e.getSource().equals(upButton)) {// ������"��һ��"��ť
			row--;// ָ��ֵ��һ
			selectStu();// �����Զ���Ĳ�ѯ�������Խ�rowֵ����
			downButton.setEnabled(true);
			if (row <= 1) {// ��ָ��ֵС��һʱ����������ѯ�����Сָ�뻹С
				upButton.setEnabled(false);// ��ʱ"��һ��"��ť����ѡ��
				row = 1;// ��ʱָ��ֵʼ��Ϊһ
			}
		}

		if (e.getSource().equals(downButton)) {// ������"��һ��"��ť
			row++;// ָ��ֵ��һ
			selectStu();// �����Զ���Ĳ�ѯ�������Խ�rowֵ����
			upButton.setEnabled(true);
			if (row >= count) {// ��ָ��ֵ����countֵʱ����������ѯ������ָ�뻹��
				row = count;// ��ʱָ��ֵʼ��Ϊ����ѯ������ָ��ֵcount
				downButton.setEnabled(false);// ��ʱ"��һ��"��ť����ѡ��
			}
		}

		if (e.getSource() == yesButton) {
			if (creditField.getText().length() == 0) {
				JOptionPane.showMessageDialog(p13, "�����������ѧ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			} else {

				String stuId = stuIddataLabel.getText();
				String credit = creditField.getText();

				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
				courseDaoImpl.addCredit(stuId, account, credit);

				JOptionPane.showMessageDialog(p13, "�ɹ�¼���ѧ���ķ���", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
			}
		}

		/*
		 * 
		 * �ڶ�ҳ
		 * 
		 */

		if (e.getSource() == checkButton2) {

			String stuId = checkField2.getText();
			
			try {
				AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();

				ResultSet resultSet = administratorDaoImpl.JSelectStudentByNum(stuId);
				
				int count = 0;
				while(resultSet.next()) {
					count++;
				}
				if(count==0) {
					JOptionPane.showMessageDialog(p23, "���޴���", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
				}
				else {
					resultSet.beforeFirst();
					
					resultSet.next();
					String stuNam = resultSet.getString(2);
					
					stuIddataLabel2.setText(stuId);
					stunamedataLabel2.setText(stuNam);
					
					stuIdLabel2.setVisible(true);
					stunameLabel2.setVisible(true);
					creditLabel2.setVisible(true);
					creditField2.setVisible(true);
					yesButton2.setVisible(true);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		

		if (e.getSource() == yesButton2) {
			if (creditField2.getText().length() == 0) {
				JOptionPane.showMessageDialog(p23, "�����������ѧ��", "���󾯸�", JOptionPane.ERROR_MESSAGE);
			} else {

				String stuId = stuIddataLabel2.getText();
				String credit = creditField2.getText();
				String teaId = MemoryXianShi();
				
				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
				courseDaoImpl.addCredit(stuId, teaId, credit);

				JOptionPane.showMessageDialog(p13, "�ɹ�¼���ѧ���ķ���", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	String MemoryXianShi() {// ���������ݱ�����һ����¼�����ϴε�һ�η���accountFiled
		String account = "";

		try {
			GetConn getConn = new GetConn();
			Connection connection = getConn.getConnection();
			String sql = "select *from memory;";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				account = resultSet.getString(1);// �������ݿ���е����һ����¼
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

	public static void main(String[] args) {
		new TeaAddCredit();
	}

}
